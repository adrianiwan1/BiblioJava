import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Uzytkownik
{

	private int IdUzytkownika;
	private String Czytelnik;
	private String CzyZbanownay;

	//Konstruktor


	public Uzytkownik(int NowyIdUzytkownika,String NowyCzytelnik , String NowyCzyZbanowany)
	{
		this.IdUzytkownika=NowyIdUzytkownika;
		this.Czytelnik=NowyCzytelnik;
		this.CzyZbanownay=NowyCzyZbanowany;
	}




	public static Uzytkownik TworzenieUzytkownik()
	{
		int IdUzytkownika;
		String Uzytkownik;
		boolean OK = true;
		String CzyRandomId;
		String CzyZbanowany = ("nie");

		System.out.println("Czy chcesz wpisać własne ID? Tak/Nie");
		CzyRandomId = WpisywanieDanych.WpisanieTakLubNie();
		System.out.println(CzyRandomId);
		if (CzyRandomId.equals("nie")) {
			do {
				IdUzytkownika = Unikalne.Id();
				OK = SprawdzanieKsiazka.CzyPodaneIdIstnieje(IdUzytkownika);
			} while (OK != false);
		}else {

			System.out.println("Podaj ID Uzytkownika:");
			do {
				IdUzytkownika = WpisywanieDanych.WpisanieLiczby();
				OK = SprawdzanieUzytkownik.CzyPodaneIdIstnieje(IdUzytkownika);
				if (OK != false) {
					System.out.println("Istnieje juz id z podana wartoscia.Prosze podac inne.");
				}
			} while (OK != false);
			System.out.println("Czy chcesz od razu zbanować użytkownika?");
			OK = WpisywanieDanych.WpisanieBool();
			if(OK==true)
			{
				CzyZbanowany = "tak";
			}else
				{
				CzyZbanowany = "nie";
				}
		}
		System.out.println("Podaj nazwę Uzytkownika:");
		Uzytkownik=WpisywanieDanych.WpisanieSlowa();
		Uzytkownik ObiektUzytkownik= new Uzytkownik(IdUzytkownika,Uzytkownik,CzyZbanowany);

		return ObiektUzytkownik;
	}
	//Getery

	public int GetIdUzytkownika()
	{
		return IdUzytkownika;
	}

	public String GetNazwaUzytkownik()
	{
		return Czytelnik;
	}
	public String GetCzyZbanowany()
	{
		return CzyZbanownay;
	}

	//Settery

	public void SetIdUzytkownika(int NowyIdUzytkownika)
	{
		this.IdUzytkownika= NowyIdUzytkownika;
	}
	public void SetUzytkownik(String NowyCzytelnik)
	{
		this.Czytelnik= NowyCzytelnik;
	}

	public void  SetCzyZbanowany(String NowyCzyZbanowany)
	{
		this.CzyZbanownay = NowyCzyZbanowany;

	}

	public  String ShowUzytkownicy()
	{
		String TekstWyswietl;

		return TekstWyswietl = (GetIdUzytkownika()+ "\t\t\t" + GetNazwaUzytkownik() + GetCzyZbanowany());
	}



	public static void UsuwanieUzytkownika()
	{

	}

}
