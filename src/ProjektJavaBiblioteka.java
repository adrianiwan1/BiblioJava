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


	public static void main(String[] args) throws FileNotFoundException
	{


		Menu.WypisywanieKsiazek();
		OperacjePlikKsiazki.UsuwanieKsiazki();
		Menu.WypisywanieKsiazek();
		/*for(int i=0; i<4; i++)
		{
			Ksiazka Nowa = Ksiazka.TworzenieKsiazka();
			try
			{
				OperacjePlikKsiazki.ZapisywanieKsiazek(Nowa,"Books.bin");
			} catch(IOException e)
			{

			}
		}
		 */

	}
}

