package logico;

public class AristaAlgoritmos {
    private int origen;
    private int destino;
    private int peso;

    /**
     * Funci�n: AristaAlgoritmos
     * Argumentos:
     *    int origen: El v�rtice de origen de la arista.
     *    int destino: El v�rtice de destino de la arista.
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
     * Funci�n: getOrigen
     * Argumentos: Ninguno.
     * Objetivo: Obtener el v�rtice de origen de la arista.
     * Retorno: int que representa el v�rtice de origen.
     */
    public int getOrigen() {
        return origen;
    }

    /**
     * Funci�n: setOrigen
     * Argumentos:
     *    int origen: El nuevo v�rtice de origen a establecer.
     * Objetivo: Establecer el v�rtice de origen de la arista.
     * Retorno: Ninguno.
     */
    public void setOrigen(int origen) {
        this.origen = origen;
    }

    /**
     * Funci�n: getDestino
     * Argumentos: Ninguno.
     * Objetivo: Obtener el v�rtice de destino de la arista.
     * Retorno: int que representa el v�rtice de destino.
     */
    public int getDestino() {
        return destino;
    }

    /**
     * Funci�n: setDestino
     * Argumentos:
     *    int destino: El nuevo v�rtice de destino a establecer.
     * Objetivo: Establecer el v�rtice de destino de la arista.
     * Retorno: Ninguno.
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }

    /**
     * Funci�n: getPeso
     * Argumentos: Ninguno.
     * Objetivo: Obtener el peso asociado a la arista.
     * Retorno: int que representa el peso de la arista.
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Funci�n: setPeso
     * Argumentos:
     *    int peso: El nuevo peso a establecer para la arista.
     * Objetivo: Establecer el peso de la arista.
     * Retorno: Ninguno.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Funci�n: toString
     * Argumentos: Ninguno.
     * Objetivo: Representar la arista como una cadena de texto.
     * Retorno: String que representa la arista en el formato "(origen -> destino, Peso: peso)".
     */
    public String toString() {
        return "(" + origen + " -> " + destino + ", Peso: " + peso + ")";
    }
}
