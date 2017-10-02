public class Taller3
{
    private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
        if(n == 1){
            System.out.println("mover " + n + " a " + destino);
        } else {
            torresDeHannoiAux(n-1, origen, destino, intermedio);
            System.out.println("mover " + n + " a " + destino);
            torresDeHannoiAux(n-1, intermedio, origen, destino);
        }
    }
    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, 1, 2, 3);
    }
    
    private static void combinationsAux(String base, String s, int n) {
        if (n == 0){
            for(int i = 0; i < s.length(); i++){
                combinationsAux("", s.substring(i), 1);
            }
        } else if (s.length() == 0){
            System.out.println(base);
        }
        else
        {
            for (int i = 1; i <= s.length(); i++){
                combinationsAux(base + s.charAt(0), s.substring(i), i);
            }
        }
    }
    public static void combinations(String s) {
        combinationsAux("", s, 0);
    }
    
    private static void permutationsAux(String base, String s) {
        if(s.length() == 0){
            System.out.println(base);
        } else {
            for (int i = 0; i < s.length(); i++){
                permutationsAux(base + s.charAt(i), s.substring(0,i) + s.substring(i+1, s.length()));
            }
        }
    }
    public static void permutation(String s) {
        permutationsAux("", s);
    }

}