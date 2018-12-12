package s0001;

/*
31. Next Permutation
Medium

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */
import java.util.*;

public class ST0031 {
    //625431
    //search from the back, find i-1 small than i, found 2 < 5
    //search from 5 to the back, the smallest one which larger than 2, found 3
    //swap 2,3 --> 635421, and sort from 5 to end ->631245

    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length<2) {
            return;
        }
        int i;
        for (i = nums.length-1; i >0; i--) {
            if (nums[i-1] < nums[i]) {
                break;
            }
        }
        if (i==0) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int idx = i;
        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] > nums[i-1] && nums[j] < nums[idx]) {
                idx = j;
            }
        }
        swap(nums, i-1, idx);
        Arrays.sort(nums, i, nums.length);//sort(array, from, to) to excluded
        //reverse(nums, i, nums.length-1);
    }

    private void reverse(int[]a, int i, int j) {
        while (i < j) {
            swap(a, i++, j--);
        }
    }

    private void swap(int[]a, int i, int j) {
        if (i==j) {
            return;
        }
        int t = a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
