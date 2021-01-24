public class Urzytkownik {

    private String Wyporzyczajacy;


    public Urzytkownik(String Wyporzyczający)
    {
        this.Wyporzyczajacy=Wyporzyczający;
    }

    public static Urzytkownik TworzenieUrzytkownik()
    {
        String Urzytkownik;
        System.out.println("Podaj nazwę Urzytkownika:");
        Urzytkownik=WpisywanieDanych.WpisanieSlowa();

        Urzytkownik ObiektUrzytkownik= new Urzytkownik(Urzytkownik);

        return ObiektUrzytkownik;
    }
    //Getery

    public String GetUrzytkownik()
    {
        return Wyporzyczajacy;
    }

    //Settery

    public void SetUrzytkownik(String Wyporzyczajacy)
    {
        this.Wyporzyczajacy= Wyporzyczajacy;
    }
}
