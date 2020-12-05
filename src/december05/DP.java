package december05;

public class DP {

    public static int staircase(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int ans = staircase(n-1,dp) + staircase(n-2,dp) + staircase(n-3,dp);
        dp[n] = ans;
        return ans;

    }


    public static int staircaseIter(int n){
        int [] qb = new int[n + 3];
        qb[0] = 1;
        qb[1] = 1;
        qb[2] = 2;

        for (int i=3;i<=n;i++){
            qb[i] = qb[i-1] + qb[i-2] + qb[i-3];
        }
        return qb[n];

    }



    public static int maxLoot(int[] houses,int index,int[] dp){
        if(index == 0){
            return houses[0];
        }
        if(index == 1){
            return Math.max(houses[0],houses[1]);
        }

        if(dp[index] != 0){
            return dp[index];
        }

        else{
            //cur + i-2 , i -1
            int ans = Math.max(houses[index]+maxLoot(houses,index-2,dp),maxLoot(houses,index-1,dp));
            dp[index] = ans;
            return ans;
        }

    }


    public static int maxLootIter(int[] houses){

        int dp[] = new int[100];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0],houses[1]);
        for (int i=2;i< houses.length ;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+houses[i]);
        }
        return dp[houses.length-1];

    }

    // implement memoization and tabulation
    public static int countPath(int x,int y){
        if(x==0 && y ==0){
            return 1;
        }
        else if(x < 0 || y < 0){
            return 0;
        }
        else{
            return countPath(x-1,y) + countPath(x,y-1);
        }

    }

    public static void main(String[] args){
//        int[] dp = new int[100];
//        System.out.print(staircase(5,dp) + " ");
//        System.out.print(staircaseIter(5));

        int houses[] = {6,7,1,3,8,2,4};
        int dp[] = new int[100];
        int n = houses.length;
        System.out.print(maxLootIter(houses));

    }




}
