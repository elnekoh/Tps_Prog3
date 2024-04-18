import java.util.Iterator;

public class NodeIterator<T extends Comparable<T>> implements Iterator<Node<T>> {
    private Node<T> cursor;

    public NodeIterator(Node<T> cursor){
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public Node<T> next() {
        Node<T> node = this.cursor;
        this.cursor = this.cursor.getNext();
        return node;
    }
}