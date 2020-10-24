package october20;

import java.util.ArrayList;

public class RecursionContd {

	public static void main(String[] args) {
//		System.out.println(getKpc("12"));
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		Integer i = 10;
//		System.out.println(i + 1);
//		int ii = 10;
//		RecursionContd rr = new RecursionContd();
//		rr.print();
//		RecursionContd rr1 = new RecursionContd();
//		rr1.print();
//		rr.getSS("abc");
//		RecursionContd.getSS("abc");
//		int[][] boards = new int[4][4];
//		nQueens(boards, "", 0);
//		int[] arr = { 3, 34, 4, 12, 5, 2 };
//		subsetSum(arr, 0, 0, 9, "");
		subset("abc", "");
	}

	public static void subset(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		subset(ros, ans);
		subset(ros, ans + ch);
	}

	public static void subsetSum(int[] arr, int vidx, int currSum, int target, String ans) {
		if (vidx == arr.length) {
			if (currSum == target) {
				System.out.println(ans);
			}
			return;
		}

//		if all elements are positive
		if (currSum > target) {
			return;
		}
		subsetSum(arr, vidx + 1, currSum + arr[vidx], target, ans + arr[vidx] + " ");
		subsetSum(arr, vidx + 1, currSum, target, ans);
	}

	public static void subsetSum2(int[] arr, int vidx, int target, String ans) {
		if (vidx == arr.length) {
			if (target == 0) {
				System.out.println(ans);
			}
			return;
		}

//		if all elements are positive
		if (target < 0) {
			return;
		}
		subsetSum2(arr, vidx + 1, target - arr[vidx], ans + arr[vidx] + " ");
		subsetSum2(arr, vidx + 1, target, ans);
	}

	public static void nQueens(int[][] board, String ans, int qsf) {
		if (qsf == board.length) {
			System.out.println(ans);
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
			if (isItSafe(board, qsf, col) == true) {
				board[qsf][col] = 1;
				nQueens(board, ans + "R" + qsf + "C" + col + " ", qsf + 1);
				board[qsf][col] = 0;
			}
		}
	}

	private static boolean isItSafe(int[][] board, int row, int col) {
//		vertical Position
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}

//		first Diagonal
		int i = row - 1;
		int j = col - 1;
		while (i >= 0 && j >= 0) {
			if (board[i][j] == 1) {
				return false;
			}
			i--;
			j--;
		}

//		second Diagonal
		i = row - 1;
		j = col + 1;
		while (i >= 0 && j < board[0].length) {
			if (board[i][j] == 1) {
				return false;
			}
			i--;
			j++;
		}

		return true;

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
