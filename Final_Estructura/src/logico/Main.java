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
			System.out.println("1. Modificar Grafo");
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
					System.out.println("4. Mostrar Matriz de Adyacencia");
					System.out.println("5. Volver al menú principal");
					System.out.print("Seleccione una opción: ");
					grafoChoice = scanner.nextInt();

					switch (grafoChoice) {
					case 1:
						System.out.println("Ingrese el origen, destino y su peso separados por espacios:");
						int nuevoOrigen = scanner.nextInt();
						int nuevoDestino = scanner.nextInt();
						int pesoArista = scanner.nextInt();
						grafo.agregarArista(nuevoOrigen, nuevoDestino, pesoArista);
						System.out.println("Vértice agregado con éxito.");
						break;
					case 2:
						System.out.println("Ingrese el origen, destino y el nuevo peso separados por espacios:");
						int origenArista = scanner.nextInt();
						int destinoArista = scanner.nextInt();
						int nuevoPeso = scanner.nextInt();
						grafo.editarPesoArista(origenArista, destinoArista, nuevoPeso);
						System.out.println("Peso de arista editado con éxito.");
						break;
					case 3:
						System.out.println("Ingrese el vértice a eliminar:");
						int verticeEliminar = scanner.nextInt();
						grafo.eliminarVertice(verticeEliminar);
						System.out.println("Vértice eliminado con éxito.");
						break;
					case 4:
						grafo.imprimirMatrizAdyacencia();
						break;
					case 5:
						break;// Salir del menú Grafo y volver al menú principal
					default:
						System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
					}
				} while (grafoChoice != 5);
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
				ArrayList<Integer> rutaOptima;
				if (preferencia.equalsIgnoreCase("distancia") || preferencia.equalsIgnoreCase("tiempo")) {
					rutaOptima = planificador.planificarRutaOptima(origen, destino, preferencia);
					if (rutaOptima != null) {
						String tipoCalculo = preferencia.equalsIgnoreCase("distancia") ? "distancia" : "tiempo";
						System.out.println("La ruta óptima por " + tipoCalculo + " desde " + origen + " hasta "
								+ destino + " es: " + rutaOptima);
					} else {
						System.out.println("No hay ruta disponible entre " + origen + " y " + destino + ".");
					}
				} else {
					System.out.println("Opción no válida. Por favor, seleccione 'tiempo' o 'distancia'.");
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
