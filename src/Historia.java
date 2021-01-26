import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Historia extends Ksiazka{
    int IdHistoria;


    public Historia(int IdHistoria,int IdKsiazki, String NazwaKsiazki, String Autor, String Gatunek, String DataWydania,
                    String NowyCzytelnik,String DataWyporzyczenia,String CzyWyporzyczona,String DataTermin,String CzyPoTerminie,int IdUzytkownik) {
        super(IdKsiazki,NazwaKsiazki,Autor,Gatunek,DataWydania,NowyCzytelnik,DataWyporzyczenia,CzyWyporzyczona,DataTermin,CzyPoTerminie,IdUzytkownik);

        this.IdHistoria=IdHistoria;

    }

    public int GetIdHistorii() {

        return IdHistoria;
    }

    public static  void TworzenieWpisu(int IdPorzyczanejKsiazki, int IdWyporzyczajacego,String NowyDataWypozyczenia,String NowyDataTermin) throws IOException {

        int IdHistoria;
        int IdKsiazki= IdPorzyczanejKsiazki;
        int IdCzytelnik = IdWyporzyczajacego;
        String NazwaKsiazki=null;
        String Autor=null;
        String Gatunek=null;
        String DataWydania=null;
        String NowyCzytelnik=null;
        String DataWyporzyczenia=NowyDataWypozyczenia;
        String CzyWyporzyczona="Tak";
        String DataTermin=NowyDataTermin;
        String CzyPoTerminie=null;



        boolean OK=false;

        do {
            IdHistoria = Unikalne.Id();
            OK = SprawdzanieHistoria.CzyPodaneIdIstnieje(IdHistoria);
        }while(OK!= false);
        Menu.WypisywanieKsiazek();
        RandomAccessFile NowaHistoria = OperacjePlikKsiazki.OtwarciePlikKsiazki();

        try {
            Ksiazka DoWyporzyczenia = OperacjePlikKsiazki.OdczytywanieKsiazek(NowaHistoria);
            Autor=DoWyporzyczenia.GetAutor();
            NazwaKsiazki= DoWyporzyczenia.GetNazwaKsiazki();
            Gatunek= DoWyporzyczenia.GetGatunek();
            DataWydania= DoWyporzyczenia.GetDataWydania();
            NowyCzytelnik=DoWyporzyczenia.GetWyporzyczajacy();
            //DataWyporzyczenia= DoWyporzyczenia.GetDataWyporzyczenia();
            //CzyWyporzyczona= DoWyporzyczenia.GetCzyWyporzyczona();
           //DoWyporzyczenia.SetCzyWyporzyczona("Tak");
            //DoWyporzyczenia.SetDataWyporzyczenia(DataWypozyczenia);
            //DoWyporzyczenia.SetDataTermin(DataTermin);
            CzyPoTerminie=DoWyporzyczenia.GetCzyPoTerminie();
            NowaHistoria.close();

        } catch (IOException e) {

        }





        Historia Wpis = new Historia(IdHistoria,IdKsiazki,NazwaKsiazki,Autor,Gatunek,DataWydania,NowyCzytelnik,DataWyporzyczenia,CzyWyporzyczona,DataTermin,CzyPoTerminie,IdCzytelnik);


        OperacjePlikKsiazki.KasowanieKsiazki(IdKsiazki);

        OperacjePlikHistoria.ZapisywanieHistorii(Wpis,"History.bin");
        OperacjePlikKsiazki.ZapisywanieKsiazek(Wpis,"Books.bin");
        Historia.Czekaj();






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

    public  String ShowDane()
    {

        String TekstWyswietl;

        TekstWyswietl =(GetIdKsiazki()+ "\t\t" + GetNazwaKsiazki() + GetAutor() + GetGatunek()  + "Wyporzycający:"+GetWyporzyczajacy() + GetDataWydania()+ "\t\t" + GetCzyWyporzyczona() +
                "\t\t" + GetDataWyporzyczenia() +"\t\t" +"Po terminie:" +GetCzyPoTerminie() + "\t\t" + GetDataTermin() +"\t\t"+GetIdUzytkownika());
        return TekstWyswietl;
    }
}
