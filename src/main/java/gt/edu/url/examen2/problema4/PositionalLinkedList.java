package gt.edu.url.examen2.problema4;

/**
*
* @author Kevin Barrientos
*/

//ya esta documetnado en el ejercicio anterior
//solo documente el metodo a realizar
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
		private Position<E> position(Node<E> node, int i) {
			if (node == header || node == trailer)
				return null; // do not expose user to the sentinels
			return node;
		}

		// ---

		public int size() {return size;}

		public boolean isEmpty() {return size == 0;}

		public Position<E> first(int i) {
			return position(header.getNext(), i);
		}

		public Position<E> last(int i) {
			return position(trailer.getPrev(), i );
		}
		
		public Position<E> before(Position<E> p, int i) throws IllegalArgumentException {
			Node<E> node = validate(p);
			return position(node.getPrev(), i);
		}

		public Position<E> after(Position<E> p, int i) throws IllegalArgumentException {
			Node<E> node = validate(p);
			return position(node.getNext() , i );
		}
		
		
		private Position<E> addBetween(E e, Node<E> pred, Node<E> succ, int i) {
			Node<E> newest = new Node<>(e, pred, succ);
			succ.setPrev(newest);
			pred.setNext(newest);
			size++;
			return newest;
		}
		
		public Position<E> addFirst(E e, int i) {
			return addBetween(e, header, header.getNext(),i);
		}

		public Position<E> addLast(E e,int i) {
			return addBetween(e, trailer.getPrev(), trailer, i);
		}
		
		public Position<E> addBefore(Position<E> p, E e, int i) throws IllegalArgumentException{
			Node<E> node = validate(p);
			return addBetween(e, node.getPrev(), node , i);
		}
		
		public Position<E> addAfter(Position<E> p, E e, int i) throws IllegalArgumentException{
			Node<E> node = validate(p);
			return addBetween(e, node, node.getNext(), i);
		}

		public E set(Position<E> p, E e) throws IllegalArgumentException {
			Node<E> node = validate(p);
			E answer = node.getElement();
			node.setElement(e);
			return answer;
		}
		
		public E remove(Position<E> p, int i) throws IllegalArgumentException {
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

		
		/**
		 * Metodo que sirve para agregar un indice a cada una de las posicion o nodos en la lista
		 * @param p
		 * @param i
		 */
		//Agrege una posicion ya que la solucion era mas efectiva asi y mas facil
		public Position<E> positionAtIndex(int i, Position<E> p) throws IndexOutOfBoundsException {
			Node<E> node = validate(p);
			return position(node.getNext(), i);
		}


	
	}
