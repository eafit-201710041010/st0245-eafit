import java.lang.IndexOutOfBoundsException; 
public class LinkedListMauricio {
    private Node first;
    private int size;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    }

    /** Retorna el tamaño actual de la lista*/
    public int size()
    {
        return size;
    }

    /** Inserta un dato en la posición index*/
    public void insert(int data, int index)
    {
        if(index == 0){
            Node nuevo = new Node(data);
            nuevo.next = first;
            first = nuevo;
        } else {
            Node n = getNode(index-1);
            Node temp = n.next;
            n.next = new Node(data);
            n.next.next = temp;
        }
        size++;
    }

    /** Borra el dato en la posición index*/
    public void remove(int index)
    {
        if(index == 0){
            first = first.next;
        } else {
            getNode(index-1).next = getNode(index).next;
        }
        size--;
    }

    /**Verifica si está un dato en la lista*/
    public boolean contains(int data)
    {
        int n = 0;
        try{
            while(getNode(n) != null){
                if(get(n) == data){
                    return true;
                }
                n++;
            }
        } catch(Exception e){}
        return false;
    }

}
