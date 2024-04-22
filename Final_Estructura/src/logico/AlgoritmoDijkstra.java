package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgoritmoDijkstra {
	private int numVertices;
	private Grafo grafo;
	private int[] distancias;
	private boolean[] visitado;
	private int[] padre;

	/**
	 * Funci�n: AlgoritmoDijkstra
	 * Argumentos:
	 *    Grafo grafo: El grafo sobre el cual se ejecutar� el algoritmo de Dijkstra.
	 * Objetivo: Constructor de la clase AlgoritmoDijkstra.
	 * Retorno: Ninguno.
	 */
	public AlgoritmoDijkstra(Grafo grafo) {
		this.grafo = grafo;
		this.numVertices = grafo.numVer;
		this.distancias = new int[numVertices];
		this.visitado = new boolean[numVertices];
		this.padre = new int[numVertices];
		Arrays.fill(distancias, Integer.MAX_VALUE);
		Arrays.fill(padre, -1);
	}

	/**
	 * Funci�n: calcularCamino
	 * Argumentos:
	 *    int origen: El nodo de inicio del camino.
	 *    int destino: El nodo de destino del camino.
	 * Objetivo: Calcula el camino m�s corto desde el nodo de origen al nodo de destino utilizando el algoritmo de Dijkstra.
	 * Retorno: ArrayList<Integer> que representa el camino m�s corto desde el nodo de origen al nodo de destino. Devuelve una lista vac�a si no se encuentra un camino.
	 */
	public ArrayList<Integer> calcularCamino(int origen, int destino) {
		Arrays.fill(distancias, Integer.MAX_VALUE);
		Arrays.fill(visitado, false);
		Arrays.fill(padre, -1);
		distancias[origen] = 0;

		for (int count = 0; count < numVertices - 1; count++) {
			int u = obtenerVerticeMinimo();
			visitado[u] = true;

			for (int v = 0; v < numVertices; v++) {
				int peso = grafo.obtenerPesoArista(u, v);
				if (!visitado[v] && peso != Integer.MAX_VALUE && distancias[u] + peso < distancias[v]) {
					distancias[v] = distancias[u] + peso;
					padre[v] = u;
				}
			}
		}

		return reconstruirCamino(destino);
	}

	/**
	 * Funci�n: obtenerVerticeMinimo
	 * Argumentos: Ninguno.
	 * Objetivo: Obtiene el v�rtice no visitado con la menor distancia desde el origen.
	 * Retorno: El �ndice del v�rtice con la menor distancia.
	 */
	private int obtenerVerticeMinimo() {
		int minDistancia = Integer.MAX_VALUE;
		int minVertice = -1;
		for (int v = 0; v < numVertices; v++) {
			if (!visitado[v] && distancias[v] < minDistancia) {
				minDistancia = distancias[v];
				minVertice = v;
			}
		}
		return minVertice;
	}

	/**
	 * Funci�n: reconstruirCamino
	 * Argumentos:
	 *    int destino: El nodo de destino del camino.
	 * Objetivo: Reconstruye el camino m�s corto desde el nodo destino al nodo origen.
	 * Retorno: ArrayList<Integer> que representa el camino m�s corto desde el nodo destino al nodo origen.
	 */
	private ArrayList<Integer> reconstruirCamino(int destino) {
		ArrayList<Integer> camino = new ArrayList<>();
		int actual = destino;
		while (actual != -1) {
			camino.add(actual);
			// Verifica si el padre del nodo actual es -1, lo que indica que no hay camino hacia atr�s
			if (padre[actual] == -1) {
				break; // Salir del bucle si no hay camino hacia atr�s
			}
			actual = padre[actual];
		}
		ArrayList<Integer> caminoInvertido = new ArrayList<>();
		for (int i = camino.size() - 1; i >= 0; i--) {
			caminoInvertido.add(camino.get(i));
		}
		return caminoInvertido;
	}
}
