package twopointer;

import java.util.HashMap;

/*

Problem:
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

Pattern:
HashMap, Two Pointer

Time Complexity:
Brute force - O(N^2)
Two Pointer - O(N)
HashMap - O(N)
Binary Search - O(N) + O(LogN) = O(NLogN)

Space Complexity:
Brute Force - O(1)
Two Pointer - O(1)
HashMap - O(N)
Binary Search - O(1)

Notes:
Why two pointer is better than hashmap here?
Earlier two sum needed there we used hashmap becoz unsorted array gives no directional clue, now sorted array itself provides structure.
Hashmap takes extra space also.

Sorted also allows Binar Search:
For every element num[i], compute target-num[i], then binary search is needed in remaining array as array is already sorted.
Remaining array becoz we cannot use same element twice so the range becomes i+1 -> n-1
If binary search works then why do we need two pointer?
Because:
1. binary search repeatedly searches overlapping regions
2. Two Pointers eliminates impossible ranges continuously
 */
class TwoSumII {

    public int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[] { left, right }; // found the pair

            if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[] { -1, -1 };

        //HashMap
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i=0;i<arr.length;i++){
//            int complement = targetSum - arr[i];
//            if(map.containsKey(complement))
//                return new int[]{map.get(complement)+1, i+1};
//            map.putIfAbsent(arr[i], i);
//        }
//        return new int[]{};

        //Binary Search
//        for(int i=0;i<arr.length;i++){
//            int complement = targetSum - arr[i];
//            int left = i+1;
//            int right = arr.length-1;
//            while(left<=right){
//                int mid = left + (right-left)/2;
//                if(complement == arr[mid])
//                    return new int[]{i+1, mid+1};
//                else if(complement > arr[mid])
//                    left = mid+1;
//                else right = mid-1;
//            }
//        }
//        return new int[]{};

    }

    public static void main(String[] args) {
        TwoSumII sol = new TwoSumII();
        int[] result = sol.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = sol.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}

