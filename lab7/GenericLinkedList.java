package lab7;

/**
 * @author Ernest McCracken, Riley Redd
 * @param <E>
 *            a generic variable
 */
public class GenericLinkedList<E> implements List<E>
{

    private class Node<E>
    {
        private E data;
        private Node<E> next;
    }

    private Node<E> head = null;
    private int size = 0;

    /**
     * @author Ernest McCracken
     * @param index
     * @return
     */
    private Node<E> nodeAt(int index)
    {

        Node<E> curNode = head;
        int curIndex = 0;
        while (curIndex < index)
        {
            curNode = curNode.next;
            curIndex++;
        }
        return curNode;
    }

    @Override
    public E get(int index)
    {
        return nodeAt(index).data;
    }

    @Override
    public void add(E value)
    {
        Node<E> node = new Node<E>();
        node.data = value;

        if (size == 0)
        {
            head = node;
        } else
        {
            Node<E> curNode = nodeAt(size - 1);
            curNode.next = node;
        }
        size++;
    }

    /**
     * @author Ernest McCracken
     * @param index
     * @param value
     */
    public void add(int index, E value)
    {
        Node<E> node = new Node<E>();
        node.data = value;

        if (size == 0)
        {
            head = node;
        } else if (index == 0)
        {
            node.next = head;
            head = node;
        } else
        {
            Node<E> curNode = nodeAt(index - 1);
            node.next = curNode.next;
            curNode.next = node;
        }
        size++;
    }

    @Override
    public void remove(int index)
    {
        if (index == 0)
        {
            head = head.next;
        } else
        {
            Node<E> curNode = nodeAt(index - 1);
            curNode.next = curNode.next.next;
        }

    }

    @Override
    public void set(int index, E value)
    {
        nodeAt(index).data = value;

    }

    /*
     * Had to edit this method in order for Null lists to work.
     */
    @Override
    public String toString()
    {
        String s = "";
        Node<E> curNode = head;
        if (curNode != null) // added null check here. RR.
        {
            s += curNode.data + " -> ";
            while (curNode.next != null)
            {
                curNode = curNode.next;
                s += curNode.data + " -> ";
            }
        }
        s += "null";
        return s;
    }

    /**
     * @author Riley Redd
     */
    public void clear()
    {
        // simple and clean. No list exists with these settings.
        this.head = null;
        this.size = 0;
    }

    /**
     * @author Riley Redd
     * @param o
     *            the Object your are comparing to of type E.
     * @return the amount of like objects in the list.
     */
    public int count(E o)
    {
        int countNum = 0;

        for (int i = 0; i < this.size; i++)
            if (o.equals(this.get(i)))
                countNum++;

        return countNum;
    }

    /**
     * @author Riley Redd
     */
    public void reverse()
    {
        GenericLinkedList<E> tempList = new GenericLinkedList<E>();

        // setup reverse list.
        for (int i = size - 1; i >= 0; i--)
        {
            tempList.add(this.get(i));
        }

        // clear current list
        this.clear();

        // set current list to have nodes equivalent to reversed list's nodes.
        for (int i = 0; i < tempList.size; i++)
            this.add(tempList.get(i));
    }

    /**
     * @author Riley Redd
     * @param o
     */
    public void removeAll(E o)
    {
        for (int i = 0; i < this.size; i++)
        {
            if (o.equals(this.get(i)))
            {
                this.remove(i);
                i--; // reset i one step.
                size--; // shrink entire list by 1.
            }
        }
    }

    /**
     * @author Riley Redd
     * @param beginIndex
     *            the node you want the new list to start at.
     * @param endIndex
     *            the node after the one you want last in your new list.
     * @return a "sublisted" list.
     */
    public GenericLinkedList<E> subList(int beginIndex, int endIndex)
    {
        GenericLinkedList<E> subList = new GenericLinkedList<E>();

        if (beginIndex < 0 || endIndex > this.size || beginIndex > endIndex)
            return null; // invalid index
        if (beginIndex == endIndex)
            return subList; // a single node cannot be exclusive and inclusive.

        for (int i = beginIndex; i < endIndex; i++)
        {
            subList.add(this.get(i));
        }

        return subList;

    }

    public static void main(String[] args)
    {

        // List<Integer> myList = new GenericLinkedList<Integer>();
        // myList.add(4);
        // myList.add(7);
        // myList.add(123123);
        //
        // System.out.println(myList.get(2));
        //
        // GenericLinkedList<Integer> myList2 = new
        // GenericLinkedList<Integer>();
        // myList2.add(4);
        // myList2.add(7);
        // myList2.add(8);
        // myList2.add(3, 999);
        // System.out.println(myList2);
        //
        // myList2.remove(3);
        // System.out.println(myList2);

        // Basic setup
        GenericLinkedList<Integer> testList = new GenericLinkedList<Integer>();
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        System.out.println(testList);

        // clear() test
        testList.clear();
        System.out.println(testList);

        // count(E o) test
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        System.out.println(testList.count(new Integer(3)));

        // reverse() test
        testList.reverse();
        System.out.println(testList);

        // removeAll(E o) test A
        testList.add(2);
        testList.add(3);
        testList.add(2);
        testList.add(3);
        testList.add(2);
        testList.add(3);
        testList.add(2);
        testList.add(3);
        testList.removeAll(3);
        System.out.println(testList);

        // removeAll(E o) test B
        testList.add(4);
        testList.removeAll(4);
        System.out.println(testList);

        // removeAll(E o) test C
        testList.add(3);
        testList.add(3);
        testList.add(3);
        testList.add(3);
        testList.add(3);
        testList.add(3);
        testList.add(2);
        testList.removeAll(3);
        System.out.println(testList);

        // removeAll(E o) test D
        testList.clear();
        testList.removeAll(0);
        System.out.println(testList);

        // removeAll(E o) test E
        testList.add(2);
        testList.removeAll(2);
        System.out.println(testList);

        // subList(int beginIndex, int endIndex) test
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        System.out.println(testList.subList(5, 5));

    }

}
