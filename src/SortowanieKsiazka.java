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

    public static String[] PoNazwaKsiazki()
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int i = 0;
        String K;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    TreeLista.add(OdczytaneDane.GetNazwaKsiazki());
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

    public static void WyswietlaniePosortowaneNazwaKsiazki(String[] ListaKoncowa) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaKoncowa.length;
        String Porownywana = null;
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
                        String Odczyt = OdczytaneDane.GetNazwaKsiazki(); //Wpisanie danej do int
                        Porownywana = ListaKoncowa[j];
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
    public static String[] PoAutor()
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int i = 0;
        String K;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    TreeLista.add(OdczytaneDane.GetAutor());
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

    public static void WyswietlaniePosortowaneAutor(String[] ListaKoncowa) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaKoncowa.length;
        String Porownywana = null;
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
                        String Odczyt = OdczytaneDane.GetAutor(); //Wpisanie danej do int
                        Porownywana = ListaKoncowa[j];
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
    public static String[] PoGatunek()
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int i = 0;
        String K;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    TreeLista.add(OdczytaneDane.GetGatunek());
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

    public static void WyswietlaniePosortowaneGatunek(String[] ListaKoncowa) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaKoncowa.length;
        String Porownywana = null;
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
                        String Odczyt = OdczytaneDane.GetGatunek(); //Wpisanie danej do int
                        Porownywana = ListaKoncowa[j];
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
    public static String[] PoDataWydania()
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int i = 0;
        String K;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    TreeLista.add(OdczytaneDane.GetDataWydania());
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

    public static void WyswietlaniePosortowaneDataWydania(String[] ListaKoncowa) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaKoncowa.length;
        String Porownywana = null;
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
                        String Odczyt = OdczytaneDane.GetDataWydania(); //Wpisanie danej do int
                        Porownywana = ListaKoncowa[j];
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

    public static String[] PoWyporzyczajacy()
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int i = 0;
        String K;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    TreeLista.add(OdczytaneDane.GetWyporzyczajacy());
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

    public static void WyswietlaniePosortowaneWyporzyczajacy(String[] ListaKoncowa) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaKoncowa.length;
        String Porownywana = null;
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
                        String Odczyt = OdczytaneDane.GetWyporzyczajacy(); //Wpisanie danej do int
                        Porownywana = ListaKoncowa[j];
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
    public static String[] PoDataWyporzyczenia()
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int i = 0;
        String K;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    TreeLista.add(OdczytaneDane.GetDataWyporzyczenia());
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

    public static void WyswietlaniePosortowaneDataWyporzyczenia(String[] ListaKoncowa) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaKoncowa.length;
        String Porownywana = null;
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
                        String Odczyt = OdczytaneDane.GetDataWyporzyczenia(); //Wpisanie danej do int
                        Porownywana = ListaKoncowa[j];
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
    public static String[] PoDataTermin()
    {
        TreeSet<String> TreeLista = new TreeSet<String>();
        int i = 0;
        String K;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
            do
            {
                Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                if(OdczytaneDane != null)
                {
                    TreeLista.add(OdczytaneDane.GetDataTermin());
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

    public static void WyswietlaniePosortowaneDataTermin(String[] ListaKoncowa) // Wyszukiwanie inta - > ID
    {
        int i = 0;
        int j = 0;
        int Dlugosc = ListaKoncowa.length;
        String Porownywana = null;
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
                        String Odczyt = OdczytaneDane.GetDataTermin(); //Wpisanie danej do int
                        Porownywana = ListaKoncowa[j];
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
