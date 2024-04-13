package logico;

import java.util.Scanner;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        int choice;
        Grafo grafo = new Grafo(9); // Creamos el grafo
		AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(grafo); // Se crea una instancia de la clase donde se encuentra el algoritmo de dijkstra
        
        // Agregamos aristas al grafo y establecemos sus pesos
        grafo.agregarArista(0, 1, 4);
        grafo.agregarArista(0, 7, 8);
        grafo.agregarArista(1, 2, 8);
        grafo.agregarArista(1, 7, 11);
        grafo.agregarArista(2, 3, 7);
        grafo.agregarArista(2, 8, 2);
        grafo.agregarArista(2, 5, 4);
        grafo.agregarArista(3, 4, 9);
        grafo.agregarArista(3, 5, 14);
        grafo.agregarArista(4, 5, 10);
        grafo.agregarArista(5, 6, 2);
        grafo.agregarArista(6, 7, 1);
        grafo.agregarArista(6, 8, 6);
        grafo.agregarArista(7, 8, 7);

        do {
            System.out.println("Bienvenido al menu:");
            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Opcion 4");
            System.out.println("5. Opcion 5");
            System.out.println("6. Opcion 6");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	System.out.println("\nEl peso de la arista entre el vÃ©rtice 0 y el vÃ©rtice 1 es: " + grafo.obtenerPesoArista(0, 1));// Esto era para yo saber si el peso estaba bien
                    // AquÃ­ puedes poner el cÃ³digo correspondiente a la opciÃ³n 1
                    break;
                case 2:
                    System.out.println("Ingrese el origen y el destino separados por espacios:");
                    int origen = scanner.nextInt();
                    int destino = scanner.nextInt();
                    ArrayList<Integer> camino = dijkstra.calcularCamino(origen, destino);
                    System.out.println("El camino desde " + origen + " hasta " + destino + " es: " + camino);
                    break;
                case 3:
                    AlgoritmoPrim prim = new AlgoritmoPrim(grafo);
                    ArrayList<Arista> arbolPrim = prim.generarArbolExpansionMinima();
                    System.out.println("Ã�rbol de expansiÃ³n mÃ­nima (Prim): " + arbolPrim);
                    break;
                case 4:
                    AlgoritmoKruskal kruskal = new AlgoritmoKruskal(grafo);
                    ArrayList<Arista> arbolKruskal = kruskal.generarArbolExpansionMinima();
                    System.out.println("arbol de expansion minima (Kruskal): " + arbolKruskal);
                    break;
                case 5:
                    AlgoritmoFloydWarshall floydWarshall = new AlgoritmoFloydWarshall(grafo.numVer);
                    floydWarshall.inicializarDistancias(grafo);
                    floydWarshall.ejecutarFloydWarshall();
                    floydWarshall.imprimirMatrizDistancias();
                    break;
                case 6:
                	PlanificadorRutas planificador = new PlanificadorRutas(grafo);
                    System.out.println("Ingrese el origen y el destino separados por espacios:");
                    origen = scanner.nextInt();
                    destino = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.println("¿Prefiere minimizar el tiempo o la distancia? (tiempo/distancia)");
                    String preferencia = scanner.nextLine().trim();
                    ArrayList<Integer> rutaOptima = planificador.planificarRutaOptima(origen, destino, preferencia);
                    System.out.println("La ruta óptima por " + preferencia + " desde " + origen + " hasta " + destino + " es: " + rutaOptima);
                    break;

                case 7:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
