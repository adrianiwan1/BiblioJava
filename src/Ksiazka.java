public class Ksiazka
{
	//Inicjacja wszystkich potrzebnych zmiennych

	//DDla obiektu Ksiazka
	private int IdKsiazki=12;
	private String NazwaKsiazki="asaaaa";
	private String Autor="bbbbbb";
	private String Gatunek="zbcd";
	private String DataWydania="12.23.2131";
	private String Wyporzyczajacy="ghufgbf";

	//Pozostale
	private int DniWyporzyczenia=0;
	private int MiesiaceWyporzyczenia=0;
	private int RokWyporzyczenia=0;
	private boolean CzyWyporzyczona = false;
	private int DniTermin=0;
	private int MiesiaceTermin=0;
	private int RokTermin=0;
	private boolean CzyPoTerminie = false;
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
		String Wyporzyczajacy = null; // Wyporzyczajacy jest jako null na potrzeby stworznie tylko nowego wpisu w ksiazce
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

		int DniWyporzyczenia=0;
		int MiesiaceWyporzyczenia=0;
		int RokWyporzyczenia=0;
		boolean CzyWyporzyczona=false;
		int DniTermin=0;
		int MiesiaceTermin=0;
		int RokTermin=0;
		boolean CzyPoTerminie=false;

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
}
