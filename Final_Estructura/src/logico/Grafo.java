package logico;

import java.util.Arrays;

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
        matrizAdy[origen][destino] = peso;
        matrizAdy[destino][origen] = peso;
    }
    
    public int obtenerPesoArista(int origen, int destino) {
        return matrizAdy[origen][destino];
    }
}
