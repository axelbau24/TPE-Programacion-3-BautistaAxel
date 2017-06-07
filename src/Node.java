
public class Node {

    private String value;
    private int id;
    private NodeType type;

    public Node(String value, NodeType type) {
        this(-1, value, type);
    }

    public Node(int id, String value, NodeType type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public NodeType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Object obj) {
        Node n = (Node) obj;
        return value.equals(n.value) && type == n.type;
    }

    public String toString() {
        return value;
    }
}
