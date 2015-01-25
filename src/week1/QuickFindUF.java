package week1;

import java.util.Arrays;

/**
 * Created by badbug on 25.01.2015.
 */
public class QuickFindUF {

    private int[] id;

    @Override
    public String toString() {
        return "QuickFindUF{" +
                "id=" + Arrays.toString(id) +
                '}';
    }

    public QuickFindUF(int n) {
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

        QuickFindUF q = new QuickFindUF(10);
        q.union(6,8);
        q.union(7,1);
        q.union(2,0);
        q.union(0,9);
        q.union(6,0);
        q.union(3,5);

        System.out.println(q);


    }
}
