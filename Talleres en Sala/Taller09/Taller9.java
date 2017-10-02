import java.util.Hashtable;

public class Taller9{

    //pedrito 1
    public static void agregar(Hashtable empresas,String key, String value){
        empresas.put(key, value);
    }

    //pedrito 2
    public static void buscar(Hashtable empresas,String key){
        System.out.println(empresas.get(key));
    }
    //pedrito 3
    public static boolean contienekey(Hashtable empresas,String key){
        return empresas.containsKey(key);
    }

    public static boolean contienePais(Hashtable empresas,String value){
        return empresas.containsValue(value);
    }

    public static void main(String[] args) {
        Hashtable<String, String> empresas = new Hashtable<>();
        agregar(empresas, "google", "Estados Unidos");
        agregar(empresas, "locura ", "Colombia");
        agregar(empresas, "Nokia ", "Finlandia");
        agregar(empresas, "Sony ", "Japón");

        if(contienekey(empresas, "google")){
            System.out.println("google si existe");
            System.out.println("Google es de "); 
            buscar(empresas,"google");
        } else {
            System.out.println("google no existe");
        }

        if(contienekey(empresas, "motorola")){
            System.out.println("motorola si existe");
            System.out.println("motorola es de "); 
            buscar(empresas,"motorola");
        } else {
            System.out.println("motorola no existe");
        }

        if(contienePais(empresas, "Finlandia")){
            System.out.println("Finlandia si tiene empresa(s)");
        } else {
            System.out.println("Finlandia no tiene empresas");
        }
        if(contienePais(empresas, "India")){
            System.out.println("India si tiene empresa(s)");
        } else {
            System.out.println("India no tiene empresas");
        }
    }
}