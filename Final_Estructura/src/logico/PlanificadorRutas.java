package logico;

import java.util.ArrayList;

public class PlanificadorRutas {
    private Grafo grafo;

    /**
     * Funci�n: PlanificadorRutas
     * Argumentos: Grafo grafo
     * Objetivo: Constructor de la clase PlanificadorRutas que recibe un grafo para planificar rutas.
     * Retorno: Ninguno (void).
     */
    public PlanificadorRutas(Grafo grafo) {
        this.grafo = grafo;
    }
    
    /**
     * Funci�n: planificarRutaOptima
     * Argumentos: int origen, int destino, String preferencia
     * Objetivo: Planifica la ruta �ptima entre dos nodos seg�n la preferencia del usuario (distancia o tiempo).
     * Retorno: ArrayList<Integer> que representa la ruta �ptima de nodos.
     * @throws IllegalArgumentException si la preferencia no es 'distancia' o 'tiempo'.
     */
    public ArrayList<Integer> planificarRutaOptima(int origen, int destino, String preferencia) {
        if (preferencia.equalsIgnoreCase("distancia")) {
            return calcularRutaMinimaPorDistancia(origen, destino);
        } else if (preferencia.equalsIgnoreCase("tiempo")) {
            return planificarRutaOptimaTiempo(origen, destino);
        } else {
            throw new IllegalArgumentException("La preferencia debe ser 'distancia' o 'tiempo'.");
        }
    }

    /**
     * Funci�n: calcularRutaMinimaPorDistancia
     * Argumentos: int origen, int destino
     * Objetivo: Calcula la ruta m�nima entre dos nodos basada en la distancia utilizando el algoritmo A*.
     * Retorno: ArrayList<Integer> que representa la ruta m�nima de nodos.
     */
    private ArrayList<Integer> calcularRutaMinimaPorDistancia(int origen, int destino) {
    	AlgoritmoAStar aStar = new AlgoritmoAStar(grafo);
        return aStar.calcularCamino(origen, destino);
    }

    /**
     * Funci�n: planificarRutaOptimaTiempo
     * Argumentos: int origen, int destino
     * Objetivo: Planifica la ruta �ptima entre dos nodos basada en el tiempo utilizando el algoritmo de Dijkstra.
     * Retorno: ArrayList<Integer> que representa la ruta �ptima de nodos.
     */
	private ArrayList<Integer> planificarRutaOptimaTiempo(int origen, int destino) {
		AlgoritmoDijkstraTiempo dijkstra = new AlgoritmoDijkstraTiempo(grafo);
	    return dijkstra.calcularCaminoMinTiempo(origen, destino);
	}
}
