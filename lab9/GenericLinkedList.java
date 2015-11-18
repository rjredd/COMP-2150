package lab9;

public class GenericLinkedList<E> implements List<E>
{

    private class Node<E>
    {
        private E data;
        private Node<E> next;

        @Override
        public String toString()
        {
            return "" + data;
        }
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

    @Override
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

    public boolean containsRecursive(E someItem, Node<E> node)
    {
        if (node == null)
            return false;
        return node.data == someItem || containsRecursive(someItem, node.next);
    }

    public boolean containsRecursive(E someItem)
    {
        return containsRecursive(someItem, head);
    }

    public int searchRecursive(E someItem, Node<E> node, int count)
    {
        if (node == null)
            return -1;
        else
        {
            if (this.get(count).equals(someItem))
            {
                return count;
            } else
                return searchRecursive(someItem, node.next, ++count);
        }
    }

    public int searchRecursive(E someItem)
    {
        return searchRecursive(someItem, head, 0);
    }

    public Node<E> removeRecursive(int index, Node<E> node)
    {
        if (node == null)
            throw new java.util.NoSuchElementException("cannot delete.");
        else if (index == 0)
            return node.next;
        else
            node.next = removeRecursive(index - 1, node.next);

        return node;
    }

    public void removeRecursive(int index)
    {
        if (index == 0)
            head = head.next;
        else
            removeRecursive(index, head);
    }

    public static void main(String[] args)
    {
        GenericLinkedList<Integer> myList = new GenericLinkedList<Integer>();
        myList.add(4);
        myList.add(7);
        myList.add(11);
        myList.add(18);
        myList.add(123123);

        System.out.println("Testing containsRecursive():");

        System.out.println(myList.containsRecursive(3));
        System.out.println(myList.containsRecursive(7));
        System.out.println(myList.containsRecursive(123));

        System.out.println();
        System.out.println("Testing searchRecursive():");

        System.out.println(myList.searchRecursive(4));
        System.out.println(myList.searchRecursive(7));
        System.out.println(myList.searchRecursive(123123));
        System.out.println(myList.searchRecursive(0));

        System.out.println();
        System.out.println("Testing removeRecursive():");
        System.out.println(myList);

        System.out.println();
        System.out.println("removing node at index 3.");
        myList.removeRecursive(3);
        System.out.println();

        System.out.println(myList);

        System.out.println();
        System.out.println("removing node at index 0 (head).");
        myList.removeRecursive(0);
        System.out.println();

        System.out.println(myList);
        
        System.out.println();
        System.out.println("removing non existant node.");
        myList.removeRecursive(-1);
        System.out.println();

        System.out.println(myList);
    }

}
