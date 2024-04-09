package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgoritmoDijkstra {
	private int numVertices;
	private Grafo grafo;
	private int[] distancias;
	private boolean[] visitado;
	private int[] padre;

	public AlgoritmoDijkstra(Grafo grafo) {
		this.grafo = grafo;
		this.numVertices = grafo.numVer;
		this.distancias = new int[numVertices];
		this.visitado = new boolean[numVertices];
		this.padre = new int[numVertices];
		Arrays.fill(distancias, Integer.MAX_VALUE);
		Arrays.fill(padre, -1);
	}

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

	private ArrayList<Integer> reconstruirCamino(int destino) {
		ArrayList<Integer> camino = new ArrayList<>();
		int actual = destino;
		while (actual != -1) {
			camino.add(actual);
			// Verifica si el padre del nodo actual es -1, lo que indica que no hay camino
			// hacia atrás
			if (padre[actual] == -1) {
				break; // Salir del bucle si no hay camino hacia atrás
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
