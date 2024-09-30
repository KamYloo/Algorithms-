import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {

            File plik = new File("duzy1.txt");
            Scanner scanner = new Scanner(plik);
            int n = scanner.nextInt();
            int[][] rezerwacje = new int[n][3];
            for (int i = 0; i < n; i++) {
                rezerwacje[i][0] = scanner.nextInt();
                rezerwacje[i][1] = scanner.nextInt();
                rezerwacje[i][2] = scanner.nextInt();
            }
            mergeSort(rezerwacje);

            int[][] check = new int[rezerwacje[n-1][1]+1][rezerwacje[n-1][1]+1];
            int maxZarobek = 0;
            for (int i=0; i<n; i++) {
                int zarobek = Rekurencjaa(rezerwacje, i+1, rezerwacje[i][1], rezerwacje[i][1], check);
                maxZarobek = Math.max(maxZarobek,zarobek);
            }
            System.out.println(maxZarobek);

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long czasWykonania = endTime-startTime;
        System.out.println("Czas dzialania "+czasWykonania+"ms");
    }
    private static int Rekurencjaa(int[][] rezerwacje, int n, int ap1, int ap2, int[][] check) {

        if (check[ap1][ap2] != 0) {
            return check[ap1][ap2];
        }
        int maxWartosc = 0;
        for (int i=0; i<n; i++)
        {
            if (rezerwacje[i][1] <= ap1 && rezerwacje[i][1] <= ap2)
            {
                int maxx = rezerwacje[i][2] + Rekurencjaa(rezerwacje,n,rezerwacje[i][0],rezerwacje[i][1]-1,check);
                maxWartosc = Math.max(maxWartosc,maxx);
            }
            if (rezerwacje[i][1] <= ap1 && rezerwacje[i][1] > ap2)
            {
                int maxap1 = rezerwacje[i][2] + Rekurencjaa(rezerwacje,n,rezerwacje[i][0], ap2,check);
                maxWartosc = Math.max(maxWartosc,maxap1);
            }
             if (rezerwacje[i][1] <= ap2 && rezerwacje[i][1] > ap1)
            {
                int maxap2 = rezerwacje[i][2] + Rekurencjaa(rezerwacje,n,ap1,rezerwacje[i][0],check);
                maxWartosc = Math.max(maxWartosc,maxap2);
            }
            if (rezerwacje[i][1] > ap1 && rezerwacje[i][1] > ap2)
                break;
        }
        check[ap1][ap2] = maxWartosc;
        return maxWartosc;
    }
    public static void mergeSort(int[][] tab) {
        if (tab.length > 1) {
            int mid = tab.length / 2;
            int[][] left = new int[mid][3];
            int[][] right = new int[tab.length - mid][3];
            for (int i = 0; i < mid; i++) {
                left[i] = tab[i];
            }
            for (int i = mid; i < tab.length; i++) {
                right[i - mid] = tab[i];
            }
            mergeSort(left);
            mergeSort(right);
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i][1] < right[j][1]) {
                    tab[k] = left[i];
                    i++;
                } else {
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