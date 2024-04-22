# Planificador de Rutas en Grafo

Este proyecto incluye varias clases relacionadas con grafos y algoritmos para 
planificar rutas óptimas. A continuación, se detallan las clases proporcionadas y su funcionalidad:

# Clases del Proyecto

1. Arista: Esta clase representa una arista en un grafo y se utiliza para conectar vértices.
Cada arista tiene un peso y un tiempo asociado que se utilizan en algoritmos como Dijkstra para encontrar caminos óptimos.

2. AristaAlgoritmos: Esta clase es específica para los algoritmos de árboles de expansión
mínima como Prim y Kruskal. Representa una arista con un origen, destino y peso.

3. AlgoritmoDijkstra: Implementa el algoritmo de Dijkstra para encontrar el camino más
corto desde un nodo origen a todos los demás nodos en un grafo ponderado. Utiliza una cola
de prioridad para mejorar la eficiencia del algoritmo.

4. AlgoritmoDijkstraTiempo: Similar a Dijkstra, pero se utiliza para encontrar la ruta
óptima basada en el tiempo en lugar del peso de las aristas. Útil para situaciones donde
el tiempo es una consideración crítica en la planificación de rutas.

5. AlgoritmoPrim: Implementa el algoritmo de Prim para encontrar el árbol de expansión
mínima en un grafo no dirigido ponderado. El resultado es un subconjunto de aristas
que conectan todos los vértices con el menor costo total posible.

6. AlgoritmoKruskal: Implementa el algoritmo de Kruskal para encontrar el árbol de
expansión mínima en un grafo no dirigido ponderado. Este algoritmo funciona seleccionando las
aristas de menor peso y asegurándose de que no formen ciclos en el árbol resultante.

7. AlgoritmoFloydWarshall: Implementa el algoritmo de Floyd-Warshall para encontrar todos
los caminos más cortos entre todos los pares de vértices en un grafo dirigido o no dirigido
con pesos (positivos o negativos). Es eficiente para grafos pequeños y es capaz de manejar pesos negativos.

8. AlgoritmoAStar: Implementa el algoritmo A* para encontrar la ruta mínima en un grafo ponderado.
A* es una variante de búsqueda heurística que utiliza una función de evaluación para seleccionar
la mejor ruta basada en el costo acumulado y una estimación del costo restante.

9. DisjointSet: Esta clase implementa una estructura de conjuntos disjuntos, también conocida como
Union-Find, que se utiliza en algoritmos como Kruskal para manejar conjuntos de elementos y realizar
operaciones de unión y búsqueda eficientes.

10. Grafo: Representa un grafo mediante una matriz de adyacencia y proporciona operaciones básicas
como agregar aristas, obtener vecinos, editar pesos de aristas, eliminar vértices, e imprimir la matriz
de adyacencia. Es la estructura principal para trabajar con grafos en el proyecto.

11. Main: La clase principal del programa que contiene el menú interactivo para que el usuario pueda
realizar diversas operaciones en el grafo, ejecutar algoritmos y planificar rutas óptimas según sus preferencias.

12. PlanificadorRutas: Esta clase utiliza los algoritmos Dijkstra y A* para planificar rutas óptimas
en el grafo, considerando tanto la distancia como el tiempo como criterios para encontrar la mejor ruta entre dos nodos.

# Uso del Programa

Para usar el programa, ejecuta la clase `Main`. Se mostrará un menú interactivo con opciones
para trabajar con el grafo, ejecutar algoritmos específicos y planificar rutas óptimas entre nodos.

Autores: Carlos D. Hernandez y Nelson R. Luna
