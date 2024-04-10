package ProgramacionIII.tp1;

public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int size = 0;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(T info) { // O(1)
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() { // O(1)
		return this.getFirst().getInfo();
	}

	public boolean isEmpty() { // O(1)
		return this.first == null;
	}
	
	public T get(int index) { // O(n) (ya que tendrá que recorrer TODA la lista para llegar al indice deseado)
		Node<T> actual = this.first;
		
		if(index < 0) {
			throw new IndexOutOfBoundsException("Indice no valido");
		}else if(index >= this.size()){
			throw new IndexOutOfBoundsException("El indice supera el tamaño de la lista");
		}

		for(int i = 0; i < index; i++){ 
			actual = actual.getNext();
		}
		return actual.getInfo();
	}
	
	public int size() { // O(1)
		return this.size;
	}
	
	@Override
	public String toString() {
		// TODO
		return "";
	}
	
}
