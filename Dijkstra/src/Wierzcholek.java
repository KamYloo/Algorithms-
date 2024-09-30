import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wierzcholek {
    int id, weight,k;
    List<Wierzcholek> sasiedzi;
    Wierzcholek(int id, int weight,int k) {
        this.id = id;
        this.weight = weight;
        this.k = k;
        this.sasiedzi = new ArrayList<>();
    }
    void dodajSasiada(Wierzcholek sasiad, int weight, int k) {
        sasiedzi.add(new Wierzcholek(sasiad.id, weight, k));
        sasiad.sasiedzi.add(new Wierzcholek(id, weight, k));
    }
    void usunSasiada(int idSasiada) {
        sasiedzi.removeIf(sasiad -> sasiad.id == idSasiada);
    }
    public List<Wierzcholek> getSasiedzi()
    {
        return sasiedzi;
    }

}
