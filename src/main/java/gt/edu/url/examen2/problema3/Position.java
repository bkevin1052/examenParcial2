package gt.edu.url.examen2.problema3;

/**
*
* @author Kevin Barrientos
*/
public interface Position<E> {
	
	E getElement() throws IllegalStateException;
	public void setElement(E e) throws IllegalStateException;

}
