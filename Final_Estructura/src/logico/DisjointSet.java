package logico;

public class DisjointSet {
    private int[] parent;
    private int[] rank;

    /**
     * Funci�n: DisjointSet
     * Argumentos:
     *    int size: El tama�o inicial del conjunto disjunto.
     * Objetivo: Constructor de la clase DisjointSet.
     * Retorno: Ninguno.
     */
    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;  // Cada elemento comienza como su propio padre
            rank[i] = 0;    // La altura inicial de cada �rbol es 0
        }
    }

    /**
     * Funci�n: find
     * Argumentos:
     *    int x: El elemento cuyo representante se busca.
     * Objetivo: Encontrar el representante (ra�z) del conjunto al que pertenece x.
     * Retorno: int que representa el representante (ra�z) de x.
     */
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * Funci�n: union
     * Argumentos:
     *    int x: Un elemento del primer conjunto.
     *    int y: Un elemento del segundo conjunto.
     * Objetivo: Unir los conjuntos que contienen x e y.
     * Retorno: Ninguno.
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
