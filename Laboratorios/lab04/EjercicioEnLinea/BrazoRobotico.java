import java.util.*;
/**
 * Write a description of class Brazo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrazoRobotico
{
    Stack<Integer>[] stacks;
    public BrazoRobotico(int n){
        stacks = new Stack[n];
        for(int i = 0; i < stacks.length; i++){
            Stack<Integer> stack = new Stack<Integer>();
            stacks[i] = stack;
            stacks[i].push(i);
        }
    }

    public void leerComandos(String[] comandos){
        //Leer comando
        int a = Integer.parseInt(comandos[1]);
        int b = Integer.parseInt(comandos[3]);
        String comandoUno = comandos[0];
        String comandoDos = comandos[2];
        //Decidir pilas
        int sa = decidirPila(a);
        int sb = decidirPila(b);
        if(sa == -1 || sb == -1){
            System.out.println("No existe uno o ambos bloques solicitados");
            return;
        } else if(sa == sb){
            System.out.println("Están en la misma pila");
            return;
        }
        Stack<Integer> sA = stacks[sa];
        Stack<Integer> sB = stacks[sb];
        //Movimientos
        if(comandoUno.equals("move")){
            if(comandoDos.equals("onto")){
                moveOnto(a, b, sA, sB);
            } else if(comandoDos.equals("over")) {
                moveOver(a, b, sA, sB);
            }
        } else if(comandoUno.equals("pile")){
            if (comandoDos.equals("onto")) {
                pileOnto(a, b, sA, sB);
            } else if(comandoDos.equals("over")) {
                pileOver(a, b, sA, sB);
            }
        } else {
            System.out.println("Comando inválido");
        }
    }

    public int decidirPila(int n){
        int pila = -1;
        for(int i = 0; i < stacks.length; i++){
            Stack<Integer> stack = stacks[i];
            if(stack.contains(n)){
                return i;
            }
        }
        return pila;
    }

    public void moveOnto(int a, int b, Stack<Integer> sa, Stack<Integer> sb){
        while(sa.peek() != a){
            devolver(sa.pop());
        }
        while(sb.peek() != b){
            devolver(sb.pop());
        }
        sb.push(sa.pop());
    }
    public void moveOver(int a, int b, Stack<Integer> sa, Stack<Integer> sb){
        while(sa.peek() != a){
            devolver(sa.pop());
        }
        sb.push(sa.pop());
    }
    public void pileOnto(int a, int b, Stack<Integer> sa, Stack<Integer> sb){
        Stack<Integer> losAmigosDeA = new Stack<Integer>();
        int n = sa.pop();
        while(n != a){
            losAmigosDeA.push(n);
            n = sa.pop();
        }
        losAmigosDeA.push(n);
        while(sb.peek() != b){
            devolver(sb.pop());
        }
        while(!(losAmigosDeA.isEmpty())){
            sb.push(losAmigosDeA.pop());
        }
    }
    public void pileOver(int a, int b, Stack<Integer> sa, Stack<Integer> sb){
        Stack<Integer> losAmigosDeA = new Stack<Integer>();
        int n = sa.pop();
        while(n != a){
            losAmigosDeA.push(n);
            n = sa.pop();
        }
        losAmigosDeA.push(n);
        while(!(losAmigosDeA.isEmpty())){
            sb.push(losAmigosDeA.pop());
        }
    }

    public void devolver(int n){
        stacks[n].push(n);
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < stacks.length; i++){
            Stack<Integer> secundario = new Stack<>();
            s += i + ":";
            while(!(stacks[i].isEmpty())){
                int a = stacks[i].pop();
                secundario.push(a);
            }
            while(!(secundario.isEmpty())){
                int a = secundario.pop();
                s += " " + a;
                stacks[i].push(a);
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String [] args){
        System.out.println("Ingresa número de bloques");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BrazoRobotico brazo = new BrazoRobotico(n);
        System.out.println(brazo);
        in = new Scanner(System.in);
        String s = in.nextLine();
        while(!(s.equals("quit"))){
            String[] comandos = s.split(" ");
            try{
                brazo.leerComandos(comandos);
            }catch(Exception e){
                System.out.println("Comando inválido");
            }
            System.out.println(brazo);
            s = in.nextLine();
        }
    }
}
