package logico;

import java.util.ArrayList;

public class PlanificadorRutas {
    private Grafo grafo;

    public PlanificadorRutas(Grafo grafo) {
        this.grafo = grafo;
    }

    public ArrayList<Integer> planificarRutaOptima(int origen, int destino, String preferencia) {
        if (preferencia.equalsIgnoreCase("tiempo")) {
            return calcularRutaMinimaPorTiempo(origen, destino);
        } else if (preferencia.equalsIgnoreCase("distancia")) {
            return calcularRutaMinimaPorDistancia(origen, destino);
        } else {
            throw new IllegalArgumentException("La preferencia debe ser 'tiempo' o 'distancia'.");
        }
    }

    private ArrayList<Integer> calcularRutaMinimaPorTiempo(int origen, int destino) {
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(grafo);
        return dijkstra.calcularCamino(origen, destino);
    }

    private ArrayList<Integer> calcularRutaMinimaPorDistancia(int origen, int destino) {
        AlgoritmoFloydWarshall floydWarshall = new AlgoritmoFloydWarshall(grafo.numVer);
        floydWarshall.inicializarDistancias(grafo);
        floydWarshall.ejecutarFloydWarshall();
        
        // Obtener la matriz de distancias después de ejecutar Floyd-Warshall
        int[][] distancias = floydWarshall.getDistancias();

        // Verificar si hay una ruta entre origen y destino
        if (distancias[origen][destino] == Integer.MAX_VALUE) {
            // No hay ruta disponible entre origen y destino
            return null;
        }

        // Reconstruir la ruta mínima por distancia
        ArrayList<Integer> ruta = new ArrayList<>();
        ruta.add(origen); // Agregar el nodo de origen a la ruta inicialmente

        // Iterar a través de los nodos intermedios en la ruta más corta
        while (origen != destino) {
            // Buscar el próximo nodo en la ruta mínima
            for (int intermedio = 0; intermedio < grafo.numVer; intermedio++) {
                if (intermedio != origen && intermedio != destino &&
                    distancias[origen][destino] == distancias[origen][intermedio] + distancias[intermedio][destino]) {
                    // Agregar el nodo intermedio a la ruta
                    ruta.add(intermedio);
                    // Actualizar el origen para continuar buscando el próximo nodo intermedio
                    origen = intermedio;
                    break;
                }
            }
        }

        // Agregar el nodo de destino a la ruta
        ruta.add(destino);

        return ruta;
    }
}