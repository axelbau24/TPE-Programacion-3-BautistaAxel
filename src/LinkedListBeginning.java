
public class LinkedListBeginning extends LinkedList {

    /**
     * Agrega un Object siempre al principo
     * @param value Object a agregar
     */
    public void add(Object value) {
        Nodo n = new Nodo(value);
        n.setNext(firstNode);
        firstNode = n;
        size++;
    }
}
