import java.io.IOException;
import java.io.RandomAccessFile;

public class EdycjaKsiazki
{
	public static void WypozyczanieKsiazki() throws IOException
	{
		int IdKsiazki;
		int IdCzytelnik = 0;
		String NazwaCzytelnik;
		String TerminWyporyczena;
		String Wyporzyczajacy;
		boolean OK = true;
		String CzyWypozyczona ="tak";
		boolean CzyWpisacRecznie;
		String DataWyporzyczenia;
		String DataTermin;


		Menu.WypisywanieKsiazek();

		do {
			RandomAccessFile EdycjaKsiazki = OperacjePlikKsiazki.OtwarciePlikKsiazki();
			System.out.println("Podaj Id ksiazki, ktora chcesz edytowac:");
			IdKsiazki = WpisywanieDanych.WpisanieLiczby();
			if (WyszukiwanieKsiazka.IdCzyIstnieje(IdKsiazki,EdycjaKsiazki) == 1)
			{
				EdycjaKsiazki = OperacjePlikKsiazki.OtwarciePlikKsiazki();

						System.out.println("Czy chcesz wpisac recznie termin oddania.  Tak/Nie");
						CzyWpisacRecznie = WpisywanieDanych.WpisanieBool();
						if (CzyWpisacRecznie == true) {
							System.out.println("Podaj prosze termin wyporzyczenia.");
							DataTermin = Daty.WpisanieDaty();
						} else {
							DataTermin = Daty.TerminOddania(DataWyporzyczenia);
						}
						Historia.TworzenieWpisu(IdKsiazki, IdCzytelnik, DataWyporzyczenia, DataTermin, NazwaCzytelnik); // przekazanie parametrów do funkcji tworzenia wpisu.
						//System.out.println(IdKsiazki);
				}else
			{
				System.out.println("Ksiazka o podanym ID nie istnieje");
				OK = false;
			}
		}while(OK!=true);


	}
}
