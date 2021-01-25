import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OperacjePlikUrzytkownicy {

    public static void ZapisywanieUrzytkownika(Urzytkownik NowyUrzytkownik)throws IOException {

        RandomAccessFile baza =new RandomAccessFile("Users.bin","rw");
        baza.seek(baza.length());

        baza.writeInt(NowyUrzytkownik.GetIdUrzytkownika());
        baza.writeUTF(String.format("%1$-32s",NowyUrzytkownik.GetUrzytkownik()));

        baza.close();
        System.out.println("Urzytkownik zapisany");


    }

    public static RandomAccessFile OtwarciePlikUrzytkownicy() throws FileNotFoundException {
        RandomAccessFile baza =new RandomAccessFile("Users.bin","r");
        return baza;
    }

    public static Urzytkownik OdczytywanieUrzytkownikow (RandomAccessFile baza) throws IOException
    {
        Urzytkownik OdczytywanyUrzytkownik=null;
        try {
            OdczytywanyUrzytkownik = new Urzytkownik(baza.readInt(),baza.readUTF());
        }
        catch (EOFException ex)
        {

        }
        return OdczytywanyUrzytkownik;
    }
}
