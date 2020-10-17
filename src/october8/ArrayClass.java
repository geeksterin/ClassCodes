package october8;

import java.util.*;

public class ArrayClass {

	public static void main(String[] args) {
//		declaring an array
//		int[] arr = new int[5];
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//
//		System.out.println();

//		Scanner scn = new Scanner(System.in);
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//
//		System.out.println();
//
//		for (int i = arr.length - 1; i >= 0; i--) {
//			System.out.print(arr[i] + " ");
//		}

//		System.out.println(arr[6]);

//		int[] arr2 = { 1, 2, 3, 4, 5 };
//		for (int i = 0; i < 2*arr2.length; i++) {
//			System.out.println("Hello");
//		}
//		targetSumSorted(arr2, 4);

		int[] prices = { 7, 1, 5, 3, 6, 4 };
		if (prices.length == 1) {
			return;
		}

		int minTillNow = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			maxProfit = Math.max(0, prices[i] - minTillNow);
			minTillNow = Math.min(minTillNow, prices[i]);
		}

		String str = "Hello";
		str.contains("ello");
		int[] arr = new int[2];
		Arrays.sort(arr);

		System.out.println(maxProfit);

	}

	public static void targetSum(int[] arr, int target) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int currSum = arr[i] + arr[j];
				if (currSum == target) {
					System.out.println(i + " " + j);
					System.out.println(arr[i] + " " + arr[j]);
					System.out.println("yes");
					return;
				}
			}
		}
		System.out.println("No");
	}

	public static void targetSumSorted(int[] arr, int target) {
		int l = 0;
		int r = arr.length - 1;
		int[] arr2 = new int[arr.length];
		while (l != r) {
			int currSum = arr[l] + arr[r];
			if (currSum == target) {
				System.out.println(l + " " + r);
				return;
			} else if (currSum < target) {
				l++;
			} else {
				r--;
			}
		}
	}

}
