import java.util.Scanner;
/**
 * Write a description of class Lector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lector
{
    public static void main(String[] args){
        BinaryTree arb = new BinaryTree();
        System.out.println("Ingresar datos en preorden");
        Scanner in = new Scanner(System.in);
        int n;
        while(in.hasNextLine()){
            String s = in.nextLine();
            try{
                n = Integer.parseInt(s);
                arb.insertar(n);
            } catch(Exception e){
                break;
            }
        }
        arb.recursivePrint();
    }
}