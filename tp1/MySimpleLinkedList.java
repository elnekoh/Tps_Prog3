import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<Node<T>>{
	
	private Node<T> first;
	private Node<T> last;
	private int size = 0;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	// O(1)
	public void insertFront(T info) { 
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.getFirst());
		this.setFirst(tmp);
		this.size++;
		if(this.size == 1){
			this.setLast(tmp);
		}
	}

	public void insertEnd(T info) { 
		Node<T> tmp = new Node<T>(info,null);
		if(this.isEmpty()){
			this.setFirst(tmp);
		}else{
			this.getLast().setNext(tmp);
		}	
		this.setLast(tmp);
		this.size++;
	}
	
	public Node<T> getLast() {
		return this.last;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}

	public void insert(T info, int index) {
		if(index == this.size()){
			this.insertEnd(info);
			return;
		}
		this.validateIndex(index);
		if(index == 0){
			this.insertFront(info);
			return;
		}
		if(index == this.size()){
			this.insertEnd(info);
			return;
		}
		for (Node<T> i : this){
			if(index == 1){
				Node<T> newNode = new Node<T>(info, i.getNext());
				i.setNext(newNode);
				this.size++;
				break;
			}
			index--;
		}
	}

	public void insertInOrder(T info){
		if(this.size() == 0){
			this.insertFront(info);
		}else{
			for(Node<T> i : this){
				if(i.getInfo().compareTo(info) > 0){
					Node<T> newNode = new Node<T>(info, i.getNext());
					i.setNext(newNode);
					break;
				}
			}
			this.insertEnd(info);
		}	
	}

	private void validateIndex(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException("Indice no valido");
		}else if(index >= this.size()){
			throw new IndexOutOfBoundsException("El indice supera el tamaño de la lista");
		}
	}
	
	// O(1)
	public T extractFront() { // O(1)
		return this.getFirst().getInfo();
	}

	// O(1)
	public boolean isEmpty() { // O(1)
		return this.getFirst() == null;
	}
	
	// O(n) (ya que tendrá que recorrer TODA la lista para llegar al indice deseado)
	public T get(int index) { 
		T respuesta = null;
		
		this.validateIndex(index);

		for (Node<T> i : this){
			if(index == 0){
				respuesta = i.getInfo();
				break;
			}
			index--;
		}

		return respuesta;
	}
	
	// O(1)
	public int size() { 
		return this.size;
	}
	
	// O(n) (ya que tendrá que recorrer TODA la lista para imprimir cada elemento)
	@Override
	public String toString() {
		String respuesta= "[";
		int contador = 0;
		
		for (Node<T> i : this){
			respuesta = respuesta + i.getInfo().toString();
			if(contador != this.size()-1) {
				respuesta = respuesta + ", ";
			}
			contador++;
		}
		/*
		Node<T> actual = this.getFirst();
		for(int i = 0; i < this.size(); i++){ 
			respuesta = actual.getInfo().toString();
			if (i != this.size()-1) {
				respuesta = respuesta + ", ";
				actual = actual.getNext();
			}
		}
		*/

		return respuesta+"]";
	}

	// O(n) (ya que tendrá que recorrer TODA la lista para encontrar el elemento deseado)
	public int indexOf(T info){
		int respuesta = -1;
		int contador = 0;

		for (Node<T> i : this){
			if(i.getInfo().equals(info)){
				respuesta = contador;
				break;
			}
			contador++;
		}

		/*
		Node<T> actual = this.getFirst();

		for(int i = 0; i < this.size(); i++){ 
			if(actual.getInfo().equals(info)){
				respuesta = contador;
				break;
			}else{
				contador++;
				actual = actual.getNext();
			}
		}
		

		while(respuesta == -1 && contador < this.size()){
			if(actual.getInfo().equals(info)){
				respuesta = contador;
			}else{
				actual = actual.getNext();
				contador++;
			}
		}
		*/

		return respuesta;
	}

	@Override
	public Iterator<Node<T>> iterator() {
		return new NodeIterator<T>(this.getFirst());
	}



	public Node<T> getFirst() {
		return this.first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}
}
