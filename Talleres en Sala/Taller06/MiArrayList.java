import java.util.Arrays;
/**
 *
 * @author 
 */
public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 3;
    private int elements[]; 

    // Inicializa los atributos size en cero y elements como un arreglo de tamaño  DEFAULT_CAPACITY. No, no recibe parámetros. public MiArrayList() {}          // Retorna el tamaño de la lista public int size() {}          // Agrega un elemento e a la última posición de la lista public void add(int e) {}          // Retorna el elemento que se encuentra en la posición i de la lista public int get(int i) {}          // Agrega un elemento e en la posición index de la lista
    public MiArrayList() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }     

    // Retorna el tamaño de la lista 
    public int size() {
        return size;
    }   

    // Agrega un elemento e a la última posición de la lista
    public void add(int e) {
        if(elements.length == size){
            int doble = elements.length * 2;
            elements = Arrays.copyOf(elements, doble);
        }
        elements[size] = e;
        size++;
    }    

    // Retorna el elemento que se encuentra en la posición i de la lista 
    public int get(int i) {
        if (i <0 || i>= size) {
            System.out.println("Error, no existe");
        }
        return  elements[i];
    }

    // Agrega un elemento e en la posición index de la lista
    public void add(int index, int e) {
        index = index - 1;
        if(index > size){
            System.out.println("Error, no existe");
        } else {
            if(elements.length == size){
                int doble = elements.length * 2;
                elements = Arrays.copyOf(elements, doble);
            }
            for (int i = size; i >= index; i--){
                elements[i+1] = elements[i];
            }
            elements[index] = e;
            size++;
        }
    } 
}
