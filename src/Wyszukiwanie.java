import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Wyszukiwanie
{
	//
	//
	public static void WyszukiwanieNazaKsiazki()
	{
		int i = 0;
		String Szukana= null; // Poszukiwany String
		int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			System.out.println("Wpisz nazwe ksiazki  ktora chcesz znalezc");  // Prosba o wpisanie
			Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
			Szukana = BezSpacji(Szukana); // Usuniecie spacji
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					String Odczyt = OdczytaneDane.GetNazwaKsiazki(); //Wpisanie danej do Stringa
					String OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
					if(Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
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
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
		{
			System.out.println("Nie znaleziono.");
		}
	}
	public static void WyszukiwanieAutor()
	{
		int i = 0;
		String Szukana= null; // Poszukiwany String
		int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			System.out.println("Wpisz autora ktorego ksiazki chcesz znalezc.");  // Prosba o wpisanie
			Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
			Szukana = BezSpacji(Szukana); // Usuniecie spacji
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					String Odczyt = OdczytaneDane.GetAutor(); //Wpisanie danej do Stringa
					String OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
					if(Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
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
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
		{
			System.out.println("Nie znaleziono.");
		}
	}
	//
	//
	public static void WyszukiwanieDataWyporzyczenia()
	{
		int i = 0;
		String Szukana= null; // Poszukiwany String
		int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			System.out.println("Wpisz date wyporzyczenia ksiazek ktore chcesz znalezc.");  // Prosba o wpisanie
			Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
			Szukana = BezSpacji(Szukana); // Usuniecie spacji
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					String Odczyt = OdczytaneDane.GetDataWyporzyczenia(); //Wpisanie danej do Stringa
					String OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
					if(Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
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
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
		{
			System.out.println("Nie znaleziono.");
		}
	}
	//
	//
	public static void WyszukiwanieDataWydania()
	{
		int i = 0;
		String Szukana= null; // Poszukiwany String
		int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			System.out.println("Wpisz date wydania ksiazek ktore chcesz znalezc.");  // Prosba o wpisanie
			Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
			Szukana = BezSpacji(Szukana); // Usuniecie spacji
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					String Odczyt = OdczytaneDane.GetDataWydania(); //Wpisanie danej do Stringa
					String OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
					if(Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
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
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
		{
			System.out.println("Nie znaleziono.");
		}
	}
	//
	//
	public static void WyszukiwanieDataTermin()
	{
		int i = 0;
		String Szukana= null; // Poszukiwany String
		int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			System.out.println("Wpisz termin oddania ksiazek ktora chcesz znalezc.");  // Prosba o wpisanie
			Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
			Szukana = BezSpacji(Szukana); // Usuniecie spacji
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					String Odczyt = OdczytaneDane.GetDataTermin(); //Wpisanie danej do Stringa
					String OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
					if(Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
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
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
		{
			System.out.println("Nie znaleziono.");
		}
	}
	//
	//
	public static void WyszukiwanieGatunek()
	{
		int i = 0;
		String Szukana= null; // Poszukiwany String
		int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			System.out.println("Wpisz gatunek ksiazek ktore chcesz znalezc.");  // Prosba o wpisanie
			Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
			Szukana = BezSpacji(Szukana); // Usuniecie spacji
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					String Odczyt = OdczytaneDane.GetGatunek(); //Wpisanie danej do Stringa
					String OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
					if(Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
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
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
		{
			System.out.println("Nie znaleziono.");
		}
	}
	public static void WyszukiwanieWyporzyczajacy()
	{
		int i = 0;
		String Szukana= null; // Poszukiwany String
		int Znalezione = 0; // int sprawdzajacy czy cos znaleźliśmy

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			System.out.println("Wpisz nazwe wyporzyczajacego ktorego chcesz znalezc.");  // Prosba o wpisanie
			Szukana = WpisywanieDanych.WpisanieSlowa(); //  Wpisanie poszukiwanego slowa
			Szukana = BezSpacji(Szukana); // Usuniecie spacji
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					String Odczyt = OdczytaneDane.GetWyporzyczajacy(); //Wpisanie danej do Stringa
					String OdczytBezSpacji = BezSpacji(Odczyt); //Usuniecie spacji
					if(Szukana.equals(OdczytBezSpacji)) // Porownanie odczytu.
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
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci.
		{
			System.out.println("Nie znaleziono.");
		}
	}
	//
	//
	public static void WyszukiwanieID() // Wyszukiwanie inta - > ID
	{
		int i = 0;
		int Szukana = 0;
		int Znalezione = 0;

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			System.out.println("Wpisz liczbe id ksiazki ktora chcesz znalezc");  // Prosba o wpisanie
			Szukana = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego int
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
					if(Szukana==Odczyt) // Porownanie odczytu.
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
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
		{
			System.out.println("Nie znaleziono.");
		}
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
