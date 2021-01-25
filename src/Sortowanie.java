import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sortowanie {

    public static ArrayList<Integer> PoId()  {
         ArrayList<Integer> ListaId=new ArrayList<Integer>();

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

    public static void WypisywanieKsiazekPoId(ArrayList listaId) {


        int i = 0;
        for (int j = 0; j <= listaId.size(); j++) {
            i = (int) listaId.get(j);


            try {
                RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
                do {
                    Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
                    if (OdczytaneDane != null) {
                        System.out.println(OdczytaneDane.ShowDane());
                    } else {
                        i = 201;
                    }
                    i++;
                } while (i < 200);
                PlikOdczytany.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
