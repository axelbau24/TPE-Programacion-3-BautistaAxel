public class Dijkstra {

    private static Node origin = null;
    private static GrafoGustos graph;

    /**
     * Encargado de llenar el array de caminos con las distancias correspondientes
     * @param start Nodo inicial
     * @param verts Array de nodos
     * @param paths Array de los caminos actual
     */
    private static void fillDistances(Node start, Object[] verts, int[] paths) {
        int startIndex = start.getId();
        for (int i = 0; i < verts.length; i++) {
            Object v = verts[i];
            if (graph.vecinos(start).contains(v) && !v.equals(origin)) {
                if (paths[startIndex] + 1 < paths[i] || paths[i] == 0) {
                    paths[i] = paths[startIndex] + 1;
                }
            }
        }
    }


    /**
     *
     * Encargado de generar el array con los caminos desde el origen
     * hacia todos los nodos del grafo.
     * @param startNode Nodo origen
     * @param graph Grafo
     * @return Array con la cantidad de saltos necesaria para llegar a cada nodo
     */
    public static int[] shortestPaths(Node startNode, GrafoGustos graph) {
        Dijkstra.graph = graph;
        Object[] vertices = graph.getVertices();
        int[] paths = new int[vertices.length];

        Node[] nav = new Node[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            nav[i] = (Node) vertices[i];
        }
        origin = startNode;

        for (int i = 0; i < vertices.length; i++) {
            fillDistances(startNode, nav, paths);
            int index = getClosestIndex(paths, nav);
            if (index != -1) {
                startNode = nav[index];
                nav[index] = null;
            }
        }

        return paths;
    }


    /**
     * Se obtiene la posicion mas cercana al origen
     * @param paths Caminos actuales
     * @param nav Array de nodos
     * @return Indice del nodo mas cercano
     */
    private static int getClosestIndex(int[] paths, Object[] nav) {
        int value = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < paths.length; i++) {
            if (nav[i] != null && paths[i] != 0 && value > paths[i]) {
                value = paths[i];
                index = i;
            }
        }
        return index;

    }

}
