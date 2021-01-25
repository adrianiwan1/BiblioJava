public class BlackList {
    String Zbanowany;

    public BlackList(String Zablokowany)
    {
        this.Zbanowany=Zablokowany;
    }

    public static BlackList TworzenieZbanowany()
    {
        String Zbanowany;
        System.out.println("Podaj nazwę osoby, która ma byc zablokowana:");
        Zbanowany=WpisywanieDanych.WpisanieSlowa();

        BlackList ObiektZbanowany = new BlackList(Zbanowany);

        return ObiektZbanowany;
    }

    //Getery

    public String GetZbanowany()
    {
        return Zbanowany;
    }

    public void SetZbanowany(String Zbanowany)
    {
        this.Zbanowany=Zbanowany;
    }
}
