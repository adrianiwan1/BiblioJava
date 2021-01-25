import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

public class Sprawdzanie
{
	public static boolean SprawdzanieGatunku(String WpisanyGatunek)
	{
		boolean OK = false;
		do
		{
			switch(WpisanyGatunek)
			{
				case "sci-fi":
					OK = true;
					break;
				case "fantasy":
					OK = true;
					break;
				case "drama":
					OK = true;
					break;
				case "literatura faktu":
					OK = true;
					break;
				case "horror":
					OK = true;
					break;
				case "biografia":
					OK = true;
					break;
				case "romans":
					OK = true;
					break;
				case "komedia":
					OK = true;
					break;
				case "kryminal":
					OK = true;
					break;
				case "thriller":
					OK = true;
					break;
				case "naukowe":
					OK = true;
					break;
				case "poradniki":
					OK = true;
					break;
				case "przygodowe":
					OK = true;
					break;
				default:
					System.out.println("Podany gatunek nie istnieje w bazie.Prosze sprobuj ponownie.");
					return OK = false;
			}
		} while(OK != true);
		return OK;
	}


	//
	//
	public static boolean CzyPodaneIdIstnieje(int PodaneID) // Wyszukiwanie inta - > ID
	{
		int i = 0;
		int Znalezione = 0;
		boolean Istnieje = false;

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int.
					if(PodaneID == Odczyt) // Porownanie odczytu.
					{
						Znalezione++;
					}
				} else
				{
					i = 9002; // Zakonczenie petli jesli null
				}
				i++;
			} while(i < 9000); // Maksymalna wartosc petli
			PlikOdczytany.close(); // Zamkniecie odczytu
		} catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
		{
			e.printStackTrace();
		}
		if(Znalezione == 0) // Obsluga nie znalezienia zadnej wartosci
		{
			return Istnieje = false;
		}else
			{
			return Istnieje == true;
			}
	}
}
