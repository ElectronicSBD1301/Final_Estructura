package logico;

import java.util.Arrays;
import java.util.ArrayList;

public class Grafo {
	int[][] matrizAdy;
	int numVer;

	public Grafo(int numVer) {
		this.numVer = numVer;
		matrizAdy = new int[numVer][numVer];
		for (int i = 0; i < numVer; i++) {
			Arrays.fill(matrizAdy[i], Integer.MAX_VALUE);
		}
	}

	public void agregarArista(int origen, int destino, int peso) {
		if (origen >= numVer || destino >= numVer) {
			int nuevoTam = Math.max(origen, destino) + 1;

			int[][] nuevaMatrizAdy = new int[nuevoTam][nuevoTam];

			for (int i = 0; i < numVer; i++) {
				for (int j = 0; j < numVer; j++) {
					nuevaMatrizAdy[i][j] = matrizAdy[i][j];
				}
			}

			for (int i = 0; i < nuevoTam; i++) {
				if (i != origen && i != destino) {
					nuevaMatrizAdy[origen][i] = Integer.MAX_VALUE;
					nuevaMatrizAdy[i][origen] = Integer.MAX_VALUE;
					nuevaMatrizAdy[destino][i] = Integer.MAX_VALUE;
					nuevaMatrizAdy[i][destino] = Integer.MAX_VALUE;
				}
			}

			matrizAdy = nuevaMatrizAdy;
			numVer = nuevoTam;
		}

		matrizAdy[origen][destino] = peso;
		matrizAdy[destino][origen] = peso;
	}

	public int obtenerPesoArista(int origen, int destino) {
		return matrizAdy[origen][destino];
	}

	// Método para obtener los vecinos de un vértice dado
	public ArrayList<Integer> obtenerVecinos(int nodo) {
		ArrayList<Integer> vecinos = new ArrayList<>();
		for (int i = 0; i < numVer; i++) {
			if (matrizAdy[nodo][i] != Integer.MAX_VALUE) {
				vecinos.add(i);
			}
		}
		return vecinos;
	}

	public void editarPesoArista(int origen, int destino, int nuevoPeso) {
		matrizAdy[origen][destino] = nuevoPeso;
		matrizAdy[destino][origen] = nuevoPeso;
	}

	public void eliminarVertice(int vertice) {
		if (vertice >= 0 && vertice < numVer) {
			int[][] nuevaMatrizAdy = new int[numVer - 1][numVer - 1];

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
			System.out.println("El v�rtice a eliminar no es v�lido.");
		}
	}

	public void imprimirMatrizAdyacencia() {
		System.out.println("Matriz de Adyacencia:");
		for (int i = 0; i < numVer; i++) {
			for (int j = 0; j < numVer; j++) {
				if (matrizAdy[i][j] == Integer.MAX_VALUE) {
					System.out.print("0\t");
				} else {
					System.out.print(matrizAdy[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}
	
	// Método para obtener la distancia entre dos nodos basada en el número de aristas
    public int obtenerDistanciaEuclidiana(int nodo1, int nodo2) {
        // Para simplificar, asumimos que cada arista cuenta como una unidad de distancia
        // y utilizamos el algoritmo de Dijkstra para calcular la distancia entre los nodos
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(this);
        ArrayList<Integer> camino = dijkstra.calcularCamino(nodo1, nodo2);
        if (camino != null) {
            // La distancia es el número de aristas en el camino menos uno
            return camino.size() - 1;
        } else {
            // Si no hay camino entre los nodos, retornamos un valor grande
            return Integer.MAX_VALUE;
        }
    }

}
