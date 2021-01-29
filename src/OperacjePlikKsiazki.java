import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperacjePlikKsiazki{



    public static void ZapisywanieKsiazek(Ksiazka NowaKsiazka,String NazwaPliku) throws IOException {
        RandomAccessFile baza =new RandomAccessFile(NazwaPliku,"rw");

        baza.seek(baza.length());

        baza.writeInt(NowaKsiazka.GetIdKsiazki()); // 32
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetNazwaKsiazki()));
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetAutor()));
        baza.writeUTF(String.format("%1$-24s",NowaKsiazka.GetGatunek()));
        baza.writeUTF(String.format("%1$-11s",NowaKsiazka.GetDataWydania()));
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetWyporzyczajacy()));

       //baza.writeInt(NowaKsiazka.GetDniWyporzyczenia());
        //baza.writeInt(NowaKsiazka.GetMiesiaceWyporzyczenia());
        //baza.writeInt(NowaKsiazka.GetRokWyporzyczenia());
        baza.writeUTF(String.format("%1$-11s",NowaKsiazka.GetDataWyporzyczenia()));
        baza.writeUTF(String.format("%1$-3s",NowaKsiazka.GetCzyWyporzyczona())); //1

        //baza.writeInt(NowaKsiazka.GetDniTermin());
        //baza.writeInt(NowaKsiazka.GetMiesiaceTermin());
        //baza.writeInt(NowaKsiazka.GetRokTermin());
        baza.writeUTF(String.format("%1$-11s",NowaKsiazka.GetDataTermin()));
        baza.writeUTF(String.format("%1$-3s",NowaKsiazka.GetCzyPoTerminie()));
        baza.writeInt(NowaKsiazka.GetIdUzytkownika());



        System.out.println("Zapis udany");

        baza.close();
    }

    public static Ksiazka OdczytywanieKsiazek(RandomAccessFile baza) throws IOException
    {


        Ksiazka OdczytywanaKsiazka=null;
        try {
            OdczytywanaKsiazka = new Ksiazka(baza.readInt(),baza.readUTF(),baza.readUTF(), baza.readUTF(), baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readInt());
            //baza.seek(364);
        } catch (EOFException ex)
        {



        }


        return OdczytywanaKsiazka;

    }


    public static RandomAccessFile OtwarciePlikKsiazki() throws FileNotFoundException {

        RandomAccessFile baza =new RandomAccessFile("Books.bin","rw");
        return baza;
    }

    public  static void KasowanieKsiazki(int ID)
    {
        int i = 0;
        int Szukana = 0;
        Szukana = ID;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
            if(SprawdzanieKsiazka.CzyPodaneIdIstnieje(Szukana)==true)
            {
                if(SprawdzanieKsiazka.CzyWyporzyczona(Szukana)==false)
                {
                    do {
                        Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
                        if (OdczytaneDane != null) // Jesli nie jest puste wykonaj
                        {
                            int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
                            if (Szukana != Odczyt) // Porownanie odczytu.
                            {
                                ZapisywanieKsiazek(OdczytaneDane, "TempBooks.bin");
                            }
                        } else {
                            i = 9002; // Zakonczenie petli jesli null
                        }
                        i++;
                    } while (i < 9000); // Maksymalna wartosc petli
                    PlikOdczytany.close(); // Zamkniecie odczytu
                    new File("Books.bin").delete();
                    Path Zrodlo = Paths.get("TempBooks.bin");
                    try {

                        Files.move(Zrodlo, Zrodlo.resolveSibling("Books.bin"));

                    } catch (IOException e) {

                    }
                }
                else{
                    System.out.println("Ksiazka Jest Wyporzyczona");
                }

            }
            else{
                System.out.println("Książka nie istnieje");
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
        String NazwaKsiazki = "PustyPustoPustusienkoNiemaNic";
        String Autor = "PustyPustoPustusienkoNiemaNic";
        String Gatunek = "PustyPustoPustusienkoNiemaNic";
        String DataWydania = "PustyPustoPustusienkoNiemaNic";
        int IdUzytkownika = 2147483646;
        String NazwaCzytelnik="PustyPustoPustusienkoNiemaNic";
        String CzyWyporzyczona = "PustyPustoPustusienkoNiemaNic";
        String CzyRandomId = "PustyPustoPustusienkoNiemaNic";
        String DataWyporzyczenia = "PustyPustoPustusienkoNiemaNic";
        String DataTermin = "PustyPustoPustusienkoNiemaNic";
        String CzyPoTerminie = "PustyPustoPustusienkoNiemaNic";
        boolean CzyWpisacRecznie = true;
        boolean OK = true;
        String DataObecna = Daty.ObecnaData();
        String SprawdzanieCzyPoTerminie = "czypoterminie";

        boolean CzyNaPewno = false;

        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
            System.out.println("Wpisz id czytelnika ktorego chcesz edytować.Wpisz 0 by anulowac");  // Prosba o wpisanie
            Szukana = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego int
            if(Szukana == 0)
            {
                System.out.println("Powrót do poprzedniej opcji.");
                return;
            }
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
                if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                {
                    int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
                    if(Szukana==Odczyt) // Porownanie odczytu.
                    {
                        switch(Zmienianna)
                        {
                            case "zmiananazwa":
                                ZwrotneID = OdczytaneDane.GetIdKsiazki();
                                Autor = OdczytaneDane.GetAutor();
                                Gatunek = OdczytaneDane.GetGatunek();
                                DataWydania = OdczytaneDane.GetDataWydania();
                                NazwaCzytelnik = OdczytaneDane.GetNazwaUzytkownik();
                                DataWyporzyczenia = OdczytaneDane.GetDataWyporzyczenia();
                                CzyWyporzyczona = OdczytaneDane.GetCzyWyporzyczona();
                                DataTermin = OdczytaneDane.GetDataTermin();
                                CzyPoTerminie = OdczytaneDane.GetCzyPoTerminie();
                                IdUzytkownika = OdczytaneDane.GetIdUzytkownika();

                                System.out.println("Stara nazwa to : " + OdczytaneDane.GetNazwaUzytkownik() + "Jesli nie chcesz jej zmieniac wcisnij 0");
                                System.out.println("Podaj prosze nowa nazwe ksiazki.");
                                NazwaKsiazki = WpisywanieDanych.WpisanieSlowa();
                                Znalezione++;
                                if (NazwaKsiazki.equals("0"))
                                {
                                    System.out.println("Anulowanie i powrot do poprzedniej opcji.");
                                    return;
                                }
                                break;
                            case "zmianaautor":
                                ZwrotneID = OdczytaneDane.GetIdKsiazki();
                                NazwaKsiazki = OdczytaneDane.GetNazwaKsiazki();
                                Gatunek = OdczytaneDane.GetGatunek();
                                DataWydania = OdczytaneDane.GetDataWydania();
                                NazwaCzytelnik = OdczytaneDane.GetNazwaUzytkownik();
                                DataWyporzyczenia = OdczytaneDane.GetDataWyporzyczenia();
                                CzyWyporzyczona = OdczytaneDane.GetCzyWyporzyczona();
                                DataTermin = OdczytaneDane.GetDataTermin();
                                CzyPoTerminie = OdczytaneDane.GetCzyPoTerminie();
                                IdUzytkownika = OdczytaneDane.GetIdUzytkownika();

                                System.out.println("Stara nazwa to : " + OdczytaneDane.GetAutor() + "Jesli nie chcesz jej zmieniac wcisnij 0");
                                System.out.println("Podaj prosze nowego autora.");
                                Autor = WpisywanieDanych.WpisanieSlowa();
                                Znalezione++;
                                if (NazwaKsiazki.equals("0"))
                                {
                                    System.out.println("Anulowanie i powrot do poprzedniej opcji.");
                                    return;
                                }
                                break;
                            case "zmianagatunek":
                                ZwrotneID = OdczytaneDane.GetIdKsiazki();
                                NazwaKsiazki = OdczytaneDane.GetNazwaKsiazki();
                                Autor = OdczytaneDane.GetAutor();
                                DataWydania = OdczytaneDane.GetDataWydania();
                                NazwaCzytelnik = OdczytaneDane.GetNazwaUzytkownik();
                                DataWyporzyczenia = OdczytaneDane.GetDataWyporzyczenia();
                                CzyWyporzyczona = OdczytaneDane.GetCzyWyporzyczona();
                                DataTermin = OdczytaneDane.GetDataTermin();
                                CzyPoTerminie = OdczytaneDane.GetCzyPoTerminie();
                                IdUzytkownika = OdczytaneDane.GetIdUzytkownika();

                                System.out.println("Stara nazwa to : " + OdczytaneDane.GetGatunek() + "Jesli nie chcesz jej zmieniac wcisnij 0");
                                Ksiazka.DostepneGatunki();
                                System.out.println("Podaj prosze gatunek ksiazki.");
                                do
                                {
                                    Gatunek = WpisywanieDanych.WpisanieSlowa();
                                    OK = SprawdzanieKsiazka.SprawdzanieGatunku(Gatunek);
                                }while(OK != true);
                                Znalezione++;
                                if (NazwaKsiazki.equals("0"))
                                {
                                    System.out.println("Anulowanie i powrot do poprzedniej opcji.");
                                    return;
                                }
                                break;
                            case "zmianadatawydania":
                                ZwrotneID = OdczytaneDane.GetIdKsiazki();
                                NazwaKsiazki = OdczytaneDane.GetNazwaKsiazki();
                                Autor = OdczytaneDane.GetAutor();
                                Gatunek = OdczytaneDane.GetGatunek();
                                NazwaCzytelnik = OdczytaneDane.GetNazwaUzytkownik();
                                DataWyporzyczenia = OdczytaneDane.GetDataWyporzyczenia();
                                CzyWyporzyczona = OdczytaneDane.GetCzyWyporzyczona();
                                DataTermin = OdczytaneDane.GetDataTermin();
                                CzyPoTerminie = OdczytaneDane.GetCzyPoTerminie();
                                IdUzytkownika = OdczytaneDane.GetIdUzytkownika();
                                System.out.println("Stara nazwa to : " + OdczytaneDane.GetGatunek() + "Jesli nie chcesz jej zmieniac wcisnij 0");
                                Ksiazka.DostepneGatunki();
                                System.out.println("Podaj prosze gatunek ksiazki.");
                                do
                                {
                                    System.out.println("Podaj prosze date wydania.");
                                    DataWydania = Daty.WpisanieDaty();
                                    if(Daty.SprawdzanieCzyPoPodanejDacie(DataObecna,DataWydania,SprawdzanieCzyPoTerminie) <= 0 )
                                    {
                                        System.out.println("Ksiazka nie moze byc dodana do rejestru przed jej wydaniem.\n");
                                    }
                                }
                                while (Daty.SprawdzanieCzyPoPodanejDacie(DataObecna,DataWydania,SprawdzanieCzyPoTerminie) <= 0 );
                                Znalezione++;
                                if (NazwaKsiazki.equals("0"))
                                {
                                    System.out.println("Anulowanie i powrot do poprzedniej opcji.");
                                    return;
                                }
                                break;
                            default:
                                System.out.println("Cos poszlo bardzo nie tak probujesz odwolac do funkcji. Ale nie wybrales odpowiedniej opcji.\n Sprobuj 'zmiananazwa' , 'zmianagatunek' , 'zmianaautor'");
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
                OperacjePlikKsiazki.KasowanieKsiazki(ZwrotneID);
                Ksiazka NowaKsiazka = new Ksiazka(ZwrotneID, NazwaKsiazki, Autor, Gatunek, DataWydania, NazwaCzytelnik,DataWyporzyczenia,CzyWyporzyczona,DataTermin,CzyPoTerminie,IdUzytkownika);
                ZapisywanieKsiazek(NowaKsiazka,"Books.bin");
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




