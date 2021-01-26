import java.io.IOException;
import java.io.RandomAccessFile;

public class BlackList {
    private String Zbanowany;
    private int IdZbanowany;

    public BlackList(int IdZbanowany ,String Zbanowany)
    {
        this.Zbanowany=Zbanowany;
        this.IdZbanowany= IdZbanowany;
    }
    public static BlackList TworzenieUzytkownik(int PodaneID , String Zbanowany  )
    {
        BlackList ObiektZbanowany = new BlackList(PodaneID,Zbanowany);
        return ObiektZbanowany;
    }
        public static BlackList Banowanie(int PodaneID) // Wyszukiwanie inta - > ID
        {
            int i = 0;
            int Znalezione = 0;
            int IdZbanowanego = 0;
            String Zbanowany = null;
            BlackList ObiektZbanowany = null;

            try
            {
                RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy(); //Otwarcie pliku
                do
                {
                    Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
                    if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                    {
                        int Odczyt = OdczytaneDane.GetIdUzytkownika(); //Wpisanie danej do int.
                        if(PodaneID == Odczyt) // Porownanie odczytu.
                        {
                            Znalezione++;
                            IdZbanowanego = OdczytaneDane.GetIdUzytkownika();
                            Zbanowany = OdczytaneDane.GetUzytkownik();
                        }
                    } else
                    {
                        i = 9002; // Zakonczenie petli jesli null
                    }
                    i++;
                } while(i < 9000); // Maksymalna wartosc petli
                PlikOdczytany.close(); // Zamkniecie odczytu
            } catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
            {
                e.printStackTrace();
            }
            if(Znalezione != 0) // Obsluga nie znalezienia zadnej wartosci
            {
                return ObiektZbanowany = TworzenieUzytkownik(IdZbanowanego,Zbanowany);
            } else
            {
                System.out.println("Uzytkownik z podanym Id nie istnieje.");
                return ObiektZbanowany = null;
            }
        }


    //Getery
    public int GetIdZbanownay()
    {
        return IdZbanowany;
    }
    public void SetIdZbanownay(int IdZbanowany)
    {
        this.IdZbanowany= IdZbanowany;
    }

    public String GetZbanowany()
    {
        return Zbanowany;
    }

    public void SetZbanowany(String Zbanowany)
    {
        this.Zbanowany=Zbanowany;
    }

    public  String ShowDane()
    {
        String TekstWyswietl;

        return TekstWyswietl = (GetIdZbanownay()+ "\t\t\t" + GetZbanowany());
    }

}
