import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void dijkstra(Graf graf, int[] d, int[] p){
        Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(p, -1);
        PriorityQueue<Wierzcholek> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> d[v.id]));

        d[1] = 0;
        priorityQueue.add(graf.wierzcholki[1]);
        while (!priorityQueue.isEmpty()) {
            Wierzcholek obecny = priorityQueue.poll();
            int obecny_id = obecny.id;

            for (Wierzcholek sasiedzi : graf.getSasiedzi(obecny_id)) {
                int newDistance = d[obecny_id] + sasiedzi.weight;

                if (obecny.k >= 1) {
                    if (sasiedzi.weight == 0) {
                        obecny.k--;
                    }
                    if (newDistance < d[sasiedzi.id]) {
                        d[sasiedzi.id] = newDistance;
                        p[sasiedzi.id] = obecny_id;

                        priorityQueue.add(new Wierzcholek(sasiedzi.id, sasiedzi.weight, obecny.k));
                        graf.usun(sasiedzi.id,obecny_id);
                    }
                    
                } else if (obecny.k == 0 && sasiedzi.weight > 0) {
                    if (newDistance < d[sasiedzi.id]) {
                        d[sasiedzi.id] = newDistance;
                        p[sasiedzi.id] = obecny_id;
                        priorityQueue.add(new Wierzcholek(sasiedzi.id, sasiedzi.weight, 0));
                        graf.usun(sasiedzi.id,obecny_id);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("duzy1_in.txt"))) {
            String[] params = reader.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int k = Integer.parseInt(params[2]);

            Graf graf = new Graf(n,k);
            for (int i = 0; i < m; i++) {
                String line = reader.readLine();
                String[] corridorInfo = line.split(" ");
                int city1 = Integer.parseInt(corridorInfo[0]);
                int city2 = Integer.parseInt(corridorInfo[1]);
                int weight = Integer.parseInt(corridorInfo[2]);
                graf.dodajKrawedz(city1, city2, weight,k);
            }
            int[] d = new int[n + 1];
            int[] p = new int[n + 1];

            dijkstra(graf, d, p);
            int czas = d[n];
            System.out.println(czas);
            List<Integer> sciezka = new ArrayList<>();
            int z = n;
            while (z != -1) {
                sciezka.add(z);
                z = p[z];
            }
            for (int i = sciezka.size() - 1; i >= 0; i--) {
                System.out.print(sciezka.get(i) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
