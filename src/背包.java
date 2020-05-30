/**
 * Created by PC on 2017/8/11.
 */
import java.util.*;
public class 背包 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int max = input.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            weight[i] = input.nextInt();
            value[i] = input.nextInt();
            num[i] = input.nextInt();
        }
        System.out.println(backpack(weight,value,num,max));
    }
    public static int backpack(int[] weight,int[] value,int[] num,int max){
        int n = weight.length;
        int[] dp = new int[max+1];
        for(int i = 0;i<n;i++){
            for(int k =0;k<num[i];k++)
                for(int j = max;j>=weight[i];j--){
                    dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[max];
    }

}
