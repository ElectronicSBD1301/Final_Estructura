package logico;

import java.util.ArrayList;
import java.util.Arrays;

import logico.Main.Grafo;

public class AlgoritmoDijkstra {
    // Método para encontrar el camino más corto usando el algoritmo de Dijkstra
    public ArrayList<Integer> calcularCamino(Grafo grafo, int origen, int destino) {
        int numVertices = grafo.numVer;
        int[] distancias = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];
        int[] padre = new int[numVertices];

        // Inicializar distancias y padre
        Arrays.fill(distancias, Integer.MAX_VALUE); //Valor maximo de un entero en Java
        Arrays.fill(padre, -1); //Se llena de -1 indicando que no se ha encontrado un camino (aún).
        distancias[origen] = 0;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = obtenerVerticeMinimo(distancias, visitado);
            visitado[u] = true;

            for (int v = 0; v < numVertices; v++) {
                int peso = grafo.obtenerPesoArista(u, v);
                if (!visitado[v] && peso != Integer.MAX_VALUE && distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    padre[v] = u;
                }
            }
        }

        // Reconstruir el camino desde destino hasta origen
        ArrayList<Integer> camino = new ArrayList<>();
        int actual = destino;
        while (actual != -1) {
            camino.add(actual);
            actual = padre[actual];
        }
        // Invertir el camino ya que lo hemos construido desde destino hasta origen
        ArrayList<Integer> caminoInvertido = new ArrayList<>();
        for (int i = camino.size() - 1; i >= 0; i--) {
            caminoInvertido.add(camino.get(i));
        }

        return caminoInvertido;
    }

    // Método auxiliar para encontrar el vértice con la distancia mínima
    private int obtenerVerticeMinimo(int[] distancias, boolean[] visitado) {
        int minDistancia = Integer.MAX_VALUE;
        int minVertice = -1;
        for (int v = 0; v < distancias.length; v++) {
            if (!visitado[v] && distancias[v] < minDistancia) {
                minDistancia = distancias[v];
                minVertice = v;
            }
        }
        return minVertice;
    }
}
