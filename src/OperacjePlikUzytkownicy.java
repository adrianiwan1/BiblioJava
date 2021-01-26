import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperacjePlikUzytkownicy {


    public static void ZapisywanieUzytkownika(Uzytkownik NowyUzytkownik,String NazwaPliku)throws IOException {

        RandomAccessFile baza =new RandomAccessFile("Users.bin","rw");
        baza.seek(baza.length());

        baza.writeInt(NowyUzytkownik.GetIdUzytkownika());
        baza.writeUTF(String.format("%1$-32s",NowyUzytkownik.GetUzytkownik()));

        baza.close();
        System.out.println("Urzytkownik zapisany");


    }

    public static RandomAccessFile OtwarciePlikUzytkownicy() throws FileNotFoundException {
        RandomAccessFile baza =new RandomAccessFile("Users.bin","r");
        return baza;
    }

    public static Uzytkownik OdczytywanieUzytkownikow (RandomAccessFile baza) throws IOException
    {
        Uzytkownik OdczytywanyUzytkownik=null;
        try {
            OdczytywanyUzytkownik = new Uzytkownik(baza.readInt(),baza.readUTF());
        }
        catch (EOFException ex)
        {

        }
        return OdczytywanyUzytkownik;
    }

    public static void UsuwanieUzytkownik()
    {
        int i = 0;
        int Szukana = 0;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy(); //Otwarcie pliku
            System.out.println("Wpisz liczbe id ksiazki ktora chcesz usunac");  // Prosba o wpisanie
            if(SprawdzanieUzytkownik.CzyPodaneIdIstnieje(Szukana)==true)
                {
                    if(SprawdzanieBlackList.CzyPodaneIdIstnieje(Szukana)==true)
                        {
                         OperacjePlikBlackList.UsuwanieBan(Szukana);
                        }
                    do {
                        Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
                        if (OdczytaneDane != null) // Jesli nie jest puste wykonaj
                        {
                            int Odczyt = OdczytaneDane.GetIdUzytkownika(); //Wpisanie danej do int
                            if (Szukana != Odczyt) // Porownanie odczytu.
                            {
                                ZapisywanieUzytkownika(OdczytaneDane,"TempUsers.bin");
                            }
                        } else {
                            i = 9002; // Zakonczenie petli jesli null
                        }
                        i++;
                    } while (i < 9000); // Maksymalna wartosc petli
                    PlikOdczytany.close(); // Zamkniecie odczytu
                    new File("Users.bin").delete();

                    Path Zrodlo = Paths.get("TempUsers.bin");

                    try{

                        Files.move(Zrodlo, Zrodlo.resolveSibling("Users.bin"));

                    } catch (IOException e) {

                    }

                }
                else
                    {
                    System.out.println("Ta osoba nie jest zbanowana");
                    }

        } catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
        {
            e.printStackTrace();
        }
    }


}
