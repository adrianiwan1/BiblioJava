import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperacjePlikBlackList {

    public static void ZapisywanieZbanowanego(BlackList NowyZbanowany,String NazwaPliku)throws IOException
    {
        RandomAccessFile baza =new RandomAccessFile(NazwaPliku,"rw");
        baza.seek(baza.length());
        baza.writeInt(NowyZbanowany.GetIdZbanownay());
        baza.writeUTF(String.format("%1$-32s",NowyZbanowany.GetZbanowany()));
    }

    public static RandomAccessFile OtwarciePlikBlackList() throws FileNotFoundException
    {
        RandomAccessFile baza =new RandomAccessFile("BlackList.bin","r");
        return baza;
    }

    public static BlackList OdczytywanieZbanowanych(RandomAccessFile baza) throws IOException
    {
        BlackList OdczytywanyZbanowany =null;
        try {
            OdczytywanyZbanowany = new BlackList(baza.readInt(),baza.readUTF());
        }catch (EOFException ex)
        {

        }
        return OdczytywanyZbanowany;
    }
    public static void UsuwanieBan(int Szukana)
    {
        int i = 0;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikBlackList.OtwarciePlikBlackList(); //Otwarcie pliku
            if(SprawdzanieBlackList.CzyPodaneIdIstnieje(Szukana)==true) {
                do {
                    BlackList OdczytaneDane = OperacjePlikBlackList.OdczytywanieZbanowanych(PlikOdczytany); // Odczytranie linjki tekstu
                    if (OdczytaneDane != null) // Jesli nie jest puste wykonaj
                    {
                        int Odczyt = OdczytaneDane.GetIdZbanownay(); //Wpisanie danej do int
                        if (Szukana != Odczyt) // Porownanie odczytu.
                        {
                            ZapisywanieZbanowanego(OdczytaneDane,"TempBlackList.bin");
                        }
                    } else {
                        i = 9002; // Zakonczenie petli jesli null
                    }
                    i++;
                } while (i < 9000); // Maksymalna wartosc petli
                PlikOdczytany.close(); // Zamkniecie odczytu
                new File("BlackList.bin").delete();

                Path Zrodlo = Paths.get("TempBlackList.bin");

                try{

                    Files.move(Zrodlo, Zrodlo.resolveSibling("BlackList.bin"));

                } catch (IOException e) {

                }

            }
            else{
                System.out.println("Ta osoba nie jest zbanowana");
            }

        } catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
        {
            e.printStackTrace();
        }
    }
}
