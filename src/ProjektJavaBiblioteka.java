import javax.xml.crypto.Data;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.time.Month;
import java.time.LocalDate;
import java.text.ParseException;

public class ProjektJavaBiblioteka
{


	public static void main(String[] args) throws IOException {


		Ksiazka Jan = Ksiazka.TworzenieKsiazka();
		OperacjePlikKsiazki.ZapisywanieKsiazek(Jan,"Books.bin");
		//Menu.WypisywanieUzytkownikow();
		Menu.WypisywanieKsiazek();


	}
}

