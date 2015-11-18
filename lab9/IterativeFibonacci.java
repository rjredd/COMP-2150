package lab9;

public class IterativeFibonacci
{
    private static long recursiveFibonacci(long repetitions)
    {
        if (repetitions < 2)
            return repetitions;
        else
            return recursiveFibonacci(repetitions - 1) 
                 + recursiveFibonacci(repetitions - 2);
    }
    
    private static long iterativeFibonacci(long repetitions)
    {
        int answer = 0, tempA = 0, tempB = 1;
        
        for (int i = 0; i < repetitions; i++)
        {
            tempA = answer;
            answer = tempB;
            tempB = answer + tempA;
        }
        
        return answer;
    }
    
    public static void main(String[] args)
    {
        int n = 40;
        
        System.out.println("Fibonacci iteration:");
        long start = System.currentTimeMillis();
        System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, iterativeFibonacci(n));
        System.out.printf("Time: %d ms\n", System.currentTimeMillis() - start);

        
        
        System.out.println("Fibonacci recursion:");
        start = System.currentTimeMillis();
        System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, recursiveFibonacci(n));
        System.out.printf("Time: %d ms\n", System.currentTimeMillis() - start);
    }

}
