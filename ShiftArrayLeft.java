import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 | - - - - - - - - - - - - - - - - - - - - - - - Problem Statement - - - - - - - - - - - - - - - - - - - - - - - - - - |
 | A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.             |
 | For example, if left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2]. |
 | Given an array of n integers and a number, d, perform d left rotations on the array.                                |
 | Then print the updated array as a single line of space-separated integers.                                          |
 | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |

 | - - - - - - - - - - - - - - - - - - - - - - Analysis - - - - - - - - - - - - - - - - - - - - - - - - - -|
 | The naive solution requires O(n) extra space complexity (simply create a new array and copy elements).  |
 |                                                                                                         |
 | A naive solution with only O(1) space complexity would involve multiple shifts of 1,                    |
 | resulting in O(shifts * n) time.                                                                        |
 |                                                                                                         |
 | This solution utilizes the greatest common factor between array size and shift number, since the GCF of |
 | these numbers is equal to the number of cyclic groups with all unique elements. This means we can have  |
 | a solution that runs in O(n) time with only O(1) space complexity.                                      |
 | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |
*/

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
