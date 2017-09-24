import java.util.*;
import java.io.*;
public class EjercicioEnLinea
{
    public int pos;
    public LinkedList<Character> lista;
    public EjercicioEnLinea(){
        lista = new LinkedList<>();
        pos = 0;
    }

    public void add(char letra){
        lista.add(pos, letra);
        pos++;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < lista.size(); i++){
            s += lista.get(i);
        }
        return s;
    }

    public void revisar(){
        System.out.println("Ingresar entrada ('.' para salida)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int c;
            String line = br.readLine();
            while ((c = br.read()) != -1) {
                char a = (char) c;
                if(a == '['){
                    pos = 0;
                } else if (a == ']'){
                    pos = lista.size()-1;
                } else {
                    add(a);
                }
                if(a == '.'){
                    break;
                }
            }
            System.out.println(toString());
        } catch(Exception e){}

    }

    public static void main(String [] args){
        EjercicioEnLinea e = new EjercicioEnLinea();
        e.revisar();
    }
}
