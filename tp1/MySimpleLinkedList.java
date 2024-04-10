package ProgramacionIII.tp1;

import org.w3c.dom.Node;

public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int size = 0;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	// O(1)
	public void insertFront(T info) { 
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	// O(1)
	public T extractFront() { // O(1)
		return this.getFirst().getInfo();
	}

	// O(1)
	public boolean isEmpty() { // O(1)
		return this.first == null;
	}
	
	// O(n) (ya que tendrá que recorrer TODA la lista para llegar al indice deseado)
	public T get(int index) { 
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
	
	// O(1)
	public int size() { 
		return this.size;
	}
	
	// O(n) (ya que tendrá que recorrer TODA la lista para imprimir cada elemento)
	@Override
	public String toString() {
		String respuesta= "[";
		Node<T> actual = this.first;

		for(int i = 0; i < this.size(); i++){ 
			respuesta = actual.getInfo().toString();
			if (i != this.size()-1) {
				respuesta = respuesta + ", ";
				actual = actual.getNext();
			}
		}

		return respuesta+"]";
	}
	
	public int indexOf(T info){
		int respuesta = -1;
		int contador = 0;
		Node<T> actual = this.first;

		/*
		for(int i = 0; i < this.size(); i++){ 
			if(actual.getInfo() == info){
				respuesta = contador;
				break;
			}else{
				contador++;
				actual = actual.getNext();
			}
		}
		*/

		while(respuesta == -1 && contador < this.size()){
			if(actual.getInfo() == info){
				respuesta = contador;
			}else{
				actual = actual.getNext();
				contador++;
			}
		}

		return respuesta;
	}
}
