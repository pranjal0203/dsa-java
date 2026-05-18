package binarysearch;

/*

Problem:
https://leetcode.com/problems/sqrtx/description/

Pattern:
Binary Search

Time Complexity:
Brute force - O(sqrt(x))
O(LogN)

Space Complexity:
O(1)

 */
class Sqrt {
    public int mySqrt(int x) {
        if (x < 2)
            return x; // return x if it is 0 or 1

        int left = 2, right = x / 2;
        int mid;
        long num;
        while (left <= right) { // binary search for the square root
            mid = left + (right - left) / 2;
            num = (long) mid * mid; // Not to overflow int
            if (num > x)
                right = mid - 1; // if mid * mid is greater than x, set right to mid - 1
            else if (num < x)
                left = mid + 1; // if mid * mid is less than x, set left to mid + 1
            else
                return mid; // if mid * mid is equal to x, return mid
        }

        return right;
    }

    public static void main(String[] args) {
        Sqrt solution = new Sqrt();

        int input1 = 4;
        int expectedOutput1 = 2;
        int result1 = solution.mySqrt(input1);
        System.out.println(result1 == expectedOutput1); // Expected output: true

        int input2 = 8;
        int expectedOutput2 = 2;
        int result2 = solution.mySqrt(input2);
        System.out.println(result2 == expectedOutput2); // Expected output: true

        int input4 = 2;
        int expectedOutput4 = 1;
        int result4 = solution.mySqrt(input4);
        System.out.println(result4 == expectedOutput4); // Expected output: true

        int input5 = 3;
        int expectedOutput5 = 1;
        int result5 = solution.mySqrt(input5);
        System.out.println(result5 == expectedOutput5); // Expected output: true

        int input6 = 15;
        int expectedOutput6 = 3;
        int result6 = solution.mySqrt(input6);
        System.out.println(result6 == expectedOutput6); // Expected output: true
    }
}

