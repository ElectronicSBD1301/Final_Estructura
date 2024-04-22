package logico;

public class AlgoritmoFloydWarshall {
	private int numVertices;
	private int[][] distancias;
	private int[][] predecesores; // Matriz de predecesores para reconstruir la ruta �ptima

	/**
	 * Funci�n: AlgoritmoFloydWarshall
	 * Argumentos:
	 *    int numVertices: El n�mero de v�rtices en el grafo.
	 * Objetivo: Constructor de la clase AlgoritmoFloydWarshall.
	 * Retorno: Ninguno.
	 */
	public AlgoritmoFloydWarshall(int numVertices) {
		this.numVertices = numVertices;
		this.distancias = new int[numVertices][numVertices];
		this.predecesores = new int[numVertices][numVertices];
	}

	/**
	 * Funci�n: inicializarDistancias
	 * Argumentos:
	 *    Grafo grafo: El grafo sobre el cual se ejecutar� el algoritmo.
	 * Objetivo: Inicializa las distancias entre los v�rtices en el grafo.
	 * Retorno: Ninguno.
	 */
	public void inicializarDistancias(Grafo grafo) {
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				if (i == j) {
					distancias[i][j] = 0; // Distancia de un v�rtice a s� mismo es 0
				} else if (grafo.obtenerPesoArista(i, j) != Integer.MAX_VALUE) {
					distancias[i][j] = grafo.obtenerPesoArista(i, j); // Distancia directa
				} else {
					distancias[i][j] = Integer.MAX_VALUE; // No hay conexi�n directa
				}
				predecesores[i][j] = i; // Inicializamos predecesores con el mismo v�rtice
			}
		}
	}

	/**
	 * Funci�n: ejecutarFloydWarshall
	 * Argumentos: Ninguno.
	 * Objetivo: Ejecuta el algoritmo de Floyd-Warshall para encontrar las distancias m�s cortas entre todos los pares de v�rtices.
	 * Retorno: Ninguno.
	 */
	public void ejecutarFloydWarshall() {
		for (int k = 0; k < numVertices; k++) {
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					if (distancias[i][k] != Integer.MAX_VALUE && distancias[k][j] != Integer.MAX_VALUE) {
						int distancia_a_traves_k = distancias[i][k] + distancias[k][j];
						if (distancia_a_traves_k < distancias[i][j]) {
							distancias[i][j] = distancia_a_traves_k;
							predecesores[i][j] = predecesores[k][j]; // Actualizamos predecesor
						}
					}
				}
			}
		}
	}

	/**
	 * Funci�n: getDistancias
	 * Argumentos: Ninguno.
	 * Objetivo: Devuelve la matriz de distancias calculada por el algoritmo de Floyd-Warshall.
	 * Retorno: int[][] que representa la matriz de distancias entre todos los pares de v�rtices.
	 */
	public int[][] getDistancias() {
		return distancias;
	}

	/**
	 * Funci�n: imprimirMatrizDistancias
	 * Argumentos: Ninguno.
	 * Objetivo: Imprime la matriz de distancias resultante del algoritmo de Floyd-Warshall.
	 * Retorno: Ninguno.
	 */
	public void imprimirMatrizDistancias() {
		System.out.println("Matriz de distancias:");
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				if (distancias[i][j] == Integer.MAX_VALUE) {
					System.out.print("X\t");
				} else {
					System.out.print(distancias[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}
}
