import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ProjektJavaBiblioteka {
	public static void main(String[] args)
	{



		int i =0;
		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
				if(OdczytaneDane != null) {
				System.out.println(OdczytaneDane.ShowDane());
				}else
				{
				 i = 4;
				}
				i++;
			} while(i<3);
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Poszlo dalej?");


	}

}
