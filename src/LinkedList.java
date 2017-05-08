public class LinkedList implements List {

    protected Nodo firstNode;
    protected int size;

    public LinkedList() {
        firstNode = null;
        size = 0;
    }

    /**
     * Agrega un Object a la lista en la ultima posicion
     * @param value Object a agregar
     */
    public void add(Object value) {
        Nodo toAdd = firstNode;
        if (firstNode == null) firstNode = new Nodo(value);
        else {
            while (toAdd.getNext() != null) toAdd = toAdd.getNext();
            Nodo n = new Nodo(value);
            toAdd.setNext(n);
        }
        size++;
    }

    /**
     * Elimina de la lista un Object especifico
     * Devuelve NullPointerException si no existe el elemento
     * @param value Object a elminar
     */
    public void remove(Object value) {
        Nodo n = firstNode;
        if (n.equals(value)) removeAt(0);
        else {
            Nodo toRemove = n;
            while (!n.equals(value)) {
                toRemove = n;
                n = n.getNext();
            }
            if (n.equals(value)) {
                toRemove.setNext(n.getNext());
                size--;
            }
        }

    }

    /**
     * Elimina de la lista el elemento en la posicion i
     * @param index Posicion del elemento a eliminar
     */
    public void removeAt(int index) {
        if (index < size()) {
            if (index == 0) firstNode = firstNode.getNext();
            else {
                Nodo toRemove = firstNode;
                Nodo anterior = null;

                for (int i = 0; i < index; i++) {
                    if (index - 1 == i) anterior = toRemove;
                    toRemove = toRemove.getNext();
                }
                anterior.setNext(toRemove.getNext());
            }
            size--;
        }
    }

    /**
     * Comprueba si la lista esta vacia
     * @return Si esta vacia o no.
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Devuelve el tamaño actual de la lista
     * @return tamaño de la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Devuelve un objeto en la posicion i
     * @param i posicion del objeto en la lista.
     * @return
     */
    public Object at(int i) {
        if (i < size()) {
            Nodo n = firstNode;
            for (int j = 0; j < i; j++) n = n.getNext();
            return n;
        }
        return null;
    }


    /**
     * Comrpueba si un Object especifico existe en la lista
     * @param o Object a comprobar
     * @return Si existe o no.
     */
    public boolean contains(Object o) {
        Nodo n = firstNode;
        while (n != null && !n.equals(o)) n = n.getNext();
        return n != null;
    }

    /**
     * Elimina todos los elementos de la lista cambiando el tamaño de la lista a 0 y
     * se eliminan todas las referencias solo con asignarle Null al nodo inicial.
     */
    public void clear(){
        firstNode = null;
        size = 0;
    }

    /**
     * Clase Nodo utilizada para guardar los punteros de la lista.
     */
    protected class Nodo {

        private Nodo next;
        private Object value;

        Nodo(Object v) {
            value = v;
            next = null;
        }

        public Nodo getNext() {
            return next;
        }

        public void setNext(Object v) {
            if (next == null) next = new Nodo(v);
            else next.setNext(v);
        }

        public void setNext(Nodo n) {
            next = n;
        }

        public Object getValue() {
            return value;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Nodo) {
                return ((Nodo) obj).getValue().equals(value);
            }
            return obj.equals(value);
        }

        public String toString() {
            return value.toString();
        }
    }


}
