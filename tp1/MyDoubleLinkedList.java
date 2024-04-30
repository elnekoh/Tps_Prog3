public class MyDoubleLinkedList<T> {
    private NodeDouble<T> first;
    private int size = 0;

    public MyDoubleLinkedList() {
        this.first = null;
    }

    public NodeDouble<T> getFirst() {
        return this.first;
    }

    public void setFirst(NodeDouble<T> first) {
        this.first = first;
    }

    public int size() {
        return this.size;
    }

    public void insertFront(T info){
        NodeDouble<T> tmp = new NodeDouble<T>(info, null, null);
        tmp.setNext(this.getFirst());
        this.setFirst(tmp);
        this.size++;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public T extractFront() {		
		return this.getFirst().getInfo();
	}

    public T get(int index) {
		T respuesta = null;

        if(index < 0) {
			throw new IndexOutOfBoundsException("Indice no valido");
		}else if(index >= this.size()){
			throw new IndexOutOfBoundsException("El indice supera el tamaño de la lista");
		}

        while(index > 0){
            respuesta = this.getFirst().getInfo();
            index--;
        }

		return null;
	}
	
	@Override
	public String toString() {
		String respuesta= "[";
        NodeDouble<T> actual = this.getFirst();

        for(int i = 0; i < this.size(); i++){ 
			respuesta = actual.getInfo().toString();
			if (i != this.size()-1) {
				respuesta = respuesta + ", ";
				actual = actual.getNext();
			}
		}
		return respuesta;
	}
}
