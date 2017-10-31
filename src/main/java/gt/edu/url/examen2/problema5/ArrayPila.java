package gt.edu.url.examen2.problema5;

/**
*
* @author Kevin Barrientos
*/
public class ArrayPila<E> implements Stack<E> {
	

	private Nodo<E> top;
	private int tam;
		
	/**
	 * Metodo contructor
	 */
	public ArrayPila() {
			top = null;
			this.tam = 0;
	}

	/**
	 * Metodo que permite ver el tamaño de la pila
	 */
	public int size(){
		return this.tam;
	}
	
	

	/**
	 * Metodo que permite verificar si la pila esta vacia
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Metodo que permite  insertar un valor generico
	 */
	public void push(E elemento) {
		
		Nodo<E> aux = new Nodo<>(elemento,top);
		top = aux;
		this.tam++;

	}

	/**
	 * Metodo que permite ver el tope
	 */
	public E top() {
		if(isEmpty()) {
			return null;
		}else {
			return top.getElemento();
		}
		
	}

	/**
	 * Metodo que permite sacar elementos de la pila
	 */
	public E pop() {
		
		if(isEmpty()) {
			return null;
		}else {
			E elemento = top.getElemento();
			Nodo<E> aux = top.getSiguiente();
			top = null;
			top = aux;
			this.tam--;
			
			return elemento;
		}
		
	}
	
	/**
	 * Metodo que permite ver el la pila
	 */
	public String toString() {
		
		if(isEmpty()) {
			return "La pila se encuentra vacia";
		}else {
			String resultado = "";
			Nodo<E> aux = top;
			while(aux!=null)
			{
		    resultado += aux.toString();
			aux = aux.getSiguiente();
			}
			return resultado;
		}	
	}
}

