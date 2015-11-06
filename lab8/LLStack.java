package lab8;
/**
 * Implements a stack using a linked list as the underlying data
 * structure.  The head of the list corresponds to the top of the stack,
 * since adding and removing from the head are much more efficient than
 * doing so from the tail (no traversal needed).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.EmptyStackException;

public class LLStack<E> implements Stack<E>
{
    private static class LLNode<E>
    {
        private E data;         // data stored in this node
        private LLNode<E> next; // a reference to the next node in the list
        
        public LLNode(E data, LLNode<E> next)
        {
            this.data = data;
            this.next = next;
        }
    }
    
    private LLNode<E> head = null;

    public boolean isEmpty()
    {
        return (head == null);
    }

    // Same as adding to the head of the list
    public void push(E newData)
    {
        head = new LLNode<E>(newData, head);
    }

    // Same as removing from the head of the list
    public E pop()
    {
        if (!isEmpty()) {
            E toReturn = head.data;
            head = head.next;
            return toReturn;
        } else {
            throw new EmptyStackException();
        }
    }
    
    public E peek()
    {
        if (!isEmpty()) {
            return head.data;
        } else {
            throw new EmptyStackException();
        }
    }
    
    public String toString()
    {
        String s = "LLStack with elements (top to bottom):\n";
        for (LLNode<E> temp = head; temp != null; temp = temp.next) {
            s += temp.data + "\n";
        }
        return s;
    }
    
    public static void main(String[] args)
    {
        //TODO
    }
}
