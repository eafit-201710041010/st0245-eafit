
/**
 * Guarda información de la nevera (código y descripción)
 */
public class Nevera
{
    public int id;
    public String descripcion;
    /**Constructor */
    public Nevera(int num, String nom){
        descripcion = nom;
        id = num;
    }
    /**Sobreescribir toSring para impirimir */
    public String toString(){
        return "(" + id + ", " + descripcion + ")";
    }
}
