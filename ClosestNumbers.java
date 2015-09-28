package SortingPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Rajiur
 */
public class ClosestNumbers {
    public static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
    private static void quickSort(int[] ar, int lowerIndex, int higherIndex){
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = ar[lowerIndex+(higherIndex-lowerIndex)/2];
//        int pivot = ar[lowerIndex];
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
        int[] ar2 = new int[n];
        for(int i=0;i<n;i++){
            int temp = in.nextInt(); 
            ar2[i] = temp;
        }      
        quickSort(ar2, 0, ar2.length-1);
        int[] diff = new int[n-1];
        Arrays.fill(diff, 0);
        for(int i=0; i<diff.length; i++){
            diff[i] = ar2[i+1]-ar2[i];
        }
//        printArray(ar2);
//        printArray(diff);
        int minDiff = findMin(diff);
        for(int i=0; i<diff.length-1; i++){
            if(diff[i]==minDiff){
                System.out.print(ar2[i]+" "+ar2[i+1]+ " ");
            }
        }
    } 

    private static int findMin(int[] diff) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<diff.length; i++){
            if(diff[i] < min){min = diff[i];}
        }
        return min;
    }
}
