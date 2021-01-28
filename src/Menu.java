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

	public static void WypozyczanieKsiazki() throws IOException {
		int IdKsiazki;
		int IdCzytelnik = 0;
		String NazwaCzytelnik;
		String TerminWyporyczena;
		String Wyporzyczajacy;
		boolean OK = true;
		String CzyWypozyczona ="tak";
		boolean CzyWpisacRecznie;
		String DataWyporzyczenia;
		String DataTermin;


		Menu.WypisywanieKsiazek();

		do {
			RandomAccessFile NowaHistoria = OperacjePlikKsiazki.OtwarciePlikKsiazki();
			System.out.println("Podaj Id ksiazki, ktora chcesz wyporzyczyc:");
			IdKsiazki = WpisywanieDanych.WpisanieLiczby();
			if (WyszukiwanieKsiazka.IdCzyIstnieje(IdKsiazki,NowaHistoria) == 1) {
				NowaHistoria = OperacjePlikKsiazki.OtwarciePlikKsiazki();
				if(WyszukiwanieKsiazka.CzyWypozyczona(IdKsiazki,NowaHistoria).equals("nie")){
					Menu.WypisywanieUzytkownikow();
					System.out.println("Podaj Id Czytelnika, który chce wyporzyczyć ksiażkę:");
					IdCzytelnik = WpisywanieDanych.WpisanieLiczby();

					if (SprawdzanieUzytkownik.CzyPodaneIdIstnieje(IdCzytelnik) == true) {

						NazwaCzytelnik = SprawdzanieUzytkownik.IdNazwaCztelnik(IdCzytelnik);
						System.out.println("Czy chcesz wziasc aktualna date dla daty wyporzyczenia? Tak/Nie");
						CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();
							if (CzyWpisacRecznie == false) {
								System.out.println("Podaj prosze date wyporzyczenia.");
								DataWyporzyczenia = Daty.WpisanieDaty();
							} else {
								DataWyporzyczenia = Daty.ObecnaData();
							}
							System.out.println("Czy chcesz wpisac recznie termin oddania.  Tak/Nie");
							CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();
							if (CzyWpisacRecznie == true) {
								System.out.println("Podaj prosze termin wyporzyczenia.");
								DataTermin = Daty.WpisanieDaty();
							} else {
								DataTermin = Daty.TerminOddania(DataWyporzyczenia);
							}/*
						try {
							NowaHistoria = OperacjePlikKsiazki.OtwarciePlikKsiazki();

						} catch (FileNotFoundException e) {

						}
						 NowaHistoria.close();

						 */

						Historia.TworzenieWpisu(IdKsiazki, IdCzytelnik, DataWyporzyczenia, DataTermin, NazwaCzytelnik); // przekazanie parametrów do funkcji tworzenia wpisu.
						//System.out.println(IdKsiazki);
					}else{
						System.out.println("Użytkownik nie istnieje.");
						OK=false;
					}

				} else {
					System.out.println("Ksiażka jest już wypożyczona.");
					OK=false;
				}

			} else {
				System.out.println("Ksiazka o podanym ID nie istnieje");
				OK=false;
			}
		}while(OK!=true);


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


}
