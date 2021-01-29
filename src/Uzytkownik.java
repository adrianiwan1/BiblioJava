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
		int IdUzytkownika = 0;
		String Uzytkownik = null;
		boolean OK = true;
		String CzyRandomId =null;
		String CzyZbanowany = ("nie");

		System.out.println("Czy chcesz wpisać własne ID? Tak/Nie");
		CzyRandomId = WpisywanieDanych.WpisanieTakLubNie();
		if (CzyRandomId.equals("nie")) {
			do {
				IdUzytkownika = GeneratorLosowegoID.Id();
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

	public String GetIdUzytkownikWypisiywanie()
	{
		String IdKsiazkiJakoString = (""+IdUzytkownika);
		int dlugosc =IdKsiazkiJakoString.length();
		switch(dlugosc)
		{
			case 1:
				IdKsiazkiJakoString = (IdUzytkownika + "         ");
				break;
			case 2:
				IdKsiazkiJakoString = (IdUzytkownika + "        ");
				break;
			case 3:
				IdKsiazkiJakoString = (IdUzytkownika + "       ");
				break;
			case 4:
				IdKsiazkiJakoString = (IdUzytkownika + "      ");
				break;
			case 5:
				IdKsiazkiJakoString = (IdUzytkownika + "     ");
				break;
			case 6:
				IdKsiazkiJakoString = (IdUzytkownika + "    ");
				break;
			case 7:
				IdKsiazkiJakoString = (IdUzytkownika + "   ");
				break;
			case 8:
				IdKsiazkiJakoString = (IdUzytkownika + "  ");
				break;
			case 9:
				IdKsiazkiJakoString = (IdUzytkownika + " ");
				break;

		}
		return  IdKsiazkiJakoString;
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

		return TekstWyswietl = (GetIdUzytkownikWypisiywanie()+ "\t\t\t" + GetNazwaUzytkownik() + GetCzyZbanowany());
	}



	public static void UsuwanieUzytkownika()
	{

	}

}
