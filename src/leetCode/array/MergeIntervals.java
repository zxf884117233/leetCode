package leetCode.array;

import java.util.*;

/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        System.out.println(Arrays.deepToString(intervals));
        int left = intervals[0][0];
        int right = intervals[0][1];
        map.put(left, right);
        for (int i = 1; i < intervals.length; i++) {
            if ((intervals[i][0] == left && intervals[i][1] >= right)
                    || (intervals[i][0] != left && right >= intervals[i][0])) {
                left = Math.min(intervals[i][1], left);
                right = Math.max(intervals[i][1], right);
                map.put(left, right);
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
                map.put(intervals[i][0], intervals[i][1]);
            }
        }
        int[][] result = new int[map.size()][2];
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
        }
        return result;
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        /*
        int right = intervals[0][1];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                right = Math.max(intervals[i][1], right);
                intervals[index][1] = right;
            } else {
                //必须更新right，不然right为上面遗留的值，并不是最新的值，若连续两个区间不重叠，
                right = intervals[i][1];
                intervals[++index] = intervals[i];
            }
        }*/
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                intervals[index][1] = Math.max(intervals[i][1], intervals[index][1]);
                ;
            } else {
                intervals[++index] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, index + 1);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        int[][] arr2 = new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}};
        MergeIntervals intervals = new MergeIntervals();
        int[][] merge = intervals.merge2(arr);
        System.out.println(Arrays.deepToString(merge));
        int[][] merge2 = intervals.merge2(arr2);
        System.out.println(Arrays.deepToString(merge2));
    }
}
