import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int gcf(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int findNextIndex(int[] arr, int shifts, int currentPosition) {
        if (currentPosition + shifts >= arr.length)
            return (currentPosition + shifts - arr.length);
        return (currentPosition + shifts);
    }
    
    public static void shiftArray(int[] arr, int shifts) {
        
        shifts = shifts % arr.length;
        int steps = gcf(arr.length, shifts);
        
        for (int i=0; i<steps; i++) {
            int currentPosition = i;
            int nextPosition = findNextIndex(arr, shifts, i);
            int temp = arr[i];
            while (nextPosition != i) {
                arr[currentPosition] = arr[nextPosition];
                currentPosition = nextPosition;
                nextPosition = findNextIndex(arr, shifts, currentPosition);
            }
            arr[currentPosition] = temp;
        }   
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        shiftArray(a, k);
        for(int a_i=0; a_i < n; a_i++){
            System.out.print(a[a_i] + " ");
        }
    }
}
