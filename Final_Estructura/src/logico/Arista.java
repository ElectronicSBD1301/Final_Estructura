package logico;

public class Arista {
    private int peso;
    private int tiempo;

    /**
     * Función: Arista
     * Argumentos:
     *    - peso: entero que representa el peso de la arista.
     *    - tiempo: entero que representa el tiempo de la arista.
     * Objetivo: Constructor para inicializar una arista con peso y tiempo.
     * Retorno: Ninguno.
     */
    public Arista(int peso, int tiempo) {
        this.peso = peso;
        this.tiempo = tiempo;
    }

    /**
     * Función: getPeso
     * Argumentos: Ninguno.
     * Objetivo: Obtener el peso de la arista.
     * Retorno: Entero que representa el peso de la arista.
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Función: getTiempo
     * Argumentos: Ninguno.
     * Objetivo: Obtener el tiempo de la arista.
     * Retorno: Entero que representa el tiempo de la arista.
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Función: setPeso
     * Argumentos:
     *    - peso: entero que representa el nuevo peso de la arista.
     * Objetivo: Establecer el peso de la arista.
     * Retorno: Ninguno.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Función: setTiempo
     * Argumentos:
     *    - tiempo: entero que representa el nuevo tiempo de la arista.
     * Objetivo: Establecer el tiempo de la arista.
     * Retorno: Ninguno.
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
