package org.brenomachado.codingproblems.binarysearch

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContentEquals

internal class FirstAndLastPositionInSortedArrayTests {
    lateinit var sut: FirstAndLastPositionInSortedArray

    @BeforeTest
    fun setUp() {
        sut = FirstAndLastPositionInSortedArray()
    }

    /*
     *   Input: nums = [5,7,7,8,8,10], target = 8
     *   Output: [3,4]
     */
    @Test
    fun targetWithTwoValues() {
        val result = sut.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
        assertContentEquals(intArrayOf(3, 4), result)
    }

    /*
     *   Input: nums = [5,7,7,8,8,10], target = 6
     *   Output: [-1,-1]
     */
    @Test
    fun targetNotInArray() {
        val result = sut.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6)
        assertContentEquals(intArrayOf(-1, -1), result)
    }

    /*
     *   Input: nums = [], target = 0
     *   Output: [-1,-1]
     */
    @Test
    fun emptyArray() {
        val result = sut.searchRange(intArrayOf(), 0)
        assertContentEquals(intArrayOf(-1, -1), result)
    }
}