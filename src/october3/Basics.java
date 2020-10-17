package october3;

import java.util.Scanner;

public class Basics {

	public static void main(String[] args) {
//		System.out.println("Hello World");
//
//		int val = 10;
//		System.out.println(val);
//		float pi = (float) 3.14;
////		int pii = 3.14;
//
//		char ch = 'a';
//		String str = "abc";
//		String st = "a";
//		int n1 = 0, n2 = 0, n3 = 0;
//		Scanner scn = new Scanner(System.in);
//		int x = scn.nextInt();
//		int y = scn.nextInt();
//		int z = scn.nextInt();
//
//		if (x > y) {
//			if (x > z) {
//				System.out.println(x);
//			} else {
//				System.out.println(z);
//			}
//		} else {
//			if (y > z) {
//				System.out.println(y);
//			} else {
//				System.out.println(z);
//			}
//		}
//
//		int num1 = 20;
//		int num2 = 30;
//		char operator = '*';
//
//		if (operator == '+') {
//			System.out.println(num1 + num2);
//		} else if (operator == '-') {
//			System.out.println(num1 - num2);
//		} else if (operator == '*') {
//			System.out.println(num1 * num2);
//		} else if (operator == '/') {
//			System.out.println(num1 / num2);
//		}
//
////		while loop
////		while(condn) {
////			
////		}
//
//		int i = 0;
//		while (i < 3) {
//			System.out.println(i);
////			i++;
//		}

//		Sum of N numbers
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
//		int count = 0;
//		int sum = 0;
//		while (count < n) {
//			int input = scn.nextInt();
//			sum = 10;
//			count++;
//		}
//
//		System.out.println(sum);

//		Larget of N numbers
//		int count = 0;
//		int max = Integer.MIN_VALUE;
//		while (count < n) {
//			int input = scn.nextInt();
//			if (input > max) {
//				max = input;
//			}
//
//			count++;
//		}
//
//		System.out.println(max);

		boolean isPrime = true;
		int count = 2;
		while (count <= Math.sqrt(n)) {
			if (n % count == 0) {
				System.out.println("Not Prime");
				isPrime = false;
				break;
			}
			count++;
		}

		if (isPrime == true) {
			System.out.println("Prime");
		}

	}

}
