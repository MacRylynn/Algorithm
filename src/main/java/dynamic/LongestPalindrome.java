package dynamic;

/**
 * @ClassName LongestPalindrome
 * @Description 最长回文字符串
 * @Author: lijiao73
 * @Date: 2019/8/26 16:38
 * @Version 1.0
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String string = "asdfghhgfd";
        System.out.println(result(string));
    }

    /**
     * 辅助空间:flag[i][j]表示从第i个字符到第j个字符是否回文字符串
     * 状态转移方程flag[i][j]=true时，flag[i+1][j-1]=true并且string[i]=string[j]
     *
     * @param string 原字符串
     * @return 最长回文子字符串
     */

    private static String result(String string) {
        int length = string.length();
        if (length <= 1) {
            return string;
        }
        //回文串开始的地方
        int start = 0;
        //回文串最大长度
        int maxLength = 0;
        //是否回文串标志
        boolean[][] flag = new boolean[length][length];
        //前两个的情况
        for (int i = 0; i < length - 1; i++) {
            flag[i][i] = true;
            if (string.charAt(i) == string.charAt(i + 1)) {
                flag[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        //从长度为3开始
        for (int m = 3; m <= length; m++) {
            for (int i = 0; i <= length - m; i++) {
                int j = i + m - 1;
                if (flag[i + 1][j - 1] && string.charAt(i) == string.charAt(j)) {
                    flag[i][j] = true;
                    start = i;
                    maxLength = m;
                }
            }
        }
        return string.substring(start, start + maxLength);
    }
}
