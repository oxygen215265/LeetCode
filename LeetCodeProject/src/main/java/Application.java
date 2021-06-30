import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Application {

    public static void main(String[] args) {

        int[] nums = {0,1,2,4,5,7,8};
        List<Integer> missingNumbers = findMissingNumbers(nums, 10);


    }

    public static List<Integer> findMissingNumbers(int[] array,int num) {
        List<Integer> res = new ArrayList<>();
        BitSet bitSet = new BitSet(num);

        for(int element:array) {
            bitSet.set(element);
        }

        int missingCount = num - array.length;

        int lastMissingIndex = 0;
        while(missingCount>0) {

            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            res.add(lastMissingIndex++);
            missingCount--;
        }
        return res;


    }

    static class ListNode {
        int val;
        int min;
        ListNode next;
        ListNode(int x, int y) {
            val = x;
            min =y;
            next = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class MinStack {

        private ListNode head;
        private ListNode curr;
        private ListNode pre;
        /** initialize your data structure here. */
        public MinStack() {
            curr = new ListNode(Integer.MAX_VALUE,Integer.MAX_VALUE);
        }

        public void push(int val) {

            int min = curr.min;
            ListNode node = new ListNode(val,Math.min(min,val));
            node.next = curr;
            curr = node;
        }

        public void pop() {
            curr = curr.next;
        }

        public int top() {
            return curr.val;
        }

        public int getMin() {

            return curr.min;

        }

    }

    public static  int maxProfit(int[] prices) {

        int profit = 0;
        for(int i=0;i<prices.length-1;i++) {
            if(prices[i+1]> prices[i]) {
                profit +=  prices[i+1] - prices[i];
                i++;
            }

        }
        return profit;

    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int resultIndex=0;
        int size = Math.min(nums1.length,nums2.length);
        int[] result = new int[size];

        int index1 = 0;
        int index2 = 0;

        while(index1< nums1.length && index2<nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                result[resultIndex++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(result,0,resultIndex);


    }


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }




    public static int search(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }



}
