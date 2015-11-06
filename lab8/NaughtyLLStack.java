package lab8;

import java.util.EmptyStackException;

public class NaughtyLLStack<E> implements Stack<E>
{
    private static class LLNode<E>
    {
        private E data; // data stored in this node
        private LLNode<E> next; // a reference to the next node in the list

        public LLNode(E data, LLNode<E> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    private LLNode<E> head = null;

    @Override
    public boolean isEmpty()
    {
        return (head == null);
    }

    @Override
    public void push(E newData)
    {
        if (this.head == null)
            this.head = new LLNode<E>(newData, head);
        else if (this.head.next == null)
        {
            LLNode<E> tail = new LLNode<E>(newData, null);
            head.next = tail;
        } else
        {
            for (LLNode<E> temp = head; temp != null; temp = temp.next)
            {
                if (temp.next.next == null)
                {
                    LLNode<E> tail = new LLNode<E>(newData, null);
                    temp.next.next = tail;
                    break;
                }
            }
        }
    }

    @Override
    public E pop()
    {
        E toReturn = null;
        
        if (!isEmpty())
        {
            if (this.head.next == null)
            {
                toReturn = head.data;
                head = null;
            }
            else if (this.head.next.next == null)
            {
                toReturn = head.next.data;
                head.next = null;
            } else
            {
                for (LLNode<E> temp = head; temp != null; temp = temp.next)
                {
                    if (temp.next.next == null)
                    {
                        toReturn = temp.next.data;
                        temp.next = null;
                        break;
                    }
                }
            }
            
            return toReturn;
        } else
        {
            throw new EmptyStackException();
        }
    }

    /**
     * there was no requirement to peak at tail, so I am assuming this stays the
     * same.
     */
    @Override
    public E peek()
    {
        if (!isEmpty())
        {
            return head.data;
        } else
        {
            throw new EmptyStackException();
        }
    }

    @Override
    public String toString()
    {
        String s = "LLStack with elements (top to bottom):\n";
        for (LLNode<E> temp = head; temp != null; temp = temp.next)
        {
            s += temp.data + "\n";
        }
        return s;
    }

    public LLNode<E> getTail()
    {
        LLNode<E> temp = this.head;

        while (temp.next != null)
        {
            temp = temp.next;
        }

        return temp;
    }
}
