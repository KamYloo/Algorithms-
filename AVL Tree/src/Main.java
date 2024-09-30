import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Drzewo drzewo = new Drzewo();
        Wezel wezel = null;
        int opcja;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Drzewo AVL");
            System.out.println("1 Szukaj element");
            System.out.println("2 Dodaj element");
            System.out.println("3 Usun element");
            System.out.println("4 Znajdz liczbe liczb, których część całkowita jest równa zadanej przez użytkownika liczbie");
            System.out.println("5 Wyswietl drzewo");
            System.out.println("6 Wczytaj polecenia z pliku");
            System.out.println("7 Wyjdz");
            opcja = scanner.nextInt();
            switch (opcja) {
                case 1:
                    System.out.println("Podaj szukana liczbe");
                    double liczba1 = scanner.nextDouble();
                    if(drzewo.szukaj(wezel,liczba1) != null)
                        System.out.println("TAK");
                    else
                        System.out.println("Nie");
                    break;
                case 2:
                    System.out.println("Podaj liczbe do wstawienia");
                    double liczbad = scanner.nextDouble();
                    Wezel B = drzewo.szukaj(wezel,liczbad);
                    if (B == null)
                        wezel = drzewo.wstaw(wezel,liczbad);
                    break;
                case 3:
                    System.out.println("Podaj liczbe do usuniecia");
                    double liczba3 = scanner.nextDouble();
                    Wezel a = drzewo.szukaj(wezel,liczba3);
                    if (a != null)
                        wezel = drzewo.usun(wezel,a);
                    break;
                case 4:
                    System.out.println("Podaj liczbe");
                    int liczba4 = scanner.nextInt();
                    System.out.println(drzewo.licz(wezel, liczba4));
                case 5:
                    drzewo.rysujDrzewo(wezel,0);
                    break;
                case 6:
                    try {
                        File file = new File("duzy1.txt");
                        Scanner scanner2 = new Scanner(file);
                        int n = scanner2.nextInt();
                        String[][] tab = new String[n][2];
                        for (int i = 0; i < n; i++) {
                            tab[i][0] = scanner2.next();
                            tab[i][1] = scanner2.next();
                            if (tab[i][0].equals("W")) {
                                Double liczba = Double.parseDouble(tab[i][1].replace(',', '.'));
                                B = drzewo.szukaj(wezel,liczba);
                                if (B == null)
                                    wezel = drzewo.wstaw(wezel,liczba);
                            } else if (tab[i][0].equals("S")) {
                                Double liczba = Double.parseDouble(tab[i][1].replace(',', '.'));
                                if(drzewo.szukaj(wezel,liczba) != null)
                                    System.out.println("TAK");
                                else
                                    System.out.println("Nie");
                            } else if (tab[i][0].equals("U")) {
                                Double liczba = Double.parseDouble(tab[i][1].replace(',', '.'));
                                a = drzewo.szukaj(wezel,liczba);
                                if (a != null)
                                    wezel = drzewo.usun(wezel,a);
                            } else if (tab[i][0].equals("L")) {
                                int liczba = Integer.parseInt(tab[i][1]);
                                System.out.println(drzewo.licz(wezel, liczba));
                            }

                        }
                        scanner2.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Brak opcji");
            }

        } while (opcja != 7);
    }
}

