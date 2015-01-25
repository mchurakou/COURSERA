package week1;

import java.util.Arrays;

/**
 * Created by badbug on 25.01.2015.
 */
public class QuickFind {

    private int[] id;

    @Override
    public String toString() {
        return "QuickFindUF{" +
                "id=" + Arrays.toString(id) +
                '}';
    }

    public QuickFind(int n) {
        id = new int[n];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;

        }
    }

    public boolean connected (int p, int q){
        return id[p] == id[q];
    }

    public void union (int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid){
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("START");

        QuickFind q = new QuickFind(10);
        q.union(1,3);
        q.union(3,7);
        q.union(0,4);
        q.union(9,8);
        q.union(3,9);
        q.union(7,0);

        System.out.println(q);


    }
}
