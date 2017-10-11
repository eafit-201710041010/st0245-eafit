
public class Archivo implements Comparable<Archivo>
{
    int size;
    String nombre;
    Archivo jefe;
    public Archivo(int tam, String nom, Archivo boss){
        size = tam;
        nombre = nom;
        jefe = boss;
    }
    public Archivo(int tam, String nom){
        size = tam;
        nombre = nom;
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

    public String imprimirDireccion(){
        return imprimirDireccionAux(this) + "/" + nombre;
    }
    private String imprimirDireccionAux(Archivo a){
        if(a.jefe == null){
            return "";
        }
        String s = imprimirDireccionAux(a.jefe) + "/" + a.jefe.nombre;
        return s;
    }
    public String toString(){
        String s = nombre;
        if(size >= 1000000){
            double size2 = size / 1000000.0;
            s += " " + size2 + "M";
        } else if(size >= 1000){
            double size2 = size / 1000.0;
            s += " " + size2 + "K";
        } else {
            s += " " + size;
        }
        return s;
    }
}
