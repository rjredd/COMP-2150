package lab7;

public class GenericLinkedList<E> implements List<E>
{

    private class Node<E>
    {
        private E data;
        private Node<E> next;
    }

    private Node<E> head = null;
    private int size = 0;

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

    public String toString()
    {
        String s = "";
        Node<E> curNode = head;
        s += curNode.data + " -> ";
        while (curNode.next != null)
        {
            curNode = curNode.next;
            s += curNode.data + " -> ";
        }
        s += "null";
        return s;
    }

    public static void main(String[] args)
    {
        List<Integer> myList = new GenericLinkedList<Integer>();
        myList.add(4);
        myList.add(7);
        myList.add(123123);

        System.out.println(myList.get(2));

        GenericLinkedList<Integer> myList2 = new GenericLinkedList<Integer>();
        myList2.add(4);
        myList2.add(7);
        myList2.add(8);
        myList2.add(3, 999);
        System.out.println(myList2);

        myList2.remove(3);
        System.out.println(myList2);

    }

}
