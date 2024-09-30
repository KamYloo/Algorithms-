import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            File plik = new File("test3.txt");
            Scanner scanner = new Scanner(plik);
            int n = scanner.nextInt();
            Kat[] katy = new Kat[n];
            for(int i=0; i<n; i++)
            {
                int stopien = scanner.nextInt();
                int minuta = scanner.nextInt();
                katy[i] = new Kat(stopien,minuta);
            }
            int liczba_zniszczen = 0;
            for (int stopien = 0; stopien < 360; stopien++) {
                for (int minuta = 0; minuta < 60; minuta++) {
                    int licznik = 0;
                    for (int i = 0; i < katy.length; i++) {
                        double suma_sprawdzanego_kata = katy[i].stopien + katy[i].minuta / 60.0;
                        double suma_obecnego_kata = stopien + minuta / 60.0;
                        double roznica = Math.abs(suma_sprawdzanego_kata - suma_obecnego_kata);
                        if (roznica <= 45 || (360-roznica) <=45) {  // pozycja ktora szukamy musi byc <= polowie szerokosci katowej
                            licznik++;                              // baza znajduje sie wtedy jakby wewnatrz przedizalu 90 stopni wokol pozycji obserwacji
                        }
                    }
                    if (licznik > liczba_zniszczen) {
                        liczba_zniszczen = licznik;

                    }
                }
            }
            System.out.println("Liczba zniszczonych baz "+liczba_zniszczen);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long czasWykonania = endTime - startTime;
        System.out.println("Czas wykonania "+czasWykonania+" ms");
    }
}