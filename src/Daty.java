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
			if(Rok > 99999)
			{
				System.out.println("Rok nie może przekraczać 99999.");
			}
		}while(Rok > 99999);
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
				System.out.println("Podano zbyt duza ilosc dni do podanego miesiaca.\n");
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
		String Data = (Day+"-"+(Month+1)+"-"+Year);

		return Data;

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
			System.out.println("To nie jest liczba.");
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
			System.out.println("To nie jest liczba.");
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
	public static int CzyPoTerminie(String DataObecna , String DataTermin,String Zmienna)
	{
		int DzienWyporzyczenia = GetDzien(DataObecna);
		int MiesiacWyporzyczenia = GetMiesiac((DataObecna)+1);
		int RokWyporzyczenia = GetRok(DataObecna);
		int DzienTermin = GetDzien(DataTermin);
		int MiesiacTermin = GetMiesiac((DataTermin)+1);
		int RokTermin  = GetRok(DataTermin);
		int Porownanie = 0;


		GregorianCalendar KalendarzObecna = new GregorianCalendar(RokWyporzyczenia,MiesiacWyporzyczenia,DzienWyporzyczenia);
		GregorianCalendar KalendarzTermin = new GregorianCalendar(RokTermin,MiesiacTermin,DzienTermin);




		switch(Zmienna)
		{


				case "czypoterminie":
					Porownanie = KalendarzObecna.compareTo(KalendarzTermin);
					return Porownanie;
				case "ilepoterminie":
					int OdjetyDni = DzienWyporzyczenia - DzienTermin;
					int OdjetyMiesiac = MiesiacWyporzyczenia - MiesiacTermin;
					int OdjetyRok = RokWyporzyczenia - RokTermin;
					System.out.println("Dni " + OdjetyDni);
					System.out.println("Miesiace " + OdjetyMiesiac);
					System.out.println("Lata " + OdjetyRok);
					GregorianCalendar KalendarzPozostalo = new GregorianCalendar(OdjetyRok,OdjetyMiesiac,OdjetyDni);
					Porownanie = ((KalendarzPozostalo.get(Calendar.DAY_OF_YEAR)) * OdjetyRok) + KalendarzPozostalo.get(Calendar.DAY_OF_MONTH);

					return Porownanie;
				default:
					System.out.println("Cos poszlo nie tak. Nie podanno poprawnej zmiennej. Zwracanie zera");
					return  Porownanie;
		}

	}
	public static String CzyPoTerminie(int IleDniPoTerminie)
	{
		String CzyPoTerminie = "nie";
		if (IleDniPoTerminie > 0)
		{
		CzyPoTerminie = "tak";
		}
		return CzyPoTerminie;
	}


}
