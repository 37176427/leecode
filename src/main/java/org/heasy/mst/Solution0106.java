package org.heasy.mst;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 描述 :字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 *
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 作者 : wyh
 * 时间: 2020-03-16 17:35
 */
public class Solution0106 {


	public String compressString(String S) {
		char[] chars = S.toCharArray();
		StringBuilder b = new StringBuilder();
		for (int i=0;i<chars.length;i++){
			int c = 1;
			char tmp = chars[i];
			while (i<chars.length-1 && tmp==chars[i+1]){
				c++;
				i++;
			}
			b.append(tmp).append(c);
		}
		//没有变短的情况
		if (b.length()>=S.length()){
			return S;
		}
		return b.toString();
	}


	public static void main(String[] args) {
		Solution0106 s = new Solution0106();
		String t = s.compressString("aabccrraaaaaa");
		System.out.println(t);
	}

}
