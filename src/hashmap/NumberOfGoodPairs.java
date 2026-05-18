package hashmap;

/*

Problem:
https://leetcode.com/problems/number-of-good-pairs/description/

Pattern:
Hashmap

Time Complexity:
O(N)

Space Complexity:
O(N)

Trade off:
Brute Force - Nested loops - TC - O(N^2)
Second Approach - Frequency Count First then freq * (freq - 1)/2 - TC - O(N)
Third Approach - Running frequency Map - Single traversal

Notes:
Can we solve without using hashmap -- Yes since contraints are -- 1 <= nums[i] <= 100
Can we solve using Sorting? Yes
After sorting - duplicates are grouped together after that problem reduces to frequency counting
Traverse Array, count continuous duplicate frequency - whenever group ends compute = n*n-1/2
TC - O(NlogN) and Space TC - O(1)
HashMap optimizes time, sorting optimizes auxiliary space

What if we need to return ALL INDEX PAIRS
O(N^2) - nested loops
Optimal approach - HashMap<Integer, List>
If there are n identical elemets then number of pairs can intself become nC2 which is O(N^2)
Since output size itself can be O(N^2), returning all pairs cannot be better than O(N^2)

 */
import java.util.*;

class NumberOfGoodPairs {
    public int numGoodPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int pairs = 0;
        for(int i :nums){
            pairs += freq.getOrDefault(i, 0);
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        return pairs;

        //Sorting
//        Arrays.sort(nums);
//        int pairs = 0;
//        int freq = 1; // Since the first element already belongs to current group, freq starts from 1 not 0. A group containing one element has freq 1
//        for(int i = 1; i < nums.length; i++){
//            if(nums[i] == nums[i-1]){
//                freq++;
//            }
//            else{
//                pairs += freq; * (freq-1)/2;
//                freq = 1
//            }
//        }
//        //last group
//        pairs += freq*(freq-1)/2;
//        return pairs;

        // Return indexes of all pairs
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        List<List<Integer>> result = new ArrayList<>();
//        for(int i=0;i<nums.length;i++){
//            int num = num[i];
//            if(map.containsKey(num)){
//                for(int prevIndex:map.get(num)){
//                    result.add(Arrays.asList(prevIndex,i));
//                }
//            }
//            map.putIfAbsent(num,new ArrayList<>());
//            map.get(num).add(i);
//        }
//        return result;
    }

    public static void main(String[] args) {
        NumberOfGoodPairs sol = new NumberOfGoodPairs();

        int[] nums1 = { 1, 2, 3, 1, 1, 3 };
        int result1 = sol.numGoodPairs(nums1);
        System.out.println("Result 1: " + result1 + " (Expected: 4)");

        int[] nums2 = { 1, 1, 1, 1 };
        int result2 = sol.numGoodPairs(nums2);
        System.out.println("Result 2: " + result2 + " (Expected: 6)");

        int[] nums3 = { 1, 2, 3 };
        int result3 = sol.numGoodPairs(nums3);
        System.out.println("Result 3: " + result3 + " (Expected: 0)");
    }
}

