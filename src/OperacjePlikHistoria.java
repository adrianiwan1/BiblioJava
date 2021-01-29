import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

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
            OdczytywanaHistoria = new Historia(baza.readInt(),baza.readInt(),baza.readUTF(),baza.readUTF(), baza.readUTF(), baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readInt());
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


                            Historia.TworzenieWpisu(IdKsiazki, IdCzytelnik, DataWyporzyczenia, DataTermin, NazwaCzytelnik); // przekazanie parametrów do funkcji tworzenia wpisu.
                            NowaHistoria.close();
                            OperacjePlikKsiazki.KasowanieKsiazki(IdKsiazki);

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

    public static void ZwracanieKsiazki() throws IOException {
        int IdKsiazki;
        int IdCzytelnik = 0;
        String NazwaCzytelnik;
        String TerminWyporyczena;
        String Wyporzyczajacy;
        boolean OK = true;
        String CzyWypozyczona ="tak";
        boolean CzyWpisacRecznie;
        String DataWyporzyczenia;
        String DataTermin;

        RandomAccessFile NowaOddanie = OperacjePlikKsiazki.OtwarciePlikKsiazki();

        WyszukiwanieKsiazka.UltraSkroconeWyszukiwanie("tak",NowaOddanie,"czywyporzyczona");
        NowaOddanie.close();
        RandomAccessFile NowaHistoria = OperacjePlikHistoria.OtwarciePlikHistoria();
        do {

            System.out.println("Podaj Id ksiazki, ktora chcesz Zwrocic:");
            IdKsiazki = WpisywanieDanych.WpisanieLiczby();
            if (WyszukiwanieKsiazka.IdCzyIstnieje(IdKsiazki,NowaHistoria) == 1) {
                NowaHistoria = OperacjePlikKsiazki.OtwarciePlikKsiazki();
                if(WyszukiwanieKsiazka.CzyWypozyczona(IdKsiazki,NowaHistoria).equals("tak")){
                    RandomAccessFile PlikKsiazki = OperacjePlikKsiazki.OtwarciePlikKsiazki();

                    Ksiazka OdebranaKsiazka = WyszukiwanieKsiazka.WyszukiwanieIDUzytkownika(IdKsiazki,PlikKsiazki);
                    IdCzytelnik =OdebranaKsiazka.GetIdUzytkownika();

                    if (SprawdzanieUzytkownik.CzyPodaneIdIstnieje(IdCzytelnik) == true) {

                        NazwaCzytelnik = SprawdzanieUzytkownik.IdNazwaCztelnik(IdCzytelnik);
                        Ksiazka PobieranieDaty = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikKsiazki);

                        DataTermin = OdebranaKsiazka.GetDataTermin();
                        DataWyporzyczenia = OdebranaKsiazka.GetDataWyporzyczenia();
                        CzyWypozyczona="nie";
                        PlikKsiazki.close();
                        NowaHistoria.close();

                        Historia.TworzenieWpisu(IdKsiazki, IdCzytelnik, DataWyporzyczenia, DataTermin, NazwaCzytelnik); // przekazanie parametrów do funkcji tworzenia wpisu.

                        OperacjePlikKsiazki.KasowanieKsiazki(IdKsiazki);
                        OperacjePlikKsiazki.ZapisywanieKsiazek(PobieranieDaty,"Books.bin");


                        //System.out.println(IdKsiazki);

                    }else{
                        System.out.println("Użytkownik nie istnieje.");
                        OK =false;
                    }

                } else {
                    System.out.println("Ksiażka nie jest jeszcze wypożyczona.");
                    OK =false;
                }

            } else {
                System.out.println("Ksiazka o podanym ID nie istnieje");
                OK =false;
            }
        }while(OK!=true);


    }

}
