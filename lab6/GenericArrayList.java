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

    /**
     * Isn't this just a getter method for size?
     * 
     * @author Riley Redd
     * @return The number of non-null elements in the arraylist.
     */
    public int size()
    {
        return this.size;
    }

    /**
     * @author Riley Redd
     * @param anotherList
     *            a Generic ArrayList of the same generic type.
     */
    public void addAll(GenericArrayList<E> anotherList)
    {
        for (int i = 0; i < anotherList.size; i++)
        {
            if (anotherList.data[i] != null)
                this.add(anotherList.data[i]);
        }
    }

    /**
     * @author Riley Redd
     * @param someData
     *            an object of the same generic type as the calling object
     * @return whether or not the calling array contains the requested data.
     */
    public boolean contains(E someData)
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (this.data[i].equals(someData))
                return true;
        }
        return false;
    }

    /**
     * SPAGHETTI COOOOODE XD
     * 
     * @author Riley Redd
     * @param anotherList
     *            a Generic ArrayList of the same generic type.
     */
    public void retainAll(GenericArrayList<E> anotherList)
    {
        // Spaghetti code part 2
        escape: for (int i = this.size() - 1; i >= 0; i--)
        {
            for (int j = 0; j < anotherList.size(); j++)
            {
                if (this.data[i] == anotherList.data[j])
                {
                    // Spaghetti code part 1
                    continue escape;
                }
            }
            this.remove(i);
        }
    }

    /**
     * @author Riley Redd
     * @param index
     *            the index of the array that you wish to remove.
     */
    public void removeAndTrim(int index)
    {
        this.remove(index);

        if (this.size() < (data.length / 2))
        {
            System.out.println("Resizing array to capacity " + data.length / 2);
            E[] newArray = (E[]) new Object[data.length / 2];
            for (int i = 0; i < size; i++)
            {
                newArray[i] = data[i];
            }
            data = newArray;
        }
    }

    /**
     * @author Riley Redd
     * @param beginIndex
     *            an int that should greater than zero and less than endIndex.
     * @param endIndex
     *            an int that should be greater than beginIndex and less that
     *            arrayList size.
     * @return a new GenericArrayList<E> that is made up of the values of the
     *         calling objects data between said indexes.
     */
    public GenericArrayList<E> subList(int beginIndex, int endIndex)
    {
        if (beginIndex < 0 || beginIndex > this.size() || endIndex < 0
                || endIndex > this.size() || beginIndex > endIndex)
        {
            return null;
        }

        GenericArrayList<E> temp = new GenericArrayList<E>();

        if (endIndex - beginIndex > 0)
        {
            for (int i = beginIndex; i < endIndex; i++)
            {
                temp.add(this.get(i));
            }
        }

        return temp;
    }

    public static void main(String[] args)
    {
        GenericArrayList<Integer> myList = new GenericArrayList<Integer>();
        GenericArrayList<Integer> aList = new GenericArrayList<Integer>();
        for (int i = 0; i < 80; i++)
        {
            myList.add(i);
        }

        aList.add(1);
        aList.add(3);
        aList.add(20);
        aList.add(67);

        System.out.println(myList.size());

        myList.addAll(aList);

        // show that i have added to lists.
        for (int i = 0; i < myList.size(); i++)
        {
            System.out.println(myList.get(i));
        }

        // testing subList method
        GenericArrayList<Integer> subListA = myList.subList(1, 5);
        for (int i = 0; i < subListA.size(); i++)
        {
            System.out.println(subListA.get(i));
        }

        // testing the removeAndTrim method.
        for (int i = myList.size() - 1; i >= 20; i--)
        {
            myList.removeAndTrim(i);
        }
        for (int i = 0; i < myList.size(); i++)
        {
            System.out.println(myList.get(i));
        }

        // does myList contain the number 1?
        System.out.println(myList.contains(1));

        // does myList contain the number 81?
        System.out.println(myList.contains(81));

        // change myList and print it out.
        myList.retainAll(aList);
        for (int i = 0; i < myList.size(); i++)
        {
            System.out.println(myList.get(i));
        }

        for (int i = myList.size() - 1; i >= 20; i--)
        {
            myList.remove(i);
        }
        for (int i = 0; i < myList.size(); i++)
        {
            System.out.println(myList.get(i));
        }
    }

}
