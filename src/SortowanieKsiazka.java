import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class SortowanieKsiazka
{

    public static ArrayList<Integer> PoId()
    {
        ArrayList<Integer> ListaId = new ArrayList<Integer>();

        int i = 0;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    ListaId.add(OdczytaneDane.GetIdKsiazki());
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
                RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
                do
                {
                    Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
                    if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
                    {
                        int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
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

    public static String[] Sortowanie(String Zmienna) // Zmienna to wartosc co sortujemy potrzebne do switcha.
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int i = 0;

        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {

                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
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
                        case "datatermin":
                            TreeLista.add(OdczytaneDane.GetDataTermin());
                            break;
                        case "datawydania":
                            TreeLista.add(OdczytaneDane.GetDataWydania());
                            break;
                        case "datawyporzyczenia":
                            TreeLista.add(OdczytaneDane.GetDataWyporzyczenia());
                            break;
                        case "czypoterminie":
                            TreeLista.add(OdczytaneDane.GetCzyPoTerminie());
                            break;
                        case "czywyporzyczona":
                            TreeLista.add(OdczytaneDane.GetCzyWyporzyczona());
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
        String[] ListaKoncowa = TreeLista.toArray(new String[TreeLista.size()]);
        return ListaKoncowa;

    }

    public static void WyswietlaniePosortowaneNazwaKsiazki(String[] ListaKoncowa,String Zmienna) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaKoncowa.length;
        String Porownywana = null;
        String Odczyt = ("PustyPustoPustusienkoNiemaNic");
        do
        {
            i = 0;
            try
            {
                RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
                do
                {
                    Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
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
