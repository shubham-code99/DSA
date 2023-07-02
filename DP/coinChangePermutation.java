import java.util.Scanner;

public class coinChangePermutation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int[] coins=new int[n];
            for(int i=0;i<n;++i){
                coins[i]=sc.nextInt();
            }
            int tar=sc.nextInt();

            int[] dp=new int[tar+1];
            dp[0]=1;
            for(int i=1;i<tar+1;++i){
                for(int c:coins){
                    if(i>=c){
                        dp[i]+=dp[i-c];
                    }
                }
            }
            System.out.println(dp[tar]);
        }
        
    }
}
