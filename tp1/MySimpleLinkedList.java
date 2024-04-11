import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
	
	private Node<T> first;
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
		
		if(index < 0) {
			throw new IndexOutOfBoundsException("Indice no valido");
		}else if(index >= this.size()){
			throw new IndexOutOfBoundsException("El indice supera el tamaño de la lista");
		}

		for (T i : this){
			if(index == 0){
				respuesta = i;
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
		
		for (T i : this){
			respuesta = respuesta + i.toString();
			if(contador != this.size()-1) {
				respuesta = respuesta + ", ";
			}
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

		for (T i : this){
			if(i.equals(info)){
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
	public Iterator<T> iterator() {
		return new MyIterator<T>(this.getFirst());
	}

	public Node<T> getFirst() {
		return this.first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}
}
