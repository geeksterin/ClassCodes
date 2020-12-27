package stringMatching;

public class KMP {

	public static void main(String[] args) {
//		String str = "abcaby$abxabcabcaby";
//		int[] arr = LPS(str);
//		for (int val : arr) {
//			System.out.print(val + " ");
//		}
		int[] arr = { 5, 4, 3, 2, 1 };
		quickSort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.println(val);
		}
	}

	public static int[] LPS(String str) {
		int[] arr = new int[str.length()];

		arr[0] = 0;
		int len = 0;
		int i = 1;
		while (i < str.length()) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				arr[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = arr[len - 1];
				} else {
					arr[i] = len;
					i++;
				}
			}
		}

		return arr;
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int pi = partition(arr, lo, hi);
			quickSort(arr, lo, pi - 1);
			quickSort(arr, pi + 1, hi);
		}
	}

	private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int i = lo - 1;
		for (int j = lo; j < hi; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		i++;
		int temp = arr[i];
		arr[i] = arr[hi];
		arr[hi] = temp;

		return i;
	}

}
