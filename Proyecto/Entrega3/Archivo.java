
/**
 * Write a description of class Archivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Archivo implements Comparable<Archivo>
{
    int size;
    String nombre;
    Archivo jefe;
    int jerarquia;
    public Archivo(int tam, String nom, Archivo boss){
        size = tam;
        nombre = nom;
        jefe = boss;
    }
    public Archivo(int tam, String nom, int jer){
        size = tam;
        nombre = nom;
        jerarquia = jer;
        jefe = null;
    }
    public int compareTo(Archivo a){
        if(a.size > size){
            return -1;
        } else if (a.size == size){
            return 0;
        } else {
            return 1;
        }
    }
}
