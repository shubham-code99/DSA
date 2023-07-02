import java.util.Scanner;

public class zeroOneKnapsack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] items=new int[n];
        int[] wt=new int[n];
        for(int i=0;i<n;++i) items[i]=sc.nextInt();
        for(int i=0;i<n;++i) wt[i]=sc.nextInt();
        int cap=sc.nextInt();

        int[][] dp=new int[n+1][cap+1];
        for(int i=0;i<=n;++i){
            for(int j=0;j<cap+1;++j){
                if(i==0 || j==0) dp[i][j]=0;
                else{
                    if(j-wt[i-1]>=0)
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]]+items[i-1]);
                    else dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][cap]);
    }
}
