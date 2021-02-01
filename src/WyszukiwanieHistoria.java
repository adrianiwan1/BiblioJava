import java.io.IOException;
import java.io.RandomAccessFile;

public class WyszukiwanieHistoria {

    public static void Wyszukiwanie(String Zmienna)
    {

        String Szukana= null; // Poszukiwany String
        int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy
        int Szukany = 0;

        RandomAccessFile PlikOdczytany = null; //Otwarcie pliku
        try
        {   PlikOdczytany = OperacjePlikHistoria.OtwarciePlikHistoria();
            switch(Zmienna)
            {
                case"idksiazki":
                    System.out.println("Wpisz id wyszukiwanej ksiazki z histori.Wpisz 0 by anulowac.");  // Prosba o wpisanie
                    Szukany = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego slowa
                    if(Szukany == 0)
                    {

                        System.out.println("Powrót do poprzedniej opcji.");
                        try
                        {
                            PlikOdczytany.close();
                        }catch(NullPointerException e)
                        {

                        }
                        return;
                    }
                    Znalezione = WyszukiwanieID(Szukany,PlikOdczytany,Zmienna);

                    break;
                case"id":
                    System.out.println("Wpisz id wpisu z histori.Wpisz 0 by anulowac.");  // Prosba o wpisanie
                    Szukany = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego slowa
                    if(Szukany == 0)
                    {
                        System.out.println("Powrót do poprzedniej opcji.");
                        try
                        {
                            PlikOdczytany.close();
                        }catch(NullPointerException e)
                        {

                        }
                        return;
                    }
                    Znalezione = WyszukiwanieID(Szukany,PlikOdczytany,Zmienna);
                    break;
                case"idczytelnika":
                    System.out.println("Wpisz id wyszukiwanego czytelnika.Wpisz 0 by anulowac.");  // Prosba o wpisanie
                    Szukany = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego slowa
                    if(Szukany == 0)
                    {
                        System.out.println("Powrót do poprzedniej opcji.");
                        try
                        {
                            PlikOdczytany.close();
                        }catch(NullPointerException e)
                        {

                        }
                        return;
                    }
                    Znalezione = WyszukiwanieID(Szukany,PlikOdczytany,Zmienna);
                    break;
                case"czywyporzyczonatak":
                    Szukana = ("tak");
                    Znalezione = UltraSkroconeWyszukiwanie(Szukana,PlikOdczytany,Zmienna);
                    Znalezione = Znalezione + 20;
                        break;
                default:
                    System.out.println("Wpisz nazwe poszukiwanej treści.Wpisz 0 by anulować");  // Prosba o wpisanie
                    Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
                    if(Szukana.equals("0") )
                    {
                        System.out.println("Powrót do poprzedniej opcji.");
                        try
                        {
                            PlikOdczytany.close();
                        }catch(NullPointerException e)
                            {

                            }
                        return;
                    }
                    Znalezione = UltraSkroconeWyszukiwanie(Szukana,PlikOdczytany,Zmienna);
                    break;

            }
            if(Znalezione == 0)
            {
                System.out.println("Nie znaleziono wyszukiwanej treści.");
            }
            if(Znalezione == 20)
            {
                System.out.println("Nie ma książek do oddania.");
            }
            PlikOdczytany.close(); // Zamkniecie odczytu
        } catch(IOException e)
        {
        }
    }

    public static int WyszukiwanieID(int Szukany,RandomAccessFile PlikOdczytany,String Zmienna) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int Znalezione = 0;
        int Odczyt = 0;
        try
        {
            do
            {
                Historia OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany); // Odczytranie linjki tekstu
                if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                {
                    switch(Zmienna)
                    {
                        case "idksiazki":
                            Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
                            break;
                        case "idczytelnika":
                             Odczyt = OdczytaneDane.GetIdUzytkownika(); //Wpisanie danej do int
                            break;
                        case "id":
                            Odczyt = OdczytaneDane.GetIdHistorii(); //Wpisanie danej do int
                            break;
                    }
                    if(Szukany == Odczyt) // Porownanie odczytu.
                    {
                        System.out.println(OdczytaneDane.ShowDane()); //Wyswietlenie odczytu
                        Znalezione++;
                    }
                }
                i++;
            } while(i < 9000); // Maksymalna wartosc petli
            PlikOdczytany.close();
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



        Szukana = WyszukiwanieKsiazka.BezSpacji(Szukana); // Usuniecie spacji
        try {
            do {

                Historia OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany); // Odczytranie linjki tekstu
                if (OdczytaneDane != null) // Jesli nie jest puste wykonaj
                {
                    switch (Zmienna) {
                        case "datatermin":
                            Odczyt = OdczytaneDane.GetDataTermin(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "gatunek":
                            Odczyt = OdczytaneDane.GetGatunek(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "autor":
                            Odczyt = OdczytaneDane.GetAutor(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "nazwa":
                            Odczyt = OdczytaneDane.GetNazwaKsiazki(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "datawydania":
                            Odczyt = OdczytaneDane.GetDataWydania(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "datawyporzyczenia":
                            Odczyt = OdczytaneDane.GetDataWyporzyczenia(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "wyporzyczajacy":
                            Odczyt = OdczytaneDane.GetWyporzyczajacy(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "czywyporzyczona":
                            Odczyt = OdczytaneDane.GetCzyWyporzyczona(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "czywyporzyczonatak":
                            Odczyt = OdczytaneDane.GetCzyWyporzyczona(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                        case "czypoterminie":
                            Odczyt = OdczytaneDane.GetCzyPoTerminie(); //Wpisanie danej do Stringa
                            OdczytBezSpacji = WyszukiwanieKsiazka.BezSpacji(Odczyt); //Usuniecie spacji
                            break;
                    }
                    if (Odczyt.equals("PustyPustoPustusienkoNiemaNic")) //Jesl nic nie wpisano do odczytu.
                    {
                        i = 9002; // Zakonczenie petli jesli null
                    } else {
                        if (Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
                        {
                            System.out.println(OdczytaneDane.ShowDane()); //Wyswietlenie odczytu
                            Znalezione++;
                        }
                    }
                    i++;
                }else {i=9002;}
            } while (i < 9000);
            PlikOdczytany.close();
        } catch (IOException e)// Maksymalna wartosc petli
        {

        }
        return Znalezione;
    }
}
