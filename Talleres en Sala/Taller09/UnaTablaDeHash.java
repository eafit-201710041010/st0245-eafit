import java.util.LinkedList;

public class UnaTablaDeHash
{
    // Ojo, esta tabla definida así no permite manejar las colisiones
    private LinkedList<Integer>[] tabla;

    public UnaTablaDeHash(){
        tabla = new LinkedList[10];
        for(int i = 0; i < tabla.length; i++){
            tabla[i] = new LinkedList<>();
        }
    }

    // Ojo, esta función hash es muy ingenua
    private int funcionHash(String k){
        return ((int) k.charAt(0)) % 10;
    }

    // Ojo con las colisiones
    public LinkedList get(String k){
        int mapa = funcionHash(k);
        int res = 0;
        return tabla[mapa];
    }

    // Ojo con las colisiones
    public void put(String k, int v){
        int mapa = funcionHash(k);
        tabla[mapa].push(v);
    }
    
    public static void main(String [] args){
        UnaTablaDeHash tabla = new UnaTablaDeHash();
        tabla.put("Hugo", 3213134);
        tabla.put("Hugo", 3003000);
        tabla.put("Gringo", 5762456);
        tabla.put("Fijo", 1234567);
        
        System.out.println(tabla.get("Hugo"));
        System.out.println(tabla.get("Gringo"));
        System.out.println(tabla.get("Fijo"));
    }
}




















