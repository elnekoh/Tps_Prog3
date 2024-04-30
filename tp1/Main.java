import java.util.Iterator;

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
        System.out.println("--------");
        MySimpleLinkedList<Integer> lista3 = new MySimpleLinkedList<Integer>();
        lista3.insertFront(20);
        lista3.insertFront(18);
        lista3.insertFront(17);
        lista3.insertFront(14);
        lista3.insertFront(10);
        lista3.insertFront(9);
        MySimpleLinkedList<Integer> lista4 = new MySimpleLinkedList<Integer>();
        lista4.insertFront(23);
        lista4.insertFront(20);
        lista4.insertFront(18);
        lista4.insertFront(11);
        lista4.insertFront(10);
        lista4.insertFront(7);
        System.out.println("Lista 3: " + lista3);
        System.out.println("Lista 4: " + lista4);
        System.out.println("Ejercicio5b");  
        System.out.println(ejercicio5b(lista3, lista4));
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

    public static <T extends Comparable<T>> MySimpleLinkedList<T> ejercicio5b(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2){
        MySimpleLinkedList<T> respuesta = new MySimpleLinkedList<T>();
        Iterator<Node<T>> it1 = lista1.iterator();
        Iterator<Node<T>> it2 = lista2.iterator();
        T val1 = it1.next().getInfo();
        T val2 = it2.next().getInfo();
        while(it1.hasNext() && it2.hasNext()){
        
            if(val2.compareTo(val1) < 0){
                // Si el valor de iter2 es menor al de iter1, avanzo el iter2
                if(it2.hasNext()){
                    val2 = it2.next().getInfo();
                }
            } else if(val1.compareTo(val2) < 0){
                // Si el valor de iter1 es menor al de iter2, avanzo el iter1
                if(it1.hasNext()){
                    val1 = it1.next().getInfo();
                }
            }else if(val2.compareTo(val1) == 0) {
                respuesta.insertEnd(val1);
                val1 = it1.next().getInfo();
                val2 = it2.next().getInfo();
            }
        }
        return respuesta;
    }

    // Escriba una función que dadas dos listas construya otra con los elementos que están en la 
    // primera pero no en la segunda
    public static <T extends Comparable<T>> MySimpleLinkedList<T> ejercicio6(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2){
        MySimpleLinkedList<T> respuesta = new MySimpleLinkedList<T>();
        for(Node<T> i : lista1){ 
            if(lista2.indexOf(i.getInfo()) == -1){
                respuesta.insertInOrder(i.getInfo());
            }
        }
        return respuesta;
    }
}
