import java.util.Arrays;
import java.util.Random;
public class Codigo
{
    /** Computer the sum of an array*/
    public static int ArraySum(int[] A){          
        int sum = 0;
        for (int i = 0; i < A.length; i++){
            System.out.println("ArraySum " + i);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
            sum = sum + A[i];
        }
        return sum;
    }

    /** Computes the maximum value of an array*/
    public static int ArrayMax(int[] A){
        int max = A[0];
        for (int i = 0; i < A.length; i++){
            System.out.println("ArrayMax " + i);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
            if (A[i] > max){
                max = A[i];
            }
        }
        return max;
    }

    /** Sorts an array using Insertion Sort*/
    public static void InsertionSort(int[] A){
        int temp,j;
        for (int i = 0; i < A.length; i++){
            System.out.println("InsertionSort " + i);
            j = i;
            while (j > 0 && A[j-1] > A[j]){
                temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j = j-1;
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){}
            }           
        }
    }

    /** Sorts an array using Merge Sort
    // Taken from www.cs.cmu.edu*/
    public static void mergeSort(int [ ] a){
        int i = 0;
        int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right){
        if( left < right )
        {
            System.out.println("InsertionSort ");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
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
        int tamano = max;
        int[] hola = GeneradorDeArreglos(max);

        //ArraySum 
        long startTime = System.currentTimeMillis();
        ArraySum(hola);
        long estimatedTimeSum = System.currentTimeMillis() - startTime;
        tiempo = estimatedTimeSum;

        String ArraySum =("ArraySum con " + tamano + " elementos se demoró " + tiempo + " milisegundos.");

        //ArrayMax
        startTime = System.currentTimeMillis();
        ArrayMax(hola);
        estimatedTimeSum = System.currentTimeMillis() - startTime;
        tiempo = estimatedTimeSum;

        String ArrayMax = ("ArrayMax con " + tamano + " elementos se demoró " + tiempo + " milisegundos.");

        //InsertionSort
        startTime = System.currentTimeMillis();
        InsertionSort(hola);
        estimatedTimeSum = System.currentTimeMillis() - startTime;
        tiempo = estimatedTimeSum;

        String InsertionSort = ("InsertionSort con " + tamano + " elementos se demoró " + tiempo + " milisegundos.");

        //mergeSort
        startTime = System.currentTimeMillis();
        mergeSort(hola);
        estimatedTimeSum = System.currentTimeMillis() - startTime;
        tiempo = estimatedTimeSum;

        String mergeSort = ("mergeSort con " + tamano + " elementos se demoró " + tiempo + " milisegundos.");
        
        System.out.println(ArraySum);
        System.out.println(ArrayMax);
        System.out.println(InsertionSort);
        System.out.println(mergeSort);
    }
}
