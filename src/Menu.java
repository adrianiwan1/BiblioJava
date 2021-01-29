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

			System.out.println("ID"+"\t\t\t\t"+"NazwaKsiazki"+"\t\t\t\t\t"+"Autor"+"\t\t\t\t\t\t\t"+"Gatunek"+"\t\t\t\t\t"+"Data Wydania"+ "\t\t"+"Wypozyczający"+"\t\t\t\t\t"+"Czy wyporzyczona");
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
		} catch(IOException e )
		{
		}
	}
	//
	//
	public static void WypisywanieUzytkownikow()
	{

		int i=0;


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
			OperacjePlikKsiazki.ZapisywanieKsiazek(ObiektKsiazka,"Books.bin");
		} catch(IOException e)
		{
		}

	}
	//
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




	public static void WyswietlanieHistori()
	{
			int i = 0;

			System.out.println("ID Wpisu"+"\t"+"ID ksiazki"+"\t"+"Nazwa ksiazki"+"\t\t\t\t\t"+"Wypozyczajacy"+"\t\t\t\t\t"+"Data Wyporzyczenia"+"\t\t"+"Data Odddania"+"\t"+"Po terminie"+"\t"+"Id Wypozyczajacego"+"\t"+"Ile Dni Po Terminie");
			try
			{
				RandomAccessFile PlikOdczytany = OperacjePlikHistoria.OtwarciePlikHistoria();
				do
				{
					Ksiazka OdczytaneDane = OperacjePlikHistoria.OdczytywanieHistorii(PlikOdczytany);
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
			} catch(IOException e )
			{
			}
	}

	public static void UsuwanieKsiazki()
	{
		Menu.WypisywanieKsiazek();
		int Szukana;
		System.out.println("Wpisz liczbe id ksiazki ktora chcesz usunac");  // Prosba o wpisanie
		Szukana = WpisywanieDanych.WpisanieLiczby();
		OperacjePlikKsiazki.KasowanieKsiazki(Szukana);
	}

	public static void UsuwanieUzytkownika()
	{
		Menu.WypisywanieUzytkownikow();
		int Szukana;
		System.out.println("Wpisz liczbe id uzytkownika ktora chcesz usunac");  // Prosba o wpisanie
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
					break;
				case 4:
					try
					{
						OperacjePlikHistoria.WypozyczanieKsiazki();
					} catch(IOException e)
					{
						System.out.println("Błąd IO-0002");
					}
					break;
				case 5:
					try
					{
						OperacjePlikHistoria.ZwracanieKsiazki();
					} catch(IOException e)
					{
						System.out.println("Błąd IO-0002");
					}
					break;
				case 9:
					WyswietlenieOpcjiMenuGlowne();
					break;
				case 0:
					System.out.println("Zakonczenie Programu");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
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
	System.out.println("1.Menu Ksiazka");
	System.out.println("2.Menu Czytelnika");
	System.out.println("3.Menu Historia");
	System.out.println("4.Wyporzyczenie Ksiazki");
	System.out.println("5.Zwrot Ksiazki");
	System.out.println("9.Pomoc.");
	System.out.println("0.Zakonczenie Programu.");
	}
	public static void WyswietlenieOpcjiMenuHistoria()
	{

		System.out.println("Aktualnie znajdujesz się w Menu Czytelnika");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie Czytelników");
		System.out.println("2.Wyszukiwanie Czytelników");
		System.out.println("3.Edycja Czytelników");
		System.out.println("4.Dodanie Nowej Czytelników");
		System.out.println("5.Banowanie Czytelników");
		System.out.println("6.Od Banowanie Czytelników");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do menu głównego.");
	}






	public static void WyswietlenieOpcjiMenuCzytelnik()
	{

		System.out.println("Aktualnie znajdujesz się w Menu Czytelnika");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie Czytelników");
		System.out.println("2.Wyszukiwanie Czytelników");
		System.out.println("3.Edycja Czytelników");
		System.out.println("4.Dodanie Nowej Czytelników");
		System.out.println("5.Banowanie Czytelników");
		System.out.println("6.Od Banowanie Czytelników");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do menu głównego.");
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
					WyswietlanieCzytelnikow();
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
					OperacjePlikUzytkownicy.ZmianaDanych("ban");
					break;
				case 6:
					OperacjePlikUzytkownicy.ZmianaDanych("unban");
					break;
				case 9:
					WyswietlenieOpcjiMenuCzytelnik();
					break;
				case 0:
					System.out.println("Zakonczenie Programu");
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
		System.out.println("4.Sortowanie po: Czy Zbanowany");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do menu ksiazki.");
	}
	public static void WyswietlanieCzytelnikow()
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
				case 4:
					SortowanieUzytkownik.WyswietlaniePosortowane(SortowanieUzytkownik.Sortowanie("czyzbanowany"),"czyzbanowany");
					break;

				case 9:
					WyswietlanieOpcjiCzytelnikow();
					break;
				case 0:
					System.out.println("Zakonczenie Programu");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
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
		System.out.println("0.Cofniecie do menu ksiazki.");
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
					WyszukiwanieUzytkownik.Wyszukiwanie("idUzytkownika");
					break;
				case 2:
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
					System.out.println("Zakonczenie Programu");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
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
		System.out.println("0.Cofniecie do menu ksiazki.");
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
					OperacjePlikKsiazki.ZmianaDanych("zmiananazwa");
					break;
				case 2:
					OperacjePlikKsiazki.ZmianaDanych("ban");
					break;
				case 3:
					OperacjePlikKsiazki.ZmianaDanych("unban");
					break;
				case 4:
					TworznieUzytkownika();
					break;
				case 9:
					WyswietlanieOpcjeEdycjaCzytelnika();
					break;
				case 0:
					System.out.println("Zakonczenie Programu");
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
					Czekaj();
					break;

			}

		}while(ZakoniecznieProgramu != 0);
	}

	public static void WyswietlenieOpcjiMenuKsiazki()
	{
		System.out.println("Aktualnie znajdujesz się w menu ksiązki");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie Ksiązek");
		System.out.println("2.Wyszukiwanie Książek");
		System.out.println("3.Edycja Ksiązek");
		System.out.println("4.Wyporzyczenie Ksiazki");
		System.out.println("5.Zwrot Ksiazki");
		System.out.println("6.Dodanie Nowej Ksiazki");
		System.out.println("7.Usuniecie Ksiazki");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do menu głównego.");
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
					WyswietlanieKsiazka();
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
						System.out.println("Błąd IO-0002");
					}
					break;
				case 5:
					try
					{
						OperacjePlikHistoria.ZwracanieKsiazki();
					} catch(IOException e)
					{
						System.out.println("Błąd IO-0002");
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
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
					Czekaj();
					break;
			}
		}while(ZakoniecznieProgramu != 0);

	}
	public static void WyswietlenieOpcjiWyswietlaniaKsiazki()
	{
		System.out.println("Aktualnie znajdujesz się w Wyswietlanie ksiązek");
		System.out.println("Mozliwe sa:");
		System.out.println("1.Wyswietlanie wszystkich książek");
		System.out.println("2.Sortowanie po: ID");
		System.out.println("3.Sortowanie po: Nazwa Ksiazki");
		System.out.println("4.Sortowanie po: Autor");
		System.out.println("5.Sortowanie po: Nazwa Uzytkownika");
		System.out.println("6.Sortowanie po: Gatunek");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do menu ksiazki.");
	}
	public static void WyswietlanieKsiazka()
	{
		int ZakoniecznieProgramu = 1;
		do{
			WyswietlenieOpcjiWyswietlaniaKsiazki();

			System.out.println("Prosze dokonac wyboru. Poprzez podanie liczby.");
			int Wybor = WpisywanieDanych.WpisanieLiczby();

			switch(Wybor)
			{
				case 1:
					WyswietlanieKsiazka();
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
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
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
		System.out.println("6.Wyszukiwanie po: Czy jest wyporzyczona");
		System.out.println("7.Wyszukiwanie po: Czy jest po terminie");
		System.out.println("9.Pomoc.");
		System.out.println("0.Cofniecie do menu ksiazki.");
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
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
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
		System.out.println("0.Cofniecie do menu ksiazki.");
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
					OperacjePlikKsiazki.ZmianaDanych("zmiananazwa");
					break;
				case 2:
					OperacjePlikKsiazki.ZmianaDanych("zmianaautor");
					break;
				case 3:
					OperacjePlikKsiazki.ZmianaDanych("zmianagatunek");
					break;
				case 4:
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
					ZakoniecznieProgramu = 0;
					break;
				default:
					System.out.println("Nie ma takiego wyboru.Prosze spróbować ponownie.");
					Czekaj();
					break;
			}
		}while(ZakoniecznieProgramu != 0);

	}
	public static void Czekaj()
	{
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			System.out.println("Cos poszlo Nie tak");
		}
	}

}
