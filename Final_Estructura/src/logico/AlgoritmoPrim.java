package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgoritmoPrim {
    private Grafo grafo;
    private int numVertices;

    public AlgoritmoPrim(Grafo grafo) {
        this.grafo = grafo;
        this.numVertices = grafo.numVer;
    }

    public ArrayList<Arista> generarArbolExpansionMinima() {
        boolean[] visitado = new boolean[numVertices];
        ArrayList<Arista> arbolExpansion = new ArrayList<>();
        visitado[0] = true; // Empezamos desde el primer nodo

        while (arbolExpansion.size() < numVertices - 1) {
            Arista aristaMinima = null;
            int pesoMinimo = Integer.MAX_VALUE;

            for (int i = 0; i < numVertices; i++) {
                if (visitado[i]) {
                    for (int j = 0; j < numVertices; j++) {
                        int peso = grafo.obtenerPesoArista(i, j);
                        if (!visitado[j] && peso < pesoMinimo && peso != 0) {
                            pesoMinimo = peso;
                            aristaMinima = new Arista(i, j, peso);
                        }
                    }
                }
            }

            if (aristaMinima != null) {
                arbolExpansion.add(aristaMinima);
                visitado[aristaMinima.getDestino()] = true;
            }
        }

        return arbolExpansion;
    }
}