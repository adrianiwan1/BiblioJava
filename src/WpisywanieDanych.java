import java.util.InputMismatchException;
import java.util.Scanner;

public class WpisywanieDanych
{
	//Wszelakie funkcje umozliwiajace wpisanie jakiejs danej do juz zainicjowanej danej.
	//
	public static int WpisanieLiczby() // Pozwala na wpisanie Liczby do int
	{
		boolean OK; // Wszystkie dane inicjowane sa jako puste
		int Liczba = 0;
		do
		{
			try
			{
				OK = true;
				Scanner Wprowadzenie_Liczby = new Scanner(System.in); // Nowy Scaner
				String Liczba_String = Wprowadzenie_Liczby.nextLine(); // Wpisanie Liczby
				Liczba = Integer.parseInt(Liczba_String); //Zamiana String do Int
			} catch(InputMismatchException | NumberFormatException ex) // Sprawdzenie
			{
				System.out.println("To nie jest liczba.Prosze wpisac liczbe");
				OK = false;
			}
		} while(!OK);
		return Liczba; // Zwraca int
	}
	//
	//
	public static String WpisanieSlowa()// Pozwala na wpisanie slowa do String
	{
		boolean OK = false; // Wszystkie dane inicjowane sa jako puste
		String Slowo = null;
		do
		{

				OK = true;
				Scanner Wprowadzenie_Slowa = new Scanner(System.in); // Nowy Scaner
				Slowo = Wprowadzenie_Slowa.nextLine().toLowerCase();; // Wpisanie slowa
				if(Slowo == null || Slowo.equals("") || Slowo.equals(" "))
				{
				System.out.println("Podane slowo nie moze byc puste.Sprobuj Ponownie.");
				OK = false;
				}
		} while(!OK);
		return Slowo; // Zwraca String
	}
	//
	//
		public static char WpisanieSymbol() // Pozwala na wpisanie Symbolu do char
	{
		boolean OK; // Wszystkie dane inicjowane sa jako puste
		String Slowo;
		char Pierwszy_Char = 0;

		do
		{
			try
			{
				OK = true;
				Scanner Wprowadzenie_Stringu = new Scanner(System.in); // Nowy Scaner
				Slowo = Wprowadzenie_Stringu.nextLine(); // Wpisanie Slowa
				Pierwszy_Char = Slowo.charAt(0); // Pobranie z Slowa pierwszy Symbol.
				if(Slowo == null || Slowo == "" || Slowo == "	")
				{
					System.out.println("Podane slowo nie moze byc puste");
					OK = false;
				}
			} catch(InputMismatchException | StringIndexOutOfBoundsException ex) // Sprawdzenie
				{
					System.out.println("Podane slowo nie moze byc puste");
					OK = false;
				}
		} while(!OK);
		return Pierwszy_Char; // Zwraca Char
	}

	public static boolean WpisanieBool() // Pozwala na wpisanie Bool z stringa.
	{
		int Liczba_Wybor = 1; // Liczba potrzebna na obsluge petli
		boolean Wybor = false; // Boolean potrzebny do wpisania w return
		do
		{
			Scanner WpisanyWybor = new Scanner(System.in); // Nowy Scaner
			String WpisanyWyborString = WpisanyWybor.nextLine().toLowerCase(); // Zamiana na male slowo wyboru
			switch (WpisanyWyborString)
			{
				case "tak": // tak zwraca true
					Wybor = true;
					Liczba_Wybor = 0; // zakonczenie petli
					break;
				case "nie": // nie zwraca false
					Wybor = false;
					Liczba_Wybor = 0; // zakonczenie petli
					break;
				default: // Niepoprawne slowo zostalo podane
					Liczba_Wybor = 1; // Kontynuacja petli
					System.out.println("Uzyto niepoprawnego slowa. Uzyj 'Tak' lub 'Nie' .");
					break;

			}
		}
		while(Liczba_Wybor == 1);
		return Wybor;
	}

	public static String WpisanieTakLubNie() // Pozwala na wpisanie Bool z stringa.
	{
		int Liczba_Wybor = 1; // Liczba potrzebna na obsluge petli
		String Wybor = null; // String potrzebny do wpisania w return
		do
		{
			Scanner WpisanyWybor = new Scanner(System.in); // Nowy Scaner
			String WpisanyWyborString = WpisanyWybor.nextLine().toLowerCase(); // Zamiana na male slowo wyboru
			switch (WpisanyWyborString)
			{
				case "tak": // tak zwraca true
					Wybor = ("tak");
					Liczba_Wybor = 0; // zakonczenie petli
					break;
				case "nie": // nie zwraca false
					Wybor = ("nie");
					Liczba_Wybor = 0; // zakonczenie petli
					break;
				default: // Niepoprawne slowo zostalo podane
					Liczba_Wybor = 1; // Kontynuacja petli
					System.out.println("Uzyto niepoprawnego slowa. Uzyj 'Tak' lub 'Nie' .");
					break;

			}
		}
		while(Liczba_Wybor == 1);
		return Wybor;
	}
}
