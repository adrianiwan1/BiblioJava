import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperacjePlikKsiazki{



    public static void ZapisywanieKsiazek(Ksiazka NowaKsiazka,String NazwaPliku) throws IOException {
        RandomAccessFile baza =new RandomAccessFile(NazwaPliku,"rw");

        baza.seek(baza.length());

        baza.writeInt(NowaKsiazka.GetIdKsiazki()); // 32
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetNazwaKsiazki()));
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetAutor()));
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetGatunek()));
        baza.writeUTF(String.format("%1$-11s",NowaKsiazka.GetDataWydania()));
        baza.writeUTF(String.format("%1$-32s",NowaKsiazka.GetWyporzyczajacy()));


       //baza.writeInt(NowaKsiazka.GetDniWyporzyczenia());
        //baza.writeInt(NowaKsiazka.GetMiesiaceWyporzyczenia());
        //baza.writeInt(NowaKsiazka.GetRokWyporzyczenia());
        baza.writeUTF(String.format("%1$-11s",NowaKsiazka.GetDataWyporzyczenia()));
        baza.writeUTF(String.format("%1$-4s",NowaKsiazka.GetCzyWyporzyczona())); //1

        //baza.writeInt(NowaKsiazka.GetDniTermin());
        //baza.writeInt(NowaKsiazka.GetMiesiaceTermin());
        //baza.writeInt(NowaKsiazka.GetRokTermin());
        baza.writeUTF(String.format("%1$-11s",NowaKsiazka.GetDataTermin()));
        baza.writeUTF(String.format("%1$-4s",NowaKsiazka.GetCzyPoTerminie()));
        baza.writeInt(NowaKsiazka.GetIdUzytkownika());



        System.out.println("Zapis udany");

        baza.close();
    }

    public static Ksiazka OdczytywanieKsiazek(RandomAccessFile baza) throws IOException
    {


        Ksiazka OdczytywanaKsiazka=null;
        try {
            OdczytywanaKsiazka = new Ksiazka(baza.readInt(),baza.readUTF(),baza.readUTF(), baza.readUTF(), baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readUTF(), baza.readUTF(),baza.readInt());
            //baza.seek(364);
        } catch (EOFException ex)
        {



        }


        return OdczytywanaKsiazka;

    }


    public static RandomAccessFile OtwarciePlikKsiazki() throws FileNotFoundException {

        RandomAccessFile baza =new RandomAccessFile("Books.bin","rw");
        return baza;
    }

    public static void UsuwanieKsiazki()
    {
        int i = 0;
        int Szukana = 0;
        try
        {
            RandomAccessFile PlikOdczytany = OperacjePlikKsiazki.OtwarciePlikKsiazki(); //Otwarcie pliku
            System.out.println("Wpisz liczbe id ksiazki ktora chcesz usunac");  // Prosba o wpisanie
            Szukana = WpisywanieDanych.WpisanieLiczby(); //  Wpisanie poszukiwanego int

            if(SprawdzanieKsiazka.CzyPodaneIdIstnieje(Szukana)==true) {
                do {
                    Ksiazka OdczytaneDane = OperacjePlikKsiazki.OdczytywanieKsiazek(PlikOdczytany); // Odczytranie linjki tekstu
                    if (OdczytaneDane != null) // Jesli nie jest puste wykonaj
                    {
                        int Odczyt = OdczytaneDane.GetIdKsiazki(); //Wpisanie danej do int
                        if (Szukana != Odczyt) // Porownanie odczytu.
                        {
                            ZapisywanieKsiazek(OdczytaneDane,"TempBooks.bin");
                        }
                    } else {
                        i = 9002; // Zakonczenie petli jesli null
                    }
                    i++;
                } while (i < 9000); // Maksymalna wartosc petli
                PlikOdczytany.close(); // Zamkniecie odczytu
                new File("Books.bin").delete();

                Path Zrodlo = Paths.get("TempBooks.bin");

                try{

                    Files.move(Zrodlo, Zrodlo.resolveSibling("Books.bin"));

                } catch (IOException e) {

                }

            }
            else{
                System.out.println("Książka nie istnieje");
            }

        } catch(IOException e) //Obsluga bledu ktory nie powinien sie wydarzyc
        {
            e.printStackTrace();
        }
        }
    }




