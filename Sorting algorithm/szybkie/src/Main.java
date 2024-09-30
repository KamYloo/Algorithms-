import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            File plik = new File("test0.txt");
            Scanner scanner = new Scanner(plik);
            int n = scanner.nextInt();
            int[] katy = new int[n];

            for(int i=0; i<n; i++)
            {
                int stopien = scanner.nextInt();
                int minuta = scanner.nextInt();
                int suma = stopien*60 + minuta;
                katy[i] = suma;
            }
            mergeSort(katy);

            int dlugosc_Podciagu = 0;
            int liczba_zniszczen=0;
            int startIdx=0;
            int roznica=0;
            int roznica2=0;
            int zmiana = 0;

            for (int i=0; startIdx<n;i++)
            {
                dlugosc_Podciagu++;
                if (i == n)
                {
                    i=0;
                    zmiana=1;
                    roznica=0;
                }
                if (zmiana ==1)
                    roznica2 = 21600 - (Math.abs(katy[i] - katy[startIdx]));
                if (zmiana==0)
                    roznica = Math.abs(katy[i] - katy[startIdx]);

                if(roznica>5400 || roznica2>5400)
                {
                    dlugosc_Podciagu--;
                    startIdx++;
                }
                if (dlugosc_Podciagu>liczba_zniszczen)
                {
                    liczba_zniszczen=dlugosc_Podciagu;
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

    public static void mergeSort(int [] tab) {
        if (tab.length > 1)
        {
            int mid = tab.length /2;
            int [] left = new int[mid];
            int [] right = new int[tab.length-mid];
            for (int i = 0; i < mid; i++) {
                left[i] = tab[i];
            }
            for (int i = mid; i < tab.length; i++) {
                right[i - mid] = tab[i];
            }
            mergeSort(left);
            mergeSort(right);
            int i=0,j=0,k=0;

            while (i<left.length && j<right.length)
            {
                if (left[i] < right[j])
                {
                    tab[k] = left[i];
                    i++;
                }
                else {
                    tab[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i<left.length)
            {
                tab[k] = left[i];
                i++;
                k++;
            }
            while (j<right.length)
            {
                tab[k] = right[j];
                j++;
                k++;
            }
        }
    }
}