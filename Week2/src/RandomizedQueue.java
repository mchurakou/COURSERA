import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private ArrayList<Item> list;

    // construct an empty randomized queue


    public RandomizedQueue() {
        list = new ArrayList<Item>();


    }

    // is the queue empty?
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // return the number of items on the queue
    public int size() {
        return list.size();
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        list.add(item);

    }

    // remove and return a random item
    public Item dequeue() {
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }

        int index  = (int) (StdRandom.uniform() * list.size());
        return list.remove(index);
    }

    // return (but do not remove) a random item
    public Item sample()    {
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }

        int index  = (int) (StdRandom.uniform() * list.size());
        return list.get(index);
    }
    // return an independent iterator over items in random order

    public Iterator<Item> iterator()  {
        final ArrayList<Item> copy = new ArrayList<Item>(list);

        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return copy.isEmpty();
            }

            @Override
            public Item next() {
                int index  = (int) (StdRandom.uniform() * list.size());
                return copy.remove(index);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        RandomizedQueue deq = new RandomizedQueue();
        deq.sample();
    }
}
