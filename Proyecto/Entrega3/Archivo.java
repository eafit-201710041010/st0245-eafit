import java.util.ArrayList;
public class Archivo implements Comparable<Archivo>
{
    String size;
    String nombre;
    Archivo jefe;
    boolean porNombre;
    boolean buscando;
    ArrayList<Archivo> iguales;
    AvlTree<Archivo> igualNombre;
    AvlTree<Archivo> subDirectorios;
    public Archivo(String tam, String nom, Archivo boss){
        size = tam;
        nombre = nom;
        jefe = boss;
        porNombre = false;
        buscando = false;
        subDirectorios = new AvlTree<Archivo>();
        igualNombre = new AvlTree<Archivo>();
        Archivo copia = new Archivo(this);
        igualNombre.insert(copia);
        copia.iguales.add(copia);
        iguales = new ArrayList<Archivo>();
        iguales.add(this);
    }
    public Archivo(String tam, String nom){
        size = tam;
        nombre = nom;
        jefe = null;
        buscando = true;
        igualNombre = new AvlTree<Archivo>();
        Archivo copia = new Archivo(this);
        igualNombre.insert(copia);
        subDirectorios = new AvlTree<Archivo>();
        iguales = new ArrayList<>();
        iguales.add(this);
    }
    public Archivo(String tamnom, boolean nom){
        porNombre = nom; 
        if (nom){
            size = "";
            nombre = tamnom;
        }else {
            size = tamnom;
            nombre = "";
        }
        jefe = null;
        buscando = true;
    }
    public Archivo(Archivo a){
        nombre = a.nombre;
        size = a.size;
        jefe = a.jefe;
        porNombre = false;
        buscando = false;
        iguales = new ArrayList<Archivo>();
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
        int n = size.compareTo(a.size);
        if(!(a.buscando || buscando)){
            if(n == 0){
                a.iguales.add(this);
                buscando = true;
            }
        }
        return n;
    }
    public int compararNombre(Archivo a){
        int n = nombre.compareTo(a.nombre);
        if(!(a.buscando || buscando)){
            if(n == 0){
                a.iguales.add(this);
                buscando = true;
                Archivo copia = new Archivo(this);
                a.igualNombre.insert(copia);
            }
        }
        return n;
    }
    
    public String imprimirDireccion(){
        return imprimirDireccion(this) + "/" + nombre;
    }
    private String imprimirDireccion(Archivo a){
        if(a.jefe == null){
            return "";
        }
        String s = imprimirDireccion(a.jefe) + "/" + a.jefe.nombre;
        return s;
    }
    
    public String imprimirSubdirectorios(){
        String s = "";
        if(subDirectorios.numberOfElements() > 0){
            s += "Con " + subDirectorios.numberOfElements() + " subdirectorios\n\t" + subDirectorios.serializePrefix() + "\n";
        }
        return s;
    }
    
    public String toString(){
        String s = nombre;
        return s + " " + size + "\t" + imprimirDireccion();
    }
}
