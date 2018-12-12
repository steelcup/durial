package s0051;
/*
80. Remove Duplicates from Sorted Array II
Medium

Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.

Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],
*/
public class ST0080 {
    public int removeDuplicates(int[] a) {

        int idx = 1;
        for (int i = 2; i < a.length; i++) {
            if (a[i] != a[idx] || a[i] != a[idx-1]) {
                a[++idx] = a[i];
            }
        }
        return idx+1;
    }
}
