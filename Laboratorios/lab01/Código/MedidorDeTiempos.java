import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MedidorDeTiempos
{
    /** ArraySum recursivo */
    public static int ArraySum(int[] A, int n){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){}
        if (n == 0){
            return A[n];
        } else {
            return A[n] + ArraySum(A, n-1);
        }
    }

    /** Array Máximo recursivo */
    public static int ArrayMax(int [] A, int n){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){}
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

    /**Generador de Arreglos*/
    public static int[] GeneradorDeArreglos(int n) {
        int size = n;
        int max = 5000;
        int[] A = new int[size];
        Random generator = new Random();
        for (int i =0; i<size; i++){
            A[i] = generator.nextInt(max);
        }
        return A;
    }

    /** Main para medir tiempos*/
    public static void main(String[] args, int max){
        long tiempo;
        int tamano;
        int[] hola = GeneradorDeArreglos(max);

        //ArraySum 
        long startTime = System.currentTimeMillis();
        ArraySum(hola, max-1);
        long estimatedTimeSum = System.currentTimeMillis() - startTime;
        tiempo = estimatedTimeSum;
        tamano = max;

        System.out.println("ArraySum con " + tamano + " elementos se demoró " + tiempo + " milisegundos.");

        //ArrayMax
        startTime = System.currentTimeMillis();
        ArrayMax(hola, max-1);
        estimatedTimeSum = System.currentTimeMillis() - startTime;
        tiempo = estimatedTimeSum;
        tamano = max;

        System.out.println("ArrayMax con " + tamano + " elementos se demoró " + tiempo + " milisegundos.");

        // Fibonacci
        startTime = System.currentTimeMillis();
        fibonacci(max-1);
        estimatedTimeSum = System.currentTimeMillis() - startTime;

        tiempo = estimatedTimeSum;
        tamano = max;

        System.out.println("Fibonacci con " + tamano + " elementos se demoró " + tiempo + " milisegundos.");
    }
}
