
public class Taller02
{
    public static int gdc(int x, int y){
        if (y == 0){
            return x;
        }
        else {
            return gdc(y, x % y);
        }
    }

    public static boolean sumaGrupo(int start,  int[] nums, int target) {
        if (start >= nums.length){
            return false;
        }
        else {
            int c = 0;
            for(int i = start; i < nums.length; i++){
                c += nums[i];
            }
            if (c == target){
                return true;
            }
            
            
            if(sumaGrupo(start+1, nums, target)) {
                return true;
            }
            return false;
        }
    }    
    
    public static void combinations(String base, String s, int j){
        if (j == 0){
            for(int i = 0; i < s.length(); i++){
                combinations("", s.substring(i), 1);
            }
        } else if (s.length() == 0){
            System.out.println(base);
        }
        else
        {
            for (int i = 1; i <= s.length(); i++){
                combinations(base + s.charAt(0), s.substring(i), i);
            }
        }
    }
     
    public static void main(String[] args){
        System.out.println("Punto 1");
        System.out.println(gdc(345, 150));
        System.out.println();
        
        int[] nums = {4,2,8};
        System.out.println("Punto 2");
        System.out.println(sumaGrupo(0, nums, 10));
        System.out.println();
        
        System.out.println("Punto 3");
        combinations("", "abcde", 0);
        System.out.println();
    }
}