import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperacjePlikUzytkownicy {


    public static void ZapisywanieUzytkownika(Uzytkownik NowyUzytkownik,String NazwaPliku)throws IOException {

        RandomAccessFile baza =new RandomAccessFile(NazwaPliku,"rw");
        baza.seek(baza.length());

        baza.writeInt(NowyUzytkownik.GetIdUzytkownika());
        baza.writeUTF(String.format("%1$-32s",NowyUzytkownik.GetNazwaUzytkownik()));
        baza.writeUTF(String.format("%1$-3s",NowyUzytkownik.GetCzyZbanowany()));
        System.out.println("Urzytkownik zapisany");
        baza.close();


    }

    public static RandomAccessFile OtwarciePlikUzytkownicy() throws FileNotFoundException {
        RandomAccessFile baza =new RandomAccessFile("Users.bin","rw");
        return baza;
    }

    public static Uzytkownik OdczytywanieUzytkownikow (RandomAccessFile baza) throws IOException
    {
        Uzytkownik OdczytywanyUzytkownik=null;
        try {
            OdczytywanyUzytkownik = new Uzytkownik(baza.readInt(),baza.readUTF(),baza.readUTF());
        }
        catch (EOFException ex)
        {

        }
        return OdczytywanyUzytkownik;
    }

    public static void UsuwanieUzytkownik(int Id)
    {
        int i = 0;
        int Szukana = 0;
        Szukana = Id;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy(); //Otwarcie pliku
            if(SprawdzanieUzytkownik.CzyPodaneIdIstnieje(Szukana) == true)
            {
                do
                {
                    Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
                    if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                    {
                        int Odczyt = OdczytaneDane.GetIdUzytkownika(); //Wpisanie danej do int
                        if(Szukana != Odczyt) // Porownanie odczytu.
                        {
                            ZapisywanieUzytkownika(OdczytaneDane, "TempUsers.bin");
                        }
                    } else
                    {
                        i = 9900; // Zakonczenie petli jesli null
                    }
                    i++;
                } while(i < 9000); // Maksymalna wartosc petli
                PlikOdczytany.close(); // Zamkniecie odczytu
                new File("Users.bin").delete();
                Path Zrodlo = Paths.get("TempUsers.bin");
                try
                {

                    Files.move(Zrodlo, Zrodlo.resolveSibling("Users.bin"));

                } catch(IOException e)
                {

                }
            } else
            {
                System.out.println("Ta osoba nie istnieje.");
            }

        } catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
        {
            e.printStackTrace();
        }
    }


    public static void ZmianaDanych(String Zmienianna) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int Szukana = 0;
        int Znalezione = 0;
        int ZwrotneID = 0;
        String NowaNazwaUzytkownika = "PustyPustoPustusienkoNiemaNic";
        String CzyBan = "PustyPustoPustusienkoNiemaNic";
        boolean CzyNaPewno = false;

        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy(); //Otwarcie pliku
            System.out.println("Wpisz id czytelnika którego chcesz edytować.Wpisz 0 by anulowac");  // Prosba o wpisanie
            Szukana = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego int
            if(Szukana == 0)
            {
                System.out.println("Powrót do poprzedniej opcji.");
                return;
            }
            do
            {
                Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
                if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                {
                    int Odczyt = OdczytaneDane.GetIdUzytkownika(); //Wpisanie danej do int
                    if(Szukana==Odczyt) // Porownanie odczytu.
                    {
                        switch(Zmienianna)
                        {
                            case "zmiananazwa":
                                ZwrotneID = OdczytaneDane.GetIdUzytkownika();
                                CzyBan = OdczytaneDane.GetCzyZbanowany();
                                System.out.println("Stara nazwa to : " + OdczytaneDane.GetNazwaUzytkownik() + "Jesli nie chcesz jej zmieniac wcisnij 0");
                                System.out.println("Prosze podac nowa nazwe ksiazki.");
                                NowaNazwaUzytkownika = WpisywanieDanych.WpisanieSlowa();
                                Znalezione++;
                                if (NowaNazwaUzytkownika.equals("0"))
                                {
                                  System.out.println("Anulowanie i powrot do poprzedniej opcji.");
                                  return;
                                }
                                break;
                            case "ban":
                                if (OdczytaneDane.GetCzyZbanowany().equals("tak"))
                                {
                                    System.out.println("Uzytkownik juz jest zbanowany.Anulowanie i powrot do poprzedniej opcji.");
                                    return;
                                }
                                System.out.println("Czy na pewno chcesz banowac uzytkownika? Tak/Nie");
                                CzyNaPewno = WpisywanieDanych.WpisanieBool();
                                ZwrotneID = OdczytaneDane.GetIdUzytkownika();
                                NowaNazwaUzytkownika = OdczytaneDane.GetNazwaUzytkownik();
                                CzyBan = "tak";
                                Znalezione++;
                                if (CzyNaPewno == false)
                                {
                                    System.out.println("Anulowanie i powrot do poprzedniej opcji.");
                                    return;
                                }
                                break;
                            case "unban":
                                if (OdczytaneDane.GetCzyZbanowany().equals("nie"))
                                {
                                    System.out.println("Uzytkownik nie jest zbanowany.Anulowanie i powrot do poprzedniej opcji.");
                                    return;
                                }
                                System.out.println("Czy na pewno chcesz odbanowac uzytkownika? Tak/Nie");
                                CzyNaPewno = WpisywanieDanych.WpisanieBool();
                                ZwrotneID = OdczytaneDane.GetIdUzytkownika();
                                NowaNazwaUzytkownika = OdczytaneDane.GetNazwaUzytkownik();
                                CzyBan = "nie";
                                Znalezione++;
                                if (CzyNaPewno == false)
                                {
                                    System.out.println("Anulowanie i powrot do poprzedniej opcji.");
                                    return;
                                }
                                break;
                            default:
                                System.out.println("Cos poszlo bardzo nie tak probujesz odwolac do funkcji. Ale nie wybrales odpowiedniej opcji.\n Sprobuj 'zmiananazwa' , 'ban , 'unban'");
                                return;
                        }
                    }
                } else
                {
                    i = 9002; // Zakonczenie petli jesli null
                }
                i++;
            } while(i < 9000); // Maksymalna wartosc petli
            PlikOdczytany.close(); // Zamkniecie odczytu
            if (Znalezione > 0)
            {
                System.out.println(ZwrotneID);
                OperacjePlikUzytkownicy.UsuwanieUzytkownik(ZwrotneID);
                 Uzytkownik NowyUzytkownik = new Uzytkownik(ZwrotneID,NowaNazwaUzytkownika,CzyBan);
                ZapisywanieUzytkownika(NowyUzytkownik,"Users.bin");
            }
        } catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
        {
        }

        if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
        {
            System.out.println("Nie znaleziono.");
        }else
            {


            }
    }


}
