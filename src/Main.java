import java.util.Arrays;

public class Main {

    final static String addPath = "C:/Datasets/Tests/salidaalta"; // Sin .csv
    final static String searchPath = "C:/Datasets/Tests/salidabusqueda"; // Sin .csv
    final static String searchInputPath = "C:/Datasets/dataset_busqueda_10000.csv";
    final static String insertInputPath = "C:/Datasets/dataset_insert_10000.csv";

    public static void main(String[] args) {


        String dataSet500 = "C:/Datasets/dataset_500000.csv";
        String dataSet1m = "C:/Datasets/dataset_1000000.csv";
        String dataSet3m = "C:/Datasets/dataset_3000000.csv";

        GrafoGustos grafo = new GrafoGustos();

        Usuario u1 = new Usuario(new String[]{"21444758", "Tenis", "Futbol"});
        Usuario u2 = new Usuario(new String[]{"5487866", "Futbol"});
        Usuario u3 = new Usuario(new String[]{"54788865", "Futbol", "Tenis", "Golf", "Handball"});
        Usuario u4 = new Usuario(new String[]{"67545565", "Tenis", "Futbol", "Golf", "Equitacion", "Handball"});
        Usuario u5 = new Usuario(new String[]{"65324548", "Equitacion", "Handball"});

        grafo.addUsuario(Integer.toString(u5.getId()));
        grafo.addUsuario(Integer.toString(u1.getId()));
        grafo.addUsuario(Integer.toString(u2.getId()));
        grafo.addUsuario(Integer.toString(u3.getId()));
        grafo.addUsuario(Integer.toString(u4.getId()));

        for (int i = 0; i < u1.getGustos().size(); i++) {
            String gusto = u1.getGustos().at(i).toString();
            grafo.addGusto(gusto);
            grafo.insertarArista(Integer.toString(u1.getId()), gusto);
        }

        for (int i = 0; i < u2.getGustos().size(); i++) {
            String gusto = u2.getGustos().at(i).toString();
            grafo.addGusto(gusto);
            grafo.insertarArista(Integer.toString(u2.getId()), gusto);
        }

        for (int i = 0; i < u3.getGustos().size(); i++) {
            String gusto = u3.getGustos().at(i).toString();
            grafo.addGusto(gusto);
            grafo.insertarArista(Integer.toString(u3.getId()), gusto);
        }

        for (int i = 0; i < u4.getGustos().size(); i++) {
            String gusto = u4.getGustos().at(i).toString();
            grafo.addGusto(gusto);
            grafo.insertarArista(Integer.toString(u4.getId()), gusto);
        }

        for (int i = 0; i < u5.getGustos().size(); i++) {
            String gusto = u5.getGustos().at(i).toString();
            grafo.addGusto(gusto);
            grafo.insertarArista(Integer.toString(u5.getId()), gusto);
        }


        System.out.println(grafo.getGustoMasGustado());

        System.out.println(grafo.getLejano("5487866"));
        
        System.out.println(grafo.personasGustoComun("67545565"));


    }

    public static void realizarPrueba(GrafoGustos graph, String dataSetPath) {
        UserOperations csv = new UserOperations(graph);

        csv.readCSV(dataSetPath); // Se agregan los usuarios al grafo

    }
}
