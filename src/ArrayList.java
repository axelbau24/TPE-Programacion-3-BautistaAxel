
public class ArrayList implements List {

    private Object[] data;
    private int size;
    private int initialSize;

    public ArrayList() {
        initialSize = 10000;
        data = new Object[initialSize];
        size = 0;
    }

    /**
     * Agrega un Object a la lista, si el tamaño de la lista supera del limite inicial (10000)
     * se crea un nuevo arreglo con el doble de su tamaño actual.
     * Si no, se escribe el valor sobre el arreglo actual.
     * @param value Valor a agregar
     */
    public void add(Object value) {
        if (size > data.length - 1) {
            Object newData[] = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;

        }
        data[size] = value;
        size++;
    }

    /**
     * Devuelve un objeto en la posicion i
     * @param index posicion del objeto en la lista.
     * @return
     */
    public Object at(int index) {
        return data[index];
    }

    /**
     * Comprueba si la lista esta vacia
     * @return Si esta vacia o no.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Devuelve el tamaño actual de la lista
     * @return tamaño de la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Elimina de la lista un Object especifico
     *
     * @param value Object a elminar
     */
    public void remove(Object value) {
        int i = 0;
        while (i < size() && !data[i].equals(value)) i++;
        if (i < size()) deleteValue(i);
    }

    /**
     * Elimina de la lista el elemento en la posicion i
     * @param index Posicion del elemento a eliminar
     */
    public void removeAt(int index) {
        if (index < size()) deleteValue(index);
    }

    /**
     * Corrimiento hacia la izquierda del arreglo utilizado por la lista,
     * es utilizado para eliminar valores de esta.
     * @param index Posicion donde se hara el corrimiento
     */
    private void deleteValue(int index) {
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * Comprueba si un Object especifico existe en la lista
     * @param o Object a comprobar
     * @return Si existe o no.
     */
    public boolean contains(Object o){
        int i = 0;
        while (i < size() && !data[i].equals(o)) i++;
        return i < size();
    }

    /**
     * Elimina todos los elementos de la lista, reiniciando el arreglo contenedor de los datos
     * y cambiando el tamaño de la lista a 0.
     */
    public void clear(){
        data = new Object[initialSize];
        size = 0;
    }

}
