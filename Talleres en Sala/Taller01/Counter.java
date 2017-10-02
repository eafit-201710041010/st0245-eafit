
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter
{
    private String id;
    private int n;
    
    public Counter(String _id){
        id = _id;
        n = 0;
    }
    
    public void incrementar(){
        n++;
    }
    
    public int tally(){
        return n;
    }
    
    public String toString(){
        return "El contador ha sido incrementado " + n + " veces";
    }
}
