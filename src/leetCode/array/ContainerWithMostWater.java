package leetCode.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class ContainerWithMostWater {
    /*   public int maxArea(int[] height) {
           int max=0;
           int area;
           for(int i=0;i<height.length;i++){
               for(int j=i+1;j<height.length;j++){
                   area=(j-i)*Math.min(height[i],height[j]);
                   max=Math.max(area,max);
               }
           }
           return max;
       }*/
    public int maxArea(int[] height) {
        int max = 0;
        int area;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] <= height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater.maxArea(arr));
    }
}
