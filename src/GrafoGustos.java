import java.util.List;
import java.util.ArrayList;

public class GrafoGustos extends Grafo {

    private static final int MAX_GUSTOS_COMUN = 2;

    /**
     * Se agrega un usuario al grafo siempre que este no exista
     *
     * @param userId Usuario a agregar
     */
    public void addUsuario(String userId) {
        if (!existeUsuario(userId)) {
            Node user = new Node(vertices.length, userId, NodeType.USUARIO);
            insertarVertice(user);
        }
    }

    /**
     * Se agrega un gusto al grafo siempre que este no exista
     *
     * @param gusto Gusto a agregar
     */
    public void addGusto(String gusto) {
        if (!existeGusto(gusto)) {
            Node g = new Node(vertices.length, gusto, NodeType.GUSTO);
            insertarVertice(g);
        }
    }

    /**
     * Se crea un arista entre un usuario y un gusto y viceversa.
     *
     * @param userId ID del usuario
     * @param gusto Gusto
     */
    public void insertarArista(String userId, String gusto) {
        if (existeUsuario(userId) && existeGusto(gusto)) {

            Node user = new Node(userId, NodeType.USUARIO);
            Node g = new Node(gusto, NodeType.GUSTO);

            super.insertarArista(user, g);
            super.insertarArista(g, user);
        }
    }

    /**
     * Comprueba si existe un gusto especifico
     *
     * @param gusto Gusto a buscar
     * @return Si existe o no
     */
    public boolean existeGusto(String gusto) {
        return existeDato(gusto, NodeType.GUSTO);
    }

    /**
     * Comprueba si existe un usuario especifico
     *
     * @param userID Usuario a buscar
     * @return Si existe o no
     */
    public boolean existeUsuario(String userID) {
        return existeDato(userID, NodeType.USUARIO);
    }

    /**
     * Dado un una lista de indices del grafo, se busca si existe un dato en el grafo
     *
     * @param dato Dato a buscar en el grafo
     * @param tipo Tipo de dato a buscar
     * @return Si existe o no
     */
    private boolean existeDato(String dato, NodeType tipo) {
        Node nodo = new Node(dato, tipo);
        for (Object o : vertices) {
            Node n = (Node) o;
            if (nodo.equals(n)) return true;
        }
        return false;
    }

    /**
     * Dado un ID de usuario, se busca el usuario que mas lejos este
     * en terminos de cantidad de saltos en el grafo
     *
     * @param userID ID del usuario
     * @return ID de Usuario mas lejano al dado
     */
    public String getLejano(String userID) {
        Node usuario = buscarDato(userID, NodeType.USUARIO);

        int[] caminos = Dijkstra.shortestPaths(usuario, this);
        int lejano = 0;
        int lejanoIndex = -1;

        for (int i = 0; i < caminos.length; i++) {

            Node node = (Node) vertices[i];
            if (node.getType() == NodeType.USUARIO) {
                if (caminos[i] > lejano) {
                    lejano = caminos[i];
                    lejanoIndex = i;
                }
            }
        }

        return vertices[lejanoIndex].toString();
    }


    /**
     * Busca un Nodo en el grafo dado un dato y tipo de nodo.
     * @param dato Dato a buscar
     * @param tipo Tipo del nodo
     * @return El nodo deseado (Con ID)
     */
    private Node buscarDato(String dato, NodeType tipo) {
        Node n = new Node(dato, tipo);

        for (Object o : vertices) {
            Node node = (Node) o;
            if (node.equals(n)) return (Node) o;
        }

        return null;

    }

    /**
     * Se obtiene el gusto que tiene mayor cantidad de vecinos del grafo (El más gustado)
     *
     * @return Gusto que más le gusta a la gente.
     */
    public String getGustoMasGustado() {
        int cant = 0;
        String masGustado = null;

        for (Object o : vertices) {
            Node gusto = (Node) o;
            if (gusto.getType() == NodeType.GUSTO) {

                int cantGente = vecinos(gusto).size();

                if (cantGente > cant) {
                    cant = cantGente;
                    masGustado = gusto.getValue();
                }
            }
        }
        return masGustado;
    }

    /**
     * Dado un usuario, se obtienen todos los usuarios que tengan mas de 2 gustos
     * en comun.
     *
     * @param user usuario a buscar gustos en comun
     * @return Lista de usuarios que cumplen la condicion
     */
    public ArrayList<String> personasGustoComun(String user) {
        ArrayList<String> personas = new ArrayList<>();

        Node usuario = new Node(user, NodeType.USUARIO);
        List<Object> v = vecinos(usuario);

        for (Object o : vertices) {
            Node n = (Node) o;
            if (n.getType() == NodeType.USUARIO) {
                if (!n.equals(usuario) && contains(v, vecinos(n))) personas.add(n.getValue());
            }
        }
        return personas;
    }

    /**
     * Se busca entre los gustos de un usuario, que al menos 2 (MAX_GUSTOS_COMUN) esten
     * en los gustos de otro usuario
     *
     * @param gustos  Gustos del usuario
     * @param gustos1 Gustos del usuario a comparar
     * @return Si ese usuario a comparar tiene gustos en comun
     */
    private boolean contains(List<Object> gustos, List<Object> gustos1) {
        int cant = 0;

        for (Object g : gustos) {
            if (gustos1.contains(g)) cant++;
            if (cant >= MAX_GUSTOS_COMUN) return true;
        }
        return false;
    }

}
