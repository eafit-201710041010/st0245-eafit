import java.util.List;
import java.util.Scanner;
/**
 * Write a description of class Buscador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buscador
{
    AvlTree<Archivo> tnum;
    AvlTree<Archivo> tnom;
    public Buscador(AvlTree<Archivo> num, AvlTree<Archivo> nom){
        tnum = num;
        tnom = nom;
    }

    public Archivo leerBusqueda(){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingresar parámetro de búsqueda (\"nombre\" o \"tamaño\") o \" salir\" para salir");
        String par;
        while(true){
            par = in.next();
            if(par.equals("tamaño")){
                System.out.println("Ingrese el tamaño del archivo buscado (ejemplo \"255K\")");
                String numero = in.next();
                Archivo a = new Archivo(numero, false);
                return a;
            } else if (par.equals("nombre")){
                System.out.println("Ingrese el nombre del archivo buscado (ejemplo \"miArchivoPreferido.txt\")");
                String nombre = in.next();
                Archivo a = new Archivo(nombre, true);
                return a;
            } else if(par.equals("salir")){
                return null;
            } else {
                System.out.println("Ingresar parámetro válido (\"nombre\" o \"tamaño\")");
            }
        }
    }

    public Archivo buscar(Archivo a){
        Archivo encontrado;
        if(a.porNombre){
            encontrado = tnom.buscar(a);
        } else {
            encontrado = tnum.buscar(a);
        }
        return encontrado;
    }

    public static void main(String [] args) throws Exception {
        long startTime ;
        long estimatedTimeSum;

        CreadorDeArbol arb = new CreadorDeArbol("juegos.txt");
        //CreadorDeArbol arb = new CreadorDeArbol("treeEtc.txt");
        //CreadorDeArbol arb = new CreadorDeArbol("ejemplito.txt");

        //Creación árbol 1
        startTime = System.currentTimeMillis();
        AvlTree<Archivo> tnum = arb.crearArbol();
        estimatedTimeSum = System.currentTimeMillis() - startTime;
        long creacion1 = estimatedTimeSum;
        
        System.out.println("Creación árbol por tamaño: " + creacion1);
        
        //Creación árbol 2
        startTime = System.currentTimeMillis();
        AvlTree<Archivo> tnom = arb.crearArbol2();
        estimatedTimeSum = System.currentTimeMillis() - startTime;
        long creacion2 = estimatedTimeSum;
        
        System.out.println("Creación árbol por nombre: " + creacion2);
        
        
        //Buscador
        Buscador buscador = new Buscador(tnum, tnom);
        Archivo perdido = buscador.leerBusqueda();
        List<Archivo> encontrados;
        while(perdido != null){
            startTime = System.currentTimeMillis();
            Archivo encontrado = buscador.buscar(perdido);
            long tiempoDeBusqueda = System.currentTimeMillis() - startTime;
            if(encontrado == null){
                System.out.println("No se encontraron archivos o carpetas con las características ingresadas");
            } else {
                encontrados = encontrado.iguales;
                System.out.println("Se encontraron " + (encontrados.size()) + " archivo(s) de ese nombre o tamaño en " + tiempoDeBusqueda + " milisegundos");
                for(int i = 0; i < encontrados.size(); i++){
                    System.out.println(encontrados.get(i));
                }
                System.out.println();
            }
            perdido = buscador.leerBusqueda();
        }
        
        //Nombre y tamaño ejemplos para juegos.txt: talk020.bfstm, 255K
        //Nombre y tamaño ejemplos para treeEtc.txt: powerbtn.sh , 43
        //Nombre y tamaño ejemplos para ejemplito.txt: rosette.eps , 4.0K
    }
}
