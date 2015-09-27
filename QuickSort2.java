package SortingPractice;

import java.util.Scanner;

/**
 *
 * @author Rajiur
 */
public class QuickSort2 {
    
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
    private static void quickSort(int[] ar, int lowerIndex, int higherIndex){
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = ar[lowerIndex+(higherIndex-lowerIndex)/2];
        while(i<=j){
            while(ar[i] < pivot){i++;}
            while(ar[j] > pivot){j--;}
            if(i<=j){
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i++;
                j--;
            }
        }
        if(lowerIndex < j){
            quickSort(ar, lowerIndex, j);
        }
        if(i < higherIndex){
            quickSort(ar, i, higherIndex);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
        }
        quickSort(ar, 0, ar.length-1);
        printArray(ar);
    } 
}
