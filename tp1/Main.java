public class Main {
    public static void main(String[] args) {
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
        for(Integer i : lista1){
            System.out.println(i);
        }
        System.out.println("Lista 2:");
        for(Integer i : lista2){
            System.out.println(i);
        }
        System.out.println("Ejercicio5a");
        System.out.println(ejercicio5a(lista1, lista2));
    }

    public static <T> MySimpleLinkedList<T> ejercicio5a(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
        MySimpleLinkedList<T> respuesta = new MySimpleLinkedList<T>();
        for(T i : lista1){
            if(lista2.indexOf(i) != -1){
                respuesta.insertFront(i);
            }
        }
        return respuesta;
    }
}
