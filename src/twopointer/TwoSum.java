package twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

Problem:
https://leetcode.com/problems/two-sum/description/

Variant - Array is not sorted

Pattern:
Two Pointer, HashMap

Time Complexity:
Brute force - O(N^2)
HashMap - O(N)
Sorting - O(NLogN)

Space Complexity:
Brute Force - O(1)
HashMap - O(N)
Sorting - O(N)

Notes:
Think of HashMap - For every element we are searching for its complement, and hashmap gives O(1) lookup.
1. Check complement
2. Then insert current element
3. What if we insert first?
suppose target is 6 and first element is 3, we inserted 3 and then checked then map already contains 3, we incorrectly use same element twice, so order matters
4. Two Pointer doesn't work on the original array becoz two pointer need sorted array, so after sorting original index gets lost.
So now instead of storing only values we will keep values and original index and then sort by value, so that original index is preserved
Why in sorting -- a[0]-b[0] can be dangerous?
suppose a[0] = Integer.MAX_VALUE and b[0] = -1 then overlflow issue that is why Integer.compare(a[0], b[0]) -- which safely handles overflow
 */
class TwoSum {

    public int[] search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int needed = target - nums[i];
            if(map.containsKey(needed))
                return new int[]{map.get(needed), i};
            map.put(nums[i], i);
        }
        return new int[]{};

        //Sorting
//        int n = nums.length;
//        int[][] arr = new int[n][2];
//        for(int i=0;i<n;i++){
//            arr[i][0] = nums[i];
//            arr[i][1] = i;
//        }
//        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
//        int left = 0;
//        int right = n-1;
//        while(left<right){
//            int sum = arr[left][0] + arr[right][0];
//            if(sum == target)
//                return new int[]{arr[left][1], arr[right][1]};
//            else if(sum<target) left++;
//            else right--;
//        }
//        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] result = sol.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = sol.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}

