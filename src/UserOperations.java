import java.io.*;

public class UserOperations {

    private GrafoGustos graph;

    public UserOperations(GrafoGustos graph) {
        this.graph = graph;
    }

    /**
     * Metodo encargado de leer archivos CSV, cada linea se ira guardando en una lista
     * y se realiza una operacion sobre esta.
     *
     * @param datasetPath   Ruta del archivo CSV a leer.
     */
    public void readCSV(String datasetPath) {
        String line;
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(datasetPath))) {
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(cvsSplitBy);
                addUser(lineData);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String[] data) {
        if (!data[0].contains("DNI")) {

            Usuario u = new Usuario(data);
            String userId = Integer.toString(u.getId());
            graph.addUsuario(userId);

            LinkedList gustos = u.getGustos();

            for (int i = 0; i < gustos.size(); i++) {
                String gusto = (String) gustos.at(i);
                graph.addGusto(gusto);
                graph.insertarArista(userId, gusto);
            }
        }
    }


}