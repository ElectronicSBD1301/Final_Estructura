package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgoritmoDijkstraTiempo {
    private Grafo grafo;
    private int numVertices;

    /**
     * Funci�n: AlgoritmoDijkstraTiempo
     * Argumentos:
     *    Grafo grafo: El grafo sobre el cual se ejecutar� el algoritmo de Dijkstra por tiempo.
     * Objetivo: Constructor de la clase AlgoritmoDijkstraTiempo.
     * Retorno: Ninguno.
     */
    public AlgoritmoDijkstraTiempo(Grafo grafo) {
        this.grafo = grafo;
        this.numVertices = grafo.numVer;
    }

    /**
     * Funci�n: calcularCaminoMinTiempo
     * Argumentos:
     *    int origen: El nodo de inicio del camino.
     *    int destino: El nodo de destino del camino.
     * Objetivo: Calcula el camino �ptimo desde el nodo de origen al nodo de destino minimizando el tiempo utilizando el algoritmo de Dijkstra.
     * Retorno: ArrayList<Integer> que representa el camino �ptimo desde el nodo de origen al nodo de destino minimizando el tiempo. Devuelve una lista vac�a si no se encuentra un camino.
     */
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

    /**
     * Funci�n: minDistancia
     * Argumentos:
     *    int[] distancias: Arreglo de distancias desde el origen a cada nodo.
     *    boolean[] visitados: Arreglo que indica si un nodo ha sido visitado.
     * Objetivo: Encuentra el �ndice del v�rtice no visitado con la menor distancia desde el origen.
     * Retorno: El �ndice del v�rtice con la menor distancia.
     */
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
