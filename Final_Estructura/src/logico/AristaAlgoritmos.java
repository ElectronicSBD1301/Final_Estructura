package logico;

public class AristaAlgoritmos {
    private int origen;
    private int destino;
    private int peso;

    /**
     * Función: AristaAlgoritmos
     * Argumentos:
     *    int origen: El vértice de origen de la arista.
     *    int destino: El vértice de destino de la arista.
     *    int peso: El peso asociado a la arista.
     * Objetivo: Constructor de la clase AristaAlgoritmos.
     * Retorno: Ninguno.
     */
    public AristaAlgoritmos(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Función: getOrigen
     * Argumentos: Ninguno.
     * Objetivo: Obtener el vértice de origen de la arista.
     * Retorno: int que representa el vértice de origen.
     */
    public int getOrigen() {
        return origen;
    }

    /**
     * Función: setOrigen
     * Argumentos:
     *    int origen: El nuevo vértice de origen a establecer.
     * Objetivo: Establecer el vértice de origen de la arista.
     * Retorno: Ninguno.
     */
    public void setOrigen(int origen) {
        this.origen = origen;
    }

    /**
     * Función: getDestino
     * Argumentos: Ninguno.
     * Objetivo: Obtener el vértice de destino de la arista.
     * Retorno: int que representa el vértice de destino.
     */
    public int getDestino() {
        return destino;
    }

    /**
     * Función: setDestino
     * Argumentos:
     *    int destino: El nuevo vértice de destino a establecer.
     * Objetivo: Establecer el vértice de destino de la arista.
     * Retorno: Ninguno.
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }

    /**
     * Función: getPeso
     * Argumentos: Ninguno.
     * Objetivo: Obtener el peso asociado a la arista.
     * Retorno: int que representa el peso de la arista.
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Función: setPeso
     * Argumentos:
     *    int peso: El nuevo peso a establecer para la arista.
     * Objetivo: Establecer el peso de la arista.
     * Retorno: Ninguno.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Función: toString
     * Argumentos: Ninguno.
     * Objetivo: Representar la arista como una cadena de texto.
     * Retorno: String que representa la arista en el formato "(origen -> destino, Peso: peso)".
     */
    public String toString() {
        return "(" + origen + " -> " + destino + ", Peso: " + peso + ")";
    }
}
