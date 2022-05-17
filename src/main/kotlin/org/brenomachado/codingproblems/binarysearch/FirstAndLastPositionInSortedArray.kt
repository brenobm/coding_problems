package org.brenomachado.codingproblems.binarysearch

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

 */


class FirstAndLastPositionInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var initial = binarySearch(nums, target, 0, nums.size - 1)
        var left: Int
        var right: Int

        if (initial == -1)
            return intArrayOf(-1, -1)


        var tmp = initial
        do {
            left = tmp
            tmp = binarySearch(nums, target, 0, left - 1)
        } while (tmp != -1)

        tmp = initial
        do {
            right = tmp
            tmp = binarySearch(nums, target, right + 1, nums.size - 1)
        } while (tmp != -1)

        return intArrayOf(left, right)
    }

    private fun binarySearch(nums: IntArray, target: Int, start: Int, end: Int): Int {
        var left = start
        var right = end

        while (left <= right) {
            var middle = (left + right) / 2

            if (nums[middle] == target)
                return middle
            if (nums[middle] < target)
                left = middle + 1
            else
                right = middle - 1
        }

        return -1
    }
}