import java.io.IOException;
import java.io.RandomAccessFile;

public class Ksiazka extends Uzytkownik
{
	//Inicjacja wszystkich potrzebnych zmiennych

	//Dla obiektu Ksiazka
	private int IdKsiazki;
	private String NazwaKsiazki;
	private String Autor;
	private String Gatunek;
	private String DataWydania;
	private String Czytelnik;
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
	public Ksiazka(int IdKsiazki, String NazwaKsiazki, String Autor, String Gatunek, String DataWydania,
						String NowyCzytelnik, String DataWyporzyczenia, String CzyWyporzyczona,
						String DataTermin, String CzyPoTerminie, int IdUzytkownik)
	{
		super(IdUzytkownik, NowyCzytelnik, NazwaKsiazki);
		this.IdKsiazki = IdKsiazki;
		this.NazwaKsiazki = NazwaKsiazki;
		this.Autor = Autor;
		this.Gatunek = Gatunek;
		this.DataWydania = DataWydania;
		this.Czytelnik = NowyCzytelnik;
		//this.DniWyporzyczenia=DniWyporzyczenia;
		//this.MiesiaceWyporzyczenia=MiesiaceWyporzyczenia;
		//this.RokWyporzyczenia=RokWyporzyczenia;
		this.DataWyporzyczenia = DataWyporzyczenia;
		this.CzyWyporzyczona = CzyWyporzyczona;
		//this.DniTermin=DniTermin;
		//this.MiesiaceTermin=MiesiaceTermin;
		//this.RokTermin=RokTermin;
		this.DataTermin = DataTermin;
		this.CzyPoTerminie = CzyPoTerminie;

	}


	public static Ksiazka TworzenieKsiazka() // Metoda pozwalajaca stworzyc Obiekt Ksiazke z wpisanie wszystkich danych
	{
		int IdKsiazki;
		String NazwaKsiazki;
		String Autor;
		String Gatunek;
		String DataWydania;
		int IdUzytkownika = 2147483646;
		String NazwaCzytelnik = null;
		String CzyWyporzyczona = null;
		String CzyRandomId = null;
		String DataWyporzyczenia = null;
		String DataTermin = null;
		String CzyPoTerminie = "nie";
		boolean CzyWpisacRecznie = true;
		boolean OK = true;
		String DataObecna = Daty.ObecnaData();
		String SprawdzanieCzyPoTerminie = "czypoterminie";
		String SprawdzanieIlePoTerminie = "ilepoterminie";


		System.out.println("Czy chcesz wpisać własne ID? Tak/Nie");
		CzyRandomId = WpisywanieDanych.WpisanieTakLubNie();
		if(CzyRandomId.equals("nie"))
		{
			do
			{
				IdKsiazki = GeneratorLosowegoID.Id();
				OK = SprawdzanieKsiazka.CzyPodaneIdIstnieje(IdKsiazki);
			} while(OK != false);
		} else
		{
			System.out.println("Podaj prosze ID.");
			do
			{
				IdKsiazki = WpisywanieDanych.WpisanieLiczby();
				OK = SprawdzanieKsiazka.CzyPodaneIdIstnieje(IdKsiazki);
				if(IdKsiazki > 2147483645 || IdKsiazki < 1)
				{
					System.out.println("Id nie moze byc wieksze niz 2147483645 i mniejsze niz 1.");
				}
				if(OK != false)
				{
					System.out.println("Istnieje książka z podanym ID.Spróbuj ponownie.");
				}
			} while(OK != false || IdKsiazki > 2147483645 || IdKsiazki < 0);
		}
		System.out.println("Podaj proszę nazwę książki.");
		NazwaKsiazki = WpisywanieDanych.WpisanieSlowa();
		System.out.println("Podaj proszę autora.");
		Autor = WpisywanieDanych.WpisanieSlowa();
		DostepneGatunki();
		System.out.println("Podaj proszę gatunek książki.");
		do
		{
			Gatunek = WpisywanieDanych.WpisanieSlowa();
			OK = SprawdzanieKsiazka.SprawdzanieGatunku(Gatunek);
		} while(OK != true);
		do
		{
			System.out.println("Podaj prosze date wydania.");
			DataWydania = Daty.WpisanieDaty();
			if(Daty.SprawdzanieCzyPoPodanejDacie(DataObecna, DataWydania, SprawdzanieCzyPoTerminie) < 0)
			{
				System.out.println("Ksiazka nie moze byc dodana do rejestru przed jej wydaniem.\n");
			}
		} while(Daty.SprawdzanieCzyPoPodanejDacie(DataObecna, DataWydania, SprawdzanieCzyPoTerminie) < 0);

		System.out.println("Czy chcesz by książka była już  wyporzyczona? Tak/Nie");
		CzyWyporzyczona = WpisywanieDanych.WpisanieTakLubNie();
		Ksiazka ObiektKsiazka = null;
		if(CzyWyporzyczona.equals("tak"))
		{
			Menu.WypisywanieUzytkownikow();
			System.out.println("Podaj ID Czytelnika:");
			System.out.println("jesli chcesz jednak by ksiazka nie była wyporzyczona wpisz 0.");

			do
			{
				IdUzytkownika = WpisywanieDanych.WpisanieLiczby();
				OK = SprawdzanieUzytkownik.CzyPodaneIdIstnieje(IdUzytkownika);
				NazwaCzytelnik = SprawdzanieUzytkownik.IdNazwaCztelnik(IdUzytkownika);
				if(IdUzytkownika==0)
				{
					System.out.println("Ustawianie książki jako nie wyporzyczona i przejście dalej.");
					CzyWyporzyczona = ("tak");
					OK =true;
				}else
					{
						if(NazwaCzytelnik.equals("PustyPustoPustusienkoNiemaNic"))
						{
							OK = false;
						}
						if(OK == false)
						{
							System.out.println("Brak czytelnika o podanym Id. Spróbuj ponownie\n");
						}
						if(SprawdzanieUzytkownik.CzyZablokowany(IdUzytkownika))
						{
							System.out.println("Czytelnik jest zbanowany nie moze wyporzyczac ksiazek. Sprobuj jeszcze raz.");
							OK = false;
						}
					}
			} while(OK == false);

			if(CzyWyporzyczona.equals("tak"))
			{


			do
			{
				System.out.println("Czy chcesz wziasc aktualna date dla daty wyporzyczenia? Tak/Nie");
				CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();


				if(Daty.SprawdzanieCzyPoPodanejDacie(DataWydania, DataObecna, SprawdzanieCzyPoTerminie) < 0)
				{
					if(CzyWpisacRecznie == false)
					{
						System.out.println("Datak Wydania: " + DataWydania);
						System.out.println("Podaj prosze date wyporzyczenia.");
						DataWyporzyczenia = Daty.WpisanieDaty();
					} else
					{
						DataWyporzyczenia = Daty.ObecnaData();
					}
					if(Daty.SprawdzanieCzyPoPodanejDacie(DataWydania, DataWyporzyczenia, SprawdzanieCzyPoTerminie) > 0)
					{
						System.out.println("Nie mozna wyporzyczyc ksiazki przed jej wydaniem! Prosze sprobowac ponownie.");

					}
				} else
				{
					if(CzyWpisacRecznie == true)
					{
						System.out.println("Datak Wydania: " + DataWydania);
						System.out.println("Nie mozna uzyc daty aktualnej.Prosze podac date recznie");
						System.out.println("Podaj prosze date wyporzyczenia.");
						DataWyporzyczenia = Daty.WpisanieDaty();
					} else
					{
						DataWyporzyczenia = Daty.ObecnaData();
					}
					if(Daty.SprawdzanieCzyPoPodanejDacie(DataWydania, DataWyporzyczenia, SprawdzanieCzyPoTerminie) > 0)
					{
						System.out.println("Nie mozna wyporzyczyc ksiazki przed jej wydaniem! Prosze sprobowac ponownie.");

					}
				}

			} while(Daty.SprawdzanieCzyPoPodanejDacie(DataWydania, DataWyporzyczenia, SprawdzanieCzyPoTerminie) > 0);
			do
			{
				System.out.println("Czy chcesz automatycznie wygenerowac termin oddania.  Tak/Nie");
				CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();
				if(CzyWpisacRecznie == false)
				{
					System.out.println("Datak Wypożyczenia: " + DataWyporzyczenia);
					System.out.println("Podaj prosze termin oddania.");
					DataTermin = Daty.WpisanieDaty();
				} else
				{
					DataTermin = Daty.TerminOddania(DataWyporzyczenia);
				}
				if(Daty.SprawdzanieCzyPoPodanejDacie(DataWyporzyczenia, DataTermin, SprawdzanieCzyPoTerminie) >= 0)
				{
					System.out.println("Termin oddania nie moze byc mniejszy niz data wyporzyczenia!. Prosze sprobowac ponownie.");

				}
			}
			// */
			while(Daty.SprawdzanieCzyPoPodanejDacie(DataWyporzyczenia, DataTermin, SprawdzanieCzyPoTerminie) >= 0);

			CzyPoTerminie = Daty.CzyPoDacieString(Daty.SprawdzanieCzyPoPodanejDacie(DataObecna, DataTermin, SprawdzanieIlePoTerminie));

		}//ObiektKsiazka = new Ksiazka(IdKsiazki, NazwaKsiazki, Autor, Gatunek, DataWydania, NazwaCzytelnik, DataWyporzyczenia, CzyWyporzyczona, DataTermin, CzyPoTerminie, IdUzytkownika);
		}
		ObiektKsiazka = new Ksiazka(IdKsiazki, NazwaKsiazki, Autor, Gatunek, DataWydania, NazwaCzytelnik, DataWyporzyczenia, CzyWyporzyczona, DataTermin, CzyPoTerminie, IdUzytkownika);

		return ObiektKsiazka; //Zwraca obiekt ksiazka.
	}

	//Getery dla innych klas
	public String GetIdKsiazkaWypisiywanie()
	{
		String IdKsiazkiJakoString = (""+IdKsiazki);
		int dlugosc =IdKsiazkiJakoString.length();
		switch(dlugosc)
		{
			case 1:
				IdKsiazkiJakoString = (IdKsiazki + "         ");
				break;
			case 2:
				IdKsiazkiJakoString = (IdKsiazki + "        ");
				break;
			case 3:
				IdKsiazkiJakoString = (IdKsiazki + "       ");
				break;
			case 4:
				IdKsiazkiJakoString = (IdKsiazki + "      ");
				break;
			case 5:
				IdKsiazkiJakoString = (IdKsiazki + "     ");
				break;
			case 6:
				IdKsiazkiJakoString = (IdKsiazki + "    ");
				break;
			case 7:
				IdKsiazkiJakoString = (IdKsiazki + "   ");
				break;
			case 8:
				IdKsiazkiJakoString = (IdKsiazki + "  ");
				break;
			case 9:
				IdKsiazkiJakoString = (IdKsiazki + " ");
				break;

		}
		return  IdKsiazkiJakoString;
	}
	public String GetCzyPoTerminieWyswietlanie()
	{
		  CzyPoTerminie = Daty.CzyPoDacieString(Daty.SprawdzanieCzyPoPodanejDacie(GetDataTermin(),Daty.ObecnaData(),"ilepoterminie"));
 		return CzyPoTerminie;
	}

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
		return Czytelnik;
	}

	public String GetDataWyporzyczenia()
	{
		return DataWyporzyczenia;
	}

	public String GetCzyWyporzyczona()
	{
		return CzyWyporzyczona;
	}

	public String GetDataTermin()
	{
		return DataTermin;
	}
	public  String GetCzyPoTerminie()
	{
		return CzyPoTerminie;
	}

	//Setery dla innych Klas

	public void SetNazwaKsiazki(String NowyNazwaKsiazki)
	{
		this.NazwaKsiazki=NowyNazwaKsiazki;
	}

	public void SetAutor(String NowyAutor)
	{
		this.Autor=NowyAutor;
	}

	public void SetGatunek(String NowyGatunek)
	{
		this.Gatunek=NowyGatunek;
	}
	public void SetDataWydania(String NowyDataWydania)
	{
		this.DataWydania=NowyDataWydania;
	}
	public void SetWyporzyczajacy(String NowyWyporzyczajacy)
	{
		this.Czytelnik=NowyWyporzyczajacy;
	}
	public void SetCzyWyporzyczona (String NowyCzyWyporzyczona)
	{
		this.CzyWyporzyczona=NowyCzyWyporzyczona;
	}
	public void SetDataWyporzyczenia(String NowyDataWyporzyczenia)
	{
		this.DataWydania=NowyDataWyporzyczenia;
	}
	public void SetDataTermin(String NowyDataTermin)
	{
		this.DataTermin=NowyDataTermin;
	}
	public void SetCzyPoTerminie(String NowyCzyPoTerminie)
	{
		this.CzyPoTerminie=NowyCzyPoTerminie;
	}





	// Funkcja pokazujaca wszystkei dane
	public  String ShowDane()
	{

		String TekstWyswietl;

		if(GetCzyWyporzyczona().equals("tak"))
		{

			if(GetCzyPoTerminieWyswietlanie().equals("tak"))
			{
				TekstWyswietl =(GetIdKsiazkaWypisiywanie()+ "\t|\t" + GetNazwaKsiazki() + "|" + GetAutor() + "|" + GetGatunek()  + "|" + GetDataWydania()+ "\t|\t"+ GetWyporzyczajacy() + "|" + GetCzyWyporzyczona() +
						  "\t|\t" + GetDataWyporzyczenia() +"\t|\t\t" + GetCzyPoTerminieWyswietlanie() + "\t\t|\t\t" + GetDataTermin());
			}
			else
			{
				TekstWyswietl =(GetIdKsiazkaWypisiywanie()+ "\t|\t" + GetNazwaKsiazki() + "|" +GetAutor() + "|" + GetGatunek()  + "|" + GetDataWydania() + "\t|\t"+ GetWyporzyczajacy() + "|" + GetCzyWyporzyczona() +
						  "\t|\t" + GetDataWyporzyczenia() +"\t|\t\t" + GetCzyPoTerminieWyswietlanie() + "\t\t|\t\t" + GetDataTermin());
			}
		}
		else
		{
			TekstWyswietl = (GetIdKsiazkaWypisiywanie()+ "\t|\t" + GetNazwaKsiazki() + "|" +  GetAutor() + "|" + GetGatunek() + "|" + GetDataWydania());
		}



		return TekstWyswietl;
	}
//
	public static void DostepneGatunki()
	{
		System.out.println("Dostepne gatunki: \nsci-fi , drama , literatura faktu , horror , biografia , romans , komedia , kryminal , thriller , naukowe , poradniki , przygodowe ,fantasy.");
	}

}
