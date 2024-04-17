package logico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlgoritmoKruskal {
    private Grafo grafo;
    private int numVertices;

    public AlgoritmoKruskal(Grafo grafo) {
        this.grafo = grafo;
        this.numVertices = grafo.numVer;
    }

    public ArrayList<AristaAlgoritmos> generarArbolExpansionMinima() {
        ArrayList<AristaAlgoritmos> arbolExpansion = new ArrayList<>();
        ArrayList<AristaAlgoritmos> aristas = obtenerAristas();

        // Ordenar las aristas por peso
        Collections.sort(aristas, Comparator.comparingInt(AristaAlgoritmos::getPeso));

        DisjointSet disjointSet = new DisjointSet(numVertices);

        for (AristaAlgoritmos arista : aristas) {
            int origen = arista.getOrigen();
            int destino = arista.getDestino();

            int setOrigen = disjointSet.find(origen);
            int setDestino = disjointSet.find(destino);

            if (setOrigen != setDestino) {
                arbolExpansion.add(arista);
                disjointSet.union(setOrigen, setDestino);
            }
        }

        return arbolExpansion;
    }

    private ArrayList<AristaAlgoritmos> obtenerAristas() {
        ArrayList<AristaAlgoritmos> aristas = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                int peso = grafo.obtenerPesoArista(i, j);
                if (peso != Integer.MAX_VALUE) {
                    aristas.add(new AristaAlgoritmos(i, j, peso));
                }
            }
        }

        return aristas;
    }
}
