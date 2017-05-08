
public interface List {

    void add(Object value);

    void remove(Object value);

    void removeAt(int index);

    Object at(int index);

    boolean isEmpty();

    boolean contains(Object value);

    int size();

    void clear();

}
