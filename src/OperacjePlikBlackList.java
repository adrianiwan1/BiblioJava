import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OperacjePlikBlackList {

    public static void ZapisywanieZbanowanego(BlackList NowyZbanowany)throws IOException
    {
        RandomAccessFile baza =new RandomAccessFile("BlackList.bin","rw");
        baza.seek(baza.length());
        baza.writeUTF(String.format("%1$-32s",NowyZbanowany.GetZbanowany()));
    }

    public static RandomAccessFile OtwarciePlikBlackList() throws FileNotFoundException
    {
        RandomAccessFile baza =new RandomAccessFile("BlackList.bin","r");
        return baza;
    }

    public static BlackList OdczytywanieZbanowanych(RandomAccessFile baza) throws IOException
    {
        BlackList OdczytywanyZbanowany =null;
        try {
            OdczytywanyZbanowany = new BlackList(baza.readUTF());
        }catch (EOFException ex)
        {

        }
        return OdczytywanyZbanowany;
    }
}
