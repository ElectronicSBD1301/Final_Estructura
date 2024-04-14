package logico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AlgoritmoAStar {
    private Grafo grafo;

    public AlgoritmoAStar(Grafo grafo) {
        this.grafo = grafo;
    }

    public ArrayList<Integer> calcularCamino(int origen, int destino) {
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        HashSet<Integer> visitados = new HashSet<>();
        int[] costoDesdeOrigen = new int[grafo.numVer];
        int[] padres = new int[grafo.numVer];

        // Inicializar los arreglos de costos y padres
        for (int i = 0; i < grafo.numVer; i++) {
            costoDesdeOrigen[i] = Integer.MAX_VALUE;
            padres[i] = -1;
        }

        // Agregar el nodo de origen a la cola de prioridad
        colaPrioridad.add(new Nodo(origen, 0, 0));
        costoDesdeOrigen[origen] = 0;

        // Ejecutar el algoritmo A*
        while (!colaPrioridad.isEmpty()) {
            Nodo actual = colaPrioridad.poll();

            if (actual.indice == destino) {
                return reconstruirCamino(destino, padres);
            }

            // Marcar el nodo actual como visitado
            visitados.add(actual.indice);

            // Explorar los vecinos del nodo actual
            for (int vecino : grafo.obtenerVecinos(actual.indice)) {
                // Calcular el costo tentativo
                int costoTentativo = actual.g + grafo.obtenerPesoArista(actual.indice, vecino);

                // Verificar si el vecino ya fue visitado o el costo tentativo es mayor que el costo conocido
                if (visitados.contains(vecino) || costoTentativo >= costoDesdeOrigen[vecino]) {
                    continue;
                }

                // Actualizar el costo y el padre del vecino
                costoDesdeOrigen[vecino] = costoTentativo;
                padres[vecino] = actual.indice;
                colaPrioridad.add(new Nodo(vecino, costoTentativo, costoTentativo));
            }
        }
        return null;//Solo si no encuentra un camino
    }

    // Método para reconstruir el camino óptimo desde el nodo destino al origen
    private ArrayList<Integer> reconstruirCamino(int destino, int[] padres) {
        ArrayList<Integer> camino = new ArrayList<>();
        camino.add(destino);
        int actual = destino;
        while (padres[actual] != -1) {
            camino.add(padres[actual]);
            actual = padres[actual];
        }
        return camino;
    }

    private static class Nodo {
        int indice;
        int g; // Costo real desde el origen al nodo
        int f; // Función de evaluación

        public Nodo(int indice, int g, int f) {
            this.indice = indice;
            this.g = g;
            this.f = f;
        }
    }
}
