import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperacjePlikHistoria{

    public static void ZapisywanieHistorii(Historia NowyWpis,String NazwaPliku) throws IOException {
        RandomAccessFile baza =new RandomAccessFile(NazwaPliku,"rw");

        baza.seek(baza.length());
        baza.writeInt(NowyWpis.GetIdHistorii());
        baza.writeInt(NowyWpis.GetIdKsiazki()); // 32
        baza.writeUTF(String.format("%1$-32s",NowyWpis.GetNazwaKsiazki()));
        baza.writeUTF(String.format("%1$-32s",NowyWpis.GetAutor()));
        baza.writeUTF(String.format("%1$-24s",NowyWpis.GetGatunek()));
        baza.writeUTF(String.format("%1$-11s",NowyWpis.GetDataWydania()));
        baza.writeUTF(String.format("%1$-32s",NowyWpis.GetWyporzyczajacy()));
        baza.writeUTF(String.format("%1$-11s",NowyWpis.GetDataWyporzyczenia()));
        baza.writeUTF(String.format("%1$-3s",NowyWpis.GetCzyWyporzyczona())); //1
        baza.writeUTF(String.format("%1$-11s",NowyWpis.GetDataTermin()));
        baza.writeUTF(String.format("%1$-3s",NowyWpis.GetCzyPoTerminie()));
        baza.writeInt(NowyWpis.GetIdUzytkownika());
        baza.writeUTF(String.format("%1$-11s",NowyWpis.GetDataWpisu()));



        System.out.println("Historia Zapisana");

        baza.close();
    }

    public static RandomAccessFile OtwarciePlikHistoria() throws FileNotFoundException {

        RandomAccessFile baza =new RandomAccessFile("History.bin","rw");
        return baza;
    }

    public static Historia OdczytywanieHistorii (RandomAccessFile baza) throws IOException
    {
        Historia OdczytywanaHistoria=null;
        try {
            OdczytywanaHistoria = new Historia(baza.readInt(),baza.readInt(),baza.readUTF(),baza.readUTF(), baza.readUTF(), baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readInt(), baza.readUTF());
        }
        catch (EOFException ex)
        {

        }
        return OdczytywanaHistoria;
    }

    public static void WypozyczanieKsiazki() throws IOException {
        int IdKsiazki;
        int IdCzytelnik = 0;
        String NazwaCzytelnik;
        boolean OK = true;
        String CzyWypozyczona ="tak";
        boolean CzyWpisacRecznie;
        String DataWyporzyczenia;
        String DataTermin;
        String SprawdzanieCzyPoTerminie = "czypoterminie";
        String SprawdzanieIlePoTerminie = "ilepoterminie";
        String CzyPoTerminie = "nie";
        String DataObecna = Daty.ObecnaData();
        String DataWydania;

        Menu.WypisywanieKsiazek();

        do {
            RandomAccessFile NowaHistoria = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            System.out.println("Podaj Id ksiazki, ktora chcesz wyporzyczyc.Wpisz 0 by anulować.");
            IdKsiazki = WpisywanieDanych.WpisanieLiczby();
            if(IdKsiazki == 0)
            {
                System.out.println("Powrót do poprzedniej opcji.");
                return;
            }
            if (WyszukiwanieKsiazka.IdCzyIstnieje(IdKsiazki,NowaHistoria) == 1) {
                NowaHistoria = OperacjePlikKsiazki.OtwarciePlikKsiazki();
                if(WyszukiwanieKsiazka.CzyWypozyczona(IdKsiazki,NowaHistoria).equals("nie")){
                    Menu.WypisywanieUzytkownikow();
                    System.out.println("Podaj Id Czytelnika, który chce wyporzyczyć ksiażkę:");
                    IdCzytelnik = WpisywanieDanych.WpisanieLiczby();

                    if (SprawdzanieUzytkownik.CzyPodaneIdIstnieje(IdCzytelnik) == true) {
                        if(SprawdzanieUzytkownik.CzyZablokowany(IdCzytelnik)== false) {

                            NazwaCzytelnik = SprawdzanieUzytkownik.IdNazwaCztelnik(IdCzytelnik);
                            do
                            {
                                RandomAccessFile PlikKsiazki = OperacjePlikKsiazki.OtwarciePlikKsiazki();
                                Ksiazka OdebranaKsiazka = WyszukiwanieKsiazka.WyszukiwanieIDUzytkownika(IdKsiazki,PlikKsiazki);
                                DataWydania = OdebranaKsiazka.GetDataWydania();
                                PlikKsiazki.close();
                                System.out.println("Czy chcesz wziasc aktualna date dla daty wyporzyczenia? Tak/Nie");
                                CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();

                                if (Daty.SprawdzanieCzyPoPodanejDacie(DataWydania,DataObecna,SprawdzanieCzyPoTerminie) <= 0 )
                                {
                                    if(CzyWpisacRecznie == false)
                                    {
                                        System.out.println("Podaj prosze date wyporzyczenia.");
                                        DataWyporzyczenia = Daty.WpisanieDaty();
                                    } else
                                    {
                                        DataWyporzyczenia = Daty.ObecnaData();
                                    }
                                    if(Daty.SprawdzanieCzyPoPodanejDacie(DataWydania,DataWyporzyczenia,SprawdzanieCzyPoTerminie) >= 0)
                                    {
                                        System.out.println("Nie mozna wyporzyczyc ksiazki przed jej wydaniem! Prosze sprobowac ponownie.");

                                    }
                                }else
                                {
                                    if(CzyWpisacRecznie == true)
                                    {
                                        System.out.println("Nie mozna uzyc daty aktualnej.Prosze podac date recznie");
                                        System.out.println("Podaj prosze date wyporzyczenia.");
                                        DataWyporzyczenia = Daty.WpisanieDaty();
                                    }else
                                    {
                                        DataWyporzyczenia = Daty.ObecnaData();
                                    }
                                    if(Daty.SprawdzanieCzyPoPodanejDacie(DataWydania,DataWyporzyczenia,SprawdzanieCzyPoTerminie) >= 0)
                                    {
                                        System.out.println("Nie mozna wyporzyczyc ksiazki przed jej wydaniem! Prosze sprobowac ponownie.");

                                    }
                                }

                            }while(Daty.SprawdzanieCzyPoPodanejDacie(DataWydania,DataWyporzyczenia,SprawdzanieCzyPoTerminie) >= 0);
                            do
                            {
                                System.out.println("Czy chcesz automatycznie wygenerowac termin oddania.  Tak/Nie");
                                CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();
                                if(CzyWpisacRecznie == false)
                                {
                                    System.out.println("Podaj prosze termin oddania.");
                                    DataTermin = Daty.WpisanieDaty();
                                } else
                                {
                                    DataTermin = Daty.TerminOddania(DataWyporzyczenia);
                                }
                                if(Daty.SprawdzanieCzyPoPodanejDacie(DataWyporzyczenia,DataTermin,SprawdzanieCzyPoTerminie) >= 0)
                                {
                                    System.out.println("Termin oddania nie moze byc mniejszy niz data wyporzyczenia!. Prosze sprobowac ponownie.");

                                }
                            }
                            while(Daty.SprawdzanieCzyPoPodanejDacie(DataWyporzyczenia,DataTermin,SprawdzanieCzyPoTerminie) >= 0);


                            Historia.TworzenieWpisu(IdKsiazki, IdCzytelnik, DataWyporzyczenia, DataTermin, NazwaCzytelnik,DataObecna); // przekazanie parametrów do funkcji tworzenia wpisu.
                            NowaHistoria.close();
                            RandomAccessFile PlikKsiazki = OperacjePlikKsiazki.OtwarciePlikKsiazki();
                            Ksiazka PobieranieDaty = WyszukiwanieKsiazka.WyszukiwanieIDUzytkownika(IdKsiazki,PlikKsiazki);
                            PlikKsiazki.close();
                            OperacjePlikKsiazki.KasowanieKsiazki(IdKsiazki);
                            OperacjePlikKsiazki.ZapisywanieKsiazek(PobieranieDaty,"Books.bin");

                            //System.out.println(IdKsiazki);
                        }else{
                            System.out.print("Użytkownik jest zablokowany\n");
                        }
                    }else{
                        System.out.println("Użytkownik nie istnieje.");
                        OK=false;
                    }

                } else {
                    System.out.println("Ksiażka jest już wypożyczona.");
                    OK=false;
                }

            } else {
                System.out.println("Ksiazka o podanym ID nie istnieje");
                OK=false;
            }
        }while(OK!=true);


    }


    public static void ZwracanieKsiazki() throws IOException
    {
        int IdKsiazki;
        int IdCzytelnik = 0;
        String NazwaCzytelnik;
        String TerminWyporyczena;
        String Wyporzyczajacy;
        boolean OK = true;
        String CzyWypozyczona = "tak";
        boolean CzyWpisacRecznie;
        String DataWyporzyczenia;
        String DataTermin;
        int Znaleziono=0;
        int Szukana;
        int i = 0;
        int Odczyt = 0;
        Menu.WyswietlanieHistori();
        RandomAccessFile PlikHistoriaOdczytana = OperacjePlikHistoria.OtwarciePlikHistoria(); //Otwarcie pliku
        System.out.println("Wpisz id ksiazki którego chcesz zwrocic.Wpisz 0 by anulowac");  // Prosba o wpisanie
        Szukana = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego int
        if(Szukana == 0)
        {
            System.out.println("Powrót do poprzedniej opcji.");
            return;
        }

        if(SprawdzanieHistoria.CzyPodaneIdIstnieje(Szukana) == true)
        {
             PlikHistoriaOdczytana = OperacjePlikHistoria.OtwarciePlikHistoria();
            do
            {
                Historia ObiektHistoria = OperacjePlikHistoria.OdczytywanieHistorii(PlikHistoriaOdczytana); // Odczytranie linjki tekstu
                if(ObiektHistoria != null) // Jesli nie jest puste wykonaj
                {
                     Odczyt = ObiektHistoria.GetIdKsiazki(); //Wpisanie danej do int
                    if(Szukana == Odczyt) // Porownanie odczytu.
                    {
                        ObiektHistoria.SetCzyWyporzyczona("nie");
                        ObiektHistoria.SetDataWpisu(Daty.ObecnaData());
                        RandomAccessFile PlikKsiazkaOczyt = OperacjePlikKsiazki.OtwarciePlikKsiazki();
                        Ksiazka NowaKsiazka = WyszukiwanieKsiazka.WyszukiwanieIDUzytkownika(Odczyt,PlikKsiazkaOczyt);
                        PlikKsiazkaOczyt.close();
                        PlikHistoriaOdczytana.close();
                        NowaKsiazka.SetCzyWyporzyczona("nie");
                        OperacjePlikKsiazki.KasowanieKsiazki(NowaKsiazka.GetIdKsiazki());
                        OperacjePlikKsiazki.ZapisywanieKsiazek(NowaKsiazka,"Books.bin");
                        ZapisywanieHistorii(ObiektHistoria, "History.bin");
                    }
                } else
                {
                    i = 9900; // Zakonczenie petli jesli null
                }
                i++;
            } while(i < 9000); // Maksymalna wartosc petli// Zamkniecie odczytu
        } else
        {
            System.out.println("Ta osoba nie istnieje.");
        }
    }
}