import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WyszukiwanieKsiazka
{
	//

	//
	public static void Wyszukiwanie(String Zmienna)
	{

		String Szukana= null; // Poszukiwany String
		int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy
		int Szukany = 0;

		RandomAccessFile PlikOdczytany = null; //Otwarcie pliku
		try
		{
			PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
			if (Zmienna.equals("id"))
			{
			System.out.println("Wpisz nazwe poszukiwanej treści.Wpisz 0 by anulować");  // Prosba o wpisanie
			Szukany = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego slowa
				if(Szukany == 0)
				{
					System.out.println("Powrót do poprzedniej opcji.");
					return;
				}
			WyszukiwanieID(Szukany,PlikOdczytany);
			}else
				{
					System.out.println("Wpisz nazwe poszukiwanej treści.Wpisz 0 by anulować");  // Prosba o wpisanie
					Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
					if(Szukana.equals("0") )
					{
						System.out.println("Powrót do poprzedniej opcji.");
						return;
					}
					UltraSkroconeWyszukiwanie(Szukana,PlikOdczytany,Zmienna);
				}
			if(Znalezione == 0)
			{
			System.out.println("Nie znaleziono wyszukiwanej treści.");
			}
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e)
		{
		}
	}
	//
	//
	public static int UltraSkroconeWyszukiwanie(String Szukana,RandomAccessFile PlikOdczytany,String Zmienna)
	{
		int i = 0;
		int Znalezione = 0;
		String OdczytBezSpacji = ("PustyPustoPustusienkoNiemaNic");
		String Odczyt =("PustyPustoPustusienkoNiemaNic");

		Szukana = BezSpacji(Szukana); // Usuniecie spacji
		try
		{
			do
			{

				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					switch(Zmienna)
					{
						case"datatermin":
							Odczyt = OdczytaneDane.GetDataTermin(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
						case"gatunek":
							Odczyt = OdczytaneDane.GetGatunek(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
						case"autor":
							Odczyt = OdczytaneDane.GetAutor(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
						case"nazwa":
							Odczyt = OdczytaneDane.GetNazwaKsiazki(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
						case"datawydania":
							Odczyt = OdczytaneDane.GetDataWydania(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
						case"datawyporzyczenia":
							Odczyt = OdczytaneDane.GetDataWyporzyczenia(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
						case"wyporzyczajacy":
							Odczyt = OdczytaneDane.GetWyporzyczajacy(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
						case"czywyporzyczona":
							Odczyt = OdczytaneDane.GetCzyWyporzyczona(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
						case"czypoterminie":
							Odczyt = OdczytaneDane.GetCzyPoTerminie(); //Wpisanie danej do Stringa
							OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
							break;
					}
					if (Odczyt.equals("PustyPustoPustusienkoNiemaNic" )) //Jesl nic nie wpisano do odczytu.
					{
						i = 9002; // Zakonczenie petli jesli null
					}
					else
					{
						if(Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
						{
							System.out.println(OdczytaneDane.ShowDane()); //Wyswietlenie odczytu
							Znalezione++;
						}
				}
					i++;
				}else{
					i=90002;
					}
			} while(i < 9000);
		}catch(IOException e)// Maksymalna wartosc petli
		{

		}
		return Znalezione;
	}
	//
	//
	public static int WyszukiwanieID(int Szukany,RandomAccessFile PlikOdczytany) // Wyszukiwanie inta - > ID
	{
		int i = 0;
		int Znalezione = 0;
		try
		{
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
					if(Szukany == Odczyt) // Porownanie odczytu.
					{
						System.out.println(OdczytaneDane.ShowDane()); //Wyswietlenie odczytu
						Znalezione++;
					}
				} else
				{
					i = 9002; // Zakonczenie petli jesli null
				}
				i++;
			} while(i < 9000); // Maksymalna wartosc petli
		}catch(IOException e)
		{

		}
		return Znalezione;
	}


	public static int IdCzyIstnieje(int Szukany,RandomAccessFile PlikOdczytany) // Wyszukiwanie inta - > ID, Zwraca Int 1 jeśli znalezione
	{
		int i = 0;
		int Znalezione = 0;
		try
		{
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
					if(Szukany == Odczyt) // Porownanie odczytu.
					{

						PlikOdczytany.close();
						Znalezione++;
					}
				} else
				{
					i = 9002; // Zakonczenie petli jesli null
				}
				i++;

			} while(i < 9000); // Maksymalna wartosc petli
		}catch(IOException e)
		{

		}
		return Znalezione;
	}

	public static String CzyWypozyczona(int Szukany,RandomAccessFile PlikOdczytany) // Wyszukiwanie inta - > ID, Zwraca Int 1 jeśli znalezione
	{
		int i = 0;
		int Znalezione = 0;
		String CzyWypozyczone="PustyPustoPustusienkoNiemaNic";
		try
		{
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int

					if(Szukany == Odczyt) // Porownanie odczytu.
					{

						CzyWypozyczone= OdczytaneDane.GetCzyWyporzyczona();

					}


				}
				else {
					i = 9002; // Zakonczenie petli jesli null


					System.out.println(CzyWypozyczone);
				}
				i++;

			} while(i < 9000); // Maksymalna wartosc petli
			PlikOdczytany.close();
		}catch(IOException e)
		{

		}
		return CzyWypozyczone;
	}
	//
	//
	public static Ksiazka WyszukiwanieIDUzytkownika(int Szukany,RandomAccessFile PlikOdczytany) // Wyszukiwanie inta - > ID
	{

		int i = 0;
		int ZnalezioneId = 0;
		try
		{
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
					if(Szukany == Odczyt) // Porownanie odczytu.
					{
						Ksiazka NowaKsiazka = OdczytaneDane;
						return NowaKsiazka;
					}
				} else
				{
					i = 9002; // Zakonczenie petli jesli null
				}
				i++;
			} while(i < 9000); // Maksymalna wartosc petli
		}catch(IOException e)
		{

		}
		return null;

	}

	//
	//
	public  static String BezSpacji(String Slowo)
	{
		String GotoweSlowo = null;
		if (Slowo != null)
		{
			GotoweSlowo = Slowo.trim();
			return GotoweSlowo;
		}else
			{
			 GotoweSlowo =("Podane Slowo jest puste");
				return GotoweSlowo;
			}
	}
}
