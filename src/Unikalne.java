import java.util.Random;

public class Unikalne {

    public static int Id()
    {
        Random generator = new Random();

        return generator.nextInt(2147483644)+1;

    }
}
