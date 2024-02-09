/**
 * This is the DFS solution to the Custom Rat part of the assignment.
 *
 * It makes use of the Tree, and Node classes, along with a visited HashMap. It starts by building
 * a root in the tree, sets the node as visited, then it computes the neighbours of this root Node (if
 * they haven't already been computed). Finally, it finds the next node to travel to by:
 * (1) checking for the next unvisited neighbour (in a structured direction), or
 * (2) going back to the parent node if there are no unvisited neighbours left.
 *
 * On the next call to move, we move to the new Node that was computed, and then we find the next
 * direction as desribed above. This ends up giving us a DFS search as we're always going to the
 * next available neighbour in an ordered fashion (see `Rat.fillDirections`).
 *
 * @author Gregory Mierzwinski
 *
 */

import java.util.*;

public class DepthFirstRat extends Rat {
    private Tree mazeTree;
    private Node currentNode;
    private HashMap<String, Boolean> visited;

    public DepthFirstRat() {
        this.name = "DFS";
        this.mazeTree = new Tree();
        this.visited = new HashMap<String, Boolean>();
        this.fillDirections();
    }

    public void getNeighbours(Maze maz, Node n) {
        for (ArrayList<Integer> direction : this.directions) {
            Node tmpNode = new Node(
                    n.getRow() + direction.get(0),
                    n.getCol() + direction.get(1),
                    n,
                    null
            );

            // Skip the node if it's the current node's parent
            if (n.getParent() != null && n.getParent().equals(tmpNode)) {
                continue;
            }

            // Don't add the node if something has already visited it
            if (this.visited.get(tmpNode.toString()) != null) {
                continue;
            }

            // Add the neighbour if we can move to it
            if (maz.canMove(tmpNode.getRow(), tmpNode.getCol())) {
                n.addNeighbour(tmpNode);
            }
        }
    }

    public void moveTo(Node n) {
        this.currentCol = n.getCol();
        this.currentRow = n.getRow();
        n.visit();
    }

    @Override
    public void move(Maze maz) {
        if (this.mazeTree.getRoot() == null) {
            // Set the root of the maze if we haven't
            // already
            this.mazeTree.setRoot(
                    new Node(
                            this.getRow(),
                            this.getColumn(),
                            null,
                            null
                    )
            );
            this.currentNode = this.mazeTree.getRoot();
        }

        // Move to this new node and set it as visited
        this.moveTo(this.currentNode);
        this.numMoves++;

        // Add it to the set of visited nodes
        this.visited.put(this.currentNode.toString(), true);

        // Get its neighbours
        if (this.currentNode.getNeighbours() == null) {
            this.getNeighbours(maz, this.currentNode);
        }

        // While the neighbour has already been visited, go to the next one
        Node tmpNode = this.currentNode.getNextNeighbour();
        while(tmpNode != null && this.visited.get(tmpNode.toString()) != null) {
            tmpNode.visit();
            tmpNode = this.currentNode.getNextNeighbour();
        }

        // If the neighbour node is still null, go back to the parent
        if (tmpNode == null) {
            tmpNode = this.currentNode.getParent();
        }
        this.currentNode = tmpNode;

    }
}
