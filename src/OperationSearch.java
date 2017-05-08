
public class OperationSearch implements OperationType {


    /**
     * Metodo encargado de realizar las pruebas de tiempo para buscar
     * usuarios en la lista.
     *
     * @param lineData Linea con los datos del usuario
     * @param userList Lista de usuarios actual
     * @param lines Lista de lineas a agregar para la salida del archivo CSV.
     */
    public void createLine(String[] lineData, List userList, List lines) {

        boolean existe;
        Usuario u = new Usuario(lineData);

        long startTime = System.nanoTime();

        existe = userList.contains(u);

        long end = System.nanoTime();

        String separator = ";";
        String line = u.getId() + separator + (end - startTime) + separator + existe;
        lines.add(line);

    }
}
