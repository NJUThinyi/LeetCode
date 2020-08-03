//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
// 注意：
//
//
// num1 和num2 的长度都小于 5100.
// num1 和num2 都只包含数字 0-9.
// num1 和num2 都不包含任何前导零。
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
//
// Related Topics 字符串
// 👍 235 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        return method1(num1, num2);
    }

    // 纯暴力解法
    // 先把每一位的加一起，之后再判断是否 >= 10，并判断最后一位是否进位
    public String method1(String num1, String num2){
        List<Integer> tempRes = new ArrayList<>();
        int flag = 1;   // 标识较长的字符串
        int minLen = Math.min(num1.length(), num2.length());
        if(!(num1.length()>minLen)){
            flag = 2;
        }
        int distance = Math.abs(num1.length()-num2.length());
        for(int i=minLen-1;i>=0;i--){
            String s1,s2;
            if(flag==1){
                s1 = num1.substring(i+distance, i+distance+1);
                s2 = num2.substring(i, i+1);
            }else{
                s2 = num2.substring(i+distance, i+distance+1);
                s1 = num1.substring(i, i+1);
            }
            int temp = Integer.parseInt(s1)+Integer.parseInt(s2);
            tempRes.add(temp);
        }
        if(distance!=0){
            for(int i=distance-1;i>=0;i--){
                if(flag==1){
                    tempRes.add(Integer.parseInt(num1.substring(i, i+1)));
                }else{
                    tempRes.add(Integer.parseInt(num2.substring(i, i+1)));
                }
            }
        }
        boolean isCarry=false;
        for(int i=0;i<tempRes.size();i++){
            if(i==tempRes.size()-1){
                if(tempRes.get(i)>=10){
                    isCarry=true;
                    tempRes.set(i, tempRes.get(i)-10);
                }
            }else{
                if(tempRes.get(i)>=10){
                    tempRes.set(i, tempRes.get(i)-10);
                    tempRes.set(i+1,tempRes.get(i+1)+1);
                }
            }
        }
        if(isCarry){
            tempRes.add(1);
        }
        StringBuilder res = new StringBuilder();
        for(int i=tempRes.size()-1;i>=0;i--){
            res.append(tempRes.get(i));
        }
        return res.toString();
    }

    // 官方暴力解法（方法比我的简单得多）
    // 技巧：取模（%）和整数除法（/）的使用
    public String method(String num1, String num2){
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i>=0 || j>=0 || carry!=0){
            if(i>=0){
                carry+=num1.charAt(i--)-'0';
            }
            if(j>=0){
                carry+=num2.charAt(j--)-'0';
            }
            res.append(carry%10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}


//leetcode submit region end(Prohibit modification and deletion)
