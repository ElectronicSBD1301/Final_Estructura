package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class PlanificadorRutas {
    private Grafo grafo;

    public PlanificadorRutas(Grafo grafo) {
        this.grafo = grafo;
    }
    
    // Luego de establecer el origen y destino, pedimos el metodo que prefiere el usuario
    public ArrayList<Integer> planificarRutaOptima(int origen, int destino, String preferencia) {
        if (preferencia.equalsIgnoreCase("distancia")) {
            return calcularRutaMinimaPorDistancia(origen, destino);
        } else if (preferencia.equalsIgnoreCase("tiempo")) {
            return planificarRutaOptimaTiempo(origen, destino);
        } else {
            throw new IllegalArgumentException("La preferencia debe ser 'distancia' o 'tiempo'.");
        }
    }

    //Para distancia utilizamos el algoritmo de A*, mas eficiente que Djisktra
    private ArrayList<Integer> calcularRutaMinimaPorDistancia(int origen, int destino) {
    	AlgoritmoAStar aStar = new AlgoritmoAStar(grafo);
        return aStar.calcularCamino(origen, destino);
    }

	private ArrayList<Integer> planificarRutaOptimaTiempo(int origen, int destino) {
		AlgoritmoDijkstraTiempo dijkstra = new AlgoritmoDijkstraTiempo(grafo);
	    return dijkstra.calcularCaminoMinTiempo(origen, destino);
	}
}
