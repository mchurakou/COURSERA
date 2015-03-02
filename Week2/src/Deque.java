import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Deque<Item> implements Iterable<Item> {
    private LinkedList<Item> list;

    // construct an empty deque
    public Deque() {
        list = new LinkedList<Item>();
    }

    // is the deque empty?
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // return the number of items on the deque
    public int size() {
        return list.size();
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item == null){
            throw new NullPointerException();
        }
        list.addFirst(item);
    }

    // add the item to the end
    public void addLast(Item item){
        if (item == null){
            throw new NullPointerException();
        }

        list.addLast(item);
    }
    // remove and return the item from the front
    public Item removeFirst(){
        return list.removeFirst();
    }

    // remove and return the item from the end
    public Item removeLast(){
        return list.removeLast();
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator(){
        final Iterator<Item> it =  list.iterator();

        return new Iterator<Item>() {;
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Item next() {
                return it.next();
            }
        };
    }

    // unit testing
    public static void main(String[] args) {

    }
}
