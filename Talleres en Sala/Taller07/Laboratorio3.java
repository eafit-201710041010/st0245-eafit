package Taller07;
public class Laboratorio3 {
    private static int maximoAux(Node nodo, Node nodo2){
        if(nodo2 == null){
            return nodo.data;
        }
        int uno = nodo.data;
        int dos = nodo2.data;
        if(uno > dos){
            return maximoAux(nodo, nodo2.next);
        } else {
            return maximoAux(nodo2, nodo2.next);
        }
    }
    public static int maximo(LinkedListMauricio lista){
        return maximoAux(lista.first, lista.first.next);
    }
    
    public static boolean comparar(LinkedListMauricio lista, LinkedListMauricio lista2){
        if(lista.size() != lista2.size()){
            return false;
        }
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
            System.out.println(lista2.get(i));
            if(lista.get(i) != lista2.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){

        LinkedListMauricio list = new LinkedListMauricio();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

        System.out.println(list.contains(3));
        list.remove(2);
        System.out.println(list.contains(3));
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        System.out.println("máximo");
        System.out.println(maximo(list));
        
        LinkedListMauricio list2 = new LinkedListMauricio();
        list2.insert(5, 0);
        list2.insert(5, 0);
        list2.insert(7, 0);
        list2.insert(4, 0);
        list2.insert(1, 0);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list2.get(i));
        }
        System.out.println("máximo");
        System.out.println(maximo(list));
        
        LinkedListMauricio list3 = new LinkedListMauricio();
        list3.insert(5, 0);
        list3.insert(5, 0);
        list3.insert(7, 0);
        list3.insert(4, 0);
        list3.insert(1, 0);
        System.out.println(comparar(list, list2));
        System.out.println(comparar(list3, list2));
    }
}