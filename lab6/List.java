package lab6;

/**
 * 
 * @author Ernest McCracken
 * @param <E>
 *            a generic variable
 */
public interface List<E>
{

    E get(int index);

    void add(E value);

    void remove(int index);

    void set(int index, E value);
}
