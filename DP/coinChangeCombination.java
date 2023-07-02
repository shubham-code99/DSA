import java.util.*;

public class coinChangeCombination {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] coins=new int[n];
        for(int i=0;i<n;++i){
            coins[i]=sc.nextInt();
        }
        int tar=sc.nextInt();
        int []dp=new int[tar+1];
        dp[0]=1;
        for(int c:coins){
            for(int i=1;i<=tar;++i){
                if(i>=c){
                    dp[i]+=dp[i-c];
                }
            }
        }
        System.out.println(dp[tar]);
    }
}
