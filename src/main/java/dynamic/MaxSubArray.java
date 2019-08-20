package dynamic;

/**
 * @ClassName MaxSubArray
 * @Description 最大子序列和
 * @Author: lijiao73
 * @Date: 2019/8/20 15:00
 * @Version 1.0
 */
public class MaxSubArray {

    public static void main(String[] args) {

        int[] org = {-1, 1, -1, -1, 6, -1};
        System.out.println(maxSubArray(org));

    }

    /**
     * dp[i]表示前i个连续数字的和
     *
     * @param org
     * @return
     */

    public static int maxSubArray(int[] org) {
        int max = 0;
        if (org.length == 0) {
            return 0;
        }
        int[] dp = new int[org.length];
        dp[0] = org[0];
        for (int i = 1; i < org.length; i++) {
            //要求连续子数列的和，因此比较前i个的和与第i个的大小，如果
            //1.当前i个的和大于第i个，说明需要把第i个添加进来
            //2.当前i个的和还没有第i个大的话，说明前i-1个是负担，不需要前i-1个
            dp[i] = Math.max(org[i], dp[i - 1] + org[i]);
            if (dp[i] > dp[i - 1]) {
                //返回dp中最大的数
                max = dp[i];
            }
        }
        return max;
    }
}
