/* MAX SUB ARRAY SUM
 *  We need to find the sub array with max sum. At index i, we have 2 choices:
 *  1) Extend previous sub array
 *  2) Start fresh from element at index i. (If element becomes greater than sub array sum)

    For example- arr= [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    - At index 1 (1), we restart because 1 is better than continuing -2.
    - At index 3 (4), we restart again since 4 > -2+4.
    - At index 6 (1), continuing from previous (5+1) was better → we grow the subarray.
    - global_max keeps track of the best seen so far → which is 6.

    To keep track of starting and ending indices, we take 3 variables as start=0, stop=0, temp_start=0
 */


class kadane{
    public int maxSubArray(int[] arr) {
        int max_here= arr[0], global_max= max_here;
        int start=0, end=0, temp_start=0;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] > max_here + arr[i])
            {
                max_here = arr[i];
                temp_start = i;         // The best sub array starts here
            }
            else
            {
                max_here = arr[i] + max_here;
            }

            if(max_here>global_max)
            {
                global_max= max_here;
                start= temp_start;      // Once we confirm that sub array is best, we give it the temp_start where it began
                end= i;                 // We mark only the end of the best sub array
            }
            
        }
        return global_max;
    }
}





/*  Max sub array product 
 * 
 */