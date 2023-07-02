import java.util.*;

public class targetSumSubset {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;++i){
                arr[i]=sc.nextInt();
            }
            int tar=sc.nextInt();

            int[][] dp=new int[n+1][tar+1];

            for(int i=0;i<=n;++i){
                for(int j=0;j<=tar;++j){
                    if(i==0 && j==0)    dp[i][j]=1;
                    else if(i==0)    dp[i][j]=0;
                    else if(j==0)    dp[i][j]=1;
                    else{
                        if(dp[i-1][j]==1)   dp[i][j]=1;
                        else if(j-arr[i-1]>=0){
                            if(dp[i-1][j-arr[i-1]]==1)    dp[i][j]=1;
                        }
                    }
                }
            }
            System.out.println(dp[n][tar]);
        }
    }
}