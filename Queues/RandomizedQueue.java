import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] items;
    private int size;
    private class RandomizedQueueIterator implements Iterator<Item>
    {
        private Item[] itemsCopy;
        private int sizeCopy;
        private RandomizedQueueIterator()
        {
            sizeCopy = size;
            itemsCopy = (Item[]) new Object[sizeCopy];

            for (int i = 0; i < sizeCopy; i++) {
                itemsCopy[i] = items[i];
            }
        }

        public boolean hasNext()
        {
            return (sizeCopy > 0);
        }

        public Item next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int index = StdRandom.uniform(sizeCopy);
            Item item = itemsCopy[index];
            itemsCopy[index] = itemsCopy[sizeCopy - 1];
            itemsCopy[sizeCopy - 1] = null;
            sizeCopy--;

            return item;
        }
    }

    // construct an empty randomized queue
    public RandomizedQueue()
    {
        int defaultItemsSize = 2;

        items = (Item[]) new Object[defaultItemsSize];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty()
    {
        return (size == 0);
    }

    // return the number of items on the queue
    public int size()
    {
        return size;
    }

    // add the item
    public void enqueue(Item item)
    {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (size == items.length) {
            resizeItems(items.length * 2);
        }

        items[size] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue()
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int index = StdRandom.uniform(size);
        Item item = items[index];

        items[index] = items[size - 1];
        items[size - 1] = null;
        size--;

        if (size > 0 && (size == items.length / 4)) {
            resizeItems(items.length / 2);
        }

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample()
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int index = StdRandom.uniform(size);

        return items[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
        return new RandomizedQueueIterator();
    }

    // resize items array
    private void resizeItems(int length) {
        Item[] newItems = (Item[]) new Object[length];

        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }

        items = newItems;
    }

    // unit testing
    public static void main(String[] args)
    {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        String text = "A";
        queue.enqueue(text);
        StdOut.println(text);
        text = "B";
        queue.enqueue(text);
        StdOut.println(text);
        queue.dequeue();
        queue.sample();
        for (String item: queue) {
            StdOut.println(item);
        }
    }
}
