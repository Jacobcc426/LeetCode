import java.util.*;

/*
703. 数据流中的第 K 大元素
设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

请实现 KthLargest 类：

KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
int add(int val) 返回当前数据流中第 k 大的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode701 {
}
class KthLargest {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 4
        System.out.println(kthLargest.add(10));   // return 4
        System.out.println(kthLargest.add(9));   // return 4
        System.out.println(kthLargest.add(4));   // return 4
    }
    PriorityQueue<Integer> queue;
    int num;
    public KthLargest(int k, int[] nums) {
        this.num = k;

        queue = new PriorityQueue<>(num);
        for(int i:nums){
            add(i);
        }
    }

    public int add(int val) {
        if (queue.size() < num) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */