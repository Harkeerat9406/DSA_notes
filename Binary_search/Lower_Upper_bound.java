package Binary_search;

/*Lower bound->  Find first index where element >= target 

Upper bound-> Find first index where element > target

We can use this pattern to find the:
1) frequency of target
2) range in which target lies
3) smallest element >= target  and  largest element <= target
*/

public class Lower_Upper_bound {
    public int lower_bound(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        int result = arr.length; // if target > all elements

        while (left <= right) {
            int mid = left + (right - left); // 2

            if (arr[mid] >= target) {
                result = mid; // potential answer
                right = mid - 1; // look for earlier occurrence
            } else
                left = mid + 1;
        }
        return result;
    }

    public int upper_bound(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        int result = arr.length; // if target > all elements

        while (left <= right) {
            int mid = left + (right - left); // 2

            if (arr[mid] > target) {
                result = mid; // potential answer
                right = mid - 1; // look for earlier occurrence
            } else
                left = mid + 1;
        }
        return result;
    }

    public static void main(String args[]) {
        Lower_Upper_bound ob = new Lower_Upper_bound();
        int arr[] = { 2, 4, 6, 6, 8, 10 };
        int target = 6;

        int lower = ob.lower_bound(arr, target);
        int upper = ob.upper_bound(arr, target);
        System.out.println("Frequency of " + target + " : " + upper - lower);
    }
}
