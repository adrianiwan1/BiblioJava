import java.io.IOException;
import java.io.RandomAccessFile;

public class Wyszukiwanie
{
	public static void WyszukiwanieAutora()
	{
		int i = 0;
		String SzukanyAutor = null;
		int Znalezione = 0;

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki();
			System.out.println("Wpisz autora ktorego ksiaz chcesz znalezc");
			SzukanyAutor = WpisywanieDanych.WpisanieSlowa();
			SzukanyAutor = BezSpacji(SzukanyAutor);
			do
			{
				Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany);
				if(OdczytaneDane != null)
				{
					String OdczytanyAutor = OdczytaneDane.GetAutor();
					String AutorBezSpacji = BezSpacji(OdczytanyAutor);
					if(SzukanyAutor.equals(AutorBezSpacji))
					{
						System.out.println(OdczytaneDane.ShowDane());
						Znalezione++;
					}
				} else
				{
					i = 300;
				}
				i++;
			} while(i < 200);
			PlikOdczytany.close();
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		if(Znalezione == 0)
			{
			System.out.println("Nie znaleziono ksiazek z podanego autora.");
			}
	}



	public  static String BezSpacji(String Slowo)
	{
		String GotoweSlowo = null;
		if (Slowo != null)
		{
			GotoweSlowo = Slowo.trim();
			return GotoweSlowo;
		}else
			{
			 GotoweSlowo =("Podane Slowo jest puste");
				return GotoweSlowo;
			}
	}
}
