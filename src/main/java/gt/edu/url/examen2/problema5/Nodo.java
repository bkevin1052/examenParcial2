package gt.edu.url.examen2.problema5;

/**
*
* @author Kevin Barrientos
*/
public class Nodo<E> {
	
	/**
	 * GETTERS Y SETTERS
	 */
	private E elemento;
	private Nodo<E> siguiente;
	public Nodo(E elemento, Nodo<E> siguiente) {
		this.elemento = elemento;
		this.siguiente = siguiente;
	}
	public E getElemento() {
		return elemento;
	}
	public void setElemento(E elemento) {
		this.elemento = elemento;
	}
	public Nodo<E> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente = siguiente;
	}
	
	public String toString() {
		return "elemento=" + elemento;
	}

}
