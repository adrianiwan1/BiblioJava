import java.io.*;

public class Menu
{

	public static void WpisywanieKsiazek()
	{
		int i = 0;
		try
		{
			ObjectInputStream PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
				if(OdczytaneDane != null)
				{
					System.out.println(OdczytaneDane.ShowDane());
				} else
				{
					i = 201;
				}
				i++;
			} while(i < 200);
		} catch(IOException| ClassNotFoundException e)
		{
			e.printStackTrace();
		}


	}
}
