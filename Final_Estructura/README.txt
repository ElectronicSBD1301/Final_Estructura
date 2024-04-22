# Planificador de Rutas en Grafo

Este proyecto incluye varias clases relacionadas con grafos y algoritmos para 
planificar rutas �ptimas. A continuaci�n, se detallan las clases proporcionadas y su funcionalidad:

# Clases del Proyecto

1. Arista: Esta clase representa una arista en un grafo y se utiliza para conectar v�rtices.
Cada arista tiene un peso y un tiempo asociado que se utilizan en algoritmos como Dijkstra para encontrar caminos �ptimos.

2. AristaAlgoritmos: Esta clase es espec�fica para los algoritmos de �rboles de expansi�n
m�nima como Prim y Kruskal. Representa una arista con un origen, destino y peso.

3. AlgoritmoDijkstra: Implementa el algoritmo de Dijkstra para encontrar el camino m�s
corto desde un nodo origen a todos los dem�s nodos en un grafo ponderado. Utiliza una cola
de prioridad para mejorar la eficiencia del algoritmo.

4. AlgoritmoDijkstraTiempo: Similar a Dijkstra, pero se utiliza para encontrar la ruta
�ptima basada en el tiempo en lugar del peso de las aristas. �til para situaciones donde
el tiempo es una consideraci�n cr�tica en la planificaci�n de rutas.

5. AlgoritmoPrim: Implementa el algoritmo de Prim para encontrar el �rbol de expansi�n
m�nima en un grafo no dirigido ponderado. El resultado es un subconjunto de aristas
que conectan todos los v�rtices con el menor costo total posible.

6. AlgoritmoKruskal: Implementa el algoritmo de Kruskal para encontrar el �rbol de
expansi�n m�nima en un grafo no dirigido ponderado. Este algoritmo funciona seleccionando las
aristas de menor peso y asegur�ndose de que no formen ciclos en el �rbol resultante.

7. AlgoritmoFloydWarshall: Implementa el algoritmo de Floyd-Warshall para encontrar todos
los caminos m�s cortos entre todos los pares de v�rtices en un grafo dirigido o no dirigido
con pesos (positivos o negativos). Es eficiente para grafos peque�os y es capaz de manejar pesos negativos.

8. AlgoritmoAStar: Implementa el algoritmo A* para encontrar la ruta m�nima en un grafo ponderado.
A* es una variante de b�squeda heur�stica que utiliza una funci�n de evaluaci�n para seleccionar
la mejor ruta basada en el costo acumulado y una estimaci�n del costo restante.

9. DisjointSet: Esta clase implementa una estructura de conjuntos disjuntos, tambi�n conocida como
Union-Find, que se utiliza en algoritmos como Kruskal para manejar conjuntos de elementos y realizar
operaciones de uni�n y b�squeda eficientes.

10. Grafo: Representa un grafo mediante una matriz de adyacencia y proporciona operaciones b�sicas
como agregar aristas, obtener vecinos, editar pesos de aristas, eliminar v�rtices, e imprimir la matriz
de adyacencia. Es la estructura principal para trabajar con grafos en el proyecto.

11. Main: La clase principal del programa que contiene el men� interactivo para que el usuario pueda
realizar diversas operaciones en el grafo, ejecutar algoritmos y planificar rutas �ptimas seg�n sus preferencias.

12. PlanificadorRutas: Esta clase utiliza los algoritmos Dijkstra y A* para planificar rutas �ptimas
en el grafo, considerando tanto la distancia como el tiempo como criterios para encontrar la mejor ruta entre dos nodos.

# Uso del Programa

Para usar el programa, ejecuta la clase `Main`. Se mostrar� un men� interactivo con opciones
para trabajar con el grafo, ejecutar algoritmos espec�ficos y planificar rutas �ptimas entre nodos.

Autores: Carlos D. Hernandez y Nelson R. Luna