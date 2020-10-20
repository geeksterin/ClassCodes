package october20;

import java.util.ArrayList;

public class RecursionContd {

	public static void main(String[] args) {
//		System.out.println(getKpc("12"));
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer i = 10;
		System.out.println(i + 1);
		int ii = 10;
		RecursionContd rr = new RecursionContd();
		rr.print();
		RecursionContd rr1 = new RecursionContd();
		rr1.print();
		rr.getSS("abc");
		RecursionContd.getSS("abc");
	}

	public static int num = 10;
	public int num2 = 20;

	public void print() {
		
		System.out.println("Hello Non Static");
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> toReturn = new ArrayList<>();
			toReturn.add("");
			return toReturn;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String s : rr) {
			mr.add(s);
			mr.add(ch + s);
		}

		return mr;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add("");
			return temp;
		}
//		base case
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getPermutations(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String s : rr) {
			for (int i = 0; i <= s.length(); i++) {
				String prefix = s.substring(0, i);
				String suffix = s.substring(i);
				mr.add(prefix + ch + suffix);
			}
		}

		return mr;
	}

	public static ArrayList<String> getKpc(String str) {
		if (str.length() == 0) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add("");
			return temp;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getKpc(ros);
		ArrayList<String> mr = new ArrayList<String>();
		String mc = getChoice(ch);
		for (String s : rr) {
			for (int i = 0; i < mc.length(); i++) {
				mr.add(mc.charAt(i) + s);
			}
		}

		return mr;
	}

	public static String getChoice(char key) {
		if (key == '1') {
			return "abc";
		}
		if (key == '2') {
			return "def";
		}
		if (key == '3') {
			return "ghi";
		}
		if (key == '4') {
			return "jkl";
		}
		if (key == '5') {
			return "mno";
		}
		if (key == '6') {
			return "pqrs";
		}
		if (key == '7') {
			return "tuv";
		}
		if (key == '8') {
			return "wx";
		}
		if (key == '9') {
			return "yz";
		}
		if (key == '0') {
			return ".;";
		}
		return "";
	}

}
