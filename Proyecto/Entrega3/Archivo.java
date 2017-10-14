import java.util.ArrayList;
public class Archivo implements Comparable<Archivo>
{
    int size;
    String nombre;
    Archivo jefe;
    boolean porNombre;
    boolean buscando;
    ArrayList<Archivo> iguales;
    public Archivo(int tam, String nom, Archivo boss){
        size = tam;
        nombre = nom;
        jefe = boss;
        porNombre = false;
        buscando = false;
        iguales = new ArrayList<Archivo>();
        iguales.add(this);
    }
    public Archivo(int tam, String nom){
        size = tam;
        nombre = nom;
        jefe = null;
        porNombre = false;
        buscando = false;
        iguales = new ArrayList<Archivo>();
        iguales.add(this);
    }
    public Archivo(int tam){
        size = tam;
        nombre = "";
        jefe = null;
        buscando = true;
        porNombre = false;
    }
    public Archivo(String nom){
        size = 0;
        nombre = nom;
        jefe = null;
        buscando = true;
        porNombre = true;
    }
    
    @Override
    public int compareTo(Archivo a){
        if(a.porNombre != porNombre){
            System.out.println("Hay un error");
            return 999;
        } else if (a.porNombre){
            return compararNombre(a);
        } else {
            return compararSize(a);
        }
    }
    
    public int compararSize(Archivo a){
        int n = Integer.compare(size, a.size);
        if(!(a.buscando) && !(buscando)){
            if(n == 0){
                a.iguales.add(this);
                buscando = true;
            }
        }
        return n;
    }
    public int compararNombre(Archivo a){
        int n = nombre.compareTo(a.nombre);
        if(!(a.buscando) && !(buscando)){
            if(n == 0){
                a.iguales.add(this);
                buscando = true;
            }
        }
        return n;
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
        return s + " " /*+ imprimirDireccion() + "\n"*/;
    }
}
