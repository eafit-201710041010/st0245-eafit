import java.io.*;
public class CreadorDeArbol
{
    BufferedReader br;
    BufferedReader br2;
    public CreadorDeArbol(String file){
        try{
            br = new BufferedReader(new FileReader(file+""));
            br2 = new BufferedReader(new FileReader(file+""));
        } catch(FileNotFoundException e){}
    }

    public AvlTree<Archivo> crearArbol() throws Exception {
        AvlTree<Archivo> t = new AvlTree<Archivo>();
        
        CreadorDeArchivos arch = new CreadorDeArchivos();
        String linea = br.readLine();
        t.insert(arch.leerEncabezado(linea, false));
        while(linea != null){
            linea = br.readLine();
            Archivo a = arch.leerLinea(linea, false);
            if(a == null){
                break;
            }
            //System.out.println(a);
            a.porNombre = false;
            t.insert(a);
        }
        return t;
    }
    
    public AvlTree<Archivo> crearArbol2() throws Exception {
        AvlTree<Archivo> t = new AvlTree<Archivo>();
        
        CreadorDeArchivos arch = new CreadorDeArchivos();
        String linea = br2.readLine();
        t.insert(arch.leerEncabezado(linea, true));
        while(linea != null){
            linea = br2.readLine();
            Archivo a = arch.leerLinea(linea, true);
            if(a == null){
                break;
            }
            //System.out.println(a);
            a.porNombre = true;
            t.insert(a);
        }
        return t;
    }
}










