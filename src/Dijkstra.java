public class Dijkstra {

    private static Object origin = null;
    private static GrafoGustos graph;

    private static void fillDistances(Object start, Object[] verts, int[] paths) {
        for (Object v : verts) {
            if (graph.vecinos(start).contains(v) && !v.equals(origin)) {
                int index = getIndex(v);
                int startIndex = getIndex(start);
                if (paths[startIndex] + 1 < paths[index] || paths[index] == 0) {
                    paths[index] = paths[startIndex] + 1;
                }
            }
        }
    }


    public static int[] shortestPaths(Object startNode, GrafoGustos graph) {
        Dijkstra.graph = graph;
        Object[] vertices = graph.getVertices();
        int[] paths = new int[vertices.length];

        Object[] nav = new Object[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            nav[i] = vertices[i];
        }
        origin = startNode;

        for (int i = 0; i < vertices.length - 1; i++) {
            fillDistances(startNode, nav, paths);
            int index = getClosestIndex(paths, nav);
            if (index != -1) {
                startNode = nav[index];
                nav[index] = null;
            }
        }

        return paths;
    }


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

    private static int getIndex(Object vertice) {
        Object[] vertices = graph.getVertices();
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertice)) return i;
        }
        return -1;
    }
}
