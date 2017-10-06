import java.util.*;
public class Banco
{    
    /**Recibe arreglo de filas, y reparte elementos entre dos cajeros*/
    public void recibirFilas(Queue[] filas){
        int cajero = 1;
        for(int i = 0; i < filas.length; i++){
            if(!(filas[i].isEmpty())){
                if(cajero == 1){
                    System.out.println("Atendiendo a " + filas[i].poll() + " en el cajero " + cajero);
                    cajero++;
                } else {
                    System.out.println("Atendiendo a " + filas[i].poll() + " en el cajero " + cajero);
                    cajero--;
                }
            }
        }
        int chao = 0;
        for(int i = 0; i < filas.length; i++){
            if(filas[i].isEmpty()){
                chao++;
            }
        }
        if(chao < 4){
            recibirFilas(filas);
        }
    }
    
    public static void main(String [] args){
        Banco banco = new Banco();
        Queue<String> f1 = new LinkedList<String>();
        Queue<String> f2 = new LinkedList<String>();
        Queue<String> f3 = new LinkedList<String>();
        Queue<String> f4 = new LinkedList<String>();
        
        f1.add("Ana");
        f1.add("Eduardo");
        f1.add("Ingrid");
        f2.add("Beatriz");
        f2.add("Felipe");
        f2.add("Juan");
        f3.add("Candance");
        f3.add("Guillermina");
        f4.add("Diana");
        f4.add("Helga");
        f4.add("Kiwi");
        
        Queue[] filas = {f1, f2, f3, f4};
        banco.recibirFilas(filas);
    }
}
