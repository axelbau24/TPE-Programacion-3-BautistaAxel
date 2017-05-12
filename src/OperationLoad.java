
public class OperationLoad implements OperationType {


    public void createLine(String[] lineData, List userList, List lines) {

        if (!lineData[0].contains("DNI")) {
            Usuario u = new Usuario(lineData);
            userList.add(u);
        }


    }
}
