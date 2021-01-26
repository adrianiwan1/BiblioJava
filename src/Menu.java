import java.io.FileNotFoundException;
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
					System.out.println(OdczytaneDane.ShowDane());
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
	public static void WypisywanieZbanowanych()
	{
		int i=0;
		try{
			RandomAccessFile PlikOdczytany = OperacjePlikBlackList.OtwarciePlikBlackList();
			do {
				BlackList OdczytaneDane = OperacjePlikBlackList.OdczytywanieZbanowanych(PlikOdczytany);
				if(OdczytaneDane != null)
				{
					System.out.println(OdczytaneDane.ShowDane());
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
	public static void Banowanie()
	{
		int PodaneID = 0;
		String NazwaPliku = ("BlackList.bin");
		System.out.println("Podaj Id uzytkownika ktorego chcesz zbanowac");
		PodaneID = WpisywanieDanych.WpisanieLiczby();
		boolean OK = SprawdzanieUzytkownik.CzyPodaneIdIstnieje(PodaneID);
		if(OK != false)
		{
			BlackList ObiektZbanowany = BlackList.Banowanie(PodaneID);
			try
			{
				OperacjePlikBlackList.ZapisywanieZbanowanego(ObiektZbanowany,NazwaPliku);
			} catch(IOException e)
			{
			}
		} else
		{
			System.out.println("Podany uzytkownik nie istnieje");
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
		boolean OK = false;
		int IdUzytkownika =0;
		String NazwaPlikuBlackList = ("BlackList.bin");
		String NazwaPlikuUzytkownik = ("Users.bin");
		Uzytkownik ObiektUzytkownik = Uzytkownik.TworzenieUzytkownik();
		try
		{
			OperacjePlikUzytkownicy.ZapisywanieUzytkownika(ObiektUzytkownik,NazwaPlikuUzytkownik);
		} catch(IOException e)
		{
		}
		System.out.println("Czy chcesz od razu dodac uzytkownika do zbanowanych?");
		OK = WpisywanieDanych.WpisanieBool();
		if(OK == true)
		{
			IdUzytkownika = ObiektUzytkownik.GetIdUzytkownika();
			boolean WszystkoOK = SprawdzanieUzytkownik.CzyPodaneIdIstnieje(IdUzytkownika);
			if(WszystkoOK != false)
			{
				BlackList ObiektZbanowany = BlackList.Banowanie(IdUzytkownika);
				try
				{
					OperacjePlikBlackList.ZapisywanieZbanowanego(ObiektZbanowany,NazwaPlikuBlackList);
				} catch(IOException e)
				{
				}
			} else
			{
				System.out.println("Podany uzytkownik nie istnieje");
			}
		}
	}

}
