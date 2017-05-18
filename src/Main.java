
public class Main {

    final static String addPath = "C:/Datasets/Tests/salidaalta"; // Sin .csv
    final static String searchPath = "C:/Datasets/Tests/salidabusqueda"; // Sin .csv
    final static String searchInputPath = "C:/Datasets/dataset_busqueda_10000.csv";
    final static String insertInputPath = "C:/Datasets/dataset_insert_10000.csv";

    public static void main(String[] args) {


        String dataSet500 = "C:/Datasets/dataset_500000.csv";
        String dataSet1m = "C:/Datasets/dataset_1000000.csv";
        String dataSet3m = "C:/Datasets/dataset_3000000.csv";

        // Pruebas con ArrayList con búsqueda binaria
        // Se agregan 10 mil usuarios y se realizan 3 millones de búsquedas

        realizarPrueba(new ArrayListBinary(), insertInputPath, dataSet3m, "_AL_500");

        // Se agregan 3 millones de  usuarios y se realizan 10 mil de búsquedas
        realizarPrueba(new ArrayListBinary(), dataSet3m, insertInputPath, "_AL_3M");

    }

    /**
     * Se encarga de realizar las pruebas completas y crear los archivos de salida de
     * insercion y busqueda necesarios
     *
     * @param listType    Tipo de lista a utilizar
     * @param dataSetPath Ruta del dataset de usuarios
     * @param searchDataset Ruta del dataset de donde se realizaran busquedas.
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
