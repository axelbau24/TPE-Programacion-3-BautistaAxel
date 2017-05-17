
public class ArrayListBinary extends ArrayList{

    /**
     * Comprueba si un Object especifico existe en la lista utilizando busqueda binaria.
     * Antes de utilizar este metodo, la lista tiene que ordenarse
     * y los Object a buscar deben ser Comparable
     * @param o Object a comprobar
     * @return Si se encontro o no.
     */
    public boolean contains(Object o) {
        try {
            Comparable search = (Comparable) o;
            int start = 0;
            int end = size - 1;

            while (end >= start) {
                int mid = (start + end) / 2;
                Comparable midValue = (Comparable) data[mid];

                if (midValue.equals(search)) return true;
                if (midValue.compareTo(search) < 0) start = mid + 1;
                if (midValue.compareTo(search) > 0) end = mid - 1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object[] toArray(){
        return data;
    }
}
