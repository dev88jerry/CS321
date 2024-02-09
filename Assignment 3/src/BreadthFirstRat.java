/**
 * This is the BFS solution to the Custom Rat part of the assignment.
 *
 * This method is very similar to the DFS solution (see that one first). It uses additional variables
 * such as te LinkedList as a queue of the next Nodes to check. It also holds a new variable for
 * remembering where it's trying to get to.
 *
 * As in the DFS solution, we start by building the root of the tree. Then, as we aren't looking for
 * another node, we get the neighbours of the root (in the exact same way as for the DFS). At the same time,
 * we add these to the queue of the next Nodes to check, and the HashMap of the nodes that were inserted
 * into the tree. Now, we get the next node to go check, check if the current Node we are at is a
 * parent, and then:
 * (1) If it's a parent, among the parent's children/neighbours, find the common ancestor (child) between the parent and the next Node.
 * (2) If it isn't a parent, then move up in the Tree to the parent to check its parent on the next iteration.
 *
 * On the next iteration, we'll move to the new Node we found above. If we found it, then we'll gather the neighbours,
 * and find another node to search for from the LinkedList queue. Otherwise, we redo (1)/(2) above.
 *
 * @author Gregory Mierzwinski
 *
 */

import java.util.*;

public class BreadthFirstRat extends Rat {
    private Tree mazeTree;
    private Node currentNode;
    private Node nextNode;
    private HashMap<String, Boolean> visited; // Use hashmap for constant access
    private LinkedList<Node> nextNodes;

    public BreadthFirstRat() {
        this.name = "BFS";
        this.mazeTree = new Tree();
        this.visited = new HashMap<String, Boolean>();
        this.nextNodes = new LinkedList<Node>();
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
        // Move to the given node and set it to visited
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

        // If we aren't looking for the next node to visit, or we've found it
        // then get the neighbours, set them as visited, and add them to the queue.
        if (this.nextNode == null || this.currentNode == this.nextNode) {
            // Get its neighbours
            if (this.currentNode.getNeighbours() == null) {
                this.getNeighbours(maz, this.currentNode);
                this.visited.put(this.currentNode.toString(), true);

                // Add all the neighbours to the queue of next nodes to check
                if (this.currentNode.getNeighbours() != null) {
                    for (Node neighbour : this.currentNode.getNeighbours()) {
                        this.nextNodes.add(neighbour);
                        this.visited.put(neighbour.toString(), true);
                    }
                }
            }

            // Get the next node to visit
            this.nextNode = nextNodes.removeFirst();
        }

        // If the current node is a parent of the node we are searching
        // for, then find the correct neighbour to move to.
        if (this.currentNode.isParent(this.nextNode)) {
            for (Node neighbour : this.currentNode.getNeighbours()) {
                if (neighbour.equals(this.nextNode) || neighbour.isParent(this.nextNode)) {
                    this.currentNode = neighbour;
                    break;
                }
            }
        } else {
            // If not, check the parent
            this.currentNode = currentNode.getParent();
        }
    }
}
