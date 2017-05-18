
public class OperationLoad implements OperationType {

    /**
     * Metodo para hacer carga de usuarios sobre un tipo de lista.
     * @param lineData Linea con los datos del usuario
     * @param userList Lista de usuarios actual
     * @param lines No se usa
     */
    public void createLine(String[] lineData, List userList, List lines) {

            Usuario u = new Usuario(lineData);
            userList.add(u);

    }
}
