import java.io.IOException;
import java.io.RandomAccessFile;

public class WyszukiwanieUzytkownik {


    public static void Wyszukiwanie(String Zmienna) //podajemy co chcemy wyszukać:idUzytkownika, Nazwa,CzyZbanowany
    {

        String Szukana= null; // Poszukiwany String
        int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy
        int Szukany = 0;

        RandomAccessFile PlikOdczytany = null; //Otwarcie pliku
        try
        {
            PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy();
            if (Zmienna.equals("idUzytkownika"))
            {
                System.out.println("Wpisz id wyszukiwanego użytkownika.");  // Prosba o wpisanie
                Szukany = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego slowa
                WyszukiwanieID(Szukany,PlikOdczytany);
            }else
            {
                if(Zmienna.equals("nazwa"))
                {
                    System.out.println("Wpisz nazwę Użytkownika.");  // Prosba o wpisanie
                    Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
                    UltraSkroconeWyszukiwanie(Szukana,PlikOdczytany,Zmienna);

                }else {
                    System.out.println("Wpisz czy zbanowany czy nie.");  // Prosba o wpisanie
                    Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
                    UltraSkroconeWyszukiwanie(Szukana, PlikOdczytany, Zmienna);
                }
            }
            if(Znalezione == 0)
            {
                System.out.println("Nie znaleziono wyszukiwanej treści.");
            }
            PlikOdczytany.close(); // Zamkniecie odczytu
        } catch(IOException e)
        {
        }
    }

    public static int WyszukiwanieID(int Szukany, RandomAccessFile PlikOdczytany) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int Znalezione = 0;
        try
        {
            do
            {
                Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
                if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                {
                    int Odczyt = OdczytaneDane.GetIdUzytkownika(); //Wpisanie danej do int
                    if(Szukany == Odczyt) // Porownanie odczytu.
                    {
                        System.out.println(OdczytaneDane.ShowUzytkownicy()); //Wyswietlenie odczytu
                        Znalezione++;
                    }
                } else
                {
                    i = 9002; // Zakonczenie petli jesli null
                }
                i++;
            } while(i < 9000); // Maksymalna wartosc petli
        }catch(IOException e)
        {

        }
        return Znalezione;
    }

    public static int WyszukiwanieCzyZablokowany(String Szukany,RandomAccessFile PlikOdczytany) // Wyszukiwanie inta - > ID zwraca 1 gdy zablokowany
    {
        int i = 0;
        int Znalezione = 0;
        try
        {
            do
            {
                Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
                if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                {
                    String Odczyt = OdczytaneDane.GetCzyZbanowany(); //Wpisanie danej do int
                    if(Szukany.equals(Odczyt)) // Porownanie odczytu.
                    {
                        System.out.println(OdczytaneDane.ShowUzytkownicy()); //Wyswietlenie odczytu
                        Znalezione++;
                    }
                } else
                {
                    i = 9002; // Zakonczenie petli jesli null
                }
                i++;
            } while(i < 9000); // Maksymalna wartosc petli
        }catch(IOException e)
        {

        }
        return Znalezione;
    }

    public static int UltraSkroconeWyszukiwanie(String Szukana, RandomAccessFile PlikOdczytany, String Zmienna) {
        int i = 0;
        int Znalezione = 0;
        String OdczytBezSpacji = ("PustyPustoPustusienkoNiemaNic");
        String Odczyt = ("PustyPustoPustusienkoNiemaNic");



        Szukana = BezSpacji(Szukana); // Usuniecie spacji
        try {
            do {

                Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
                if (OdczytaneDane != null) // Jesli nie jest puste wykonaj
                {
                    switch (Zmienna) {
                        case "CzyZbanowany":
                            Odczyt = OdczytaneDane.GetCzyZbanowany(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "nazwa":
                            Odczyt = OdczytaneDane.GetNazwaUzytkownik(); //Wpisanie danej do Stringa
                            System.out.println("To odczytałem:"+Odczyt);
                            System.out.println("Takiego typu szukam:"+Zmienna);
                            System.out.println("Tego szukam:"+Szukana);
                            OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                    }

                    if (Odczyt.equals("PustyPustoPustusienkoNiemaNic")) //Jesl nic nie wpisano do odczytu.
                    {
                        i = 9002; // Zakonczenie petli jesli null
                    } else {
                        if (Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
                        {
                            System.out.println("Nie działa");
                            System.out.println(OdczytaneDane.ShowUzytkownicy()); //Wyswietlenie odczytu
                            Znalezione++;
                        } else {
                            System.out.println("@@@@@@@"+Szukana);
                            System.out.println("%%%%%%%"+OdczytBezSpacji);
                            System.out.println("Nie działa!!!!!");
                            i = 9002; // Zakonczenie petli jesli null
                        }
                    }
                    i++;
                }
                PlikOdczytany.close();
            } while (i < 9000);
        } catch (IOException e)// Maksymalna wartosc petli
        {
        }
        return Znalezione;
    }


    public  static String BezSpacji(String Slowo)
    {
        String GotoweSlowo = null;
        if (Slowo != null)
        {
            GotoweSlowo = Slowo.trim();
            return GotoweSlowo;
        }else
        {
            GotoweSlowo =("Podane Slowo jest puste");
            return GotoweSlowo;
        }
    }
}
