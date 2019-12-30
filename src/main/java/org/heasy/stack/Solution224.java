package org.heasy.stack;

import java.util.Stack;

public class Solution224 {
	/**
	 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
	 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
	 * 示例 1:
	 * 输入: "1 + 1"
	 * 输出: 2
	 * 示例 2:
	 * 输入: " 2-1 + 2 "
	 * 输出: 3
	 * 示例 3:
	 * 输入: "(1+(4+5+2)-3)+(6+8)"
	 * 输出: 23
	 *
	 * 未能做出来 参考评论中的代码
	 */
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		char[] chars = s.toCharArray();
		int result = 0;
		int curr = 0;
		int sign = 1;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (Character.isDigit(c)) {
				curr = c - '0';
				//多个数字字符连起来
				while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
					curr = curr * 10 + chars[++i] - '0';
				}
				result = result + sign * curr;
			}
			if (c == '+') {
				sign = 1;
			}
			if (c == '-') {
				sign = -1;
			}
			if (c == '(') {
				//先放结果再放符号
				stack.push(result);
				result = 0;
				stack.push(sign);
				sign = 1;
			}
			if (c == ')') {
				//这样出栈先出的是符号 再出结果
				result = stack.pop() * result + stack.pop();
			}
		}

		return result;
	}

	/**
	 * test
	 */
	public static void main(String[] args) {
		String s = "288 + 2";
		System.out.println(calculate(s));
	}
}

