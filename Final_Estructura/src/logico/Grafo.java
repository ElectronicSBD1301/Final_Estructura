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
}
