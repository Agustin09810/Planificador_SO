package equipo3.planificador;

public class Nodo<T> implements INodo{

	private Comparable etiqueta;
	private Nodo siguiente = null;
        private T dato;
        
        
	public Nodo(Comparable clave, T dato) {
            this.etiqueta = clave;
            this.dato = dato;
	}
        
        public T getDato() {
            return this.dato;
        }
        

	public Comparable getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(Comparable unaClave) {
		this.etiqueta = unaClave;

	}

	public void setSiguiente(Nodo nodo) {
		this.siguiente = nodo;

	}

	public Nodo getSiguiente() {
		return this.siguiente;
	}
	public void imprimirEtiqueta(){
		System.out.println(etiqueta.toString());
	}
	
	public Nodo<T> clonar() {
            return new Nodo<>(this.etiqueta, this.dato);
        }
	

	@Override
	public boolean equals(INodo unNodo){
		return this.etiqueta.equals(unNodo.getEtiqueta());
	}
	
	@Override
	public int compareTo(INodo unNodo){
		return this.etiqueta.compareTo(unNodo.getEtiqueta());
	}

    @Override
    public String imprimir() {
        return this.dato + "    ID: " + this.etiqueta;
    }
}

