package gt.edu.url.examen2.problema4;

/**
*
* @author Kevin Barrientos
*/
public interface PositionalList<E> {
	int size( );
	boolean isEmpty( );
	Position<E> first(int i );
	Position<E> last( int i);
	Position<E> addFirst(E e, int i);
	Position<E> addLast(E e, int i);
	Position<E> before(Position<E> p, int i) throws IllegalArgumentException;
	Position<E> after(Position<E> p, int i) throws IllegalArgumentException;
	Position<E> addBefore(Position<E> p, E e, int i) throws IllegalArgumentException;
	Position<E> addAfter(Position<E> p, E e, int i) throws IllegalArgumentException;
	E set(Position<E> p, E e) throws IllegalArgumentException;
	E remove(Position<E> p, int i) throws IllegalArgumentException;
        //Metodo a implementar
    Position<E> positionAtIndex(int i, Position<E> p) throws IndexOutOfBoundsException;
        

}
