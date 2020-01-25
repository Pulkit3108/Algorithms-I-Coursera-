import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
public class Deque<Item> implements Iterable<Item>
{
    private int size;
    private Node<Item> first;
    private Node<Item> last;
    private class Node<Item>
    {
        Item item;
        Node<Item> next;
        Node<Item> previous;
    }
    private class DequeIterator<Item> implements Iterator<Item>
    {
        private Node<Item> current;
        private DequeIterator(Node<Item> item)
        {
            current = item;
        }

        public boolean hasNext()
        {
            return (current != null);
        }

        public Item next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    // construct an empty deque
    public Deque()
    {
        size = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return (size == 0);
    }

    // return the number of items on the deque
    public int size()
    {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node<Item> newItem = new Node<>();
        newItem.item = item;
        newItem.next = first;
        newItem.previous = null;

        if (isEmpty()) {
            last = newItem;
        } else {
            first.previous = newItem;
        }

        first = newItem;
        size++;
    }

    // add the item to the end
    public void addLast(Item item)
    {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node<Item> newItem = new Node<>();
        newItem.item = item;
        newItem.next = null;
        newItem.previous = last;

        if (isEmpty()) {
            first = newItem;
        } else {
            last.next = newItem;
        }

        last = newItem;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst()
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = first.item;
        first = first.next;
        size--;

        if (isEmpty()) {
            last = null;
        } else {
            first.previous = null;
        }

        return item;
    }

    // remove and return the item from the end
    public Item removeLast()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        Item item = last.item;
        last = last.previous;
        size--;

        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }

        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator()
    {
        return new DequeIterator<>(first);
    }

    // unit testing
    public static void main(String[] args)
    {
        Deque<String> deque = new Deque<>();
        String text = "A";
        deque.addFirst(text);
		StdOut.println(text);
        text = "B";
        deque.addFirst(text);
		StdOut.println(text);
        text = "C";
        deque.addLast(text);
        deque.removeFirst();
        deque.removeLast();
        text = "D";
        deque.addLast(text);
        for (String item: deque) {
            StdOut.println(item);
        }
    }
}
