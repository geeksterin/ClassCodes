package October14;

import java.util.Scanner;

public class Arrays2d {

	public static void main(String[] args) {
//		int[][] arr = new int[3][3];
//
//		Scanner scn = new Scanner(System.in);
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[0].length; j++) {
//				arr[i][j] = scn.nextInt();
//			}
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[0].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		int diagonal1 = 0, diagonal2 = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[0].length; j++) {
//				if (i == j) {
//					diagonal1 += arr[i][j];
//				}
//
//				if ((i + j) == (arr.length - 1)) {
//					diagonal2 += arr[i][j];
//				}
//			}
//		}
//
//		System.out.println(diagonal1 + " " + diagonal2);
//
//		int temp = 0;
//		for (int i = 0, j = 0; i < arr.length; i++, j++) {
//			temp += arr[i][j];
//		}
//		System.out.println(temp);
//
//		for (int j = 0; j < arr[0].length; j++) {
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printSpiral(arr);
	}

	public static void printWave(int[][] arr) {
		for (int j = 0; j < arr[0].length; j++) {
//			in top to bottom case
			if (j % 2 == 0) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i][j] + " ");
				}
			} else {

//			in bottom to top case
				for (int i = arr.length - 1; i >= 0; i--) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
	}

	public static void printReverseWave(int[][] arr) {
		boolean flag = false;
		for (int j = arr[0].length - 1; j >= 0; j--) {
//			in top to bottom case
			if (flag == false) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i][j] + " ");
				}
				flag = true;
			} else {

//			in bottom to top case
				for (int i = arr.length - 1; i >= 0; i--) {
					System.out.print(arr[i][j] + " ");
				}
				flag = false;
			}
		}
	}

	public static void printSpiral(int[][] arr) {
		int startRow = 0;
		int endRow = arr.length - 1;
		int startCol = 0;
		int endCol = arr[0].length - 1;

		while (startRow <= endRow && startCol <= endCol) {
			for (int i = startCol; i <= endCol; i++) {
				System.out.println(arr[startRow][i]);
			}
			startRow++;

			if (startRow <= endRow && startCol <= endCol) {
				for (int i = startRow; i <= endRow; i++) {
					System.out.println(arr[i][endCol]);
				}
				endCol--;
			}
			if (startRow <= endRow && startCol <= endCol) {

				for (int i = endCol; i >= startCol; i--) {
					System.out.println(arr[endRow][i]);
				}

				endRow--;
			}

			if (startRow <= endRow && startCol <= endCol) {
				for (int i = endRow; i >= startRow; i--) {
					System.out.println(arr[i][startCol]);
				}

				startCol++;
			}
		}
	}

}
