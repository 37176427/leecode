package org.heasy.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述 :给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 作者 : wyh
 * 时间: 2020-03-17 18:45
 */
public class Solution1160 {

	public int countCharacters(String[] words, String chars) {
		if (words == null) {
			return 0;
		}
		char[] charArray = chars.toCharArray();
		Map<Character, Integer> map = new HashMap<>(charArray.length);
		int count = 0;
		for (char c : charArray) {
			map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
		}
		for (String word : words) {
			Map<Character, Integer> m = new HashMap<>(map);
			char[] wordArray = word.toCharArray();
			boolean has = true;
			for (char w :wordArray){
				if (m.get(w) == null || m.get(w) == 0){
					has = false;
					break;
				}else {
					m.put(w,m.get(w)-1);
				}

			}
			if (has){
				count+=word.length();
			}

		}
		return count;

	}


}
