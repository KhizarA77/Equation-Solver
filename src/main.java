public class main {

    public static void main(String[] args) {
        double [][] a = { {4, 3, 1}, {5,7,1}, {2,-1,9} };
        double [] solution = {9,11,10};
        EquationSolver d = new EquationSolver(a, solution);
        d.JacobiIterativeMethod();
            
    }
    
}
