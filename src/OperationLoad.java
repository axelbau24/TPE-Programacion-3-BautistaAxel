
public class OperationLoad implements OperationType {


    public void createLine(String[] lineData, List userList, List lines) {

            Usuario u = new Usuario(lineData);
            userList.add(u);

    }
}
