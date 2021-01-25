import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Sortowanie
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
}
