import java.util.Arrays;

public class EquationSolver {

    private double[][] Matrix;
    private double[] Solution;
    private double Tolerace = 1 * Math.pow(10, -10);

    public EquationSolver(int n) {
        double sum = 0;
        Matrix = new double[n][n];
        Solution = new double[n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                Matrix[i][j] = Math.random()*1000;
                sum = sum + Matrix[i][j];
            }
            Matrix[i][i] = sum;
            Solution[i] = Math.random()*1000;
            sum = 0;
        }
    }

    public void JacobiIterativeMethod() {
        double[] prev = new double[Matrix.length];
        double[] next = new double[Matrix.length];
        double residual = Double.MAX_VALUE;
        int iterations = 0;
        double sum = 0;
        while (residual > Tolerace) {
            for (int i = 0; i < Matrix.length; i++) {
                for (int j = 0; j < Matrix[0].length; j++) {
                    if (i != j) {
                        sum = sum + (Matrix[i][j] * prev[j]);
                    }
                }
                next[i] = (Solution[i] - sum) / Matrix[i][i];
                sum = 0;
            }
            prev = next;
            iterations++;
            double[] Difference = SubtractMatrix(MultiplyMatrix(Matrix, prev), Solution);
            residual = residual(Difference);
        }
        System.out.println("Number of iterations taken for Jacobi: "+iterations);
        // System.out.println(Arrays.toString(next));

    }

    public void GaussSiedalMethod() {
        double[] variablevalues = new double[Matrix.length];
        double residual = Double.MAX_VALUE;
        int iterations = 0;
        double sum = 0;
        while (residual > Tolerace) {
            for (int i=0; i<Matrix.length; i++) {
                for (int j=0; j<Matrix[0].length; j++) {
                    if (i != j) {
                        sum = sum + (Matrix[i][j] * variablevalues[j]);
                    }
                }
                variablevalues[i] = (Solution[i] - sum) / Matrix[i][i];
                sum = 0; 
            }
            iterations++;
            double[] Difference = SubtractMatrix(MultiplyMatrix(Matrix, variablevalues), Solution);
            residual = residual(Difference);
            
        }
        System.out.println("Number of iterations taken for Seidal: "+iterations);
        // System.out.println(Arrays.toString(variablevalues)); 
    }
 
    public double[] MultiplyMatrix(double[][] A, double[] x) {
        double[] C = new double[A.length];
        
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A[0].length; j++) {
                C[i] = C[i] + (A[i][j] * x[j]);
            }
        }

        return C;
    }

    public double[] SubtractMatrix(double[] Ax, double[] b) {
        double[] C = new double[Ax.length];

        for (int i=0; i<Ax.length; i++) {
            C[i] = Ax[i] - b[i];
        }

        return C;
    }

    public double residual(double[] a) {
        double sum = 0;
        for (int i=0; i<a.length; i++) {
            sum = sum + (a[i]*a[i]);
        }
        double residual = Math.pow(sum, 0.5);
        return residual;

    }

}
