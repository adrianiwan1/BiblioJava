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
}
