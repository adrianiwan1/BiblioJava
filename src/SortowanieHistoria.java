import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class SortowanieHistoria {
/*
    public static String[] Sortowanie(String Zmienna) // Zmienna to wartosc co sortujemy potrzebne do switcha.
    {

        return ListaKoncowa;

    }

 */
public static ArrayList<Integer> PoId(String Zmienna)
{
    ArrayList<Integer> ListaId = new ArrayList<Integer>();

    int i = 0;
    try
    {
        RandomAccessFile PlikOdczytany = OperacjePlikHistoria.OtwarciePlikHistoria();
        do
        {
            Historia OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany);
            if(OdczytaneDane != null)
            {
                switch(Zmienna)
                {
                    case"id":
                        ListaId.add(OdczytaneDane.GetIdHistorii());
                        break;
                    case"idksiazki":
                        ListaId.add(OdczytaneDane.GetIdKsiazki());
                        break;
                    case"iduzytkownika":
                        ListaId.add(OdczytaneDane.GetIdUzytkownika());
                        break;
                }
            } else
            {
                i = 201;
            }
            i++;
        } while(i < 200);
        PlikOdczytany.close();
    } catch(IOException e)
    {
        e.printStackTrace();
    }

    Collections.sort(ListaId);
    return ListaId;
}

    public static void WyswietlaniePosortowaneID(ArrayList<Integer> ListaID,String  Zmienna) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaID.size();
        int Porownywana = 0;
        int Odczyt = 0;
        do
        {
            i = 0;
            try
            {
                RandomAccessFile PlikOdczytany = OperacjePlikHistoria.OtwarciePlikHistoria(); //Otwarcie pliku
                do
                {
                    Historia OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany); // Odczytranie linjki tekstu
                    if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                    {
                        switch(Zmienna)
                        {
                            case"id":
                              Odczyt = OdczytaneDane.GetIdHistorii(); //Wpisanie danej do int
                              Porownywana = ListaID.get(j);
                              break;
                            case"idksiazki":
                                Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
                                Porownywana = ListaID.get(j);
                                break;
                            case"iduzytkownika":
                                Odczyt = OdczytaneDane.GetIdUzytkownika(); //Wpisanie danej do int
                                Porownywana = ListaID.get(j);
                                break;
                        }
                        if(Porownywana == Odczyt) // Porownanie odczytu.
                        {
                            System.out.println(OdczytaneDane.ShowDaneHistoria()); //Wyswietlenie odczytu
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
            j++;
        } while((Dlugosc) != j);
    }

    public static void WyswietlaniePosortowaneHistoria(String Zmienna) // Wpisujesz Jedną opcję z case i wyświetla w konsoli posortowane według niej.
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int x = 0;

        int i = 0;
        int j = 0;
        String Porownywana = null;
        String Odczyt = ("PustyPustoPustusienkoNiemaNic");

        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikHistoria.OtwarciePlikHistoria();
            do
            {

                Historia OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    switch(Zmienna)
                    {
                        case "nazwaksiazki":
                            TreeLista.add(OdczytaneDane.GetNazwaKsiazki());
                            break;
                        case "autor":
                            TreeLista.add(OdczytaneDane.GetAutor());
                            break;
                        case "uzytkownik":
                            TreeLista.add(OdczytaneDane.GetWyporzyczajacy());
                            break;
                        case "czypoterminie":
                            TreeLista.add(OdczytaneDane.GetCzyPoTerminie());
                            break;
                        case"czywyporzyczona":
                            TreeLista.add(OdczytaneDane.GetCzyWyporzyczona()); //Wpisanie danej do int
                            break;
                        case"gatunek":
                            TreeLista.add(OdczytaneDane.GetGatunek()); //Wpisanie danej do int
                            break;

                    }
                } else
                {
                    x = 201;
                }
                x++;
            } while(x < 200);
            PlikOdczytany.close();
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        String[] ListaKoncowa = TreeLista.toArray(new String[TreeLista.size()]);

        int Dlugosc = ListaKoncowa.length;

        do
        {
            i = 0;
            try
            {
                RandomAccessFile PlikOdczytany = OperacjePlikHistoria.OtwarciePlikHistoria(); //Otwarcie pliku
                do
                {
                    Historia OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany); // Odczytranie linjki tekstu
                    if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                    {
                        switch(Zmienna)
                        {
                            case"nazwaksiazki":
                                Odczyt = OdczytaneDane.GetNazwaKsiazki(); //Wpisanie danej do int
                                break;
                            case"autor":
                                Odczyt = OdczytaneDane.GetAutor(); //Wpisanie danej do int
                                break;
                            case"uzytkownik":
                                Odczyt = OdczytaneDane.GetNazwaUzytkownik(); //Wpisanie danej do int
                                break;
                            case"czypoterminie":
                                Odczyt = OdczytaneDane.GetCzyPoTerminie(); //Wpisanie danej do int
                                break;
                            case"czywyporzyczona":
                                Odczyt = OdczytaneDane.GetCzyWyporzyczona(); //Wpisanie danej do int
                                break;
                            case"gatunek":
                                Odczyt = OdczytaneDane.GetGatunek(); //Wpisanie danej do int
                                break;
                        }
                        if(Odczyt.equals("PustyPustoPustusienkoNiemaNic"))
                        {

                        }else
                        {
                            Porownywana = ListaKoncowa[j];
                        }
                        if(Porownywana.equals(Odczyt)) // Porownanie odczytu.
                        {
                            System.out.println(OdczytaneDane.ShowDaneHistoria()); //Wyswietlenie odczytu
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
            j++;
        } while((Dlugosc) != j);
    }
}
