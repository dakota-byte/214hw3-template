package cse214hw3;

import java.util.LinkedList;
import java.util.List;

public class Node<E> {

    /**
     * @return <code>true</code> if and only if this node is a leaf node.
     */
    public boolean isLeaf() {
        return false;
    }

    /**
     * @return <code>true</code> if and only if this node is a full node, i.e., it has the maximum
     * possible number of elements permitted by the minimum degree of the B-tree.
     */
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        return toString(0);
    }
    // based on what toString() does, think about what ‘elements’ and ‘children’ can be
    private String toString(int depth) {
        StringBuilder builder = new StringBuilder();
        String blankPrefix = new String(new char[depth]).replace("\0", "\t");
        List<String> printedElements = new LinkedList<>();
        for (E e : elements) printedElements.add(e.toString());
        String eString = String.join(" :: ", printedElements);
        builder.append(blankPrefix).append(eString).append("\n");
        children.forEach(c -> builder.append(c.toString(depth + 1)));
        return builder.toString();
    }
}
