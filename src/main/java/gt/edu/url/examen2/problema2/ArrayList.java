package gt.edu.url.examen2.problema2;

import java.util.NoSuchElementException;

/**
*
* @author Kevin Barrientos
*/
public class ArrayList<E> implements List<E>, DemoList<E>{
	
	public static final int CAPACITY = 1;
	private E[] data;
	private int size = 1;

	public ArrayList() {
		this(CAPACITY);
	}

	/**
	 * Metodo que permite agregar un tamaño a una lista
	 * @param capacity
	 */
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	/**
	 * Metodo que permite ver el tamaño de una lista
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * Metodo que permite ver si la lsita esta vacia
	 * @param i
	 * @param e
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Metodo que permite obtener el valor de un elemento de tipo entero a una lista
	 * @param i
	 */
	public E get(int i) {
		checkIndex(i, size);
		return data[i];
	}
	
	
	/**
	 * Metodo que permite cambiar el valor de un elemento de tipo entero a una lista
	 * @param i
	 * @param e
	 */
	public E set(int i, E e) {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	
	/**
	 * Metodo que permite agregar un elemento de tipo entero a una lista
	 * @param i
	 * @param e
	 */
	public void add(int i, E e) {
		if(e != null)
		checkIndex(i, size + 1);
		if (size == data.length)
			resize(2 * data.length);
		for (int k = size-1; k >= i; k--)
			data[k+1] = data[k];
		data[i] = e; 
		size++;

	}

	/**
	 * Metodo que remueve un dato en el indice indicado
	 * @param i
	 */
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++)
			data[k] = data[k + 1];
		data[size - 1] = null;
		size--;
		return temp;
	}

	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}

	/**
	 * Internal method to increase array capacity
	 * @param capacity
	 */
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int k=0; k < size; k++)
			temp[k] = data[k];
		data = temp;
	}

	/**
	 * Crea un demostracion de lista luego la muestra
	 */
	public List<E> crearDemoLista() {
		ArrayList<Integer> Lista = new ArrayList<>();
		if(Lista.size() == 1) {
			Lista.add(0, 4);
			Lista.add(0, 3);
			Lista.add(0, 2);
			Lista.add(2, 1);
			Lista.add(1, 5);
			Lista.add(1, 6);
			Lista.add(3, 7);
			Lista.add(0, 8);
			System.out.println("CONTENIDO DE LA LISTA:");
			for(int j = 0; j < Lista.size(); j++) {
				System.out.println(Lista.remove(j));
			}
		}else {
			System.out.println("Esta vacia");
		}
		return null;
	}

}