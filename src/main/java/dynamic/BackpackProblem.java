package dynamic;

/**
 * @ClassName BackpackProblem
 * @Description
 * @Author: lijiao73
 * @Date: 2019/8/16 14:55
 * @Version 1.0
 */
public class BackpackProblem {
    public static void main(String[] args) {
        int total = 5;
        int[] w = {0, 2, 3, 4, 5};  //商品的体积2、3、4、5
        int[] v = {0, 3, 4, 5, 6};  //商品的价值3、4、5、6
        int bagV = 8;               //背包大小
        System.out.println(dpResult(total, w, v, bagV));
    }

    /**
     * 理解背包问题的前提
     * dp[i][j]表示，有前i个商品可以选择，并且目前还剩余的容量是j的情况下，此时背包里面商品总共的价值
     * @param total      参数1：商品的总个数
     * @param wight      参数2：每一个商品的体积（或重量等）
     * @param value      参数3：每个商品对应的价值
     * @param bagContain 参数4：背包总共能装下的商品体积（或重量）
     * @return 返回结果：背包可以装下的最大价值和
     */
    private static int dpResult(int total, int[] wight, int[] value, int bagContain) {
        if (wight.length != value.length || wight.length != total) {
            return 0;
        }
        int[][] dp = new int[total][bagContain + 1];
        //遍历每一个商品
        for (int i = 1; i < total; i++) {
            //j是当前背包还剩余的容量（最大只能是bagContain）
            for (int j = 1; j <= bagContain; j++) {
                if (j < wight[i]) {
                    //1. 如果当前的剩余容量小于第i个商品需要占据的体积，那么第i个不会放进来，所以dp[i][j] = dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //2. 如果当前的剩余容量大于第i个商品需要占据的体积
                    //2.1 那么第i个可以放进来：dp[i - 1][j - wight[i]] + value[i]；
                    //2.2 也可以不放进来：dp[i - 1][j]，取决于两者谁更大。
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < total; i++) {
            for (int j = 0; j <= bagContain; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[total - 1][bagContain];
    }

}
