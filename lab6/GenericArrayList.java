package lab6;

import java.util.NoSuchElementException;

/**
 * @author Ernest McCracken, Riley Redd
 * @param <E>
 *            a generic variable
 */
public class GenericArrayList<E> implements List<E>
{

    E[] data;
    int size = 0;

    /**
     * @author Ernest McCracken
     */
    public GenericArrayList()
    {
        data = (E[]) new Object[10];
    }

    /**
     * @author Ernest McCracken
     */
    @Override
    public E get(int index)
    {
        if (index >= size || index < 0)
        {
            throw new NoSuchElementException();
        }

        return data[index];
    }

    /**
     * @author Ernest McCracken
     */
    @Override
    public void add(E value)
    {
        if (size == data.length)
        {
            System.out.println("Resizing array to capacity " + data.length * 2);
            E[] newArray = (E[]) new Object[data.length * 2];
            for (int i = 0; i < size; i++)
            {
                newArray[i] = data[i];
            }
            data = newArray;
        }

        data[size++] = value;

    }

    /**
     * @author Ernest McCracken
     */
    @Override
    public void remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new NoSuchElementException();
        }

        for (int i = index; i < size - 1; i++)
        {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

    }

    /**
     * @author Ernest McCracken
     */
    @Override
    public void set(int index, E value)
    {
        if (index < 0 || index >= size)
        {
            throw new NoSuchElementException();
        }

        data[index] = value;

    }
    
    public static void main(String[] args)
    {
        GenericArrayList<Integer> myList = new GenericArrayList<Integer>();
        for (int i = 0; i < 80; i++)
        {
            myList.add(i);
        }
        myList.remove(0);
        myList.set(23, 4444);
        for (int i = 0; i < 79; i++)
        {
            System.out.println(myList.get(i));
        }

    }

}
