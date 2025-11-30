/*Prefix sum means sum of the previous elements of the array upto a certain index
For example in arr = [1,2,3,4,5]
prefix_arr = [1,3,6,10,15]

There are various types in which prefix array is used
1) Range sum problems- Questions in which we are asked sum of range of indices*/

public class prefix_sum {
    static int[] pref;
    prefix_sum(int[] nums){
        pref = new int[nums.length];
        pref[0] = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            pref[i] = pref[i-1] + nums[i];
        }

    }
    static int sumArray(int left, int right){
        int sum;
        if(left==0)
        return sum = pref[right];
        else
        return sum = pref[right] - pref[left-1];
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6};
        prefix_sum Numbers = new prefix_sum(nums);
        int left= 2, right= 4;
        System.out.println("Sum = " + sumArray(left, right));
    }
}






/*
 * 2) Difference array- We are asked to increment values of array. With simple method of iterating over all elements with time complexity of
    O(n). We fix the first element and then find the change in value with each increasing index.
    For example, arr= [15, 10, 5, 20, 40]
    we find difference array->   diff_arr = [15, -5, -5, 15, 20, 0]

    Now if we are asked to increase values as (l,r,val) ==> (1,4, 10)    where 10 is the value to be increased
    We just make changes at diff_arr[l] and diff_arr[r+1] as ==>    diff_arr[l]+=val   &    diff_arr[r+1]-=val

    because the gradient in the range giver to be increased will remain same, only the left value of range will increase by val and 
    the one index ahead of right limit of range will decrease because we are increasing the value of the index behind it.
 */








/*
 * 3) 2D Array prefix sum- It is same as simple 1D prefix sum but just in 2D array. 
 *  Formula:   pref[i][j] = arr[i][j] + pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1]
 *  
 *  We subtract [i-1][j-1] index because it got added twice.
 *  For example->    arr= 1   2   3
 *                        4   5   6 
 *                        7   8   9
 *  
 *  In prefix sum array, the first row and first column of array will be calculated like simple 1D array prefix sum.
 *  For any sub matrix, we will store the prefix sum of that matrix in the bottom right corner. For the sub matrix->  1   2
 *                                                                                                                    4   5
 *  the sum of this submatrix will be stored at the place of 5. Similarly for submatrix   1  2  3    the sum will be stored at place of 6
 *                                                                                        4  5  6
 *  Using the formula, prefix array of given 3x3 matrix is  1    3    6
 *                                                          5    12   21
 *                                                          12   27   45
 */
class NumMatrix {
    int pref[][];
    public NumMatrix(int[][] matrix) {
        pref = new int[matrix.length+1][matrix[0].length+1];

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                pref[i+1][j+1] = matrix[i][j] + pref[i][j+1] + pref[i+1][j] - pref[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pref[row2+1][col2+1] - pref[row1][col2+1] - pref[row2+1][col1] + pref[row1][col1];
    }
}