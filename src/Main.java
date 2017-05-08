

public class Main {

    final static String addPath = "C:/Datasets/Tests/salidaalta"; // Sin .csv
    final static String searchPath = "C:/Datasets/Tests/salidabusqueda"; // Sin .csv
    final static String searchInputPath = "C:/Datasets/dataset_busqueda_10000.csv";

    public static void main(String[] args) {

        String dataSet500 = "C:/Datasets/dataset_500000.csv";
        String dataSet1m = "C:/Datasets/dataset_1000000.csv";
        String dataSet3m = "C:/Datasets/dataset_3000000.csv";


        // Pruebas con ArrayList y Dataset 500 mil
        realizarPrueba(new ArrayList(), dataSet500, "_AL_500");
        // Pruebas con ArrayList y Dataset 1 millon
        realizarPrueba(new ArrayList(), dataSet1m, "_AL_1M");
        // Pruebas con ArrayList y Dataset 3 millones
        realizarPrueba(new ArrayList(), dataSet3m, "_AL_3M");

        // Pruebas con LinkedList y Dataset 500 mil
        realizarPrueba(new LinkedList(), dataSet500, "_LL_500");
        // Pruebas con LinkedList y Dataset 1 millon
        realizarPrueba(new LinkedList(), dataSet1m, "_LL_1M");
        // Pruebas con LinkedList y Dataset 3 millones
        realizarPrueba(new LinkedList(), dataSet3m, "_LL_3M");

        // Pruebas con LinkedListBeginning y Dataset 500 mil
        realizarPrueba(new LinkedListBeginning(), dataSet500, "_LB_500");
        // Pruebas con LinkedListBeginning y Dataset 1 millon
        realizarPrueba(new LinkedListBeginning(), dataSet1m, "_LB_1M");
        // Pruebas con LinkedListBeginning y Dataset 3 millones
        realizarPrueba(new LinkedListBeginning(), dataSet3m, "_LB_3M");


    }

    /**
     * Se encarga de realizar las pruebas completas y crear los archivos de salida de
     * insercion y busqueda necesarios
     * @param listType Tipo de lista a utilizar
     * @param dataSetPath Ruta del dataset de usuarios
     * @param id Identificador agregado al final del nombre del archivo para saber que operacion fue realizada
     */
    public static void realizarPrueba(List listType, String dataSetPath, String id) {
        UserOperations csv = new UserOperations(listType);
        String ext = ".csv";

        csv.readCSV(new OperationAdd(), dataSetPath);
        csv.writeData(addPath + id + ext);
        csv.readCSV(new OperationSearch(), searchInputPath);
        csv.writeData(searchPath + id + ext);
    }
}
