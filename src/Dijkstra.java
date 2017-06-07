public class Dijkstra {

    private static Node origin = null;
    private static GrafoGustos graph;

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
