import java.util.*;
/**
 * Realiza los pedidos con las solicitudes, y 
 * las neveras que se agregan a la orden
 */
public class Entrega
{
    public Solicitud pedidor;
    public LinkedList<Nevera> neveras;
    /**Constructor */
    public Entrega(Solicitud s){
        neveras = new LinkedList<>();
        pedidor = s;
    }
    /**Agrega neveras a la lista de la entrega */
    public void add(Nevera nevera){
        neveras.add(nevera);
    }
    /**Sobreescribir el toString para pode imprimir */
    public String toString(){
        String s = pedidor.nombre + "-> ";
        for(int i = 0; i < neveras.size(); i++){
            s += neveras.get(i).toString() + " ";
        }
        return s;
    }
}
