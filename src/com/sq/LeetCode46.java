package com.sq;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LeetCode46 {

   /* public List<Integer> switchForList(int[] nums){
        List<Integer> list = new ArrayList();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        result.add(switchForList(nums));
        if (length == 1) {
            return result;
        } else {
            for (int i = length - 1; i > 0; i--) {
                int n = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = n;
                result.add(switchForList(nums));
            }
        }
        return result;
    }
*/
    public static void main(String[] args) {
        LeetCode46 m = new LeetCode46();
        int[] nums = {1,2,3};
        System.out.println(m.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(res, nums,list, visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
