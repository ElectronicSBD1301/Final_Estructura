package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
	Arista[][] matrizAdy;
	int numVer;

	public Grafo(int numVer) {
		this.numVer = numVer;
		matrizAdy = new Arista[numVer][numVer];
		for (int i = 0; i < numVer; i++) {
			Arrays.fill(matrizAdy[i], null);
		}
	}

	public void agregarArista(int origen, int destino, int peso, int tiempo) {
		if (origen >= numVer || destino >= numVer) {
			int nuevoTam = Math.max(origen, destino) + 1;
			Arista[][] nuevaMatrizAdy = new Arista[nuevoTam][nuevoTam];

			for (int i = 0; i < numVer; i++) {
				for (int j = 0; j < numVer; j++) {
					nuevaMatrizAdy[i][j] = matrizAdy[i][j];
				}
			}

			matrizAdy = nuevaMatrizAdy;
			numVer = nuevoTam;
		}

		matrizAdy[origen][destino] = new Arista(peso, tiempo);
		matrizAdy[destino][origen] = new Arista(peso, tiempo);
	}

	public int obtenerPesoArista(int origen, int destino) {
		if (matrizAdy[origen][destino] != null) {
			return matrizAdy[origen][destino].getPeso();
		} else {
			// Esto indica que no hay arista
			return Integer.MAX_VALUE;
		}
	}

	// Metodo para obtener los vecinos de un vertice dado
	public ArrayList<Integer> obtenerVecinos(int nodo) {
		ArrayList<Integer> vecinos = new ArrayList<>();
		for (int i = 0; i < numVer; i++) {
			if (matrizAdy[nodo][i] != null) {
				vecinos.add(i);
			}
		}
		return vecinos;
	}

	public void editarPesoArista(int origen, int destino, int nuevoPeso, int nuevoTiempo) {
		if (matrizAdy[origen][destino] != null) {
			matrizAdy[origen][destino].setPeso(nuevoPeso);
			matrizAdy[origen][destino].setTiempo(nuevoTiempo);
			matrizAdy[destino][origen].setPeso(nuevoPeso);
			matrizAdy[destino][origen].setTiempo(nuevoTiempo);
		} else {
			// Esto indica que no existe la arista
			System.out.println("No existe la arista especificada.");
		}
	}

	public void eliminarVertice(int vertice) {
		if (vertice >= 0 && vertice < numVer) {
			Arista[][] nuevaMatrizAdy = new Arista[numVer - 1][numVer - 1];

			for (int i = 0; i < numVer; i++) {
				if (i == vertice)
					continue;
				for (int j = 0; j < numVer; j++) {
					if (j == vertice)
						continue;
					nuevaMatrizAdy[i < vertice ? i : i - 1][j < vertice ? j : j - 1] = matrizAdy[i][j];
				}
			}

			numVer--;
			matrizAdy = nuevaMatrizAdy;
		} else {
			System.out.println("El vÈrtice a eliminar no es v·lido.");
		}
	}

	public void imprimirMatrizAdyacencia() {
		System.out.println("Matriz de Adyacencia:");
		System.out.print("    ");
		for (int i = 0; i < numVer; i++) {
			System.out.printf("%-4d", i); 
		}
		System.out.println();

		for (int i = 0; i < numVer; i++) {
			System.out.printf("%-4d", i); 
			for (int j = 0; j < numVer; j++) {
				if (matrizAdy[i][j] != null) {
					System.out.printf("%-4d", matrizAdy[i][j].getPeso()); 
																			
				} else {
					System.out.print("0   ");
				}
			}
			System.out.println();
		}
	}

	// M√©todo para obtener la distancia entre dos nodos basada en el n√∫mero de
	// aristas
	public int obtenerDistanciaEuclidiana(int nodo1, int nodo2) {
		// Para simplificar, asumimos que cada arista cuenta como una unidad de
		// distancia
		// y utilizamos el algoritmo de Dijkstra para calcular la distancia entre los
		// nodos
		AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(this);
		ArrayList<Integer> camino = dijkstra.calcularCamino(nodo1, nodo2);
		if (camino != null) {
			// La distancia es el n√∫mero de aristas en el camino menos uno
			return camino.size() - 1;
		} else {
			// Si no hay camino entre los nodos, retornamos un valor grande
			return Integer.MAX_VALUE;
		}
	}

}
