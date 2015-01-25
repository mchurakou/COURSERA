package week1;

import java.util.Arrays;

/**
 * Created by badbug on 25.01.2015.
 */
public class QuickUnion {

    private int[] id;
    private int[] sz;

    @Override
    public String toString() {
        return "QuickFindUF{" +
                "id=" + Arrays.toString(id) +
                '}';
    }

    public QuickUnion(int n) {

        id = new int[n];
        sz = new int[n];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            sz[i] = 1;

        }
    }

    private int root(int i){
        while (i != id[i] ){
            i = id[i];
        }
        return i;
    }

    public boolean connected (int p, int q){
        return root(p) == root(q);
    }

    public void union (int p, int q){
        int i = root(p);
        int j = root(q);

        if (i == j)
            return;

        if (sz[i] < sz[j]){
            id[i]= j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        System.out.println("START");

        QuickUnion q = new QuickUnion(10);
        q.union(3,1);
        q.union(4,6);
        q.union(7,9);
        q.union(3,8);
        q.union(4,7);
        q.union(5,8);

        q.union(2,3);
        q.union(3,0);
        q.union(0,9);

        System.out.println(q);


    }
}
