import java.io.*;

public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        try {
            BufferedReader br = new BufferedReader(new FileReader("duzy1.txt"));
            String[] dimensions = br.readLine().split(" ");
            int n = Integer.parseInt(dimensions[0]);
            int m = Integer.parseInt(dimensions[1]);
            char[][] mapa = new char[n][m];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    mapa[i][j] = line.charAt(j);
                }
            }
            br.close();

            int licznik = 0;
            int mid = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mapa[i][j] == 'o') {
                        licznik++;
                        if (licznik == m)
                            mid = i;
                    }
                }
                licznik = 0;
            }

            int max_rozmiar_wyspy = 0;
            int max_dlugosc_rzeki = 0;

            boolean[][] visited = new boolean[n][m];

            for (int i = 1; i < mid; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (!visited[i][j]) {
                        if (mapa[i][j] == 'x') {
                            int rozmiar_wyspy = szukaj_wyspy(mapa, visited, i, j, mid, m);
                            max_rozmiar_wyspy = Math.max(max_rozmiar_wyspy, rozmiar_wyspy);
                        }
                    }
                }
            }


                for (int j = 0; j < m; j++) {
                    if (!visited[mid+1][j]) {
                        if (mapa[mid+1][j] == 'u') {
                            int najdluzsza_rzeka = szukaj_rzeki(mapa, visited, mid+1, j, mid,n, m);
                            max_dlugosc_rzeki = Math.max(max_dlugosc_rzeki, najdluzsza_rzeka);
                        }
                    }

            }
            System.out.println(max_rozmiar_wyspy + " " + max_dlugosc_rzeki);

        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long czasWykonania = endTime-startTime;
        System.out.println("Czas dzialania "+czasWykonania+"ms");
    }

    public static int szukaj_wyspy(char[][] mapa, boolean[][] visited, int i, int j, int mid, int m) {
        if (i <= 0 || i >= mid || j <= 0 || j >= m || visited[i][j] == true || mapa[i][j] != 'x') {
            return 0;
        }
        visited[i][j] = true;
        int licznik = 1;

        licznik += szukaj_wyspy(mapa, visited, i + 1, j, mid, m);
        licznik += szukaj_wyspy(mapa, visited, i + 1, j + 1, mid, m);
        licznik += szukaj_wyspy(mapa, visited, i + 1, j - 1, mid, m);
        licznik += szukaj_wyspy(mapa, visited, i - 1, j, mid, m);
        licznik += szukaj_wyspy(mapa, visited, i - 1, j + 1, mid, m);
        licznik += szukaj_wyspy(mapa, visited, i - 1, j - 1, mid, m);
        licznik += szukaj_wyspy(mapa, visited, i, j + 1, mid, m);
        licznik += szukaj_wyspy(mapa, visited, i, j - 1, mid, m);
        return licznik;
    }

    public static int szukaj_rzeki(char[][] mapa, boolean[][] visited, int i, int j, int mid, int n, int m) {
        if (i < mid + 1 || i >= n || j < 0 || j >= m || visited[i][j] == true || mapa[i][j] != 'u') {
            return 0;
        }
        visited[i][j] = true;
        int wGore=1, wDol=1, wLewo=1, wPrawo=1;

        wDol += szukaj_rzeki(mapa,visited, i+1,j,mid,n,m);
        wGore += szukaj_rzeki(mapa, visited, i-1,j,mid,n,m);
        wPrawo += szukaj_rzeki(mapa, visited, i,j+1,mid,n,m);
        wLewo += szukaj_rzeki(mapa, visited, i,j-1,mid,n,m);

        return Math.max(Math.max(wLewo,wPrawo),Math.max(wDol,wGore));
    }

}