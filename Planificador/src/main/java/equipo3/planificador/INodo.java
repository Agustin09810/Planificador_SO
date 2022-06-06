package equipo3.planificador;

public interface INodo<T> {

    /**
     * Retorna la clave contenida en el nodo.
     *
     * @return Clave contenida en el nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Asigna el siguiente nodo al nodo actual.
     *
     * @param nodo Nodo a asignar como siguiente.
     */
   public void setSiguiente(Nodo nodo);

    /**
     * Retorna el siguiente nodo al nodo actual.
     *
     * @return Siguiente nodo del actual
     */
    public Nodo getSiguiente();

    /**
     * Imprime el nodo
     *
     * @return un String con los valores del nodo
     */
    public void imprimirEtiqueta();

    /**
     *
     * @param unNodo
     * @return si son iguales, por la clave
     */
    public boolean equals(INodo unNodo);

    /**
     *
     * @param unNodo
     * @return devueve -1 si this tiene una clave menor, 0 si son iguales, 1 si
     * es mayor
     */
    public int compareTo(INodo unNodo);

    /**
     * Imprime los datos del nodo
     * @return 
     */
    public String imprimir();
    
    /**
     *Obteien el dato del nodo
     * @return
     */
    public T getDato();
        
}
