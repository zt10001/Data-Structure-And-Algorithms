/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) return 1;
        int distinctIndexSoFar = 1;
        int replaceIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (i > replaceIndex) {
                    nums[replaceIndex] = nums[i];
                }
                ++distinctIndexSoFar;
                ++replaceIndex;
            }
        }
        return distinctIndexSoFar;
    }

    /*
    nums = [0, 1, 1, 2, 3, 4]
     */

    public int removeElement(int[] nums, int val) {
        int i = 0;

        for (int n : nums) {
            if (n != val) {
                nums[i++] = n;
                System.out.println(i++);
            }
        }

        return i;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) break;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }

        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid;
            else left = mid + 1; // mid + 1 could be the target
        }
        return nums[left] < target ? left + 1 : left;
    }

    public int maxSubArray(int[] nums) {

    }
}
