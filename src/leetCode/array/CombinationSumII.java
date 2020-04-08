package leetCode.array;

import java.util.*;

/**
 * 求数组中元素和为target的集合，元素不可重复利用
 * 思路：回溯dfs+剪枝+去重（set或者利用数组去重，排序，相同元素跳过）
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, candidates.length, target, 0, new ArrayDeque<>(), lists);
        return lists;
    }

    private void dfs(int[] candidates, int length, int target, int start, Deque<Integer> path, List<List<Integer>> lists) {
        if (target == 0) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, length, target - candidates[i], i + 1, path, lists);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        System.out.println(combinationSumII.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(combinationSumII.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
