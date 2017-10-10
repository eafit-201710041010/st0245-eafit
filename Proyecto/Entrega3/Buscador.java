import java.io.*;
import java.util.LinkedList;
/**
 * Write a description of class Prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buscador
{
    BufferedReader br;
    /**Constructor para pruebas*/
    public Buscador(){}
    public Buscador(String file){
        try{
            br = new BufferedReader(new FileReader(file+""));
        } catch(FileNotFoundException e){}
    }
    public Archivo leerArchivo(String linea){
        int size = 0;
        String nombre;
        int distancia = 0;
        
        String[] info = linea.split(" ");
        for(int i = 0; i < info.length; i++){
            if(info[i].contains("]")){
                String tam = info[i];
                String numero = tam.substring(0, tam.length()-1);
                if(numero.contains("M") || numero.contains("K")){
                    int u;
                    char unidad = numero.charAt(numero.length()-1);
                    if(unidad == 'M'){
                        u = 1000000;
                    } else {
                        u = 1000;
                    }
                    numero = numero.substring(0, numero.length()-1);
                    double ize = Double.parseDouble(numero) * u;
                    size = (int)ize;
                } else {
                    double ize = Double.parseDouble(numero);
                    size = (int)ize;
                }
            }
            while(linea.charAt(distancia) != '['){
                distancia++;
            }
            distancia /= 4;
            System.out.println(info[i]);
        }
        nombre = info[info.length-1];
        Archivo a = new Archivo(size, nombre, distancia);
        return a;
    }
    public String leerEncabezado(){
        return "";
    }
    
    public static void hola(){
        Buscador b = new Buscador();
        //La linkedList es para poder guardar la familia del archivo (padres)
        LinkedList<Archivo> jerarquias = new LinkedList<>();
        
        String linea ="├── [root     4.0K]  mono";
        b.leerArchivo(linea);
        
        System.out.println("\n \n Cambio \n \n");
        linea ="│   ├── [root     4.0K]  certstore";
        b.leerArchivo(linea);
        
        System.out.println("\n \n Cambio \n \n");
        linea ="│   │   └── [root     4.0K]  certs";
        b.leerArchivo(linea);
        
        System.out.println("\n \n Cambio \n \n");
        linea ="│   │       └── [root      24K]  Trust";
        b.leerArchivo(linea);
        
        System.out.println("\n \n Cambio \n \n");
        linea ="│   │           ├── [root     1.5K]  ski";
        b.leerArchivo(linea);
        
        System.out.println("\n \n Cambio \n \n");
        linea = "│   │               ├── [root      333]  parole.xml";
        b.leerArchivo(linea);
    }
}
