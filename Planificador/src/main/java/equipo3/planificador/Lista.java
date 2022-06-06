package equipo3.planificador;

public class Lista<T> implements ILista{
    
    private Nodo<T> primero;
    
    @Override
    public void insertar(Nodo nodo) {
        if (this.primero == null) {
            primero = nodo;
        } else {
            Nodo nodoActual = this.primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nodo);
        }
    }

    @Override
    public Nodo buscar(Comparable clave) {
       if (this.primero == null) {
           return null;
       } else {
           Nodo nodoActual = this.primero;
           while (nodoActual != null) {
               if (nodoActual.getEtiqueta().compareTo(clave) == 0) {
                   return nodoActual;
               } else {
                   nodoActual = nodoActual.getSiguiente();
               }
           }
       }
       return null;   
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (this.primero == null) {
            return false;
        } else {
            Nodo nodoAEliminar;
            if (this.primero.getEtiqueta().compareTo(clave) == 0){
                nodoAEliminar = this.primero;
                this.primero = this.primero.getSiguiente();
                nodoAEliminar.setSiguiente(null);
                return true;
            } else {
                Nodo nodoActual = primero;
                while (nodoActual.getSiguiente() != null) {
                    if (nodoActual.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                        nodoAEliminar = nodoActual.getSiguiente();
                        nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
                        nodoAEliminar.setSiguiente(null);
                        return true;
                    } else {
                        nodoActual = nodoActual.getSiguiente();
                    }
                }
            }
            return false;
        }
    }

    @Override
    public String imprimir() {
        if (this.primero == null) {
            System.out.println("[]");
            return "[]";
        }else {
            StringBuilder lista = new StringBuilder("[");
            Nodo nodoActual = this.primero;
            while (nodoActual != null) {
                lista.append(nodoActual.getEtiqueta());
                if (nodoActual.getSiguiente() != null) {
                    lista.append(", ");
                } else {
                    lista.append("]");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            System.out.println(lista);
            return lista.toString();
        }
    }

    @Override
    public String imprimir(String separador) {
        if (this.primero == null) {
            System.out.println("[]");
            return "[]";
        }else {
            StringBuilder lista = new StringBuilder("[");
            Nodo nodoActual = this.primero;
            while (nodoActual != null) {
                lista.append(nodoActual.getEtiqueta());
                if (nodoActual.getSiguiente() != null) {
                    lista.append(separador);
                } else {
                    lista.append("]");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return lista.toString();
        }
    }

    @Override
    public int cantElementos() {
       if (this.esVacia()) {
           return 0;
       } else {
           Nodo nodoActual = this.primero;
           int contador = 1;
           while (nodoActual.getSiguiente() != null) {
               ++contador;
               nodoActual = nodoActual.getSiguiente();
            }
           return contador;
       } 
    }

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    @Override
    public void setPrimero(Nodo unNodo) {
        unNodo.setSiguiente(this.primero.getSiguiente());
        this.primero = unNodo;    
    }
    
     public Lista ordenaParesImpares() {
            Lista listaImpares = new Lista();
            Lista listaPares = new Lista();
            Lista listaOrdenada = new Lista();
            Nodo nodoActual = primero;
            Nodo nodoUltimo;
            Nodo nodoSiguiente;
            while(nodoActual != null){
                nodoSiguiente = nodoActual.getSiguiente();
                if ( (int) nodoActual.getEtiqueta() % 2 != 0) {
                    listaImpares.insertarOrdenado(nodoActual);
                } else {
                    listaPares.insertarOrdenado(nodoActual);
                }
                nodoActual = nodoSiguiente;
            }  
            listaOrdenada.primero = listaImpares.getPrimero();
            nodoUltimo = listaImpares.getUltimo();
            nodoUltimo.setSiguiente(listaPares.getPrimero());
            return listaOrdenada;
        }
     
     public void insertarOrdenado(Nodo nodo) {
            if(esVacia()) {
                this.primero = nodo;
                this.primero.setSiguiente(null);
                return;
            }else {
            Nodo nodoActual = primero;
            Nodo nodoSiguiente;
            if(this.primero.getEtiqueta().compareTo(nodo.getEtiqueta()) > 0) {
                    this.primero = nodo;
                    this.primero.setSiguiente(nodoActual);
                    return;
            }
            while(nodoActual.getSiguiente() != null){
                nodoSiguiente = nodoActual.getSiguiente();
                if (nodoSiguiente.getEtiqueta().compareTo(nodo.getEtiqueta()) > 0) {
                    nodo.setSiguiente(nodoSiguiente);
                    nodoActual.setSiguiente(nodo);
                    return;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            nodo.setSiguiente(null);
            nodoActual.setSiguiente(nodo);
            }
        }
     
        public Nodo getUltimo() {
           if (esVacia()) {
                   return null;
           } else {
                   Nodo aux = primero;
                   while (aux.getSiguiente() != null) {
                       aux = aux.getSiguiente();
                   }
                   return aux;

           }
         }
    
        public Nodo getPrimero() {
            return primero;
        }
    
}


