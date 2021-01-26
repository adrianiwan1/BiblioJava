import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OperacjePlikHistoria{

    public static void ZapisywanieHistorii(Historia NowyWpis,String NazwaPliku) throws IOException {
        RandomAccessFile baza =new RandomAccessFile(NazwaPliku,"rw");

        baza.seek(baza.length());
        baza.writeInt(NowyWpis.GetIdHistorii());
        baza.writeInt(NowyWpis.GetIdKsiazki()); // 32
        baza.writeUTF(String.format("%1$-32s",NowyWpis.GetNazwaKsiazki()));
        baza.writeUTF(String.format("%1$-32s",NowyWpis.GetAutor()));
        baza.writeUTF(String.format("%1$-24s",NowyWpis.GetGatunek()));
        baza.writeUTF(String.format("%1$-11s",NowyWpis.GetDataWydania()));
        baza.writeUTF(String.format("%1$-32s",NowyWpis.GetWyporzyczajacy()));

        baza.writeUTF(String.format("%1$-11s",NowyWpis.GetDataWyporzyczenia()));
        baza.writeUTF(String.format("%1$-3s",NowyWpis.GetCzyWyporzyczona())); //1

        baza.writeUTF(String.format("%1$-11s",NowyWpis.GetDataTermin()));
        baza.writeUTF(String.format("%1$-3s",NowyWpis.GetCzyPoTerminie()));
        baza.writeInt(NowyWpis.GetIdUzytkownika());



        System.out.println("Historia Zapisana");

        baza.close();
    }

    public static RandomAccessFile OtwarciePlikHistoria() throws FileNotFoundException {

        RandomAccessFile baza =new RandomAccessFile("History.bin","rw");
        return baza;
    }

    public static Historia OdczytywanieHistorii (RandomAccessFile baza) throws IOException
    {
        Historia OdczytywanaHistoria=null;
        try {
            OdczytywanaHistoria = new Historia(baza.readInt(),baza.readInt(),baza.readUTF(),baza.readUTF(), baza.readUTF(), baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readInt());
        }
        catch (EOFException ex)
        {

        }
        return OdczytywanaHistoria;
    }
}
