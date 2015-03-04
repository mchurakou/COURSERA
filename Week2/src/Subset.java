/**
 * Created by badbug on 04.03.2015.
 */
public class Subset {

    public static void main(String[] args) {

        int k = StdIn.readInt();

        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String str  = StdIn.readString();
            rq.enqueue(str);

        }



        for (int i = 0; i <= k; i++) {
            StdOut.println(rq.dequeue());
        }


    }
}
