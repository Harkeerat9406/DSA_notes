/*TIME COMPLEXITIES 
1) Bubble Sort – O(n²)
2) Selection Sort – O(n²)
3) Insertion Sort – O(n²)
4) Quick Sort – O(n²)
5) Merge Sort – O(n log n)
6) Heap Sort – O(n log n)
*/


/*MERGE SORT
We keep dividing the array into 2 halves using recursion until only array of size 1 is left. When we get it, we 
merge the two halves while sorting them.
So for this we created 2 functions, one to recursively divide the array and the other one to merge while sorting.
*/
// import java.util.*;

// public class sorting {
//     static void merge(int[] arr, int low, int mid, int high)
//     {
//         List<Integer> temp = new ArrayList<>();
//         int left = low;
//         int right = mid+1;

//         while(left<=mid && right<=high)            // Fill arrays with smallest elements from both parts
//         {
//             if(arr[left]<=arr[right])
//             {
//                 temp.add(arr[left]);
//                 left++;
//             }
//             else 
//             {
//                 temp.add(arr[right]);
//                 right++;
//             }
//         }

//         while(left<=mid)                        // Add leftover elements from left array
//         {
//             temp.add(arr[left]);
//             left++;
//         }

//         while(right<=high)                      // Add leftover elements from right array
//         {
//             temp.add(arr[right]);
//             right++;
//         }


//         for(int i=0; i<=temp.size()-1; i++)                //Copy back to original array
//         {
//             arr[low+i]= temp.get(i);
//         }
//         /*We use size of the temp array because arr has its original size. But when we have just 2 elements
//         from both halves, we just have 2 elements in total stored in temp array. So we just run loop until all
//         elements from the temp array are passed back to the original array
//         */
//     }

//     public static void mergeSort(int[] arr, int low, int high)
//     {
//         if(low>=high) return;
//         int mid = low+ (high-low)/2;

//         mergeSort(arr, low, mid);
//         mergeSort(arr, mid+1, high);
//         merge(arr, low, mid, high);
//     }

//     public static void main(String[] args) {
    //     int[] arr = {9, 3, 5, 1, 4, 8, 2};
    //     System.out.println("Before sorting: " + Arrays.toString(arr));

    //     mergeSort(arr, 0, arr.length - 1);

    //     System.out.println("After sorting: " + Arrays.toString(arr));
    // }
// }




/*QUICK SORT 
In this sorting technique, we pick a pivot element and the set it at its perfect position as per order.
To do so, we compare pivot element to find the first ELEMENT BIGGER than it from the LEFT SIDE of array
and the first ELEMENT SMALLER than pivot from RIGHT SIDE of array.
Then we swap both the elements and do this thing till the right index and left index cross each other. 
*/

import java.util.*;

public class sorting
{
    static void swap(int[] arr, int a, int b)
    {
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }


    static int pivotPos(int[]arr, int low, int high)
    {
        int i= low, j=high;
        int pivot= low;

        while(i<j)
        {
            while(i<=high && arr[i]<=arr[pivot])
            {
                i++;
            }
            while(j>=low && arr[j]>=arr[pivot])
            {
                j--;
            }
            if(i<j)
            {
                swap(arr, i, j);
            }
        }

        swap(arr, pivot, j);
        return j;
    }


    static void quickSort(int[] arr, int low, int high)
    {
        if(low<high)
        {
            int pivot= pivotPos(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }


    public static void main(String[] args) 
    {
        int[] arr = {9, 3, 5, 1, 4, 8, 2};
        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}



/* SELECTION SORT
Find min or max first using inner loop and then swap outside it.*/

// public class SelectionSort {
//     public static void selectionSort(int[] arr) {
//         int n = arr.length;

//         for (int i = 0; i < n - 1; i++) {
//             int minIndex = i;

//             // Find the index of the smallest element in the unsorted part
//             for (int j = i + 1; j < n; j++) {
//                 if (arr[j] < arr[minIndex]) {
//                     minIndex = j;
//                 }
//             }

//             // Swap the found minimum with the first unsorted element
//             int temp = arr[minIndex];
//             arr[minIndex] = arr[i];
//             arr[i] = temp;
//         }
//     }
// }



/*BUBBLE SORT
We keep swapping in the inner loop*/

// public class BubbleSort {
//     public static void bubbleSort(int[] arr) {
//         int n = arr.length;

//         for (int i = 0; i < n - 1; i++) {
//             boolean swapped = false;

//             // Compare adjacent elements
//             for (int j = 0; j < n - 1 - i; j++) {
//                 if (arr[j] > arr[j + 1]) {
//                     int temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                     swapped = true;
//                 }
//             }

//             // If no elements were swapped, array is already sorted
//             if (!swapped) break;
//         }
//     }
// }



/*INSERTION SORT
We select each element one by one and insert it at its correct position in the array */

// public class InsertionSort {
//     public static void insertionSort(int[] arr) {
//         int n = arr.length;

//         for (int i = 1; i < n; i++) {
//             int key = arr[i];
//             int j = i - 1;

//             // Move elements greater than key to one position ahead
//             while (j >= 0 && arr[j] > key) {
//                 arr[j + 1] = arr[j];
//                 j--;
//             }

//             arr[j + 1] = key;
//         }
//     }
// }