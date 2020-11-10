import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
回溯法 类似火车进站
 */
public class LeetCode78 {
}
class LeetCode78Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recall(nums,res,0,new ArrayList<Integer>());
        return res;
    }

    public void recall(int[] nums,List<List<Integer>> res,int i,List<Integer> temp){
        List tempList = new ArrayList<Integer>(temp);
        res.add(tempList);//引用的是对象，temp在后面调用时会清空。
        for(int j=i;j<nums.length;j++){
            temp.add(nums[j]);
            recall(nums,res,j+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}