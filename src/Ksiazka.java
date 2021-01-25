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
	//private int DniWyporzyczenia;
	//private int MiesiaceWyporzyczenia;
	//private int RokWyporzyczenia;
	private String DataWyporzyczenia;
	private String CzyWyporzyczona;
	//private int DniTermin;
	//private int MiesiaceTermin;
	//private int RokTermin;
	private String DataTermin;
	private String CzyPoTerminie;
	//Konstruktor
	public Ksiazka( int IdKsiazki, String NazwaKsiazki, String Autor, String Gatunek, String DataWydania, String Wyporzyczajacy,String DataWyporzyczenia,String CzyWyporzyczona,String DataTermin,String CzyPoTerminie)
	{
		this.IdKsiazki=IdKsiazki;
		this.NazwaKsiazki=NazwaKsiazki;
		this.Autor=Autor;
		this.Gatunek=Gatunek;
		this.DataWydania=DataWydania;
		this.Wyporzyczajacy=Wyporzyczajacy;
		//this.DniWyporzyczenia=DniWyporzyczenia;
		//this.MiesiaceWyporzyczenia=MiesiaceWyporzyczenia;
		//this.RokWyporzyczenia=RokWyporzyczenia;
		this.DataWyporzyczenia=DataWyporzyczenia;
		this.CzyWyporzyczona=CzyWyporzyczona;
		//this.DniTermin=DniTermin;
		//this.MiesiaceTermin=MiesiaceTermin;
		//this.RokTermin=RokTermin;
		this.DataTermin=DataTermin;
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
		String CzyWyporzyczona = null;
		String DataWyporzyczenia = null;
		String DataTermin = null;
		String CzyPoTerminie=null;
		boolean CzyWpisacRecznie=true;
		boolean OK = true;
		System.out.println("Podaj prosze ID.");
		do
		{
			IdKsiazki = WpisywanieDanych.WpisanieLiczby();
			OK=Sprawdzanie.CzyPodaneIdIstnieje(IdKsiazki);
			if(OK != false )
			{
			System.out.println("Istnieje juz id z podana wartoscia.Prosze podac inne.");
			}
		}while(OK != false);
		System.out.println("Podaj prosze nazwie ksiazki.");
		NazwaKsiazki = WpisywanieDanych.WpisanieSlowa();
		System.out.println("Podaj prosze autora.");
		Autor = WpisywanieDanych.WpisanieSlowa();
		DostepneGatunki();
		System.out.println("Podaj prosze gatunek ksiazki.");
		do
		{
			Gatunek = WpisywanieDanych.WpisanieSlowa();
			OK = Sprawdzanie.SprawdzanieGatunku(Gatunek);
		}while(OK != true );
		System.out.println("Podaj prosze date wydania.");
		DataWydania = Data.WpisanieDaty();
		System.out.println("Czy ksiazka jest juz wyporzyczona? Tak/Nie");
		CzyWyporzyczona = WpisywanieDanych.WpisanieTakLubNie();
		if (CzyWyporzyczona.equals("tak"))
		{
			System.out.println("Czy chcesz wziasc aktualna date dla daty wyporzyczenia? Tak/Nie");
			CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();
			if(CzyWpisacRecznie == false)
			{
				System.out.println("Podaj prosze date wyporzyczenia.");
				DataWyporzyczenia = Data.WpisanieDaty();
			}else
				{
					DataWyporzyczenia = Data.ObecnaData();
				}
			System.out.println("Czy chcesz wpisac recznie termin oddania.  Tak/Nie");
			CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();
			if(CzyWpisacRecznie == true)
			{
				System.out.println("Podaj prosze termin wyporzyczenia.");
				DataTermin = Data.WpisanieDaty();
			}else
				{
					DataTermin=Data.TerminOddania(DataWyporzyczenia);
				}

		}

		Ksiazka ObiektKsiazka = new Ksiazka(IdKsiazki, NazwaKsiazki, Autor, Gatunek, DataWydania, Wyporzyczajacy,DataWyporzyczenia,CzyWyporzyczona,DataTermin,CzyPoTerminie); // Tworzenie Ksiazki za pomoca Konstruktora

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
	/*
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
	 */
	public String GetDataWyporzyczenia()
	{
		return DataWyporzyczenia;
	}

	public String GetCzyWyporzyczona()
	{
		return CzyWyporzyczona;
	}
	/*
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

	 */
	public String GetDataTermin()
	{
		return DataTermin;
	}
	public  String GetCzyPoTerminie()
	{
		return CzyPoTerminie;
	}

	//Setery dla innych Klas

	//public static boolean CzyPoTerminie()
	//{

	// }


	// Funkcja pokazujaca wszystkei dane
	public  String ShowDane()
	{
		String TekstWyswietl;
		if(GetCzyWyporzyczona().equals("tak"))
		{
			if(GetCzyPoTerminie().equals("tak"))
			{
				return TekstWyswietl =(GetIdKsiazki()+ "\t\t\t" + GetNazwaKsiazki() + GetAutor() + GetGatunek()  + GetDataWydania()+ "\t\t\t" + GetCzyWyporzyczona() +
						  "\t\t\t" + GetDataWyporzyczenia() +"\t\t\t" + GetCzyPoTerminie() + "\t\t\t" + GetDataTermin());
			}
			else{
				return TekstWyswietl =(GetIdKsiazki()+ "\t\t\t" + GetNazwaKsiazki() + GetAutor() + GetGatunek()  + GetDataWydania() + "\t\t\t" + GetCzyWyporzyczona() +
				"\t\t\t"+ GetDataWyporzyczenia() +"\t\t\t" + GetCzyPoTerminie() + "\t\t\t" + GetDataTermin());
			}
		}
		else
		{
			return TekstWyswietl = (GetIdKsiazki()+ "\t\t\t" + GetNazwaKsiazki() +  GetAutor() + GetGatunek() + GetDataWydania());
		}
	}
//
	public static void DostepneGatunki()
	{
		System.out.println("Dostepne gatunki: \nsci-fi , drama , literatura faktu , horror , biografia , romans , komedia , kryminal , thriller , naukowe , poradniki , przygodowe.");
	}
}
