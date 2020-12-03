package november29HashMap;

import java.util.*;

public class HMap {

	public static void main(String[] args) {
		HashMap<String, Integer> hmap = new HashMap();
//		O(1)
		hmap.put("India", 1000);
		hmap.put("Pakistan", -50);
		hmap.put("Sri Lanka", 500);
		System.out.println(hmap);

//		O(1)
		hmap.remove("Pakistan");
		System.out.println(hmap);

//		O(1)
		System.out.println(hmap.containsKey("Pakistan"));

//		O(1)
		System.out.println(hmap.get("India"));

//		O(n)
		ArrayList<String> list = new ArrayList<String>(hmap.keySet());
		System.out.println(list);

		highestFrequenceyCharacter("geekster");

		int[] one = { 5, 1, 3, 1, 2, 2, 1 };
		int[] two = { 2, 2, 4, 1, 1, 5, 2 };
		getCommonElements2(one, two);
	}

	public static void getCommonElements1(int[] one, int[] two) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int val : one) {
			hmap.put(val, hmap.getOrDefault(val, 0) + 1);
		}

		for (int val : two) {
			if (hmap.containsKey(val)) {
				System.out.print(val + " ");
				hmap.remove(val);
			}
		}

		System.out.println();
	}

	public static void getCommonElements2(int[] one, int[] two) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int val : one) {
			hmap.put(val, hmap.getOrDefault(val, 0) + 1);
		}

		for (int val : two) {
			if (hmap.containsKey(val)) {
				System.out.print(val + " ");
				hmap.put(val, hmap.get(val) - 1);
			}

			if (hmap.containsKey(val)) {
				if (hmap.get(val) <= 0) {
					hmap.remove(val);
				}
			}
		}

		System.out.println();
	}

	public static void highestFrequenceyCharacter(String word) {
		HashMap<Character, Integer> fmap = new HashMap<Character, Integer>();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (fmap.containsKey(ch)) {
				fmap.put(ch, fmap.get(ch) + 1);
			} else {
				fmap.put(ch, 1);
			}
		}

		ArrayList<Character> list = new ArrayList<Character>(fmap.keySet());

		int max = 0;
		char ans = '\0';

		for (int i = 0; i < list.size(); i++) {
			char ch = list.get(i);
			int charFreq = fmap.get(ch);
			if (charFreq > max) {
				max = charFreq;
				ans = ch;
			}
		}

		System.out.println(ans);
	}

}
