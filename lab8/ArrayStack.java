package lab8;
/**
 * Implements a stack using an array as the underlying data structure.  The
 * high index of the array corresponds to the top of the stack, in order to
 * avoid having to shift array elements up and down with push and pop operations.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>
{
    private E[] data = (E[])(new Object[10]);
    private int size;
    
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    // Same as adding new data in an array list
    public void push(E newData)
    {
        if (size == data.length) {
            E[] newDataArray = (E[])(new Object[size*2]);
            for (int i = 0; i < size; i++)
                newDataArray[i] = data[i];
            data = newDataArray;
        }
        
        data[size] = newData;
        size++;
    }
    
    public E pop()
    {
        if (!isEmpty()) {
            E temp = data[size-1];
            data[size-1] = null;
            size--;
            return temp;
        } else {
            throw new EmptyStackException();
        }
    }
    
    public E peek()
    {
        if (!isEmpty()) {
            return data[size-1];
        } else {
            throw new EmptyStackException();
        }
    }
    
    public String toString()
    {
        String s = "ArrayStack with elements (top to bottom):\n";
        for (int i = size - 1; i >= 0; i--) {
            s += data[i] + "\n";
        }
        return s;
    }
    
    public static void main(String[] args)
    {
        //TODO
    }    
}
