import java.io.IOException;
import java.io.RandomAccessFile;

public class SprawdzanieBlackList
{
	public static boolean CzyPodaneIdIstnieje(int PodaneID) // Wyszukiwanie inta - > ID
	{
		int i = 0;
		int Znalezione = 0;
		boolean Istnieje;

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikBlackList.OtwarciePlikBlackList(); //Otwarcie pliku
			do
			{
				BlackList OdczytaneDane = OperacjePlikBlackList.OdczytywanieZbanowanych(PlikOdczytany); // Odczytranie linjki tekstu
				if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
				{
					int Odczyt = OdczytaneDane.GetIdZbanownay(); //Wpisanie danej do int.
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
			return Istnieje = true;
		}
	}
}
