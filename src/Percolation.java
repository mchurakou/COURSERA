public class Percolation {

    private boolean[][] matrix;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF backUf;
    private int size;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("wrong size");

        size = n;
        matrix = new boolean[n][n];

        uf = new WeightedQuickUnionUF(n * n + 2);
        backUf = new WeightedQuickUnionUF(n * n + 1);

    }

    public void open(int y, int x) {
        checkIndeces(y, x);


        int current = xyTo1D(x, y);

        if (y == 1 && !uf.connected(current, 0)) {
            uf.union(current, 0);
            backUf.union(current, 0);
        }

        if (y == size && !uf.connected(current, size * size + 1)) {
            uf.union(current, size * size + 1);
        }

        //top
        if (y  > 1 && isOpen(y - 1, x)) {
            uf.union(current, xyTo1D(x, y - 1));
            backUf.union(current, xyTo1D(x, y - 1));
        }
        //right
        if (x + 1 <= size && isOpen(y, x + 1)) {
            uf.union(current, xyTo1D(x + 1, y));
            backUf.union(current, xyTo1D(x + 1, y));
        }
        //bottom
        if (y + 1 <= size && isOpen(y + 1, x)) {
            uf.union(current, xyTo1D(x, y + 1));

            backUf.union(current, xyTo1D(x, y + 1));
        }

        //left
        if (x  > 1 && isOpen(y, x - 1)) {
            uf.union(current, xyTo1D(x - 1, y));
            backUf.union(current, xyTo1D(x - 1, y));
        }

        matrix[y - 1][x - 1] = true;

    }
    public boolean isOpen(int y, int x) {
        checkIndeces(y, x);

        return matrix[y - 1][x - 1];
    }
    public boolean isFull(int y, int x) {
        checkIndeces(y, x);
        return uf.connected(0, xyTo1D(x, y)) && isOpen(y, x) && backUf.connected(0, xyTo1D(x, y));
    }

    public boolean percolates() {
        return uf.connected(0, size * size + 1);
    }

    private int xyTo1D(int x, int y) {
        return (y - 1) * size + x;
    }

    private void checkIndeces(int y, int x) {
        if (y <= 0 || y > size || x <= 0 || x > size)
            throw new IndexOutOfBoundsException("index out of bounds " + y + " " +  x);
    }
}
