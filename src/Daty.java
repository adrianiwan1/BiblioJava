import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

public class Daty
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
		System.out.println("Proszę podac rok.");
		do
		{
			Rok = WpisywanieDanych.WpisanieLiczby();
			if(Rok > 99999 || Rok <= 0)
			{
				System.out.println("Rok nie może przekraczać 99999. Rok nie może być mniejszy lub równy zeru.");
			}
		}while(Rok > 99999 || Rok <= 0);
		do
		{
			System.out.println("Proszę podac miesiąc. 1-12");
			Miesiac = (WpisywanieDanych.WpisanieLiczby() - 1);
		}while (Miesiac < 0 || Miesiac > 11 );
		do{
			System.out.println("Proszę podac dzień.");
			Dzien = WpisywanieDanych.WpisanieLiczby();
			Calendar Kalendarz = new GregorianCalendar(Rok,Miesiac,Dzien); //rok , miesiac , dzien
			Day = Kalendarz.get(Calendar.DAY_OF_MONTH);
			Month = Kalendarz.get(Calendar.MONTH);
			Year = Kalendarz.get(Calendar.YEAR);
			if (Month != Miesiac)
			{
				System.out.println("Podano niepoprawną ilość dni do miesiąca.\n");
				OK = false;
			}else
				{
					OK = true;
				}
		}while(OK != true);
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
		String ObecnaData = (Day+"-"+(Month+1)+"-"+Year);

		return ObecnaData;

	}
	public static String TerminOddania(String DataWyporzyczenia)
	{
		int Dzien = GetDzien(DataWyporzyczenia);
		int Miesiac = (GetMiesiac(DataWyporzyczenia));
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
			//System.out.println("To nie jest liczba.Bład IM-001");
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
			//System.out.println("To nie jest liczba.Bład IM-001");
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
			DzienRok = Integer.parseInt(WyszukiwanieKsiazka.BezSpacji(Rok)); //Zamiana String do Int
		} catch(InputMismatchException | NumberFormatException ex) // Sprawdzenie
		{
			//System.out.println("To nie jest liczba.Bład IM-001");
			OK = false;
		}
		return DzienRok;

	}
	public static long SprawdzanieCzyPoPodanejDacie(String DataObecna , String DataTermin,String Zmienna)
	{

		int DzienWyporzyczenia = GetDzien(DataObecna);
		int MiesiacWyporzyczenia = GetMiesiac((DataObecna));
		MiesiacWyporzyczenia = MiesiacWyporzyczenia -1;
		int RokWyporzyczenia = GetRok(DataObecna);
		int DzienTermin = GetDzien(DataTermin);
		int MiesiacTermin = GetMiesiac((DataTermin));
		MiesiacTermin = MiesiacTermin -1;
		int RokTermin  = GetRok(DataTermin);
		long Porownanie = 0;


		Calendar KalendarzObecna = new GregorianCalendar(RokWyporzyczenia,MiesiacWyporzyczenia,DzienWyporzyczenia);
		Calendar KalendarzTermin = new GregorianCalendar(RokTermin,MiesiacTermin,DzienTermin);

		long DataWMiliSekundach = KalendarzObecna.getTimeInMillis() - KalendarzTermin.getTimeInMillis();




		switch(Zmienna)
		{
				case "czypoterminie":
					Porownanie = KalendarzObecna.compareTo(KalendarzTermin);
					return Porownanie;
				case "ilepoterminie":
					Porownanie  = (DataWMiliSekundach / (86400000));
					return Porownanie;
				default:
					System.out.println("Cos poszlo nie tak. Nie podanno poprawnej zmiennej. Zwracanie zera");
					return  Porownanie;
		}

	}

	public static String CzyPoDacieStringint(long IleDniPoTerminie)
	{
		String CzyPoTerminie = (""+IleDniPoTerminie);
		return CzyPoTerminie;
	}

	public static String CzyPoDacieString(long IleDniPoTerminie)
	{
		String CzyPoTerminie = "tak";
		if (IleDniPoTerminie < 0)
		{
		CzyPoTerminie = "nie";
		}
		return CzyPoTerminie;
	}
}
