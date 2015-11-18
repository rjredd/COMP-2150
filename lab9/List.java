package lab9;

public interface List<E> {

	E get(int index);
	void add(E value);
	void remove(int index);
	void set(int index, E value);
}
