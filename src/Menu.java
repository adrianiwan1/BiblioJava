import java.io.FileNotFoundException;
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
			System.out.println("ID"+"\t\t\t\t"+"Nazwa Książki"+"\t\t\t\t\t\t"+"Autor"+"\t\t\t\t\t\t\t"+"Gatunek"+"\t\t\t\t\t"+"Data Wydania"+ "\t"+"Wypożyczający"+"\t\t\t\t "+"Wypożyczona?"+"\t" + " Wypożyczona" + "\t" + "Po Terminie?" + "\t\t" +"Termin" 	);
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
			Czekaj();
		} catch(IOException e )
		{
		}
	}
	//
	//
	public static void WypisywanieUzytkownikow()
	{
		int i=0;
		System.out.println("ID Czytelnika"+"\t\t"+"Imie i Nazwisko"+"\t\t\t\t\t"+"Czy Zbanowany?");
		try{
			RandomAccessFile PlikOdczytany = OperacjePlikUzytkownicy.OtwarciePlikUzytkownicy();
			do {
				Uzytkownik OdczytaneDane = OperacjePlikUzytkownicy.OdczytywanieUzytkownikow(PlikOdczytany);
				if(OdczytaneDane != null)
				{
					System.out.println(OdczytaneDane.ShowUzytkownicy());
				} else
				{
					i = 201;
				}
				i++;
			}while(i < 200);
			Czekaj();
			PlikOdczytany.close();
		}catch(IOException e)
		{
		}
	}
	//
	//
	public static void TworzenieKsiazki()
	{
		Ksiazka ObiektKsiazka = Ksiazka.TworzenieKsiazka();
		try
		{
			if(ObiektKsiazka.GetCzyWyporzyczona().equals("nie"))
			{
				OperacjePlikKsiazki.ZapisywanieKsiazek(ObiektKsiazka, "Books.bin");
			}else
			{
				OperacjePlikKsiazki.ZapisywanieKsiazek(ObiektKsiazka, "Books.bin");
				Historia.TworzenieWpisuBezBooks(ObiektKsiazka); // przekazanie parametrów do funkcji tworzenia wpisu.
				//Historia.TworzenieWpisu(ObiektKsiazka.GetIdKsiazki(), ObiektKsiazka.GetIdUzytkownika(), ObiektKsiazka.GetDataWyporzyczenia(), ObiektKsiazka.GetDataTermin(), ObiektKsiazka.GetWyporzyczajacy(),Daty.ObecnaData());
			}
		} catch(IOException e)
		{
		}
	}
	//
	public static void TworznieUzytkownika()
	{
		Uzytkownik ObiektUzytkownik = Uzytkownik.TworzenieUzytkownik();
		try
		{
			OperacjePlikUzytkownicy.ZapisywanieUzytkownika(ObiektUzytkownik,"Users.bin");
		} catch(IOException e)
		{
		}
	}
//
	public static void WyswietlanieHistori()
	{
			int i = 0;
			System.out.println("ID Wpisu"+"\t\t"+"ID ksiazki"+"\t\t "+"Nazwa Książki"+"\t\t\t\t\t"+"Wypozyczajacy"+"\t\t\t\t\t"+"Data Wypożyczenia"+"\t\t"+"Data Oddania"+"\t    "+"Po terminie?"+"   "+"Id Wypozyczajacego"+"\t "+"Czy Wypożyczona?"+"\t"+"Data Wyporzyczenia");
			try
			{
				RandomAccessFile PlikOdczytany = OperacjePlikHistoria.OtwarciePlikHistoria();
				do
				{
					Historia OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany);
					if(OdczytaneDane != null)
					{
						System.out.println(OdczytaneDane.ShowDaneHistoria());
					} else
					{
						i = 201;
					}
					i++;
				} while(i < 200);
				Czekaj();
				PlikOdczytany.close();
			} catch(IOException e )
			{
			}
	}
	//
	public static void UsuwanieKsiazki()
	{
		Menu.WypisywanieKsiazek();
		int Szukana;
		System.out.println("Wpisz liczbę id ksiązki którą chcesz usunąć");  // Prosba o wpisanie
		Szukana = WpisywanieDanych.WpisanieLiczby();
		OperacjePlikKsiazki.KasowanieKsiazki(Szukana);
	}

	public static void UsuwanieUzytkownika()
	{
		Menu.WypisywanieUzytkownikow();
		int Szukana;
		System.out.println("Wpisz liczbę id użytkownika którą chcesz usunąć");  // Prosba o wpisanie
		Szukana = WpisywanieDanych.WpisanieLiczby();
		OperacjePlikUzytkownicy.UsuwanieUzytkownik(Szukana);
	}

	public static void MenuGlowne ()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiMenuGlowne();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					MenuKsiazka();
					break;
				case 2:
					MenuCzytelnik();
					break;
				case 3:
					MenuHistoria();
					break;
				case 4:
					try
					{
						OperacjePlikHistoria.WypozyczanieKsiazki();
					} catch(IOException e)
					{
					}
					break;
				case 5:
					try
					{
						OperacjePlikHistoria.ZwracanieKsiazki();
					} catch(IOException e)
					{

					}
					break;
				case 9:
					WyswietlenieOpcjiMenuGlowne();
					break;
				case 0:
					System.out.println("Zakonczenie Programu\n");
					Czekaj();
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;

			}

		}while(ZakoniecznieProgramu != 0);
	}
	public static void WyswietlenieOpcjiMenuGlowne ()
	{
	System.out.println("Witaj w programie Biblonomicon");
	System.out.println("By zobaczyc opcje zawsze mozesz wybrac 9 opcje.");
	System.out.println("Aktualnie znajdujesz się w menu głównym");
	System.out.println("Mozliwe sa:");
	System.out.println("1.Menu Książka");
	System.out.println("2.Menu Czytelnika");
	System.out.println("3.Menu Historia");
	System.out.println("4.Wypożyczenie Ksiazki");
	System.out.println("5.Zwrot Ksiazki");
	System.out.println("9.Pomoc.");
	System.out.println("0.Zakonczenie Programu.");
	}
	public static void WyswietlenieOpcjiMenuHistoria()
	{

		System.out.println("Aktualnie znajdujesz się w Menu Historia");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie Histori");
		System.out.println("2.Wyszukiwanie Histori");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu głównego.");
	}
	public static void MenuHistoria()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiMenuHistoria();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					MenuWyswietlanieHistori();
					break;
				case 2:
					OpcjeWyszukiwanieHistori();
					break;
				case 9:
					SzukanieHistori();
					break;
				case 0:
					System.out.println("Cofniecie do Menu głównego\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;

			}

		}while(ZakoniecznieProgramu != 0);
	}
	public static void WyswietlanieOpcjiHistori()
	{
		System.out.println("Aktualnie znajdujesz się w Wyswietlanie Historii");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie całej histori wyporzyczeń");
		System.out.println("2.Sortowanie po: ID Histori");
		System.out.println("3.Sortowanie po: ID Ksiazki");
		System.out.println("4.Sortowanie po: ID Czytelnika");
		System.out.println("5.Sortowanie po: Nazwa Ksiazki");
		System.out.println("6.Sortowanie po: Nazwy Czytelnika");
		System.out.println("7.Sortowanie po: Autora");
		System.out.println("8.Sortowanie po: Gatunku");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu Historia.");
	}
	public static void MenuWyswietlanieHistori()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlanieOpcjiHistori();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					WyswietlanieHistori();
					break;
				case 2:
					SortowanieHistoria.WyswietlaniePosortowaneID(SortowanieHistoria.PoId("id"),"id");
					break;
				case 3:
					SortowanieHistoria.WyswietlaniePosortowaneID(SortowanieHistoria.PoId("idksiazki"),"idksiazki");
					break;
				case 4:
					SortowanieHistoria.WyswietlaniePosortowaneID(SortowanieHistoria.PoId("iduzytkownika"),"iduzytkownika");
					break;
				case 5:
					SortowanieHistoria.WyswietlaniePosortowaneHistoria("nazwaksiazki");
					break;
				case 6:
					SortowanieHistoria.WyswietlaniePosortowaneHistoria("uzytkownik");
					break;
				case 7:
					SortowanieHistoria.WyswietlaniePosortowaneHistoria("autor");
					break;
				case 8:
					SortowanieHistoria.WyswietlaniePosortowaneHistoria("gatunek");
					break;
				case 9:
					WyswietlanieOpcjiHistori();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Historia.\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;
			}
		}while(ZakoniecznieProgramu != 0);
	}
	public static void OpcjeWyszukiwanieHistori()
	{
		System.out.println("Aktualnie znajdujesz się w Wyszukiwnaie Historia");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyszukiwanie po: ID Histori");
		System.out.println("2.Wyszukiwanie po: ID Ksiazki");
		System.out.println("3.Wyszukiwanie po: ID Czytelnika");
		System.out.println("4.Wyszukiwanie po: Nazwa Ksiazki");
		System.out.println("5.Wyszukiwanie po: Nazwa Czytelnika");
		System.out.println("6.Wyszukiwanie po: Czy Wypożyczona");
		System.out.println("7.Wyszukiwanie po: Czy po terminie");
		System.out.println("8.Wyszukiwanie po: Gatunek");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu Historia.");
	}
	public static void SzukanieHistori()
	{
		int ZakoniecznieProgramu = 1;
		do{
			OpcjeWyszukiwanieHistori();
			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();
			switch(Wybor)
			{
				case 1:
					WyszukiwanieHistoria.Wyszukiwanie("id");
					break;
				case 2:
					WyszukiwanieHistoria.Wyszukiwanie("idksiazki");
					break;
				case 3:
					WyszukiwanieHistoria.Wyszukiwanie("idczytelnika");
					break;
				case 4:
					WyszukiwanieHistoria.Wyszukiwanie("nazwa");
					break;
				case 5:
					WyszukiwanieHistoria.Wyszukiwanie("wyporzyczajacy");
					break;
				case 6:
					WyszukiwanieHistoria.Wyszukiwanie("czywyporzyczona");
					break;
				case 7:
					WyszukiwanieHistoria.Wyszukiwanie("czypoterminie");
					break;
				case 8:
					WyszukiwanieHistoria.Wyszukiwanie("gatunek");
					break;
				case 9:
					OpcjeWyszukiwanieHistori();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Historia.\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;
			}
		}while(ZakoniecznieProgramu != 0);
	}
	public static void WyswietlenieOpcjiMenuCzytelnik()
	{
		System.out.println("Aktualnie znajdujesz się w Menu Czytelnika");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie Czytelników");
		System.out.println("2.Wyszukiwanie Czytelników");
		System.out.println("3.Edycja Czytelników");
		System.out.println("4.Dodanie Nowego Czytelnika");
		System.out.println("5.Banowanie Czytelników");
		System.out.println("6.Od Banowanie Czytelników");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu głównego.");
	}
	public static void MenuCzytelnik ()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiMenuCzytelnik();
			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();
			switch(Wybor)
			{
				case 1:
					MenuWyswietlanieCzytelnikow();
					break;
				case 2:
					SzukanieCzytelnikow();
					break;
				case 3:
					EdycjaCzytelnika();
					break;
				case 4:
					TworznieUzytkownika();
					break;
				case 5:
					Menu.WypisywanieUzytkownikow();
					OperacjePlikUzytkownicy.ZmianaDanych("ban");
					break;
				case 6:
					Menu.WypisywanieUzytkownikow();
					OperacjePlikUzytkownicy.ZmianaDanych("unban");
					break;
				case 9:
					WyswietlenieOpcjiMenuCzytelnik();
					break;
				case 0:
					System.out.println("Cofniecie do Menu głównego");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
					Czekaj();
					break;
			}

		}while(ZakoniecznieProgramu != 0);
	}
	public static void WyswietlanieOpcjiCzytelnikow()
	{
		System.out.println("Aktualnie znajdujesz się w Wyswietlanie Czytelnika");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie wszystkich Czytelników");
		System.out.println("2.Sortowanie po: ID");
		System.out.println("3.Sortowanie po: Nazwa Czytelnika");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu Czytelnik.");
	}
	public static void MenuWyswietlanieCzytelnikow()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlanieOpcjiCzytelnikow();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					WypisywanieUzytkownikow();
					break;
				case 2:
					SortowanieUzytkownik.WyswietlaniePosortowaneID(SortowanieUzytkownik.SortowaniePoID());
					break;
				case 3:
					SortowanieUzytkownik.WyswietlaniePosortowane(SortowanieUzytkownik.Sortowanie("nazwa"),"nazwa");
					break;
				case 9:
					WyswietlanieOpcjiCzytelnikow();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Czytelnik.\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;

			}

		}while(ZakoniecznieProgramu != 0);
	}
	public static void WyswietlenieOpcjiWyszukiwanieCzytelnikow()
	{
		System.out.println("Aktualnie znajdujesz się w Wyszukiwnaie Czytelnika");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyszukiwanie po: ID");
		System.out.println("2.Wyszukiwanie po: Nazwa Czytelnika");
		System.out.println("3.Wyszukiwanie po: Zbanowanych");
		System.out.println("4.Wyszukiwanie po: Nie Zbanowanych");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu Czytelnik.");
	}
	public static void SzukanieCzytelnikow()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiWyszukiwanieCzytelnikow();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					Menu.WypisywanieUzytkownikow();
					WyszukiwanieUzytkownik.Wyszukiwanie("idUzytkownika");
					break;
				case 2:
					Menu.WypisywanieUzytkownikow();
					WyszukiwanieUzytkownik.Wyszukiwanie("nazwa");
					break;
				case 3:
					WyszukiwanieUzytkownik.Wyszukiwanie("zbanowany");
					break;
				case 4:
					WyszukiwanieUzytkownik.Wyszukiwanie("niezbanowany");
					break;
				case 9:
					WyswietlenieOpcjiWyszukiwanieCzytelnikow();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Czytelnik.\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;

			}

		}while(ZakoniecznieProgramu != 0);
	}

	public static void WyswietlanieOpcjeEdycjaCzytelnika()
	{
		System.out.println("Aktualnie znajdujesz się w Edycja Czytelnika");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Zmiana Nazwy Czytelnika");
		System.out.println("2.Banowanie Czytelnika");
		System.out.println("3.Od Banowywanie Czytelnika");
		System.out.println("4.Dodawanie Czytelnika");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu Czytelnik.");
	}
	public static void EdycjaCzytelnika ()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlanieOpcjeEdycjaCzytelnika();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					Menu.WypisywanieUzytkownikow();
					OperacjePlikKsiazki.ZmianaDanych("zmiananazwa");
					break;
				case 2:
					Menu.WypisywanieUzytkownikow();
					OperacjePlikKsiazki.ZmianaDanych("ban");
					break;
				case 3:
					Menu.WypisywanieUzytkownikow();
					OperacjePlikKsiazki.ZmianaDanych("unban");
					break;
				case 4:
					TworznieUzytkownika();
					break;
				case 9:
					WyswietlanieOpcjeEdycjaCzytelnika();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Czytelnik");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;
			}

		}while(ZakoniecznieProgramu != 0);
	}

	public static void WyswietlenieOpcjiMenuKsiazki()
	{
		System.out.println("Aktualnie znajdujesz się w Menu ksiązki");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie Ksiązek");
		System.out.println("2.Wyszukiwanie Książek");
		System.out.println("3.Edycja Ksiązek");
		System.out.println("4.Wypożyczenie Ksiazki");
		System.out.println("5.Zwrot Ksiazki");
		System.out.println("6.Dodanie Nowej Ksiazki");
		System.out.println("7.Usuniecie Ksiazki");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu głównego.");
	}
	public static void MenuKsiazka()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiMenuKsiazki();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					MenuWyswietlanieKsiazka();
					break;
				case 2:
					SzukanieKsiazek();
					break;
				case 3:
					EdycjaKsiazki();
					break;
				case 4:
					try
					{
						OperacjePlikHistoria.WypozyczanieKsiazki();
					} catch(IOException e)
					{
					}
					break;
				case 5:
					try
					{
						OperacjePlikHistoria.ZwracanieKsiazki();
					} catch(IOException e)
					{
					}
					break;
				case 6:
					TworzenieKsiazki();
					break;
				case 7:
					UsuwanieKsiazki();
					break;
				case 9:
					WyswietlenieOpcjiMenuKsiazki();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Główne\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;
			}
		}while(ZakoniecznieProgramu != 0);

	}
	public static void WyswietlenieOpcjiWyswietlaniaKsiazki()
	{
		System.out.println("Aktualnie znajdujesz się w Wyświetlanie książek");
		System.out.println("Możliwe są:");
		System.out.println("1.Wyświetlanie wszystkich książek");
		System.out.println("2.Sortowanie po: ID");
		System.out.println("3.Sortowanie po: Nazwa Ksiazki");
		System.out.println("4.Sortowanie po: Autor");
		System.out.println("5.Sortowanie po: Nazwa Uzytkownika");
		System.out.println("6.Sortowanie po: Gatunek");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu ksiazki.");
	}
	public static void MenuWyswietlanieKsiazka()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiWyswietlaniaKsiazki();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					WypisywanieKsiazek();
					break;
				case 2:
					SortowanieKsiazka.WyswietlaniePosortowaneID(SortowanieKsiazka.SortowaniePoID());
					break;
				case 3:
					SortowanieKsiazka.WyswietlaniePosortowane(SortowanieKsiazka.Sortowanie("nazwaksiazki"),"nazwaksiazki");
					break;
				case 4:
					SortowanieKsiazka.WyswietlaniePosortowane(SortowanieKsiazka.Sortowanie("autor"),"autor");
					break;
				case 5:
					SortowanieKsiazka.WyswietlaniePosortowane(SortowanieKsiazka.Sortowanie("uzytkownik"),"uzytkownik");
					break;
				case 6:
					SortowanieKsiazka.WyswietlaniePosortowane(SortowanieKsiazka.Sortowanie("gatunek"),"gatunek");
					break;
				case 9:
					WyswietlenieOpcjiWyswietlaniaKsiazki();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Ksiazki.\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;
			}
		}while(ZakoniecznieProgramu != 0);

	}
	public static void WyswietlenieOpcjiWyszukiwanieKsiazki()
	{
		System.out.println("Aktualnie znajdujesz się w Wyszukiwnaie Ksiazki");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyszukiwanie po: ID");
		System.out.println("2.Wyszukiwanie po: Nazwa Ksiazki");
		System.out.println("3.Wyszukiwanie po: Autor");
		System.out.println("4.Wyszukiwanie po: Nazwa Uzytkownika");
		System.out.println("5.Wyszukiwanie po: Gatunek");
		System.out.println("6.Wyszukiwanie po: Czy jest Wypożyczona");
		System.out.println("7.Wyszukiwanie po: Czy jest po terminie");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu ksiazki.");
	}
	public static void SzukanieKsiazek()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiWyszukiwanieKsiazki();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					WyszukiwanieKsiazka.Wyszukiwanie("id");
					break;
				case 2:
					WyszukiwanieKsiazka.Wyszukiwanie("nazwa");
					break;
				case 3:
					WyszukiwanieKsiazka.Wyszukiwanie("autor");
					break;
				case 4:
					WyszukiwanieKsiazka.Wyszukiwanie("wyporzyczajacy");
					break;
				case 5:
					WyszukiwanieKsiazka.Wyszukiwanie("gatunek");
					break;
				case 6:
					WyszukiwanieKsiazka.Wyszukiwanie("czywyporzyczona");
					break;
				case 7:
					WyszukiwanieKsiazka.Wyszukiwanie("czypoterminie");
					break;
				case 9:
					WyswietlenieOpcjiWyszukiwanieKsiazki();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Ksiazki.\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;
			}
		}while(ZakoniecznieProgramu != 0);

	}
	public static void WyswietlenieOpcjiEdycjaKsiazki()
	{
		System.out.println("Aktualnie znajdujesz się w Edycja Ksiazki");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Zmiana Nazwy");
		System.out.println("2.Zmiana Autora");
		System.out.println("3.Zmiana Gatunku");
		System.out.println("4.Zmiana Daty Wydania");
		System.out.println("5.Usuniecie Ksiazki");
		System.out.println("6.Tworzenie Ksiazki");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do Menu ksiazki.");
	}
	public static void EdycjaKsiazki()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiEdycjaKsiazki();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					Menu.WypisywanieKsiazek();
					OperacjePlikKsiazki.ZmianaDanych("zmiananazwa");
					break;
				case 2:
					Menu.WypisywanieKsiazek();
					OperacjePlikKsiazki.ZmianaDanych("zmianaautor");
					break;
				case 3:
					Menu.WypisywanieKsiazek();
					OperacjePlikKsiazki.ZmianaDanych("zmianagatunek");
					break;
				case 4:
					Menu.WypisywanieKsiazek();
					OperacjePlikKsiazki.ZmianaDanych("zmianadatawydania");
					break;
				case 5:
					UsuwanieKsiazki();
					break;
				case 6:
					TworzenieKsiazki();
					break;
				case 9:
					WyswietlenieOpcjiEdycjaKsiazki();
					break;
				case 0:
					System.out.println("Cofniecie do Menu Ksiazki.\n");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.\n");
					Czekaj();
					break;
			}
		}while(ZakoniecznieProgramu != 0);

	}
	public static void Czekaj()
	{
		try
		{
			Thread.sleep(1200);
		}
		catch(InterruptedException e)
		{
			System.out.println("Cos poszlo Nie tak");
		}
	}

}
