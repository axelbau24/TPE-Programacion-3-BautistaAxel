
public class OperationAdd implements OperationType {

    /**
     * Metodo encargado de realizar las pruebas de tiempo para el agregado
     * de usuarios a una lista.
     *
     * @param lineData Linea con los datos del usuario
     * @param userList Lista de usuarios actual
     * @param lines Lista de lineas a agregar para la salida del archivo CSV.
     */
    public void createLine(String[] lineData, List userList, List lines) {

        Usuario u = new Usuario(lineData);

        long startTime = System.nanoTime();

        userList.add(u);

        long end = System.nanoTime();

        String separator = ";";
        String line = u.getId() + separator + (end - startTime);
        lines.add(line);

    }
}
