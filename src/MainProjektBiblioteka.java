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
		//String DataWpisania = Daty.WpisanieDaty();
		String DataObecna = Daty.ObecnaData();
		System.out.println("Obecna Data" + DataObecna);
		String DataTermin = Daty.TerminOddania(DataObecna);
		System.out.println("Obecna Termin" + DataTermin);
		int Porownanie = Daty.Porownanie(DataTermin,DataObecna);
		System.out.println("Porownanie" + Porownanie);


		//OperacjePlikKsiazki.KasowanieKsiazki(889739693);
		 //Menu.WypisywanieUzytkownikow();
		//Menu.TworznieUzytkownika();
		//Menu.TworzenieKsiazki();
		//Menu.WypisywanieUzytkownikow();
		//Menu.WypisywanieKsiazek();

		/*
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
		Menu.WypisywanieKsiazek();

		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
		Menu.WypozyczanieKsiazki();
 		*/


	}
}

