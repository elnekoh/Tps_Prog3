public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
        lista.insertFront(5);
        lista.insertFront(4);
        lista.insertFront(3);
        lista.insertFront(2);
        lista.insertFront(1);
        lista.insertFront(0);
        System.out.println("Lista: "+lista);
        lista.insert(10,6);
        System.out.println("Lista: "+lista);
        System.out.println("--------");
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<Integer>();
        lista1.insertFront(20);
        lista1.insertFront(15);
        lista1.insertFront(3);
        lista1.insertFront(8);
        lista1.insertFront(2);
    
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();
        lista2.insertFront(14);
        lista2.insertFront(4);
        lista2.insertFront(9);
        lista2.insertFront(2);
        lista2.insertFront(3);

        System.out.println("Lista 1: ");
        for(Node<Integer> i : lista1){
            System.out.println(i.getInfo());
        }
        System.out.println("Lista 2:");
        for(Node<Integer> i : lista2){
            System.out.println(i.getInfo());
        }
        System.out.println("Ejercicio5a");
        System.out.println(ejercicio5a(lista1, lista2));
    }

    
    public static <T extends Comparable<T>> MySimpleLinkedList<T> ejercicio5a(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
        MySimpleLinkedList<T> respuesta = new MySimpleLinkedList<T>();
        for(Node<T> i : lista1){ 
            if(lista2.indexOf(i.getInfo()) != -1){
                respuesta.insertInOrder(i.getInfo());
            }
        }
        return respuesta;
    }
}
