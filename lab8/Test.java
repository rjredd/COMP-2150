package lab8;

public class Test
{

    public static void main(String[] args)
    {
        NaughtyLLStack<Integer> testLL = new NaughtyLLStack<Integer>();
        NaughtyArrayStack<Integer> testArray = new NaughtyArrayStack<Integer>();

        long timerStartLL, timerStartArray, timerStopLL, timerStopArray;
        
        // linked list
        timerStartLL = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++)
        {
            testLL.push(10);
        }
        for (int i = 0; i < 10000; i++)
        {
            testLL.pop();
        }
        
        timerStopLL = System.currentTimeMillis();

        // Array
        timerStartArray = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++)
        {
            testArray.push(10);
        }
        for (int i = 0; i < 10000; i++)
        {
            testArray.pop();
        }
        
        timerStopArray = System.currentTimeMillis();
        
        System.out.println("LinkedList time = " + (timerStopLL - timerStartLL));
        System.out.println("Array time = " + (timerStopArray - timerStartArray));
    }

}
