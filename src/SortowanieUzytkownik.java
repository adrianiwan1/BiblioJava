import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class SortowanieUzytkownik
{
	public static ArrayList<Integer> SortowaniePoID()
	{
		ArrayList<Integer> ListaId = new ArrayList<Integer>();

		int i = 0;
		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy();
			do
			{
				Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany);
				if(OdczytaneDane != null)
				{
					ListaId.add(OdczytaneDane.GetIdUzytkownika());
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

		Collections.sort(ListaId);
		return ListaId;

	}

	public static void WyswietlaniePosortowaneID(ArrayList<Integer> ListaID) // Wyszukiwanie inta - > ID
	{
		int i = 0;
		int j = 0;
		int Dlugosc = ListaID.size();
		int Porownywana = 0;
		do
		{
			i = 0;
			try
			{
				RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy(); //Otwarcie pliku
				do
				{
					Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
					if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
					{
						int Odczyt = OdczytaneDane.GetIdUzytkownika(); //Wpisanie danej do int
						Porownywana = ListaID.get(j);
						if(Porownywana == Odczyt) // Porownanie odczytu.
						{
							System.out.println(OdczytaneDane.ShowUzytkownicy()); //Wyswietlenie odczytu
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
			j++;
		} while((Dlugosc) != j);
	}

	public static String[] Sortowanie(String Zmienna) // Zmienna to wartosc co sortujemy potrzebne do switcha.
	{
		TreeSet<String> TreeLista = new TreeSet<String>();
		int i = 0;

		try
		{
			RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy();
			do
			{

				Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany);
				if(OdczytaneDane != null)
				{
					switch(Zmienna)
					{
						case "nazwa":
							TreeLista.add(OdczytaneDane.GetNazwaUzytkownik());
							break;
						case "czyzbanowany":
							TreeLista.add(OdczytaneDane.GetCzyZbanowany());
							break;
						default:
							System.out.println("Cos poszlo bardzo nie tak.");
							break;
					}
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
		String[] ListaKoncowa = TreeLista.toArray(new String[TreeLista.size()]);
		return ListaKoncowa;

	}

	public static void WyswietlaniePosortowane(String[] ListaKoncowa,String Zmienna) // Wyszukiwanie inta - > ID
	{
		int i = 0;
		int j = 0;
		int Dlugosc = ListaKoncowa.length;
		String Porownywana = null;
		String Odczyt = ("PustyPustoPustusienkoNiemaNic");
		do
		{
			i = 0;
			try
			{
				RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy(); //Otwarcie pliku
				do
				{
					Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany); // Odczytranie linjki tekstu
					if(OdczytaneDane != null) // Jesli nie jest puste wykonaj
					{
						switch(Zmienna)
						{
							case"nazwa":
								Odczyt = OdczytaneDane.GetNazwaUzytkownik(); //Wpisanie danej do int
								break;
							case"czyzbanowany":
								Odczyt = OdczytaneDane.GetCzyZbanowany(); //Wpisanie danej do int
								break;
							default:
								System.out.println("Cos poszlo bardzo nie tak.");
								break;
						}
						if(Odczyt.equals("PustyPustoPustusienkoNiemaNic"))
						{

						}else
						{
							Porownywana = ListaKoncowa[j];
						}
						if(Porownywana.equals(Odczyt)) // Porownanie odczytu.
						{
							System.out.println(OdczytaneDane.ShowUzytkownicy()); //Wyswietlenie odczytu
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
			j++;
		} while((Dlugosc) != j);
	}

}
