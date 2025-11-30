/* If the array is sorted row wise and column wise then we perform this STAIRCASE seach method
 *  [1,3,5,7]
    [4,11,16,20]
    [6,15,17,60]

    We initialize r=0 and c=(last column)
    Then we check if the value is equal to the last element of the first row, we return the position.
    else if the key is greater than that value then we move to the next row because all prev elements of current row are smaller
    else if the key is smaller than that value then we move to the previous column because all below elements are greater
    TIME COMPLEXITY: O(n)
*/

// import java.util.Arrays;

// public class binSearch2D {
//     public static int[] stair_search(int[][] arr, int key)
//     {
//         int r= 0;
//         int c= arr[0].length -1;

//         while(r<arr.length && c>=0)
//         {
//             if(arr[r][c] == key)
//             {
//                 return new int[]{r,c};
//             } 
//             else if(arr[r][c]>key)
//             {
//                 c--;
//             }
//             else
//             {
//                 r++;
//             }
//         }
//         return new int[]{-1,-1};
//     }
//     public static void main(String args[])
//     {
//         int[][] arr={{1,3,5,7},
//                     {4,11,16,20},
//                     {6,15,17,60}
//         };
//         System.out.println(Arrays.toString(stair_search(arr, 17)));
//     }
// }




/*BINARY SEARCH
To perform binary search on 2D array, the array should be perfectly sorted row wise and column wise. Also the first element of every row
should be bigger than the last element of the previos row as 5 is greater than 4 below
[1,2,3]
[4,5,6]
[7,8,9]

The intuition here is that we will be treating it as a 1D array using divmod(division, modulus) based indexing using
r= i/n and c= i%n    where i is the index for 1D array and n= number of columns
Rest everything is same as simple binary search
TIME COMPLEXITY: O(log(n))
 */

import java.util.Arrays;
public class binSearch2D{
    static int[] bin_search(int[][] arr, int key)
    {
        int m = arr.length, n= arr[0].length;
        int low=0, high= m*n -1, mid, r,c;
        
        while(low<=high)
        {
            mid= low + (high-low)/2;
            r= mid/n;
            c= mid%n;

            if(arr[r][c] == key)
            {
                return new int[]{r,c};
            }
            else if(arr[r][c]>key)
            {
                high= mid-1;
            }
            else
            {
                low= mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] arr =  {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
    
    System.out.println(Arrays.toString(bin_search(arr, 8)));
    }
}