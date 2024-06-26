package logico;

import java.util.Scanner;

import java.util.ArrayList;

public class Main {
	
    /**
     * Función: main
     * Argumentos: String[] args
     * Objetivo: Función principal que inicia el programa y muestra un menú de opciones al usuario.
     * Retorno: Ninguno (void).
    */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choice;
		Grafo grafo = new Grafo(9); // Creamos el grafo
		AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(grafo); // Se crea una instancia de la clase donde se encuentra el algoritmo de dijkstra

		// Agregamos aristas al grafo y establecemos sus pesos
		grafo.agregarArista(0, 1, 4, 3);
		grafo.agregarArista(0, 7, 8, 20);
		grafo.agregarArista(1, 2, 8, 9);
		grafo.agregarArista(1, 7, 11, 4);
		grafo.agregarArista(2, 3, 7, 8);
		grafo.agregarArista(2, 8, 2, 14);
		grafo.agregarArista(2, 5, 4, 5);
		grafo.agregarArista(3, 4, 9, 17);
		grafo.agregarArista(3, 5, 14, 13);
		grafo.agregarArista(4, 5, 10, 2);
		grafo.agregarArista(5, 6, 2, 16);
		grafo.agregarArista(6, 7, 1, 18);
		grafo.agregarArista(6, 8, 6, 19);
		grafo.agregarArista(7, 8, 7, 10);

		do {
			System.out.println("Bienvenido al menu:");
			System.out.println("1. Menú Grafo");
			System.out.println("2. Algoritmo Dijkstra");
			System.out.println("3. Algoritmo Prim");
			System.out.println("4. Algoritmo Kruskal");
			System.out.println("5. Algoritmo FloydWarshall");
			System.out.println("6. Planificador de rutas");
			System.out.println("7. Salir");
			System.out.print("Seleccione una opcion: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// Menú Grafo
				int grafoChoice;
				do {
					System.out.println("Menú Grafo:");
					System.out.println("1. Agregar vértice con peso");
					System.out.println("2. Editar peso de arista");
					System.out.println("3. Eliminar vértice");
					System.out.println("4. Mostrar Matriz de Adyacencia (Distancia)");
					System.out.println("5. Mostrar Matriz de Adyacencia (Tiempo)");
					System.out.println("6. Volver al menú principal");
					System.out.print("Seleccione una opción: ");
					grafoChoice = scanner.nextInt();

					switch (grafoChoice) {
					case 1:
						System.out.println("Ingrese el origen, destino, peso y el tiempo separados por espacios:");
						int nuevoOrigen = scanner.nextInt();
						int nuevoDestino = scanner.nextInt();
						int pesoArista = scanner.nextInt();
						int tiempoArista = scanner.nextInt();
						grafo.agregarArista(nuevoOrigen, nuevoDestino, pesoArista, tiempoArista);
						break;
					case 2:
						System.out.println("Ingrese el origen, destino, peso y el nuevo tiempo separados por espacios:");
						int origenArista = scanner.nextInt();
						int destinoArista = scanner.nextInt();
						int nuevoPeso = scanner.nextInt();
						int nuevoTiempo = scanner.nextInt();
						grafo.editarPesoArista(origenArista, destinoArista, nuevoPeso, nuevoTiempo);
						break;
					case 3:
						System.out.println("Ingrese el vértice a eliminar:");
						int verticeEliminar = scanner.nextInt();
						grafo.eliminarVertice(verticeEliminar);
						break;
					case 4:
						grafo.imprimirMatrizAdyacencia();
						break;
					case 5:
						grafo.imprimirMatrizAdyacenciaTiempo();
						break;
					case 6:
						break;// Salir del menú Grafo y volver al menú principal
					default:
						System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
					}
				} while (grafoChoice != 6);
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
			    ArrayList<AristaAlgoritmos> arbolPrim = prim.generarArbolExpansionMinima();
			    System.out.println("Arbol de expansión mínima (Prim): ");
			    for (AristaAlgoritmos arista : arbolPrim) {
			        System.out.println(arista.toString()); // Utiliza el método toString para imprimir la arista
			    }
			    System.out.println();
			    break;

			case 4:
			    AlgoritmoKruskal kruskal = new AlgoritmoKruskal(grafo);
			    ArrayList<AristaAlgoritmos> arbolKruskal = kruskal.generarArbolExpansionMinima();
			    System.out.println("Arbol de expansión mínima (Kruskal): ");
			    for (AristaAlgoritmos arista : arbolKruskal) {
			        System.out.println(arista.toString()); // Utiliza el método toString para imprimir la arista
			    }
			    System.out.println();
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
				System.out.println("¿Prefiere minimizar el tiempo (t) o la distancia (d)? (t/d)");
				String preferencia = scanner.nextLine().trim();
				ArrayList<Integer> rutaOptima;
				if (preferencia.equalsIgnoreCase("d") || preferencia.equalsIgnoreCase("t")) {
				    String tipoCalculo = preferencia.equalsIgnoreCase("d") ? "distancia" : "tiempo";
				    rutaOptima = planificador.planificarRutaOptima(origen, destino, preferencia);
				    if (rutaOptima != null) {
				        System.out.println("La ruta óptima por " + tipoCalculo + " desde " + origen + " hasta "
				                + destino + " es: " + rutaOptima);
				    } else {
				        System.out.println("No hay ruta disponible entre " + origen + " y " + destino + ".");
				    }
				} else {
				    System.out.println("Opción no válida. Por favor, seleccione 't' o 'd'.");
				}
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
