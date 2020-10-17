package october10;

public class StackAndHeapDiscussion {

	public static void fun(int val) {
		int[] arr = new int[5];
		arr[2] = 15;
		System.out.println(arr[2]);
		arr = new int[10];
		System.out.println(arr[2]);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[5];
		int val = 5;
		fun(val);
		System.out.println(arr[3]);
//		System.out.println(val);
//		System.out.println(arr);
//		val = 10;
//		bizz(val);
	}

}
