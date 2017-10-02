import java.util.Random;
public class Taller4
{
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
    
    public static void ArraySum(int[] A, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + A[i];
        }
        System.out.println(sum);
    }

    public static void TablasDeMultiplicar(int n){
        for(int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                System.out.println(i + " * " + j + " = " + i*j);
            }
        }
    }

    public static void Ordenar(int[] A, int n){
        for(int i = 0; i <= n-1; i++){
            int j = i;
            while (j > 0 && A[j-1] > A[j]){
                int temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j = j - 1;
            }
        }
    }
    
    public static void main(String[] args, int tamanoArreglo){
        int[] hola = GeneradorDeArreglos(tamanoArreglo);
        int n = hola.length - 1;
        
        long startTime = System.currentTimeMillis();
        ArraySum(hola, n);
        long estimatedTimeSum = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        TablasDeMultiplicar(n);
        long estimatedTimeMult = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        Ordenar(hola, n);
        long estimatedTimeIns = System.currentTimeMillis() - startTime;
        
        System.out.println("Suma de arrglo con " + tamanoArreglo + " elementos se demoró " + estimatedTimeSum + " milisegundos.");
        System.out.println("Tablas de multiplicar con " + tamanoArreglo + " elementos se demoró " + estimatedTimeMult + " milisegundos.");
        System.out.println("Ordenar con " + tamanoArreglo + " elementos se demoró " + estimatedTimeIns + " milisegundos.");
    }
}
