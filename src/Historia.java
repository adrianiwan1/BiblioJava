import java.io.IOException;
import java.io.RandomAccessFile;

public class Historia extends Ksiazka{
    int IdHistoria;
    String DataWpisu;


    public Historia(int IdHistoria,int IdKsiazki, String NazwaKsiazki, String Autor, String Gatunek, String DataWydania,
                    String NowyCzytelnik,String DataWyporzyczenia,String CzyWyporzyczona,String DataTermin,String CzyPoTerminie,int IdUzytkownik,String NowaDataWpisu)
    {
        super(IdKsiazki,NazwaKsiazki,Autor,Gatunek,DataWydania,NowyCzytelnik,DataWyporzyczenia,CzyWyporzyczona,DataTermin,CzyPoTerminie,IdUzytkownik);

        this.IdHistoria=IdHistoria;
        this.DataWpisu=NowaDataWpisu;

    }

    public String GetDataWpisu()
    {
     return DataWpisu;
    }
    public void SetDataWpisu(String DataWpisu)
    {
      this.DataWpisu = DataWpisu;
    }
    public int GetIdHistorii() {

        return IdHistoria;
    }

    public String GetIdHistoiraWypisiywanie()
    {
        String IdHistoriJakoString = (""+IdHistoria);
        int dlugosc =IdHistoriJakoString.length();
        switch(dlugosc)
        {
            case 1:
                IdHistoriJakoString = (IdHistoria + "         ");
                break;
            case 2:
                IdHistoriJakoString = (IdHistoria + "        ");
                break;
            case 3:
                IdHistoriJakoString = (IdHistoria + "       ");
                break;
            case 4:
                IdHistoriJakoString = (IdHistoria + "      ");
                break;
            case 5:
                IdHistoriJakoString = (IdHistoria + "     ");
                break;
            case 6:
                IdHistoriJakoString = (IdHistoria + "    ");
                break;
            case 7:
                IdHistoriJakoString = (IdHistoria + "   ");
                break;
            case 8:
                IdHistoriJakoString = (IdHistoria + "  ");
                break;
            case 9:
                IdHistoriJakoString = (IdHistoria + " ");
                break;

        }
        return  IdHistoriJakoString;
    }
    public String GetIdKsiazkiJakoString()
    {
        String IdKsiazkiJakoString = (""+GetIdKsiazki());
        int dlugosc =IdKsiazkiJakoString.length();
        switch(dlugosc)
        {
            case 1:
                IdKsiazkiJakoString = (GetIdKsiazki() + "         ");
                break;
            case 2:
                IdKsiazkiJakoString = (GetIdKsiazki() + "        ");
                break;
            case 3:
                IdKsiazkiJakoString = (GetIdKsiazki() + "       ");
                break;
            case 4:
                IdKsiazkiJakoString = (GetIdKsiazki() + "      ");
                break;
            case 5:
                IdKsiazkiJakoString = (GetIdKsiazki() + "     ");
                break;
            case 6:
                IdKsiazkiJakoString = (GetIdKsiazki() + "    ");
                break;
            case 7:
                IdKsiazkiJakoString = (GetIdKsiazki() + "   ");
                break;
            case 8:
                IdKsiazkiJakoString = (GetIdKsiazki() + "  ");
                break;
            case 9:
                IdKsiazkiJakoString = (GetIdKsiazki() + " ");
                break;

        }
        return  IdKsiazkiJakoString;
    }
    public String GetIdUzytkownikaWypisywanie()
    {
        String IdUzytkownikaJakoString = (""+GetIdUzytkownika());
        int dlugosc =IdUzytkownikaJakoString.length();
        switch(dlugosc)
        {
            case 1:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + "         ");
                break;
            case 2:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + "        ");
                break;
            case 3:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + "       ");
                break;
            case 4:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + "      ");
                break;
            case 5:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + "     ");
                break;
            case 6:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + "    ");
                break;
            case 7:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + "   ");
                break;
            case 8:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + "  ");
                break;
            case 9:
                IdUzytkownikaJakoString = (GetIdUzytkownika() + " ");
                break;

        }
        return  IdUzytkownikaJakoString;
    }

    public static  void TworzenieWpisu(int IdPorzyczanejKsiazki, int IdWyporzyczajacego,String NowyDataWypozyczenia,String NowyDataTermin,String NowyNazwaCzytelnik,String DataWpisu) throws IOException
    {

        int IdHistoria;
        int IdKsiazki= IdPorzyczanejKsiazki;
        int IdCzytelnik = IdWyporzyczajacego;
        String NazwaKsiazki=null;
        String Autor=null;
        String Gatunek=null;
        String DataWydania=null;
        String NowyCzytelnik=NowyNazwaCzytelnik;
        String DataWyporzyczenia=NowyDataWypozyczenia;
        final String CzyWyporzyczona="tak";
        String DataTermin=NowyDataTermin;
        String CzyPoTerminie=null;



        boolean OK=false;

        do {
            IdHistoria = GeneratorLosowegoID.Id();
            OK = SprawdzanieHistoria.CzyPodaneIdIstnieje(IdHistoria);
        }while(OK!= false);
        RandomAccessFile NowaHistoria = OperacjePlikKsiazki.OtwarciePlikKsiazki();
        try {
            Ksiazka DoWyporzyczenia = OperacjePlikKsiazki.OdczytywanieKsiazek(NowaHistoria);
            Autor=DoWyporzyczenia.GetAutor();
            NazwaKsiazki= DoWyporzyczenia.GetNazwaKsiazki();
            Gatunek= DoWyporzyczenia.GetGatunek();
            DataWydania= DoWyporzyczenia.GetDataWydania();
            //NowyCzytelnik=DoWyporzyczenia.GetWyporzyczajacy();
            //DataWyporzyczenia= DoWyporzyczenia.GetDataWyporzyczenia();
            //CzyWyporzyczona= DoWyporzyczenia.GetCzyWyporzyczona();
           //DoWyporzyczenia.SetCzyWyporzyczona("Tak");
            //DoWyporzyczenia.SetDataWyporzyczenia(DataWypozyczenia);
            //DoWyporzyczenia.SetDataTermin(DataTermin);
            CzyPoTerminie=DoWyporzyczenia.GetCzyPoTerminie();
            DataWpisu = Daty.ObecnaData();
            NowaHistoria.close();

        } catch (IOException e) {
        }
//v
        Historia Wpis = new Historia(IdHistoria,IdKsiazki,NazwaKsiazki,Autor,Gatunek,DataWydania,NowyCzytelnik,DataWyporzyczenia,CzyWyporzyczona,DataTermin,CzyPoTerminie,IdCzytelnik,DataWpisu);
        Historia WpisBooks = new Historia(IdHistoria,IdKsiazki,NazwaKsiazki,Autor,Gatunek,DataWydania,NowyCzytelnik,DataWyporzyczenia,CzyWyporzyczona,DataTermin,CzyPoTerminie,IdCzytelnik,DataWpisu);

        OperacjePlikKsiazki.KasowanieKsiazki(IdKsiazki);

        OperacjePlikHistoria.ZapisywanieHistorii(Wpis,"History.bin");
        OperacjePlikKsiazki.ZapisywanieKsiazek(WpisBooks,"Books.bin");
        Historia.Czekaj();

    }
    public static  void TworzenieWpisuBezBooks(Ksiazka ObiektKsiazka) throws IOException
    {

        int IdHistoria = 0;
        boolean OK=false;

        do {
             IdHistoria = GeneratorLosowegoID.Id();
            OK = SprawdzanieHistoria.CzyPodaneIdIstnieje(IdHistoria);
        }while(OK!= false);

            int IdKsiazka=ObiektKsiazka.GetIdKsiazki();
            String Autor=WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetAutor());
            String NazwaKsiazki= WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetNazwaKsiazki());
            String Gatunek= WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetGatunek());
            String DataWydania= WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetDataWydania());
            String NowyCzytelnik=WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetWyporzyczajacy());
            String DataWyporzyczenia= WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetDataWyporzyczenia());
            String CzyWyporzyczona= WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetCzyWyporzyczona());
            String DataTermin = WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetDataTermin());
            String CzyPoTerminie=WyszukiwanieKsiazka.BezSpacji(ObiektKsiazka.GetCzyPoTerminie());
            int IdCzytelnik=ObiektKsiazka.GetIdUzytkownika();
            String DataWpisu = Daty.ObecnaData();
        //System.out.println("IdKsiazki " + IdHistoria + "Id Ksiazki " +" "+ IdKsiazka  +" "+Autor+" "+Gatunek+" "+DataWydania+" "+NowyCzytelnik+" "+DataWyporzyczenia+" "+CzyWyporzyczona+" "+DataTermin+" "+CzyPoTerminie+" "+IdCzytelnik+" "+DataWpisu );
        Historia Wpis = new Historia(IdHistoria,IdKsiazka,NazwaKsiazki,Autor,Gatunek,DataWydania,NowyCzytelnik,DataWyporzyczenia,CzyWyporzyczona,DataTermin,CzyPoTerminie,IdCzytelnik,DataWpisu);
        OperacjePlikHistoria.ZapisywanieHistorii(Wpis,"History.bin");

    }
    public String GetCzyPoTerminieWyswietlanie()
    {
        String Termin;
        return Termin = Daty.CzyPoDacieString(Daty.SprawdzanieCzyPoPodanejDacie(GetDataWyporzyczenia(),GetDataTermin(),"ilepoterminie"));
    }

    public static void Czekaj()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Cos poszlo Nie tak");
        }
    }

    public  String ShowDaneHistoria()
    {

        String TekstWyswietl;

        TekstWyswietl =("| "+GetIdHistoiraWypisiywanie()+"\t| "+GetIdKsiazkaWypisiywanie()+"\t| " + GetIdUzytkownikaWypisywanie() +"\t| " + GetNazwaKsiazki() +"| "+GetWyporzyczajacy() +"| "+ GetDataWyporzyczenia() +"\t\t|\t\t"+ GetDataTermin() +"\t|\t"+GetCzyPoTerminieWyswietlanie() +"\t\t|\t\t" + GetCzyWyporzyczona()+"\t\t|\t\t\t"+GetDataWpisu()+"|");
        return TekstWyswietl;
    }
}
