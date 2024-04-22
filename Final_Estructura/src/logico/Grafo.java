package logico;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
    Arista[][] matrizAdy;
    int numVer;

    /**
     * Función: Grafo
     * Argumentos:
     *    int numVer: El número de vértices del grafo.
     * Objetivo: Constructor de la clase Grafo que inicializa la matriz de adyacencia.
     * Retorno: Ninguno.
     */
    public Grafo(int numVer) {
        this.numVer = numVer;
        matrizAdy = new Arista[numVer][numVer];
        for (int i = 0; i < numVer; i++) {
            Arrays.fill(matrizAdy[i], null);
        }
    }

    /**
     * Función: agregarArista
     * Argumentos:
     *    int origen: El nodo de origen de la arista.
     *    int destino: El nodo de destino de la arista.
     *    int peso: El peso de la arista.
     *    int tiempo: El tiempo de la arista.
     * Objetivo: Agregar una arista al grafo entre los nodos de origen y destino.
     * Retorno: Ninguno.
     */
    public void agregarArista(int origen, int destino, int peso, int tiempo) {
        if (origen < 0 || destino < 0 || peso < 0 || tiempo < 0) {
            System.out.println("Error: Los valores de origen, destino, peso y tiempo deben ser números enteros no negativos.");
            return;
        }

        if ((origen >= 0 && destino < 0) || (origen < 0 && destino >= 0)) {
            System.out.println("Error: Origen y destino deben tener ambos valores positivos o ambos valores negativos.");
            return;
        }

        if (destino > (numVer - 1) + 1) {
            System.out.println("Error: El vértice destino no puede ser mayor que numVertices + 1.");
            return;
        }

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

        System.out.println("Arista agregada con éxito.");
    }


    /**
     * Función: obtenerPesoArista
     * Argumentos:
     *    int origen: El nodo de origen de la arista.
     *    int destino: El nodo de destino de la arista.
     * Objetivo: Obtener el peso de la arista entre los nodos de origen y destino.
     * Retorno: int que representa el peso de la arista.
     */
    public int obtenerPesoArista(int origen, int destino) {
        if (matrizAdy[origen][destino] != null) {
            return matrizAdy[origen][destino].getPeso();
        } else {
            // Esto indica que no hay arista
            return Integer.MAX_VALUE;
        }
    }

    /**
     * Función: obtenerVecinos
     * Argumentos:
     *    int nodo: El nodo del cual se desean obtener los vecinos.
     * Objetivo: Obtener los vecinos de un nodo dado en el grafo.
     * Retorno: ArrayList de enteros que representa los nodos vecinos.
     */
    public ArrayList<Integer> obtenerVecinos(int nodo) {
        ArrayList<Integer> vecinos = new ArrayList<>();
        for (int i = 0; i < numVer; i++) {
            if (matrizAdy[nodo][i] != null) {
                vecinos.add(i);
            }
        }
        return vecinos;
    }

    /**
     * Función: editarPesoArista
     * Argumentos:
     *    int origen: El nodo de origen de la arista.
     *    int destino: El nodo de destino de la arista.
     *    int nuevoPeso: El nuevo peso de la arista.
     *    int nuevoTiempo: El nuevo tiempo de la arista.
     * Objetivo: Editar el peso y tiempo de una arista existente en el grafo.
     * Retorno: Ninguno.
     */
    public void editarPesoArista(int origen, int destino, int nuevoPeso, int nuevoTiempo) {
        if (origen < 0 || destino < 0 || nuevoPeso < 0 || nuevoTiempo < 0) {
            System.out.println("Error: Los valores de origen, destino, nuevo peso y nuevo tiempo deben ser números enteros no negativos.");
            return;
        }

        if (origen >= numVer || destino >= numVer) {
            System.out.println("Error: Origen y destino deben estar dentro del rango de vértices del grafo.");
            return;
        }

        if (matrizAdy[origen][destino] != null) {
            matrizAdy[origen][destino].setPeso(nuevoPeso);
            matrizAdy[origen][destino].setTiempo(nuevoTiempo);
            matrizAdy[destino][origen].setPeso(nuevoPeso);
            matrizAdy[destino][origen].setTiempo(nuevoTiempo);

            System.out.println("Peso de arista editado con éxito.");
        } else {
            // Esto indica que no existe la arista
            System.out.println("No existe la arista especificada.");
        }
    }


    /**
     * Función: eliminarVertice
     * Argumentos:
     *    int vertice: El vértice que se desea eliminar del grafo.
     * Objetivo: Eliminar un vértice del grafo y ajustar la matriz de adyacencia.
     * Retorno: Ninguno.
     */
    public void eliminarVertice(int vertice) {
        if (vertice < 0) {
            System.out.println("Error: El vértice a eliminar debe ser un número entero no negativo.");
            return;
        }
    	
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
            
            System.out.println("Vértice eliminado con éxito.");
        } else {
            System.out.println("El vértice a eliminar no es válido.");
        }
    }

    /**
     * Función: imprimirMatrizAdyacencia
     * Argumentos: Ninguno.
     * Objetivo: Imprimir la matriz de adyacencia del grafo en la consola.
     * Retorno: Ninguno.
     */
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
                    System.out.print("X   ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Función: imprimirMatrizAdyacenciaTiempo
     * Argumentos: Ninguno.
     * Objetivo: Imprimir la matriz de adyacencia del grafo mostrando únicamente el tiempo de las aristas.
     * Retorno: Ninguno.
     */
    public void imprimirMatrizAdyacenciaTiempo() {
        System.out.println("Matriz de Adyacencia (Tiempos):");
        System.out.print("    ");
        for (int i = 0; i < numVer; i++) {
            System.out.printf("%-4d", i);
        }
        System.out.println();

        for (int i = 0; i < numVer; i++) {
            System.out.printf("%-4d", i);
            for (int j = 0; j < numVer; j++) {
                if (matrizAdy[i][j] != null) {
                    System.out.printf("%-4d", matrizAdy[i][j].getTiempo()); // Mostrar tiempo de la arista
                } else {
                    System.out.print("X   "); // No hay arista
                }
            }
            System.out.println();
        }
    }


    /**
     * Función: obtenerDistanciaEuclidiana
     * Argumentos:
     *    int nodo1: El primer nodo.
     *    int nodo2: El segundo nodo.
     * Objetivo: Calcular la distancia entre dos nodos basada en el número de aristas.
     * Retorno: int que representa la distancia entre los nodos.
     */
    public int obtenerDistanciaEuclidiana(int nodo1, int nodo2) {
        // Para simplificar, asumimos que cada arista cuenta como una unidad de
        // distancia y utilizamos el algoritmo de Dijkstra para calcular la distancia entre los nodos
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

//arbol prim y kruskal