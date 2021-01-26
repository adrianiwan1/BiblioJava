public class Uzytkownik
{

	private int IdUzytkownika;
	private String Wyporzyczajacy;


	//Konstruktor
	public Uzytkownik(int IdUzytkownika,String Wyporzyczajacy)
	{
		this.IdUzytkownika=IdUzytkownika;
		this.Wyporzyczajacy=Wyporzyczajacy;
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
		return Wyporzyczajacy;
	}

	//Settery

	public void SetIdUzytkownika(int IdUzytkownika)
	{
		this.IdUzytkownika= IdUzytkownika;
	}
	public void SetUzytkownik(String Wyporzyczajacy)
	{
		this.Wyporzyczajacy= Wyporzyczajacy;
	}

	public static void ShowUzytkownicy()
	{

	}

	public  String ShowDane()
	{
		String TekstWyswietl;

		return TekstWyswietl = (GetIdUzytkownika()+ "\t\t\t" + GetUzytkownik());
	}

}
