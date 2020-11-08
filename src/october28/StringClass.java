package october28;

public class StringClass {

	public static void main(String[] args) {
//		String str = "abcdefgh";
		String str2 = new String("Geekster");

//		Printing
//		System.out.println(str);

//		charAt
//		System.out.println(str.charAt(0));

//		substring
//		(startIdx,endIdx+1); = print from startIdx to endIdx 
//		System.out.println(str.substring(1, 4));
//
//		System.out.println(str.substring(1));
//
//		System.out.println(str.length());

//		System.out.println(removeAllVowels("abcde"));
//		countCharacters("geekster");
//		System.out.println(isPalindrome("malayala"));
//		printPalindromicSubstrings("malayalam");

//		String str = "abc";
//		String str2 = "abc";
//		String str3 = new String("abc");
//		String str4 = new String("abc");
//		if (str == str2) {
//			System.out.println("Hurray");
//		}
//
//		if (str2 == str3) {
//			System.out.println("HHH");
//		}
//
//		if (str3 == str4) {
//			System.out.println("Ttt");
//		}

//		System.out.println(toggle("abcDE"));
		System.out.println(compression("aaabbccdd"));
	}

	public static String removeAllVowels(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				continue;
			} else {
				ans += ch;
			}
		}

		return ans;
	}

	public static void countCharacters(String str) {
		int[] freq = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int idx = ch - 'a'; // will do something
			freq[idx]++;
		}

		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				int temp = 'a' + i;
				char ch = (char) temp;// will do something
				System.out.println(ch + "->" + freq[i]);
			}
		}
	}

	public static boolean isPalindrome(String str) {
		int l = 0;
		int r = str.length() - 1;
		while (l < r) {
			char leftCh = str.charAt(l);
			char rightCh = str.charAt(r);
			if (leftCh == rightCh) {
				l++;
				r--;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void printPalindromicSubstrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				String currSubstring = str.substring(i, j + 1);
				System.out.println(currSubstring);
				if (isPalindrome(currSubstring) == true) {
					System.out.println(currSubstring);
				}
			}
		}
	}

	public static String substringFuncBad(String str, int startidx, int endIdx) {
		String ans = "";
		for (int i = startidx; i <= endIdx; i++) {
			char ch = str.charAt(i);
			ans += ch;
		}

		return ans;
	}

	public static String substringFuncGood(String str, int startidx, int endIdx) {
		StringBuilder sb = new StringBuilder("");
		for (int i = startidx; i <= endIdx; i++) {
			char ch = str.charAt(i);
			sb.append(ch);
		}

		String ans = sb.toString();
		return ans;
	}

	public static String toggle(String str) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch <= 'z' && ch >= 'a') {
				int temp = ch - 'a' + 'A';
				sb.append((char) temp);
			} else {
				int temp = ch - 'A' + 'a';
				sb.append((char) temp);
			}
		}

		return sb.toString();
	}

	public static String compression(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i != str.length() - 1) {
				char chN = str.charAt(i + 1);
				if (ch == chN) {
					count++;
				} else {
					sb.append(ch + "" + (count + 1));
					count = 0;
				}
			} else {
				sb.append(ch + "" + (count + 1));
			}
		}
		return sb.toString();
	}

}
