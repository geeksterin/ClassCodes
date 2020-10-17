package october17;

public class Recursion {

	public static void main(String[] args) {
//		printDi(6);
//		System.out.println(fib(5));

		int[] arr = { 2, 5, 4, 3, 2, 1, 44, 101, 2, 79 };
		int[] res = allIndices(arr, 0, 2, 0);
		for (int val : res) {
			System.out.print(val + " ");
		}
	}

	public static void printDi(int num) {
		if (num == 0) {
			return;
		}
		if (num % 2 != 0) {
			System.out.println("Hi" + num);
		}

		printDi(num - 1);

		if (num % 2 == 0) {
			System.out.println("Bye" + num);
		}
	}

	public static void printIncreasing(int num) {
		if (num == 0) {
			return;
		}
		printIncreasing(num - 1);
		System.out.println(num);
	}

	public static void printDecreasing(int num) {
		if (num == 0) {
			return;
		}
		System.out.println(num);
		printDecreasing(num - 1);
	}

	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		}
		int fnm1 = factorial(num - 1);
		int fnm = fnm1 * num;
		return fnm;
	}

	public static int power(int num, int pow) {
		if (pow == 0) {
			return 1;
		}
		return num * power(num, pow - 1);
	}

	public static int powerBtr(int num, int pow) {
		if (pow == 0) {
			return 1;
		}

		if (pow == 1) {
			return num;
		}
		int powby2 = powerBtr(num, pow / 2);
		if (pow % 2 == 0) {
			return powby2 * powby2;
		} else {
			return powby2 * powby2 * num;
		}
	}

	public static int fib(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		int fibnm1 = fib(n - 1);
		int fibnm2 = fib(n - 2);
		int currFib = fibnm1 + fibnm2;
		return currFib;
	}

	private static void printArrayStupid(int[] arr) {
		if (arr.length == 0) {
			return;
		}
		int[] newArr = new int[arr.length - 1];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[i + 1];
		}
		System.out.println(arr[0]);
		printArrayStupid(newArr);
	}

	public static void printArray(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.println(arr[vidx]);
		printArray(arr, vidx + 1);
	}

	static int vidx = 0;

	public static void printArrayGlobal(int[] arr) {
		if (vidx == arr.length) {
			return;
		}
		System.out.println(arr[vidx]);
		vidx++;
		printArrayGlobal(arr);
	}

	public static void printReverse(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		printReverse(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			return arr[vidx];
		}
		int maxofRest = max(arr, vidx + 1);
		if (maxofRest > arr[vidx]) {
			return maxofRest;
		} else {
			return arr[vidx];
		}
	}

	public static boolean findStupid(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}
		boolean rr = findStupid(arr, vidx + 1, data);
		if (rr == true) {
			return true;
		} else {
			if (arr[vidx] == data) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static boolean findSmart(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}
		if (arr[vidx] == data) {
			return true;
		}

		boolean rr = findSmart(arr, vidx + 1, data);
		return rr;

	}

	public static int findFirstIdx(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == data) {
			return vidx;
		}

		return findFirstIdx(arr, vidx + 1, data);
	}

	public static int findLastIdx(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		int rr = findLastIdx(arr, vidx + 1, data);
		if (rr != -1) {
			return rr;
		} else {
			if (arr[vidx] == data) {
				return vidx;
			} else {
				return -1;
			}
		}

	}

	public static int[] allIndices(int[] arr, int vidx, int data, int fsf) {
		if (vidx == arr.length) {
			int[] newArr = new int[fsf];
			return newArr;
		}
//		pre area
		if (arr[vidx] == data) {
			fsf++;
		}

		int[] rr = allIndices(arr, vidx + 1, data, fsf);
//		post area
		if (arr[vidx] == data) {
			rr[fsf - 1] = vidx;
		}

		return rr;

	}

}
