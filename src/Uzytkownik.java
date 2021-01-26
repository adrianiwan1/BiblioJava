public class Uzytkownik
{

	private int IdUzytkownika;
	private String Czytelnik;


	//Konstruktor


	public Uzytkownik(int NowyIdUzytkownika,String NowyCzytelnik)
	{
		this.IdUzytkownika=NowyIdUzytkownika;
		this.Czytelnik=NowyCzytelnik;
	}




	public static Uzytkownik TworzenieUzytkownik()
	{
		int IdUzytkownika;
		String Uzytkownik;
		boolean OK = true;
		String CzyRandomId;

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
		}
		System.out.println("Podaj nazwę Uzytkownika:");
		Uzytkownik=WpisywanieDanych.WpisanieSlowa();
		Uzytkownik ObiektUzytkownik= new Uzytkownik(IdUzytkownika,Uzytkownik);

		return ObiektUzytkownik;
	}
	//Getery

	public int GetIdUzytkownika()
	{
		return IdUzytkownika;
	}

	public String GetUzytkownik()
	{
		return Czytelnik;
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

	public  String ShowUzytkownicy()
	{
		String TekstWyswietl;

		return TekstWyswietl = (GetIdUzytkownika()+ "\t\t\t" + GetUzytkownik());
	}

}
