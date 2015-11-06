package lab8;

import java.util.EmptyStackException;

public class NaughtyArrayStack<E> implements Stack<E>
{
    private E[] data = (E[]) (new Object[10]);
    private int size = 0;

    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }

    @Override
    public void push(E newData)
    {
        if (size == data.length)
        {
            E[] newDataArray = (E[]) (new Object[size * 2]);
            for (int i = 0; i < size; i++)
                newDataArray[i] = data[i];
            data = newDataArray;
        }
    
        E[] pushDataArray = (E[]) (new Object[size]);
        
        for (int i = 0; i < size; i++)
            pushDataArray[i] = data[i];
        
        for (int i = 1; i <= size; i++)
            data[i] = pushDataArray[i - 1];
        
        data[0] = newData;
        size++;
    }

    @Override
    public E pop()
    {
        if (!isEmpty())
        {
            E temp = data[0];
            
            E[] pushDataArray = (E[]) (new Object[size]);
            
            for (int i = 0; i < size; i++)
                pushDataArray[i] = data[i];
            
            for (int i = 0; i < size; i++)
                if (i + 1 != size)
                    data[i] = pushDataArray[i + 1];
            
            size--;
            return temp;
        } else
        {
            throw new EmptyStackException();
        }
    }

    @Override
    public E peek()
    {
        if (!isEmpty())
        {
            return data[size - 1];
        } else
        {
            throw new EmptyStackException();
        }
    }

    @Override
    public String toString()
    {
        String s = "ArrayStack with elements (top to bottom):\n";
        for (int i = size - 1; i >= 0; i--)
        {
            s += data[i] + "\n";
        }
        return s;
    }
}
