import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode1046 {
}
class LeetCode1046Solution {
    public static void main(String[] args) {
        LeetCode1046Solution leetCode1046Solution = new LeetCode1046Solution();
        System.out.println(leetCode1046Solution.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i:stones){
            integers.add(i);
        }
        while (integers.size()>1){
            int num1 = integers.poll();
            int num2 = integers.poll();
            if(num1!=num2)
                integers.add(num1-num2);
        }
        if(integers.size()==0)
            return 0;
        else
            return integers.poll();
    }
}