package lab8;
/**
 * This interface specifies the four basic stack operations.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Stack<E>
{
    // Returns whether or not the stack is empty
    boolean isEmpty();
    
    // Adds a new element onto the top of the stack
    void push(E newData);

    // Removes and returns the top element of the stack
    E pop();

    // Returns the top element of the stack, without actually removing it
    E peek();
}
