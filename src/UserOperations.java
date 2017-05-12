import java.io.*;

public class UserOperations {

    private List userList;
    private ArrayList csvLines;

    public UserOperations(List testList) {
        csvLines = new ArrayList();
        userList = testList;
    }

    /**
     * Metodo encargado de leer archivos CSV, cada linea se ira guardando en una lista
     * y se realiza una operacion sobre esta.
     * @param operationType Tipo de operacion a realizar (busqueda o inserciones)
     * @param datasetPath Ruta del archivo CSV a leer.
     */
    public void readCSV(OperationType operationType, String datasetPath) {
        String line;
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(datasetPath))) {
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(cvsSplitBy);

                operationType.createLine(lineData, userList, csvLines);

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Escribe los datos que existen en la lista "csvLines" en un archivo especifico
     * @param path Ruta a crear para el archivo.
     */
    public void writeData(String path) {

        BufferedWriter bw = null;
        try {
            File file = new File(path);
            if (!file.exists()) file.createNewFile();

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < csvLines.size(); i++) {
                String contenidoLinea = (String) csvLines.at(i);
                bw.write(contenidoLinea);
                bw.newLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            try {
                if (bw != null)
                    bw.close();
            }
            catch (Exception ex) {
                System.out.println("Error cerrando el BufferedWriter" + ex);
            }
        }
        csvLines.clear();
    }

}