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
