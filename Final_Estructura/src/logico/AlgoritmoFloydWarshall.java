package logico;

public class AlgoritmoFloydWarshall {
    private int numVertices;
    private int[][] distancias;
    private int[][] predecesores; // Matriz de predecesores para reconstruir la ruta óptima

    public AlgoritmoFloydWarshall(int numVertices) {
        this.numVertices = numVertices;
        this.distancias = new int[numVertices][numVertices];
        this.predecesores = new int[numVertices][numVertices];
    }

    public void inicializarDistancias(Grafo grafo) {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    distancias[i][j] = 0;  
                } else if (grafo.matrizAdy[i][j] != Integer.MAX_VALUE) {
                    distancias[i][j] = grafo.matrizAdy[i][j];  
                } else {
                    distancias[i][j] = Integer.MAX_VALUE;  
                }
                // Inicializamos la matriz de predecesores con el mismo valor que la matriz de adyacencia
                predecesores[i][j] = j;
            }
        }
    }

    public void ejecutarFloydWarshall() {
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    // Comprobamos si hay una conexión directa o si podemos llegar través de k
                    if (distancias[i][k] != Integer.MAX_VALUE && distancias[k][j] != Integer.MAX_VALUE) {
                        // Calculamos la distancia a través de k y comparamos con la distancia actual de i a j
                        int distancia_a_traves_k = distancias[i][k] + distancias[k][j];
                        if (distancia_a_traves_k < distancias[i][j]) {
                            distancias[i][j] = distancia_a_traves_k;
                            predecesores[i][j] = predecesores[i][k];
                        }
                    }
                }
            }
        }
    }
    
    // Método para obtener la matriz de distancias
    public int[][] getDistancias() {
        return distancias;
    }
    

    public void imprimirMatrizDistancias() {
        System.out.println("Matriz de distancias:");

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (distancias[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print("[" + i + " -> " + j + "]:" + distancias[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
