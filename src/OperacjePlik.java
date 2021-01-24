import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OperacjePlik{



    public void Zapisywanie(Ksiazka NowaKsiazka) throws IOException {
        RandomAccessFile baza =new RandomAccessFile("Books.bin","rw");

        baza.seek(baza.length());

        baza.writeInt(NowaKsiazka.GetIdKsiazki()); // 32
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetNazwaKsiazki()));
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetAutor()));
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetGatunek()));
        baza.writeUTF(String.format("%1$-10s",NowaKsiazka.GetDataWydania()));
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetWyporzyczajacy()));

        baza.writeInt(NowaKsiazka.GetDniWyporzyczenia());
        baza.writeInt(NowaKsiazka.GetMiesiaceWyporzyczenia());
        baza.writeInt(NowaKsiazka.GetRokWyporzyczenia());
        baza.writeBoolean(NowaKsiazka.GetCzyWyporzyczona()); //1

        baza.writeInt(NowaKsiazka.GetDniTermin());
        baza.writeInt(NowaKsiazka.GetMiesiaceTermin());
        baza.writeInt(NowaKsiazka.GetRokTermin());
        baza.writeBoolean(NowaKsiazka.GetCzyPoTerminie()); //1

        System.out.println("ZApis udany");


    }

    public Ksiazka Odczytywanie() throws IOException {
        RandomAccessFile baza =new RandomAccessFile("Books.bin","rw");
        baza.seek(0);

        Ksiazka OdczytywanaKsiazka= new Ksiazka(baza.readInt(),baza.readUTF(),baza.readUTF(), baza.readUTF(), baza.readUTF(), baza.readUTF(),baza.readInt(), baza.readInt(), baza.readInt(), baza.readBoolean(), baza.readInt(), baza.readInt(), baza.readInt(), baza.readBoolean());
        baza.seek(364);

        return OdczytywanaKsiazka;

    }





}
