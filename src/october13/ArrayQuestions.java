package october13;

public class ArrayQuestions {

	public static int trap(int[] height) {
		int[] lmax = new int[height.length];
		int[] rmax = new int[height.length];

		lmax[0] = height[0];

		for (int i = 1; i < height.length; i++) {
			lmax[i] = Math.max(lmax[i], lmax[i - 1]);
		}

		rmax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			rmax[i] = Math.max(rmax[i], rmax[i + 1]);
		}

		int ans = 0;

		for (int i = 1; i < height.length - 1; i++) {
			int minBoth = Math.min(lmax[i], rmax[i]);
			if (minBoth > height[i]) {
				ans += minBoth - height[i];
			}
		}

		return ans;
	}

	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int[] res = new int[arr1.length + arr2.length];

		while (p1 < arr1.length && p2 < arr2.length) {
			if (arr1[p1] < arr2[p2]) {
				res[p3] = arr1[p1];
				p1++;
			} else {
				res[p3] = arr2[p2];
				p2++;
			}
			p3++;
		}

		while (p1 < arr1.length) {
			res[p3] = arr1[p1];
			p1++;
			p3++;
		}

		while (p2 < arr2.length) {
			res[p3] = arr2[p2];
			p2++;
			p3++;
		}
		return res;
	}

	public static void main(String[] args) {
//		int[] arr1 = { 2, 5, 7, 9, 11 };
//		int[] arr2 = { 1, 3, 7, 9, 10 };
//		int[] merged = mergeTwoSortedArrays(arr1, arr2);
//		for (int val : merged) {
//			System.out.print(val + " ");
//		}

		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int val = trap(arr);
		System.out.println(val);
	}

}
