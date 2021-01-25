public class Urzytkownik {

    private int IdUrzytkownika;
    private String Wyporzyczajacy;


    //Konstruktor
    public Urzytkownik(int IdUrzytkownika,String Wyporzyczający)
    {
        this.IdUrzytkownika=IdUrzytkownika;
        this.Wyporzyczajacy=Wyporzyczający;
    }



    public static Urzytkownik TworzenieUrzytkownik()
    {
        int IdUrzytkownika;
        String Urzytkownik;
        System.out.println("Podaj ID Urzytkownika:");
        IdUrzytkownika=WpisywanieDanych.WpisanieLiczby();
        System.out.println("Podaj nazwę Urzytkownika:");
        Urzytkownik=WpisywanieDanych.WpisanieSlowa();

        Urzytkownik ObiektUrzytkownik= new Urzytkownik(IdUrzytkownika,Urzytkownik);

        return ObiektUrzytkownik;
    }
    //Getery

    public int GetIdUrzytkownika()
    {
        return IdUrzytkownika;
    }

    public String GetUrzytkownik()
    {
        return Wyporzyczajacy;
    }

    //Settery

    public void SetIdUrzytkownika(int IdUrzytkownika)
    {
        this.IdUrzytkownika= IdUrzytkownika;
    }
    public void SetUrzytkownik(String Wyporzyczajacy)
    {
        this.Wyporzyczajacy= Wyporzyczajacy;
    }

    public static void ShowUrzytkownicy()
    {

    }

    public  String ShowDane()
    {
        String TekstWyswietl;

        return TekstWyswietl = (GetIdUrzytkownika()+ "\t\t\t" + GetUrzytkownik());
    }

}
