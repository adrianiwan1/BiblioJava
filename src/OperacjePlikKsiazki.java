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
        String Autor;
        String Gatunek;
        String DataWydania;
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

        boolean CzyNaPewno = false;

        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
            System.out.println("Wpisz id Użytkownika ktorego chcesz edytować");  // Prosba o wpisanie
            Szukana = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego int
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
                                DataTermin = OdczytaneDane.GetDataTermin();
                                DataWyporzyczenia = OdczytaneDane.GetDataWyporzyczenia();
                                IdUzytkownika = OdczytaneDane.GetIdUzytkownika();
                                NazwaCzytelnik = OdczytaneDane.GetNazwaUzytkownik();
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
                OperacjePlikKsiazki.KasowanieKsiazki(ZwrotneID);
                Ksiazka NowaKsiazka = new Uzytkownik(ZwrotneID,NazwaKsiazki,Autor);
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




