package logico;

import java.util.ArrayList;

public class AlgoritmoPrim {
    private Grafo grafo;
    private int numVertices;

    /**
     * Función: AlgoritmoPrim
     * Argumentos:
     *    Grafo grafo: El grafo sobre el cual se aplicará el algoritmo de Prim.
     * Objetivo: Constructor de la clase AlgoritmoPrim.
     * Retorno: Ninguno.
     */
    public AlgoritmoPrim(Grafo grafo) {
        this.grafo = grafo;
        this.numVertices = grafo.numVer;
    }

    /**
     * Función: generarArbolExpansionMinima
     * Argumentos: Ninguno.
     * Objetivo: Genera el árbol de expansión mínima utilizando el algoritmo de Prim.
     * Retorno: ArrayList de AristaAlgoritmos que representa las aristas del árbol de expansión mínima.
     */
    public ArrayList<AristaAlgoritmos> generarArbolExpansionMinima() {
        boolean[] visitado = new boolean[numVertices];
        ArrayList<AristaAlgoritmos> arbolExpansion = new ArrayList<>();
        visitado[0] = true; // Empezamos desde el primer nodo

        while (arbolExpansion.size() < numVertices - 1) {
            AristaAlgoritmos aristaMinima = null;
            int pesoMinimo = Integer.MAX_VALUE;

            for (int i = 0; i < numVertices; i++) {
                if (visitado[i]) {
                    for (int j = 0; j < numVertices; j++) {
                        int peso = grafo.obtenerPesoArista(i, j);
                        if (!visitado[j] && peso < pesoMinimo && peso != 0) {
                            pesoMinimo = peso;
                            aristaMinima = new AristaAlgoritmos(i, j, peso);
                        }
                    }
                }
            }

            if (aristaMinima != null) {
                arbolExpansion.add(aristaMinima);
                visitado[aristaMinima.getDestino()] = true;
            }
        }

        return arbolExpansion;
    }
}
