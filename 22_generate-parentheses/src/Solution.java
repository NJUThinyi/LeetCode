//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1254 👎 0

import java.util.*;

public class Solution {
    List<String> cList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
        generateSc(new char[2*n], 0, 2*n);
        return cList;
    }

    public void generateSc(char[] c, int index, int maxLen){
        if(index==maxLen){
            if(isValid(c)) {
                /**
                 * 这里不能使用Arrays.toString(Object[] a)，会自动append','
                 * public static String toString(char[] a) {
                 *         if (a == null)
                 *             return "null";
                 *         int iMax = a.length - 1;
                 *         if (iMax == -1)
                 *             return "[]";
                 *
                 *         StringBuilder b = new StringBuilder();
                 *         b.append('[');
                 *         for (int i = 0; ; i++) {
                 *             b.append(a[i]);
                 *             if (i == iMax)
                 *                 return b.append(']').toString();
                 *             b.append(", ");
                 *         }
                 *     }
                 */
//                cList.add(Arrays.toString(c));
                cList.add(new String(c));
            }
            // 符合条件记得return，不然会出现数组越界或死循环
            return;
        }
        c[index]='(';
        ++index;
        generateSc(c, index, maxLen);
        --index;
        // 第一个字符为')'，肯定不符合要求，能减少一半的树生成
        if(index!=0){
            c[index]=')';
            ++index;
            generateSc(c, index, maxLen);
            --index;
        }
    }

    public boolean isValid(char[] s){
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        for(char c:s){
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                try {
                    char cPop = stack.pop();
                }catch(EmptyStackException e){
                    res = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            res=false;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(n);
        System.out.println(res);
    }
}
