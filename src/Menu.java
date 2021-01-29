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

			System.out.println("ID"+"\t\t\t\t"+"NazwaKsiazki"+"\t\t\t\t\t"+"Autor"+"\t\t\t\t\t\t\t"+"Gatunek"+"\t\t\t\t\t"+"Data Wydania"+ "\t\t"+"Wypozyczający"+"\t\t\t\t\t"+"Czy wyporzyczona");
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




	public static void WyswietlanieHistori()
	{
			int i = 0;

			System.out.println("ID Wpisu"+"\t"+"ID ksiazki"+"\t"+"Nazwa ksiazki"+"\t\t\t\t\t"+"Wypozyczajacy"+"\t\t\t\t\t"+"Data Wyporzyczenia"+"\t\t"+"Data Odddania"+"\t"+"Po terminie"+"\t"+"Id Wypozyczajacego");
			try
			{
				RandomAccessFile PlikOdczytany = OperacjePlikHistoria.OtwarciePlikHistoria();
				do
				{
					Ksiazka OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany);
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

	public static void UsuwanieKsiazki()
	{
		Menu.WypisywanieKsiazek();
		int Szukana;
		System.out.println("Wpisz liczbe id ksiazki ktora chcesz usunac");  // Prosba o wpisanie
		Szukana = WpisywanieDanych.WpisanieLiczby();
		OperacjePlikKsiazki.KasowanieKsiazki(Szukana);
	}

	public static void UsuwanieUzytkownika()
	{
		Menu.WypisywanieUzytkownikow();
		int Szukana;
		System.out.println("Wpisz liczbe id uzytkownika ktora chcesz usunac");  // Prosba o wpisanie
		Szukana = WpisywanieDanych.WpisanieLiczby();
		OperacjePlikUzytkownicy.UsuwanieUzytkownik(Szukana);
	}


}
