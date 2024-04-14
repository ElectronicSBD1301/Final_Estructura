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
        // Estructuras de datos para el algoritmo
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

        // Inicializar el costo desde el origen al nodo origen como 0
        costoDesdeOrigen[origen] = 0;

        // Ejecutar el algoritmo A*
        while (!colaPrioridad.isEmpty()) {
            Nodo actual = colaPrioridad.poll();

            // Verificar si el nodo actual es el destino
            if (actual.indice == destino) {
                // Reconstruir el camino óptimo
                return reconstruirCamino(destino, padres);
            }

            // Marcar el nodo actual como visitado
            visitados.add(actual.indice);

            // Explorar los vecinos del nodo actual
            for (int vecino : grafo.obtenerVecinos(actual.indice)) {
                // Calcular el costo tentativo desde el origen al vecino
                int costoTentativo = actual.g + grafo.obtenerPesoArista(actual.indice, vecino);

                // Verificar si el vecino ya fue visitado o el costo tentativo es mayor que el costo conocido
                if (visitados.contains(vecino) || costoTentativo >= costoDesdeOrigen[vecino]) {
                    continue;
                }

                // Actualizar el costo y el padre del vecino
                costoDesdeOrigen[vecino] = costoTentativo;
                padres[vecino] = actual.indice;

                // Calcular la función de evaluación (f) del vecino
                int f = costoTentativo + calcularHeuristica(vecino, destino);

                // Agregar el vecino a la cola de prioridad
                colaPrioridad.add(new Nodo(vecino, costoTentativo, f));
            }
        }

        // No se encontró camino
        return null;
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

    // Método para calcular la heurística (distancia estimada al destino)
    private int calcularHeuristica(int nodo, int destino) {
        // Implementa aquí una heurística adecuada
        // En este ejemplo, simplemente retornamos 0
        return 0;
    }

    // Clase Nodo para almacenar información del nodo en la cola de prioridad
    private static class Nodo {
        int indice; // Índice del nodo
        int g; // Costo real desde el origen al nodo
        int f; // Función de evaluación (f = g + h)

        public Nodo(int indice, int g, int f) {
            this.indice = indice;
            this.g = g;
            this.f = f;
        }
    }
}
