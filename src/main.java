import java.util.Arrays;
public class main {

    public static void main(String[] args) {


        EquationSolver d = new EquationSolver(100);
        long startTime = System.nanoTime();
        d.JacobiIterativeMethod();
        long endTime1 = System.nanoTime();
        System.out.println("Time taken for Jacobi Iterative Method: "+ ((endTime1-startTime)) + " nanoseconds");
        d.GaussSiedalMethod();
        long endTime2 = System.nanoTime();
        System.out.println("Time taken for Seidal Method: "+ ((endTime2-endTime1)) + " nanoseconds");
    
    }
    
}
