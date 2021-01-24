import java.util.InputMismatchException;

public class PobieranieSymboli
{
	public static char GetPierwszySymbol(String Slowo)
	{
		boolean OK; // Wszystkie dane inicjowane sa jako puste
		char Pierwszy_Char = 0;
		do
		{
			try
			{
				OK = true;
				Pierwszy_Char = Slowo.charAt(0); //Uzywa istniejacego juz Slowa do pobrnaia pierwszego Symbolu
			} catch(InputMismatchException ex) // Sprawdzenie
			{
				System.out.println("Cos poszlo nie tak.");
				OK = false;
			}
		} while(!OK);
		return Pierwszy_Char; //Zwracanie pierwszego chara
	}
}
