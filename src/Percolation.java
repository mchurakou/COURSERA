public class Percolation {

    private boolean[][] matrix;
    private WeightedQuickUnionUF uf;
    private int size;

    public Percolation(int n) {
        if (n <= 0)
            throw new IndexOutOfBoundsException("wrong size");

        size = n;
        matrix = new boolean[n][n];

        uf = new WeightedQuickUnionUF(n * n + 2);

        for (int i = 0; i < n; i++) {
            uf.union(0, xyTo1D(i + 1, 1));
            uf.union(n * n + 1, xyTo1D(i + 1, n));
        }
    }

    public void open(int y, int x) {
        checkIndeces(y, x);
        int current = xyTo1D(x, y);
        //top
        if (y - 1 > 0 && isOpen(y - 1, x)) {
            uf.union(current, xyTo1D(x, y - 1));
        }
        //right
        if (x + 1 <= size && isOpen(y, x + 1)) {
            uf.union(current, xyTo1D(x + 1, y));
        }
        //bottom
        if (y + 1 <= size && isOpen(y + 1, x)) {
            uf.union(current, xyTo1D(x, y + 1));
        }

        //left
        if (x - 1 > 0 && isOpen(y, x - 1)) {
            uf.union(current, xyTo1D(x - 1, y));
        }

        matrix[y - 1][x - 1] = true;
    }
    public boolean isOpen(int y, int x) {
        checkIndeces(y, x);

        return matrix[y - 1][x - 1];
    }
    public boolean isFull(int y, int x) {
        checkIndeces(y, x);
        return uf.connected(0, xyTo1D(x, y)) && isOpen(y, x);
    }

    public boolean percolates() {
        return uf.connected(0, uf.count() - 1);
    }

    private int xyTo1D(int x, int y) {
        return (y - 1) * size + (x - 1) + 1;
    }

    private void checkIndeces(int y, int x) {
        if (y <= 0 || y > size || x <= 0 || x > size)
            throw new IndexOutOfBoundsException("index out of bounds " + y + " " +  x);
    }
}
