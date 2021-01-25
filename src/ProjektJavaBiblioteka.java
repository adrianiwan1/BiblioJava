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


	public static void main(String[] args)
	{

		/*
		for(int i=0; i<2; i++)
		{

			Menu.WypisywanieKsiazek();
			Ksiazka Nowa = Ksiazka.TworzenieKsiazka();
			try
			{
				OperacjePlikKsiazki.ZapisywanieKsiazek(Nowa);
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}

		 */


			Wyszukiwanie.WyszukiwanieArrayListaID(Sortowanie.PoId());

	}
}

