package october3;

public class Basics2 {
	public static void main(String[] args) {

		int[] arr = { -1, -1 };
		int maxProduct = 1;
		int currNegProd = 1;
		int currPosProd = 1;

		boolean flag1 = false, flag2 = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				currPosProd *= arr[i];
				currNegProd = currNegProd * arr[i];
				flag1 = true;
			} else if (arr[i] == 0) {
				currPosProd = 1;
				currNegProd = 1;
			} else {
				int temp = currPosProd;
				currPosProd = Math.max(currNegProd * arr[i], 1);
				currNegProd = temp * arr[i];
				flag2 = true;
			}

			if (maxProduct < currPosProd) {
				maxProduct = currPosProd;
			}
		}

		if (flag2 == false && flag1 == false) {
			maxProduct = 0;
		}

		System.out.println(maxProduct);
	}
}
