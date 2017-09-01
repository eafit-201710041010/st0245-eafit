import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ejercicios
{
    /** ArraySum recursivo */
    public static int ArraySum(int[] A, int n){
        if (n == 0){
            return A[n];
        } else {
            return A[n] + ArraySum(A, n-1);
        }
    }

    /** Array Máximo recursivo */
    public static int ArrayMax(int [] A, int n){
        int max = A[n];
        int temp;
        if (n == 0) {
            max = A[0];
        } else {
            temp = ArrayMax(A, n-1);
            if (temp > max){
                max = temp;
            }
        }
        return max;
    }

    /** fibonacci recursivo */
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}
