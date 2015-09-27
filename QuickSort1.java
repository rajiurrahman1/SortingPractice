package SortingPractice;

import java.util.Scanner;

/**
 *	Quick sort with utilizing extra memory 
 *
 * @author Rajiur
 */
public class QuickSort1 {
    static void printArray(int[] ar) {
        for(int n: ar){
           System.out.print(n+" ");
        }
        System.out.println("");
    }
    static int[] partition(int[] ar, int len) {
        if(len == 0){
            return ar;
        }
        int pivot = ar[0];
        int[] ar1 = new int[len];
        int[] ar2 = new int[len];
        int ar1Counter = 0, ar2Counter = 0;
        for(int i=1; i<len; i++){
            if(ar[i] <= pivot){
                ar1[ar1Counter++] = ar[i];
            }
            else{
                ar2[ar2Counter++] = ar[i];
            }
        }
        ar1 = partition(ar1, ar1Counter );
        ar2 = partition(ar2, ar2Counter );
        for(int i=0; i<len; i++){
            if(i<ar1Counter){
                ar[i] = ar1[i];
            }
            else if(i == ar1Counter){
                ar[i] = pivot;
            }
            else{
                ar[i] = ar2[i-ar1Counter-1];
            }
        }
        return ar;
    }   
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int[] ar = new int[n];
         for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
         }
         
         int[] sortedArray = partition(ar, ar.length);
         printArray(sortedArray);
     }     
}
