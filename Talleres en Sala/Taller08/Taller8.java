 
import java.util.*;

/**
 *
 * @author 
 */
public class Taller8 {

    //Punto 1
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> stack2 = new Stack<Integer>();
        while(!stack.empty()){
            stack2.addElement(stack.pop());
        }
        return stack2;
    }

    //Punto 2
    public static void cola (Queue<String> queue){
        while(!queue.isEmpty()){
            System.out.println("Atendiendo a " + queue.poll());
        }
    }

    //notacion polaca
    public static int polaca (String string){
        Stack<Integer> stack = new Stack<Integer>();
        String[] nums = string.split(" ");
        for(int i = 0; i < nums.length; i++){
            String a = nums[i];
            if(a.equals("+")){
                int b = stack.pop() + stack.pop();
                stack.push(b);
            } else if (a.equals("-")){
                int b = stack.pop() - stack.pop();
                stack.push(b);
            } else if (a.equals("*")){
                int b = stack.pop() * stack.pop();
                stack.push(b);
            } else if (a.equals("/")){
                int b = stack.pop() / stack.pop();
                stack.push(b);
            } else {
                int b = Integer.parseInt(a);
                stack.push(b);
            }
        }
        return stack.pop();
    }
}