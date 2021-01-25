import javax.xml.crypto.Data;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.time.Month;
import java.time.LocalDate;
import java.text.ParseException;

public class ProjektJavaBiblioteka
{
	public static void main(String[] args)
	{

		int rok = 2005;
	int miesiac = 1;
	int dzien = 30;
	Calendar Kalendarz = new GregorianCalendar(rok,miesiac,dzien); //rok , miesiac , dzien
	int day = Kalendarz.get(Calendar.DAY_OF_MONTH);
		int month = Kalendarz.get(Calendar.MONTH);
		int year = Kalendarz.get(Calendar.YEAR);
		System.out.println(day+"-"+month+"-"+year);
		System.out.println(month);

	}


}

