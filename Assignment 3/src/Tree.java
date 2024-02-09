import java.util.ArrayList;

/*
    Used in the BFS and DFS algorithms.
 */

class Node {
    private int row;
    private int col;
    private boolean visited;
    private Node parent;
    private ArrayList<Node> neighbours;

    public Node(int row, int col, Node parent, ArrayList<Node> neighbours) {
        this.visited = false;
        this.row = row;
        this.col = col;
        this.parent = parent;
        this.neighbours = neighbours;
    }

    public ArrayList<Node> getNeighbours() {
        return this.neighbours;
    }

    public Node getParent() {
        return this.parent;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void visit() {
        this.visited = true;
    }

    public boolean isParent(Node n) {
        // Check if this node is the parent
        if (n.getParent().equals(this)) {
            return true;
        }
        // Check if any of its children is the parent
        if (this.getNeighbours() != null) {
            for (Node neighbour : this.getNeighbours()) {
                if (neighbour.isParent(n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addNeighbour(Node neighbour) {
        if (this.neighbours == null) {
            this.neighbours = new ArrayList<Node>();
        }
        this.neighbours.add(neighbour);
    }

    public Node getNextNeighbour() {
        // Returns the next unvisited neighbour (if they exist)
        if (this.getNeighbours() != null) {
            for (Node neighbour : this.getNeighbours()) {
                if (!neighbour.isVisited()) {
                    return neighbour;
                }
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        // Nodes are equal when their row/col are equal
        if (obj == null) {
            return false;
        }
        Node node = (Node) obj;
        return this.getRow() == node.getRow() && this.getCol() == node.getCol();
    }

    public String toString() {
        // Used for the HashMap as list hashcodes gets computed based
        // on the elements and does not incorporate the ordering.
        return String.format("Row: %s, Col: %s", this.getRow(), this.getCol());
    }
}


public class Tree {
    private Node root;

    public Tree() {}

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
