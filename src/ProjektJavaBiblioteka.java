import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ProjektJavaBiblioteka {
	public static void main(String[] args)
	{
		/*
		Ksiazka Kochanowski = Ksiazka.TworzenieKsiazka();

		try {
			OperacjePlik.Zapisywanie(Kochanowski);
		} catch (IOException e) {
			e.printStackTrace();
		}

		 */


			try {

				RandomAccessFile plik = OperacjePlik.OtwarciePlik();


				for (long j = 0; j <10; j++) {

					if (plik.readLine()!=null) {
						Ksiazka Jan = OperacjePlik.Odczytywanie(plik);
						System.out.println(Jan.GetNazwaKsiazki());
						plik.readLine();
					}else
					{
						System.out.println("Koniec pliku");
						j=11;
					}
				}


				plik.close();




			} catch (IOException e) {
				e.printStackTrace();
			}



	}
}
