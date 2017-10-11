import java.io.*;
public class CreadorDeArbol
{
    BufferedReader br;
    public CreadorDeArbol(String file){
        try{
            br = new BufferedReader(new FileReader(file+""));
        } catch(FileNotFoundException e){}
    }

    public void crearArbol() throws Exception {
        AvlTree<Archivo> t = new AvlTree<Archivo>();
        CreadorDeArchivos arch = new CreadorDeArchivos();
        String linea = br.readLine();
        arch.leerEncabezado(linea);
        while(linea != null){
            linea = br.readLine();
            Archivo a = arch.leerLinea(linea);
            if(a == null){
                break;
            }
            t.insert(a);
        }
    }
    
    public static void main(String [] args) throws Exception {
        CreadorDeArbol arb = new CreadorDeArbol("ejemplito.txt");
    }
}










