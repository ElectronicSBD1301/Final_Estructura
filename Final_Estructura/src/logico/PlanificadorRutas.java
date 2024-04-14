package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class PlanificadorRutas {
    private Grafo grafo;

    public PlanificadorRutas(Grafo grafo) {
        this.grafo = grafo;
    }

    public ArrayList<Integer> planificarRutaOptima(int origen, int destino, String preferencia) {
        if (preferencia.equalsIgnoreCase("distancia")) {
            return calcularRutaMinimaPorDistancia(origen, destino);
        } else if (preferencia.equalsIgnoreCase("tiempo")) {
            return calcularRutaMinimaPorTiempo(origen, destino);
        } else {
            throw new IllegalArgumentException("La preferencia debe ser 'distancia' o 'tiempo'.");
        }
    }

    private ArrayList<Integer> calcularRutaMinimaPorDistancia(int origen, int destino) {
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(grafo);
        return dijkstra.calcularCamino(origen, destino);
    }

    private ArrayList<Integer> calcularRutaMinimaPorTiempo(int origen, int destino) {
        // Crear una instancia del algoritmo A*
        AlgoritmoAStar aStar = new AlgoritmoAStar(grafo);

        // Calcular la ruta mínima por tiempo utilizando A*
        return aStar.calcularCamino(origen, destino);
    }
}
