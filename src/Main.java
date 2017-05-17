
public class Main {

    final static String addPath = "C:/Datasets/Tests/salidaalta"; // Sin .csv
    final static String searchPath = "C:/Datasets/Tests/salidabusqueda"; // Sin .csv
    final static String searchInputPath = "C:/Datasets/dataset_busqueda_10000.csv";
    final static String insertInputPath = "C:/Datasets/dataset_insert_10000.csv";

    public static void main(String[] args) {

        String dataSet500 = "C:/Datasets/dataset_500000.csv";
        String dataSet1m = "C:/Datasets/dataset_1000000.csv";
        String dataSet3m = "C:/Datasets/dataset_3000000.csv";

        // Pruebas con ArrayList y Dataset 500 mil
        realizarPrueba(new ArrayListBinary(), searchInputPath, dataSet3m, "_AL_500");
        // Pruebas con ArrayList y Dataset 3 millones
        realizarPrueba(new ArrayListBinary(), dataSet3m, searchInputPath, "_AL_3M");

    }

    /**
     * Se encarga de realizar las pruebas completas y crear los archivos de salida de
     * insercion y busqueda necesarios
     *
     * @param listType    Tipo de lista a utilizar
     * @param dataSetPath Ruta del dataset de usuarios
     * @param id          Identificador agregado al final del nombre del archivo para saber que operacion fue realizada
     */
    public static void realizarPrueba(ArrayListBinary listType, String dataSetPath, String searchDataset,String id) {
        UserOperations csv = new UserOperations(listType);
        String ext = ".csv";

        csv.readCSV(new OperationLoad(), dataSetPath); // Se hace la precarga
        MergeSort.sort(listType);
        csv.readCSV(new OperationSearch(), searchDataset);
        csv.writeData(searchPath + id + ext);
    }


}
