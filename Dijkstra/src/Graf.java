import java.util.*;

public class Graf {
    Wierzcholek[] wierzcholki;

    Graf(int liczbaWierzcholkow,int k) {
        wierzcholki = new Wierzcholek[liczbaWierzcholkow + 1];
        for (int i = 1; i <= liczbaWierzcholkow; i++) {
            wierzcholki[i] = new Wierzcholek(i,0,k);
        }
    }

    void dodajKrawedz(int idWierzcholka1, int idWierzcholka2, int weight, int k) {
        Wierzcholek wierzcholek1 = wierzcholki[idWierzcholka1];
        Wierzcholek wierzcholek2 = wierzcholki[idWierzcholka2];

        if (wierzcholek1 != null && wierzcholek2 != null) {
            wierzcholek1.dodajSasiada(wierzcholek2, weight, k);
        }
    }
    List<Wierzcholek> getSasiedzi(int id) {
        Wierzcholek wierzcholek = wierzcholki[id];
        if (wierzcholek != null) {
            return wierzcholek.getSasiedzi();
        } else {
            return new ArrayList<>();
        }
    }

    void usun(int id,int id2)
    {
        Wierzcholek wierzcholek = wierzcholki[id];
        wierzcholek.usunSasiada(id2);
    }
}

