import javax.xml.crypto.Data;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.time.Month;
import java.time.LocalDate;
import java.text.ParseException;

public class MainProjektBiblioteka
{


	public static void main(String[] args) throws IOException {


		Menu.WypisywanieUzytkownikow();
		Menu.TworznieUzytkownika();
		Menu.TworzenieKsiazki();
		Menu.WypisywanieUzytkownikow();
		Menu.WypisywanieKsiazek();




	}
}

