import java.io.IOException;
import java.io.RandomAccessFile;

public class Menu
{
	public static void WypisywanieKsiazek()
	{
		int i = 0;
		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
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
			PlikOdczytany.close();
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
