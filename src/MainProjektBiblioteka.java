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
	public static void main(String[] args) throws IOException
	{
		/*
		String DataObecna = Daty.ObecnaData();
		System.out.println("Wyporzyczenia Data " + DataObecna);
		String DataTermin = Daty.TerminOddania(DataObecna);
		System.out.println("Obecna Termin " + DataTermin);
		String DataWpisania = Daty.WpisanieDaty();
		System.out.println("Obecna Data " + DataWpisania);
		long Porownanie = Daty.CzyPoTerminie(DataWpisania,DataTermin,"czypoterminie");
		System.out.println("Czy po terminie " + Porownanie);
		Porownanie = Daty.CzyPoTerminie(DataWpisania,DataTermin,"ilepoterminie");
		System.out.println("Ile po terminie " + Porownanie);
		 */
		try
		{
			Menu.MenuGlowne();
		}catch(NullPointerException e)
		{

		}
	}
}

