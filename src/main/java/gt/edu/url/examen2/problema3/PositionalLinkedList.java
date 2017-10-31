package gt.edu.url.examen2.problema3;


/**
*
* @author Kevin Barrientos
*/
public class PositionalLinkedList<E> implements PositionalList<E>{

		private static class Node<E> implements Position<E> {
			private E element;
			private Node<E> prev;// Anterior
			private Node<E> next;// Siguiente

			public Node(E e, Node<E> p, Node<E> n) {
				element = e;
				prev = p;
				next = n;
			}

			public E getElement() throws IllegalStateException {
				if (next == null) // Nodo no valido
					throw new IllegalStateException("Posicion invalida");
				return element;
			}
			
			public void setElement(E e) {
				element = e;
			}

			public Node<E> getPrev() {
				return prev;
			}

			public void setPrev(Node<E> prev) {
				this.prev = prev;
			}

			public Node<E> getNext() {
				return next;
			}

			public void setNext(Node<E> next) {
				this.next = next;
			}

		}
		private Node<E> header = null;// Referencia
		private Node<E> trailer = null;
		private int size = 0;

		public PositionalLinkedList() {
			header = new Node<>(null, null, null);
			trailer = new Node<>(null, header, null);
			header.setNext(trailer);
		}

		// Metodos internos
		/**
		 * Valida si una posicion contiene un nodo y el nodo existe
		 */
		private Node<E> validate(Position<E> p) throws IllegalArgumentException {
			if (!(p instanceof Node))
				throw new IllegalArgumentException("P invalido");
			Node<E> node = (Node<E>) p; // safe cast
			if (node.getNext() == null)
				throw new IllegalArgumentException("p ya no se encuentra en la lista");
			return node;
		}
		
		/**
		 * "Empaca" un nodo como posicion a menos que sea header o trailer
		 */
		private Position<E> position(Node<E> node) {
			if (node == header || node == trailer)
				return null; // do not expose user to the sentinels
			return node;
		}

		// ---

		/**
		 * Metodo que permite ver el tamaño de la lista
		 */
		public int size() {return size;}

		/**
		 * Metodo que permite ver la lista esta llena
		 */
		public boolean isEmpty() {return size == 0;}

		
		/**
		 * Metodo que permite ver el primer valor de la lista
		 */
		public Position<E> first( ) {
			return position(header.getNext());
		}

		
		/**
		 * Metodo que permite ver el ultimo valor de la lista
		 */
		public Position<E> last( ) {
			return position(trailer.getPrev());
		}
		
		/**
		 * Metodo que permite ver el anterior valor de la lista
		 */		
		public Position<E> before(Position<E> p) throws IllegalArgumentException {
			Node<E> node = validate(p);
			return position(node.getPrev());
		}

		/**
		 * Metodo que permite ver el consecuente a que le sigue del valor de la lista
		 */
		public Position<E> after(Position<E> p) throws IllegalArgumentException {
			Node<E> node = validate(p);
			return position(node.getNext());
		}
		
		/**
		 * Metodo que permite agregar un valor entre dos nodos
		 * @param e
		 * @param pred
		 * @param succ
		 */
		private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
			Node<E> newest = new Node<>(e, pred, succ);
			succ.setPrev(newest);
			pred.setNext(newest);
			size++;
			return newest;
		}
		
		
		/**
		 * Metodo que permite agregar un valor de primero
		 * @param e
		 */
		public Position<E> addFirst(E e) {
			return addBetween(e, header, header.getNext());
		}

		/**
		 * Metodo que permite agregar un valor de ultimo
		 * @param e
		 */
		public Position<E> addLast(E e) {
			return addBetween(e, trailer.getPrev(), trailer);
		}
		
		
		/**
		 * Metodo que permite agregar un valor antes
		 * @param e
		 */
		public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
			Node<E> node = validate(p);
			return addBetween(e, node.getPrev(), node);
		}
		
		
		/**
		 * Metodo que permite agregar un valor despues
		 * @param e
		 * @param p
		 */
		public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{ 
			Node<E> node = validate(p);
			return addBetween(e, node, node.getNext());
		}

		/**
		 * Metodo que permite cambiar el valor de una posicion
		 * @param e
		 * @param p
		 */
		public E set(Position<E> p, E e) throws IllegalArgumentException {
			Node<E> node = validate(p);
			E answer = node.getElement();
			node.setElement(e);
			return answer;
		}
		
		/**
		 * Metodo que permite remover un valor
		 * @param p
		 */
		public E remove(Position<E> p) throws IllegalArgumentException {
			Node<E> node = validate(p);
			Node<E> predecessor = node.getPrev();
			Node<E> successor = node.getNext();
			predecessor.setNext(successor);
			successor.setPrev(predecessor);
			size--;
			E answer = node.getElement();
			node.setElement(null);
			node.setNext(null);
			node.setPrev(null);
			return answer;
		}
		
		protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
			if (i < 0 || i >= n)
				throw new IndexOutOfBoundsException("Illegal index: " + i);
		}

		/**
		 * Metodo que permite agregar un valor entre dos nodos
		 * @param p
		 * @param q
		 */
		public void swap(Position<E> p, Position<E> q) {
			E temp;
			temp = p.getElement();
			p.setElement(q.getElement());
			q.setElement(temp);	
		}


	
	}
