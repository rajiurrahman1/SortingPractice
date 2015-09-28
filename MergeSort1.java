package SortingPractice;

import java.util.Scanner;

/**
 *
 * @author Rajiur
 */
public class MergeSort1 {
    
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        mergeSort(ar, 0, ar.length-1);
        printArray(ar);
    }
	
    private static void mergeSort(int[] ar, int startIndex, int endIndex) {
        if(startIndex < endIndex){
            int mid = startIndex+(endIndex-startIndex)/2;
            System.out.println("start-"+startIndex+" mid-"+mid+" end-"+endIndex);
            mergeSort(ar, startIndex, mid);
            mergeSort(ar, mid+1, endIndex);
            merge(ar, startIndex, mid, endIndex);
        }
    }
	
    private static void merge(int[] ar, int startIndex, int mid, int endIndex) {
        int i,j,k;
        int[] left = new int[mid - startIndex+1];
        int[] right = new int[endIndex - mid];
        for(i=0; i<left.length; i++){
            left[i] = ar[i];
        }
        for(j=0; j<right.length; j++){
            right[j] = ar[i+j];
        }
        i=0; j=0; k=0;
        while(i<left.length && j<right.length){
            if(left[i] <= right[j]){
                ar[k] = left[i];
                i++;
            }
            else{
                ar[k] = right[j];
                j++;
            }
            k++;
        }
        if(i < left.length){ //if right is empty, the copy the rest of left to main array
            while(i<left.length){
                ar[k++] = left[i++];
            }
        }
        if(j < right.length){ //left is empty, copty the rest from right
            while(j<right.length){
                ar[k++] = right[j++];
            }
        }
        
    }
    
	private static void printArray(int[] ar) {
        for(int n: ar){
           System.out.print(n+" ");
        }
        System.out.println("");
    }
}
