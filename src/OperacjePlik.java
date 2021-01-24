import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OperacjePlik{



    public void Zapisywanie(Ksiazka NowaKsiazka) throws IOException {
        RandomAccessFile baza =new RandomAccessFile("Books.bin","rw");

        baza.writeInt(NowaKsiazka.GetIdKsiazki());
        baza.writeUTF(NowaKsiazka.GetNazwaKsiazki());
        baza.writeUTF(NowaKsiazka.GetAutor());
        baza.writeUTF(NowaKsiazka.GetGatunek());
        baza.writeUTF(NowaKsiazka.GetDataWydania());
        baza.writeUTF(NowaKsiazka.GetWyporzyczajacy());
        baza.writeUTF(NowaKsiazka.GetGatunek());
        //test


    }

}
