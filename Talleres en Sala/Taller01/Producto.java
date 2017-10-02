
/**
 * Implementacion del tipo de dato abstracto "Fecha"
 */
public class Producto
{
    private Fecha hoy;
    private Fecha vencimiento;
    
    public Producto(Fecha actual, Fecha vence){
        hoy = actual;
        vencimiento = vence;
    }
    
    public boolean comestible(){
        if(hoy.compareTo(vencimiento) == "Después"){
            System.out.println("No");
            return false;
        }
        System.out.println("Sí");
        return true;
    }
    
    public static void main(String [] args){
        Fecha actual = new Fecha(2017, 7, 17);
        Fecha vence = new Fecha(1937, 5, 29);
        Producto leche = new Producto(actual, vence);
        
        leche.comestible();
    }
}
