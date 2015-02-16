/**
 * Created by badbug on 10.02.2015.
 */
public class PercolationStats {

       private  double mean = 0;
       private double stddev = 0;
       private double[] XX;

        private double lo;
        private double hi;
        private int T;

    // perform T independent experiments on an N-by-N grid
        public PercolationStats(int N, int T)  {
            this.T = T;
            if (N <= 0 || T <= 0) {
                throw new IllegalArgumentException("wrong arg");
            }

            XX = new double[T];

            for (int i = 0; i < T; i++) {
                Percolation perc = new Percolation(N);
                int turn = 0;
                while (!perc.percolates()) {

                    int x = (int) (StdRandom.uniform() * N) + 1;
                    int y = (int) (StdRandom.uniform() * N) + 1;
                    if (!perc.isOpen(y, x)) {
                        perc.open(y, x);
                        turn++;

                    }

                }
                XX[i] =  (double) turn /  (N * N);

            }


            for (double s : XX) {
                mean += s;
            }

            mean /= T;

            for (double s : XX) {
                stddev += (s - mean) * (s - mean);
            }

            stddev = Math.sqrt(stddev / (T - 1));

            lo = mean - 1.96*stddev/Math.sqrt(T);

            hi = mean + 1.96*stddev/Math.sqrt(T);


        }
    // sample mean of percolation threshold
        public double mean()   {
            return mean;
        }

    // sample standard deviation of percolation threshold
        public double stddev()  {
            if (T == 1) {
                return Double.NaN;
            } else {
                return stddev;
            }
        }

    // low  endpoint of 95% confidence interval
        public double confidenceLo() {
            if (T == 1) {
                return Double.NaN;
            } else {
                return lo;
            }

        }

    // high endpoint of 95% confidence interval
        public double confidenceHi() {
            if (T == 1) {
                return Double.NaN;
            } else {
                return hi;
            }


        }

    // test client (described below)
        public static void main(String[] args)  {
            int n = Integer.valueOf(args[0]);
            int t = Integer.valueOf(args[1]);

            PercolationStats stat = new PercolationStats(n, t);
            System.out.println("mean: " + stat.mean());
            System.out.println("stddev: " + stat.stddev());
            System.out.println("95% confidence interval: " + stat.confidenceLo() + " " + stat.confidenceHi());

        }

}
