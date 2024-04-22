package logico;

public class Arista {
    private int peso;
    private int tiempo;

    /**
     * Funci�n: Arista
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
     * Funci�n: getPeso
     * Argumentos: Ninguno.
     * Objetivo: Obtener el peso de la arista.
     * Retorno: Entero que representa el peso de la arista.
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Funci�n: getTiempo
     * Argumentos: Ninguno.
     * Objetivo: Obtener el tiempo de la arista.
     * Retorno: Entero que representa el tiempo de la arista.
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Funci�n: setPeso
     * Argumentos:
     *    - peso: entero que representa el nuevo peso de la arista.
     * Objetivo: Establecer el peso de la arista.
     * Retorno: Ninguno.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Funci�n: setTiempo
     * Argumentos:
     *    - tiempo: entero que representa el nuevo tiempo de la arista.
     * Objetivo: Establecer el tiempo de la arista.
     * Retorno: Ninguno.
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
