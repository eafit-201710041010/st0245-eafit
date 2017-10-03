public class Nodo
{
    /**
     * Atributos de árbol
     */
    Nodo pad;
    Nodo der;
    Nodo izq;
    int altura;
    /**
     * Atributos de archivo
     */
    int tam;
    String nombre;
    /**
     * Constructor
     */
    public Nodo(int size, String name){
        tam = size;
        nombre = name;
        altura = 0;
    }
}
