import java.util.Arrays;

public class EquationSolver {

    private double[][] Matrix;
    private double[] Solution;

    public EquationSolver(double[][] Matrix, double[] Solution) {
        this.Matrix = Matrix;
        this.Solution = Solution;
    }
    // public void makeDiagonallyDominant() {
    // int sum = 0;
    // for (int i=0; i<Matrix.length; i++) {
    // for (int j=0; j<Matrix[0].length; j++) {
    // sum = sum + Matrix[i][j];
    // }
    // Matrix[i][i] = sum;
    // sum = 0;
    // }
    // }

    public void JacobiIterativeMethod() {
        double[] prev = new double[Matrix.length];
        double[] next = new double[Matrix.length];
        int maxiterations = 2;
        int iterations = 0;
        double sum = 0;
        Arrays.fill(prev, 0);
        Arrays.fill(next, 0);
        while (iterations < maxiterations) {
            for (int i = 0; i < Matrix.length; i++) {
                for (int j = 0; j < Matrix[0].length; j++) {
                    if (i != j) {
                        sum = sum + (Matrix[i][j] * prev[j]);
                    }
                }
                next[i] = (Solution[i] - sum) / Matrix[i][i];
                sum = 0;
            }
            System.out.println(Arrays.toString(prev));
            prev = next;
            System.out.println(Arrays.toString(prev));
            iterations++;
        }

    }

}
