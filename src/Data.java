import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

public class Data
{
	public static String WpisanieDaty()
	{
		int Miesiac;
		int Rok;
		int Dzien;
		int Month;
		int Year;
		int Day;
		boolean OK = true;
		System.out.println("Proszę wpisać rok wydania");
		Rok = WpisywanieDanych.WpisanieLiczby();
		do
		{
			System.out.println("Proszę wpisać miesiąc wydania. 1-12");
			Miesiac = (WpisywanieDanych.WpisanieLiczby() - 1);
		}while (Miesiac < 0 || Miesiac > 11 );
		do{
			System.out.println("Proszę wpisać dzień wydania.");
			Dzien = WpisywanieDanych.WpisanieLiczby();
			Calendar Kalendarz = new GregorianCalendar(Rok,Miesiac,Dzien); //rok , miesiac , dzien
			Day = Kalendarz.get(Calendar.DAY_OF_MONTH);
			Month = Kalendarz.get(Calendar.MONTH);
			Year = Kalendarz.get(Calendar.YEAR);
			if (Month != Miesiac)
			{
				System.out.println("Podano zbyt duza ilosc dni do podanego miesiaca.\n");
				OK = false;
			}
		}while(OK != true);
		System.out.println(Day+"-"+(Month+1)+"-"+Year);
		String Data = (Day+"-"+(Month+1)+"-"+Year);

		return Data;
	}
	public static String ObecnaData()
	{

		int Month;
		int Year;
		int Day;
		Calendar Kalendarz = new GregorianCalendar(); //rok , miesiac , dzien
		Day = Kalendarz.get(Calendar.DAY_OF_MONTH);
		Month = Kalendarz.get(Calendar.MONTH);
		Year = Kalendarz.get(Calendar.YEAR);
		System.out.println(Day+"-"+(Month+1)+"-"+Year);
		String Data = (Day+"-"+(Month+1)+"-"+Year);

		return Data;

	}
	public static String TerminOddania(String DataWyporzyczenia)
	{
		int Dzien = GetDzien(DataWyporzyczenia);
		int Miesiac = (GetMiesiac(DataWyporzyczenia)+1);
		int Rok = GetRok(DataWyporzyczenia);
		int Month;
		int Year;
		int Day;
		Calendar Kalendarz = new GregorianCalendar(Rok,Miesiac,Dzien); //rok , miesiac , dzien
		Day = Kalendarz.get(Calendar.DAY_OF_MONTH);
		Month = Kalendarz.get(Calendar.MONTH);
		Year = Kalendarz.get(Calendar.YEAR);
		String Termin = (Day+"-"+(Month+1)+"-"+Year);
		return Termin;
	}

	public static int GetDzien(String Data)
	{
		// Dzielenie daty po -
		String CzescDaty[] = Data.split("-");
		// Otrzymywania dnia z daty
		boolean OK = true;
		String Dzien = CzescDaty[0];
		int DzienLiczba=0;
		try
		{
		DzienLiczba = Integer.parseInt(Dzien); //Zamiana String do Int
		} catch(InputMismatchException | NumberFormatException ex) // Sprawdzenie
		{
			System.out.println("To nie jest liczba.Prosze wpisac liczbe");
			OK = false;
		}
		return DzienLiczba;
	}
	public static int GetMiesiac(String Data)
	{
		// Dzielenie daty po -
		String CzescDaty[] = Data.split("-");
		// Otrzymywania miesiaca z daty
		boolean OK = true;
		String Miesiac = CzescDaty[1];
		int DzienMiesiac=0;
		try
		{
			DzienMiesiac = Integer.parseInt(Miesiac); //Zamiana String do Int
		} catch(InputMismatchException | NumberFormatException ex) // Sprawdzenie
		{
			System.out.println("To nie jest liczba.Prosze wpisac liczbe");
			OK = false;
		}
		return DzienMiesiac;
	}
	public static int GetRok(String Data)
	{
		// Dzielenie daty po -
		String CzescDaty[] = Data.split("-");

		// Otrzymywania  Roku z daty
		boolean OK = true;
		String Rok = CzescDaty[2];
		int DzienRok=0;
		try
		{
			DzienRok = Integer.parseInt(Rok); //Zamiana String do Int
		} catch(InputMismatchException | NumberFormatException ex) // Sprawdzenie
		{
			System.out.println("To nie jest liczba.");
			OK = false;
		}
		return DzienRok;

	}

}
