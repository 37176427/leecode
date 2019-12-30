package org.heasy.stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution844 {
	/**
	 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
	 * 示例 1：
	 * 输入：S = "ab#c", T = "ad#c"
	 * 输出：true
	 * 解释：S 和 T 都会变成 “ac”。
	 * 示例 2：
	 * 输入：S = "ab##", T = "c#d#"
	 * 输出：true
	 * 解释：S 和 T 都会变成 “”。
	 * 示例 3：
	 * 输入：S = "a##c", T = "#a#c"
	 * 输出：true
	 * 解释：S 和 T 都会变成 “c”。
	 * 示例 4：
	 * 输入：S = "a#c", T = "b"
	 * 输出：false
	 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
	 */

	public static boolean backspaceCompare(String S, String T) {
		System.out.println(backspace(S));
		System.out.println(backspace(T));
		return backspace(S).equals(backspace(T));
	}

	//use array
	private static String backspace(String s) {
		int j = -1;
		char[] r = s.toCharArray();
		if (r.length == 1 && r[0] != '#') {
			j = 1;
		} else {
			for (int i = 0; i < r.length; i++) {
				if (r[i] == '#' && j < 0) {
					j = -1;
				} else if (r[i] == '#') {
					j--;
				} else {
					r[++j] = r[i];
				}
			}
		}
		//有可能出现j=-1 对应用例 ab##
		if (j<0){
			return "";
		}
		return Arrays.toString(Arrays.copyOfRange(r, 0, j));
	}

	//use stack
	private static String backspace2(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if ('#' == c) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(c);
			}
		}
		char[] chars = new char[stack.size()];
		int i = 0;
		for (Character c : stack) {
			chars[i++] = c;
		}
		System.out.println(chars);
		return new String(chars);
	}


	public static void main(String[] args) {
		String s1 = "ab##";
		String s2 = "c#d#";
		System.out.println(backspaceCompare(s1, s2));
	}

}
