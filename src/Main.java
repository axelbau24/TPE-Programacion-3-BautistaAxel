
public class Main {

    final static String insertInputPath = "C:/Datasets/dataset_insert_10000.csv";

    public static void main(String[] args) {

        GrafoGustos grafo = new GrafoGustos();

        // Se agregan 10000 personas al grafo con sus respectivos gustos.
        realizarPrueba(grafo, insertInputPath);

        System.out.println(grafo.getGustoMasGustado());

        System.out.println(grafo.getLejano("35729422"));

        System.out.println(grafo.personasGustoComun("82181276"));

    }

    public static void realizarPrueba(GrafoGustos graph, String dataSetPath) {
        UserOperations csv = new UserOperations(graph);

        csv.readCSV(dataSetPath); // Se agregan los usuarios al grafo

    }
}
