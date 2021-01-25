import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ksiazka
{
	//Inicjacja wszystkich potrzebnych zmiennych

	//Dla obiektu Ksiazka
	private int IdKsiazki;
	private String NazwaKsiazki;
	private String Autor;
	private String Gatunek;
	private String DataWydania;
	private String Wyporzyczajacy;

	//Pozostale
	private int DniWyporzyczenia;
	private int MiesiaceWyporzyczenia;
	private int RokWyporzyczenia;
	private boolean CzyWyporzyczona;
	private int Dni Termin;
	private int MiesiaceTermin;
	private int RokTermin;
	private boolean CzyPoTerminie;
	//Konstruktor
	public Ksiazka( int IdKsiazki, String NazwaKsiazki, String Autor, String Gatunek, String DataWydania, String Wyporzyczajacy,int DniWyporzyczenia,int MiesiaceWyporzyczenia,int RokWyporzyczenia,boolean CzyWyporzyczona,int DniTermin,int MiesiaceTermin,int RokTermin,boolean CzyPoTerminie)
	{
		this.IdKsiazki=IdKsiazki;
		this.NazwaKsiazki=NazwaKsiazki;
		this.Autor=Autor;
		this.Gatunek=Gatunek;
		this.DataWydania=DataWydania;
		this.Wyporzyczajacy=Wyporzyczajacy;
		this.DniWyporzyczenia=DniWyporzyczenia;
		this.MiesiaceWyporzyczenia=MiesiaceWyporzyczenia;
		this.RokWyporzyczenia=RokWyporzyczenia;
		this.CzyWyporzyczona=CzyWyporzyczona;
		this.DniTermin=DniTermin;
		this.MiesiaceTermin=MiesiaceTermin;
		this.RokTermin=RokTermin;
		this.CzyPoTerminie=CzyPoTerminie;

	}
	public static Ksiazka TworzenieKsiazka() // Metoda pozwalajaca stworzyc Obiekt Ksiazke z wpisanie wszystkich danych
	{
		int IdKsiazki;
		String NazwaKsiazki;
		String Autor;
		String Gatunek;
		String DataWydania;
		String Wyporzyczajacy = null; // Wyporzyczajacy jest jako null na potrzeby stworznie tylko nowego wpisu w ksiazce.
		boolean CzyWyporzyczona = false;
		int DniWyporzyczenia=0;
		int MiesiaceWyporzyczenia=0;
		int RokWyporzyczenia=0;
		int DniTermin=0;
		int MiesiaceTermin=0;
		int RokTermin=0;
		boolean CzyPoTerminie=false;
		System.out.println("Podaj prosze ID.");
		IdKsiazki = WpisywanieDanych.WpisanieLiczby();
		System.out.println("Podaj prosze nazwie ksiazki.");
		NazwaKsiazki = WpisywanieDanych.WpisanieSlowa();
		System.out.println("Podaj prosze autora.");
		Autor = WpisywanieDanych.WpisanieSlowa();
		System.out.println("Podaj prosze gatunek ksiazki.");
		Gatunek = WpisywanieDanych.WpisanieSlowa();
		System.out.println("Podaj prosze date wydania.");
		DataWydania = WpisywanieDanych.WpisanieSlowa();
		System.out.println("Czy ksiazka jest juz wyporzyczona? Tak/Nie");
		CzyWyporzyczona = WpisywanieDanych.WpisanieBool();
		if (CzyWyporzyczona != false)
		{
			System.out.println("Podaj prosze dzien wyporzyczenia.");
			DniWyporzyczenia = WpisywanieDanych.WpisanieLiczby();
			System.out.println("Podaj prosze miesiac wyporzyczenia.");
			MiesiaceWyporzyczenia = WpisywanieDanych.WpisanieLiczby();
			System.out.println("Podaj prosze rok wyporzyczenia.");
			RokWyporzyczenia = WpisywanieDanych.WpisanieLiczby();
			DniTermin = DniWyporzyczenia;
			MiesiaceTermin = MiesiaceWyporzyczenia + 1;
			if (MiesiaceTermin == 13)
			{
			MiesiaceTermin = 1;
			}
			RokTermin = RokWyporzyczenia;
		}




		Ksiazka ObiektKsiazka = new Ksiazka(IdKsiazki, NazwaKsiazki, Autor, Gatunek, DataWydania, Wyporzyczajacy,DniWyporzyczenia,MiesiaceWyporzyczenia,RokWyporzyczenia,CzyWyporzyczona,DniTermin,MiesiaceTermin,RokTermin,CzyPoTerminie); // Tworzenie Ksiazki za pomoca Konstruktora

		return ObiektKsiazka; //Zwraca obiekt ksiazka.
	}

	//Getery dla innych klas

	public int GetIdKsiazki()
	{
		return IdKsiazki;
	}
	public String GetNazwaKsiazki()
	{
		return NazwaKsiazki;
	}
	public String GetAutor()
	{
		return Autor;
	}
	public String GetGatunek()
	{
		return Gatunek;
	}
	public String GetDataWydania()
	{
		return DataWydania;
	}
	public String GetWyporzyczajacy()
	{
		return Wyporzyczajacy;
	}
	public int GetDniWyporzyczenia()
	{
		return DniWyporzyczenia;
	}

	public int GetMiesiaceWyporzyczenia()
	{
		return MiesiaceWyporzyczenia;
	}

	public int GetRokWyporzyczenia()
	{
		return RokWyporzyczenia;
	}

	public boolean GetCzyWyporzyczona()
	{
		return CzyWyporzyczona;
	}
	public int GetDniTermin()
	{
		return DniTermin;
	}
	public int GetMiesiaceTermin()
	{
		return MiesiaceTermin;
	}
	public int GetRokTermin()
	{
		return RokTermin;
	}
	public  boolean GetCzyPoTerminie()
	{
		return CzyPoTerminie;
	}

	//Setery dla innych Klas

	//public static boolean CzyPoTerminie()
	//{

	// }


	// Funkcja pokazujaca wszystkei dane
	public static void WszystkieDane()
	{
		System.out.println("");
	}
	public  String ShowDane()
	{
		String TekstWyswietl;
		if(GetCzyWyporzyczona() == true)
		{
			if(GetCzyPoTerminie() != true)
			{
				return TekstWyswietl = (GetIdKsiazki()+ "\t\t\t\t" + GetNazwaKsiazki() + GetAutor() + GetGatunek()  + GetDataWydania() + " Tak "
						  + GetDniWyporzyczenia() + GetMiesiaceWyporzyczenia() + GetRokWyporzyczenia() + " Nie " + GetDniTermin() + GetMiesiaceTermin()
						  + GetRokTermin());
			}
			else{
				return TekstWyswietl =(GetIdKsiazki()+ "\t\t\\tt" + GetNazwaKsiazki() + GetAutor() + GetGatunek()  + GetDataWydania() + " Tak "
						  + GetDniWyporzyczenia() + GetMiesiaceWyporzyczenia() + GetRokWyporzyczenia() + " Tak " + GetDniTermin() + GetMiesiaceTermin()
						  + GetRokTermin());
			}
		}
		else
		{
			return TekstWyswietl = (GetIdKsiazki()+ "\t\t\t\t" + GetNazwaKsiazki() +  GetAutor() + GetGatunek() + GetGatunek() + GetDataWydania());
		}
	}
//

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
}
