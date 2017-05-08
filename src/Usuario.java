
public class Usuario {

    private LinkedListBeginning gustos;
    private int id;

    /**
     * Se crea un usuario con los los datos generados de una linea del CSV
     *
     * @param datos Linea del CSV
     */
    public Usuario(String[] datos) {
        // Se utiliza una Lista Vinculada con insercion al principio para guardar los gustos.
        gustos = new LinkedListBeginning();
        this.id = Integer.valueOf(datos[0]);

        for (int i = 1; i < datos.length; i++) {
            String gusto = datos[i];
            // Antes de agregar un gusto, se comprueba que ya no exista
            if (!gustos.contains(gusto)) gustos.add(gusto);
        }
    }

    public int getId() {
        return id;
    }

    public String toString() {
        String s = id + " : ";
        for (int i = 0; i < gustos.size(); i++) {
            s += gustos.at(i) + " ";
        }
        return s;
    }

    public boolean equals(Object obj) {
        return ((Usuario) obj).id == id;
    }
}
