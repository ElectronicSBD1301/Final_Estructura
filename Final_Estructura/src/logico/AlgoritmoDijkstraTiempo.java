package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgoritmoDijkstraTiempo {
    private Grafo grafo;
    private int numVertices;

    public AlgoritmoDijkstraTiempo(Grafo grafo) {
        this.grafo = grafo;
        this.numVertices = grafo.numVer;
    }

    public ArrayList<Integer> calcularCaminoMinTiempo(int origen, int destino) {
        int[] distancias = new int[numVertices];
        boolean[] visitados = new boolean[numVertices];
        ArrayList<Integer> rutaOptima = new ArrayList<>();

        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(visitados, false);

        distancias[origen] = 0;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minDistancia(distancias, visitados);
            visitados[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visitados[v] && grafo.matrizAdy[u][v] != null &&
                    distancias[u] != Integer.MAX_VALUE &&
                    distancias[u] + grafo.matrizAdy[u][v].getTiempo() < distancias[v]) {
                    distancias[v] = distancias[u] + grafo.matrizAdy[u][v].getTiempo();
                }
            }
        }

        int actual = destino;
        while (actual != origen) {
            rutaOptima.add(0, actual);
            int minTiempoVertice = Integer.MAX_VALUE;
            int minTiempoIndice = -1;

            for (int i = 0; i < numVertices; i++) {
                if (grafo.matrizAdy[actual][i] != null &&
                    distancias[i] + grafo.matrizAdy[actual][i].getTiempo() == distancias[actual] &&
                    grafo.matrizAdy[actual][i].getTiempo() < minTiempoVertice) {
                    minTiempoVertice = grafo.matrizAdy[actual][i].getTiempo();
                    minTiempoIndice = i;
                }
            }

            if (minTiempoIndice == -1) {
                break;
            }

            actual = minTiempoIndice;
        }

        rutaOptima.add(0, origen);
        return rutaOptima;
    }

    private int minDistancia(int[] distancias, boolean[] visitados) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!visitados[v] && distancias[v] <= min) {
                min = distancias[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}