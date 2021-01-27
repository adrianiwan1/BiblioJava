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
public static ArrayList<Integer> PoId()
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
                ListaId.add(OdczytaneDane.GetIdHistorii());
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

    public static void WyswietlaniePosortowaneID(ArrayList<Integer> ListaID) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaID.size();
        int Porownywana = 0;
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
                        int Odczyt = OdczytaneDane.GetIdHistorii(); //Wpisanie danej do int
                        Porownywana = ListaID.get(j);
                        if(Porownywana == Odczyt) // Porownanie odczytu.
                        {
                            System.out.println(OdczytaneDane.ShowDane()); //Wyswietlenie odczytu
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
                        case "datawyporzyczenia":
                            TreeLista.add(OdczytaneDane.GetDataWyporzyczenia());
                            break;
                        case "czypoterminie":
                            TreeLista.add(OdczytaneDane.GetCzyPoTerminie());
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
                                Odczyt = OdczytaneDane.GetUzytkownik(); //Wpisanie danej do int
                                break;
                            case"datatermin":
                                Odczyt = OdczytaneDane.GetDataTermin(); //Wpisanie danej do int
                                break;
                            case"datawydania":
                                Odczyt = OdczytaneDane.GetDataWydania(); //Wpisanie danej do int
                                break;
                            case"datawyporzyczenia":
                                Odczyt = OdczytaneDane.GetDataWyporzyczenia(); //Wpisanie danej do int
                                break;
                            case"czypoterminie":
                                Odczyt = OdczytaneDane.GetCzyPoTerminie(); //Wpisanie danej do int
                                break;
                            case"czywyporzyczona":
                                Odczyt = OdczytaneDane.GetCzyWyporzyczona(); //Wpisanie danej do int
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
                            System.out.println(OdczytaneDane.ShowDane()); //Wyswietlenie odczytu
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
