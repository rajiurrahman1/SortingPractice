package SortingPractice;

import java.util.Scanner;

/**
 *
 * @author Rajiur
 */
public class Insertion1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        insertionSortPart2(ar);    
                    
    }    
    private static void insertionSortPart2(int[] ar) {
        for(int i=1; i<ar.length; i++){ //start from the second element 
                                        //assume first element is already sorted
            int correctIndex = findCorrectIndexOfElement(ar, i);
//            System.out.println("element:"+ar[i]+ " index:"+correctIndex);
            if( correctIndex != i){ //do nothing if i==correctIndex, element in the right place
                //else
                //move elements from correctIndex to index (i) one step right
                int element = ar[i];
                for(int j=i-1; j>=correctIndex; j--){ //move elements of this range
                    ar[j+1]=ar[j];
                }
                ar[correctIndex] = element; // now put the i'th elemen in it's correct position
            }
            printArray(ar);
        }
    }
    private static int findCorrectIndexOfElement(int[] ar, int index) {
        int correctIndex = 0;
        int i = 0;
        for(i=0; i<index; i++){
            if(ar[i] < ar[index]){
                continue;
            }
            else{
                correctIndex = i;
                break;
            }
        }
        if(i==index){return index;}
        else return correctIndex;
    }
    private static void printArray(int[] ar) {
        for(int n: ar){
           System.out.print(n+" ");
        }
        System.out.println("");
    }
}
