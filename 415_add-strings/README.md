# Leetcode 415
## 题目要求
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

- num1 和num2 的长度都小于 5100.
- num1 和num2 都只包含数字 0-9.
- num1 和num2 都不包含任何前导零。
 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
## Related Topics 
- 字符串
## 薄弱环节
- 计算时对**取模(%)**和**整数除法(/)**运算的使用
## 题解思路

### Method1

- 首先，定位到各自字符串的最后一位，并声明一个进位数(`carry变量`)
- 接着，以以上三者为循环条件进行判定(`while(i>=0 || j>=0 || carry!=0)`)，对于字符串的每一位取其字符并减去字符`'0'`得到其整数值并加到进位数上
- 每次循环过程通过==取模运算`carry%10`==得到其个位并添加到`StringBuilder`，并通过==整数除法运算`carry/10`==得到其十位以待下一轮循环使用
- 最后，将得到的`StringBuilder`反转并转化为字符串即可

```java
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
```

