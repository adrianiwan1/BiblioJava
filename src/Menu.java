import java.io.IOException;
import java.io.RandomAccessFile;

public class Menu
{
	public static void WypisywanieKsiazek()
	{
		int i = 0;
		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
				if(OdczytaneDane != null)
				{
					System.out.println(OdczytaneDane.ShowDane());
				} else
				{
					i = 201;
				}
				i++;
			} while(i < 200);
			PlikOdczytany.close();
		} catch(IOException e )
		{
		}
	}
	//
	//
	public static void WypisywanieUzytkownikow()
	{
		int i=0;
		try{
			RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy();
			do {
				Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany);
				if(OdczytaneDane != null)
				{
					System.out.println(OdczytaneDane.ShowUzytkownicy());
				} else
				{
					i = 201;
				}
				i++;
			}while(i < 200);
			PlikOdczytany.close();
		}catch(IOException e)
		{
		}
	}
	//

	//
	public static void TworzenieKsiazki()
	{
		Ksiazka ObiektKsiazka = Ksiazka.TworzenieKsiazka();
		try
		{
			OperacjePlikKsiazki.ZapisywanieKsiazek(ObiektKsiazka,"Books.bin");
		} catch(IOException e)
		{
		}

	}
	//
	//
	public static void TworznieUzytkownika()
	{
		Uzytkownik ObiektUzytkownik = Uzytkownik.TworzenieUzytkownik();
		try
		{
			OperacjePlikUzytkownicy.ZapisywanieUzytkownika(ObiektUzytkownik,"Users.bin");
		} catch(IOException e)
		{
		}
	}

}
