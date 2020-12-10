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
		int[] arr = {0,1,5,8,9,10,17,17,20};
		System.out.println(rodCutting(arr));
	}

}
