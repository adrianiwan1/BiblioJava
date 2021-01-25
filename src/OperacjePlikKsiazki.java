import java.io.*;

public class OperacjePlikKsiazki{



    public static void ZapisywanieKsiazek(Ksiazka NowaKsiazka) throws IOException {
        //RandomAccessFile baza =new RandomAccessFile("Books.bin","rw");
        ObjectOutputStream baza = new ObjectOutputStream(new FileOutputStream("Books.bin"));

         baza.writeObject(NowaKsiazka);

        /*
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
    */
        System.out.println("ZApis udany");


    }

    public static Ksiazka OdczytywanieKsiazek(ObjectInputStream baza) throws IOException, ClassNotFoundException {

        Ksiazka OdczytywanaKsiazka=null;
        try {
            ObjectInputStream PlikOdczytywanaKsiazka = new ObjectInputStream(OtwarciePlikKsiazki());

            OdczytywanaKsiazka = (Ksiazka) PlikOdczytywanaKsiazka.readObject();
        }catch(EOFException e)
        {
            System.out.println("324234234");
        }



        return OdczytywanaKsiazka;

    }


    public static ObjectInputStream OtwarciePlikKsiazki() throws IOException {
        ObjectInputStream baza = new ObjectInputStream(new FileInputStream("Books.bin"));
        //RandomAccessFile baza =new RandomAccessFile("Books.bin","r");
        return baza;
    }


}
