import java.util.List;
import java.util.ArrayList;


public class GrafoGustos extends GrafoDirigido {

    ArrayList<Integer> usuariosGrafo = new ArrayList<>(); // Todos los indices de usuarios en el grafo
    ArrayList<Integer> gustosGrafo = new ArrayList<>(); // Todos los indices de gustos en el grafo

    static final int MAX_GUSTOS_COMUN = 2;

    public void addUsuario(String userId) {
        usuariosGrafo.add(vertices.length);
        insertarVertice(userId);
    }

    public void addGusto(String gusto) {
        if (!existeGusto(gusto)) {
            gustosGrafo.add(vertices.length);
            insertarVertice(gusto);
        }
    }

    public void insertarArista(String userId, String gusto) {
        if (existeUsuario(userId) && existeGusto(gusto)) {
            super.insertarArista(userId, gusto);
            super.insertarArista(gusto, userId);
        }
    }

    public boolean existeGusto(String gusto) {
        return existeDato(gusto, gustosGrafo);
    }

    public boolean existeUsuario(String userID) {
        return existeDato(userID, usuariosGrafo);
    }

    private boolean existeDato(String dato, ArrayList<Integer> indices) {
        for (int i = 0; i < indices.size(); i++) {
            int index = indices.get(i);
            if (vertices[index].equals(dato)) return true;
        }
        return false;
    }

    public String getLejano(String userID) {
        int[] caminos = Dijkstra.shortestPaths(userID, this);
        int lejano = 0;
        int lejanoIndex = -1;

        for (int i = 0; i < usuariosGrafo.size(); i++) {
            int index = usuariosGrafo.get(i);
            if (caminos[index] > lejano) {
                lejano = caminos[index];
                lejanoIndex = index;
            }
        }

        return vertices[lejanoIndex].toString();
    }

    // TODO grado del grafo?
    public String getGustoMasGustado() {
        int cant = 0;
        String masGustado = null;

        for (int i = 0; i < gustosGrafo.size(); i++) {
            int gustoIndex = gustosGrafo.get(i);
            String gusto = (String) vertices[gustoIndex];
            int cantGente = vecinos(gusto).size();
            if (cantGente > cant) {
                cant = cantGente;
                masGustado = gusto;
            }
        }

        return masGustado;
    }

    // Dado un usuario, mostrarle las personas que tienen más de un gusto en común con él
    public ArrayList personasGustoComun(String user) {
        ArrayList<String> personas = new ArrayList<>();

        List<Object> v = vecinos(user);

        for (int i = 0; i < usuariosGrafo.size(); i++) {
            int userIndex = usuariosGrafo.get(i);
            String userId = (String) vertices[userIndex];

            if (!userId.equals(user) && contains(v, vecinos(userId))) personas.add(userId);

        }
        return personas;
    }

    public boolean contains(List<Object> gustos, List<Object> gustos1) {
        int cant = 0;

        for (Object g : gustos) {
            if (gustos1.contains(g)) cant++;
            if (cant >= MAX_GUSTOS_COMUN) return true;
        }
        return false;
    }


}
