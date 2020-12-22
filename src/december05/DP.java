package december05;

public class DP {

	public static int staircase(int n, int[] dp) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		int ans = staircase(n - 1, dp) + staircase(n - 2, dp) + staircase(n - 3, dp);
		dp[n] = ans;
		return ans;

	}

	public static int staircaseIter(int n) {
		int[] qb = new int[n + 3];
		qb[0] = 1;
		qb[1] = 1;
		qb[2] = 2;

		for (int i = 3; i <= n; i++) {
			qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
		}
		return qb[n];

	}

	public static int maxLoot(int[] houses, int index, int[] dp) {
		if (index == 0) {
			return houses[0];
		}
		if (index == 1) {
			return Math.max(houses[0], houses[1]);
		}

		if (dp[index] != 0) {
			return dp[index];
		}

		else {
			// cur + i-2 , i -1
			int ans = Math.max(houses[index] + maxLoot(houses, index - 2, dp), maxLoot(houses, index - 1, dp));
			dp[index] = ans;
			return ans;
		}

	}

	public static int maxLootIter(int[] houses) {

		int dp[] = new int[100];
		dp[0] = houses[0];
		dp[1] = Math.max(houses[0], houses[1]);
		for (int i = 2; i < houses.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
		}
		return dp[houses.length - 1];

	}

	// implement memoization and tabulation
	public static int countPath(int x, int y, int dp[][]) {
		if (x == 0 && y == 0) {
			return 1;
		} else if (x < 0 || y < 0) {
			return 0;
		}
		if (dp[x][y] != 0) {
			return dp[x][y];
		} else {
			dp[x][y] = countPath(x - 1, y, dp) + countPath(x, y - 1, dp);
			return dp[x][y];
		}

	}

	public static int countPathIter(int x, int y) {
		int[][] dp = new int[x][y];
		for (int i = 0; i < x; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < y; j++) {
			dp[0][j] = 1;
		}

		for (int i = 1; i < x; i++) {
			for (int j = 1; j < y; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[x - 1][y - 1];

	}

	public static int knapSack01(int[] weight, int[] value, int capacity, int index, int[][] dp) {

		// capacity is zero
		if (capacity == 0) {
			return 0;
		}
		// index == length
		if (index >= weight.length) {
			return 0;
		}
		// capacity < weight

		if (dp[capacity][index] != -1) {
			return dp[capacity][index];
		}

		if (capacity < weight[index]) {
			int ans = knapSack01(weight, value, capacity, index + 1, dp);
			dp[capacity][index] = ans;
			return ans;
		}

		// scenario include me
		int ans1 = knapSack01(weight, value, capacity - weight[index], index + 1, dp) + value[index];

		// scenaio do not include me
		int ans2 = knapSack01(weight, value, capacity, index + 1, dp);

		// my ans
		int ans = Math.max(ans1, ans2);
		dp[capacity][index] = ans;
		return ans;
	}

	public static int knapSack01Iter(int[] weight, int[] value, int capacity) {
		int[][] dp = new int[capacity + 1][weight.length + 1];

		for (int i = 1; i < capacity + 1; i++) {
			for (int j = 1; j < weight.length + 1; j++) {
				// can i include myself
				if (i >= weight[j - 1]) {
					dp[i][j] = Math.max(value[j - 1] + dp[i - weight[j - 1]][j - 1], dp[i][j - 1]);
				} else {
					dp[i][j] = dp[i][j - 1];
				}

			}
		}

		return dp[capacity][weight.length];

	}

	public static int minCostPath(int[][] costs) {
		int[][] dp = new int[costs.length][costs.length];
		int end = costs.length - 1;
		dp[end][end] = costs[end][end];
		for (int i = end; i >= 0; i--) {
			for (int j = end; j >= 0; j--) {
				if (i == end && j == end) {
					continue;
				} else if (i == end) {
					dp[i][j] = dp[i][j + 1] + costs[i][j];
				} else if (j == end) {
					dp[i][j] = dp[i + 1][j] + costs[i][j];
				} else {
					dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
				}
			}
		}

		return dp[0][0];
	}

	public static int goldMine(int[][] mine) {
		int rowMax = mine.length - 1;
		int colMax = mine[0].length - 1;

		int[][] dp = new int[rowMax + 1][colMax + 1];

		for (int i = 0; i <= rowMax; i++) {
			dp[i][colMax] = mine[i][colMax];
		}

		for (int j = colMax - 1; j >= 0; j--) {
			for (int i = 0; i <= rowMax; i++) {
				if (i == 0) {
					dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
				} else if (i == rowMax) {
					dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
				} else {
					dp[i][j] = mine[i][j] + Math.max(dp[i + 1][j + 1], Math.max(dp[i][j + 1], dp[i - 1][j + 1]));
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= rowMax; i++) {
			max = Math.max(max, dp[i][0]);
		}

		return max;
	}

	public static int rodCutting(int[] rod) {
		int[] dp = new int[rod.length];
		dp[0] = rod[0];
		dp[1] = rod[1];
		for (int i = 2; i < rod.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1, c = i - 1; j <= c; j++, c--) {
				max = Math.max(max, dp[j] + dp[c]);
			}
			if (rod[i] > max) {
				max = rod[i];
			}

			dp[i] = max;
		}

		return dp[dp.length - 1];
	}

	public static int minJumps(int[] arr) {
		int[] jumps = new int[arr.length];

		jumps[0] = 0;

		for (int i = 1; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < i; j++) {
				if (arr[j] >= i - j) {
					min = Math.min(min, jumps[j] + 1);
				}

			}
			jumps[i] = min;
		}

		for (int val : jumps) {
			System.out.print(val + " ");
		}

		System.out.println();

		return jumps[jumps.length - 1];
	}

	public static int Lis(int[] arr) {
		int[] res = new int[arr.length];

		res[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(res[j], max);
				}
			}

			res[i] = max + 1;
		}
		int max = Integer.MIN_VALUE;
		for (int val : res) {
			max = Math.max(max, val);
		}

		return max;

	}

	public static void coinChangeCombination(int[] arr, int target) {
		int[] strg = new int[target + 1];

		strg[0] = 1;
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < strg.length; i++) {
				if (i >= arr[j]) {
					strg[i] += strg[i - arr[j]];
				}
			}
		}

		for (int val : strg) {
			System.out.print(val + " ");
		}
	}

	public static void coinChangePermutation(int[] arr, int target) {
		int[] strg = new int[target + 1];

		strg[0] = 1;
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i >= arr[j]) {
					strg[i] += strg[i - arr[j]];
				}
			}
		}

		for (int val : strg) {
			System.out.print(val + " ");
		}
	}

	public static int lcsMemoised(String s1, String s2, Integer[][] qb) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (qb[s1.length()][s2.length()] != null) {
			return qb[s1.length()][s2.length()];
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans;
		if (ch1 == ch2) {
			ans = 1 + lcsMemoised(ros1, ros2, qb);
		} else {
			ans = Math.max(lcsMemoised(s1, ros2, qb), lcsMemoised(ros1, s2, qb));

		}

		qb[s1.length()][s2.length()] = ans;

		return ans;
	}

	public static void Lcs(String first, String second) {
		int[][] strg = new int[first.length() + 1][second.length() + 1];

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				if (i == 0) {
					strg[i][j] = 0;
				} else if (j == 0) {
					strg[i][j] = 0;
				} else {
					if (first.charAt(i - 1) == second.charAt(j - 1)) {
						strg[i][j] = strg[i - 1][j - 1] + 1;
					} else {
						strg[i][j] = Math.max(strg[i - 1][j], strg[i][j - 1]);
					}
				}
			}
		}

		System.out.println(strg[strg.length - 1][strg[0].length - 1]);
	}

	public static int editDist(String str1, String str2, int m, int n) {
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}
		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return editDist(str1, str2, m - 1, n - 1);
		} else {
			return 1 + Math.min(editDist(str1, str2, m, n - 1),
					Math.min(editDist(str1, str2, m - 1, n - 1), editDist(str1, str2, m - 1, n - 1)));
		}
	}

	public static int editDistTabulation(String str1, String str2, int m, int n) {
		int[][] strg = new int[m + 1][n + 1];
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				if (i == 0) {
					strg[i][j] = j;
				} else if (j == 0) {
					strg[i][j] = i;
				} else {
					if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
						strg[i][j] = strg[i - 1][j - 1];
					} else {
						strg[i][j] = Math.min(strg[i][j - 1], Math.min(strg[i - 1][j], strg[i - 1][j - 1])) + 1;
					}
				}
			}
		}

		return strg[strg.length - 1][strg[0].length - 1];
	}

	public static void unboundedKnapsack(int[] wts, int[] price, int cap) {
		int[] strg = new int[cap + 1];
		strg[0] = 0;
		for (int i = 1; i < strg.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < wts.length; j++) {
				if (i - wts[j] >= 0) {
					max = Math.max(max, strg[i - wts[j]] + price[j]);
				}
				strg[i] = max;
			}
		}
		System.out.println(strg[strg.length - 1]);
	}

	public static int LongPalinSubsequenceTabul(String str) {
		int[][] strg = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 1;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = 2;
					} else {
						strg[i][j] = 1;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = strg[i + 1][j - 1] + 2;
					} else {
						strg[i][j] = Math.max(strg[i][j - 1], strg[i + 1][j]);
					}
				}
			}
		}

		return strg[0][str.length() - 1];
	}

	public static int LongPalinSubsMem(int sIdx, int eIdx, String str, int[][] dp) {
		if (sIdx == eIdx) {
			return 1;
		}
		if (sIdx > eIdx) {
			return 0;
		}

		if (dp[sIdx][eIdx] != 0) {
			return dp[sIdx][eIdx];
		}

		char ch1 = str.charAt(sIdx);
		char ch2 = str.charAt(eIdx);
		if (ch1 == ch2) {
			return dp[sIdx][eIdx] = LongPalinSubsMem(sIdx + 1, eIdx - 1, str, dp) + 2;
		} else {
			return dp[sIdx][eIdx] = Math.max(LongPalinSubsMem(sIdx + 1, eIdx, str, dp),
					LongPalinSubsMem(sIdx, eIdx - 1, str, dp));
		}
	}

	public static boolean[][] LongestPalinSubstring(String str) {
		boolean[][] strg = new boolean[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = true;
					} else {
						strg[i][j] = false;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = strg[i + 1][j - 1];
						;
					} else {
						strg[i][j] = false;
					}
				}
			}
		}

		outer: for (int gap = str.length() - 1; gap >= 0; gap--) {
			for (int i = 0, j = gap; j < str.length(); i++, j++) {
				if (strg[i][j]) {
					System.out.println(str.substring(i, j + 1));
					break outer;
				}
			}
		}

		return strg;

	}

	public static int minCutPalindrome(String str) {
		int[][] strg = new int[str.length()][str.length()];

		boolean[][] isPalin = LongestPalinSubstring(str);

		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 0;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = 0;
					} else {
						strg[i][j] = 1;
					}
				} else {
					if (isPalin[i][j]) {
						strg[i][j] = 0;
					} else {
						int min = Integer.MAX_VALUE;
						for (int idash = i + 1, jdash = i; jdash < j; jdash++, idash++) {
							min = Math.min(strg[i][jdash] + strg[idash][j], min);
						}
						strg[i][j] = min + 1;
					}
				}
			}
		}

		return strg[0][strg.length - 1];
	}

	public static void mcm(int[] dims) {
		int[][] strg = new int[dims.length - 1][dims.length - 1];
		for (int gap = 0; gap < strg.length; gap++) {
			for (int i = 0, j = gap; j < strg.length; i++, j++) {
				if (gap == 0) {
					strg[i][j] = 0;
				} else if (gap == 1) {
					strg[i][j] = dims[i] * dims[j] * dims[j + 1];
				} else {
					strg[i][j] = Integer.MAX_VALUE;
					for (int idash = i + 1, jdash = i; jdash < j; idash++, jdash++) {
						strg[i][j] = Math.min(strg[i][j],
								strg[i][jdash] + strg[idash][j] + dims[i] * dims[jdash + 1] * dims[j + 1]);
					}
				}
			}
		}

		System.out.println(strg[0][strg.length - 1]);
	}
	
	

	public static void main(String[] args) {
//        int[] dp = new int[100];
//        System.out.print(staircase(5,dp) + " ");
//        System.out.print(staircaseIter(5));
//        int houses[] = {6,7,1,3,8,2,4};
//        int dp[] = new int[100];
//        int n = houses.length;
//        System.out.print(maxLootIter(houses));

//        int[][] dp = new int[100][100];
//        System.out.println( countPath(2,2,dp));

//		int[] weight = { 2, 3, 1, 4 };
//		int[] value = { 4, 5, 3, 7 };
//		int capacity = 5;
//		int[][] dp = new int[capacity + 5][weight.length + 5];
//		for (int i = 0; i < capacity + 5; i++) {
//			for (int j = 0; j < weight.length + 5; j++) {
//				dp[i][j] = -1;
//			}
//		}

//        System.out.print(knapSack01(weight,value,capacity,0,dp));
//		System.out.print(knapSack01Iter(weight, value, capacity));

//		int[][] costs = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
//		System.out.println(minCostPath(costs));
//		int[][] mine = { { 3, 2, 5, 8, 9, 5 }, { 5, 6, 3, 7, 9, 8 }, { 9, 1, 0, 5, 2, 1 }, { 2, 4, 7, 0, 9, 3 },
//				{ 3, 0, 7, 6, 8, 2 }, { 8, 4, 3, 2, 2, 5 } };
//		System.out.println(goldMine(mine))
//		int[] arr = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };
//		System.out.println(rodCutting(arr));
//		int[] arr = { 3, 2, 0, 2, 3, 1, 0, 1, 2, 0, 1 };
//		System.out.println(minJumps(arr));
//		int[] arr = { 10, 22, 9, 3, 21, 50, 41, 60, 80 };
//		System.out.println(Lis(arr));

//		int[] arr = { 2, 3, 5 };
//		int target = 7;
//		coinChangePermutation(arr, target);
//		Integer[][] arr = new Integer[8][8];
//		System.out.println(lcsMemoised("AGGTAB", "GXTXAYB", arr));
//		Lcs("AGGTAB", "GXTXAYB");
//		String str = "GEEKSFORGEEKS";
//		int[][] dp = new int[str.length()][str.length()];
//		System.out.println(LongPalinSubsequenceTabul("GEEKSFORGEEKS"));
//		System.out.println(LongPalinSubsMem(0, str.length() - 1, str, dp));
//		LongestPalinSubstring("abccbc");
//		System.out.println(minCutPalindrome("abccab"));
		int[] arr = {40,20,30,10,30};
		mcm(arr);
	}

}
