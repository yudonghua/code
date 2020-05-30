/**
 * Created by PC on 2017/8/9.
 */
import java.util.Arrays;
import java.util.Scanner;


public class 最长上升子序列 {
    public static void main(String[] args) {
        int[] a = {1,5,2,3,4,6,9,7,8};
        System.out.println(Arrays.toString(LengthOfLIS(a)));
    }

    public static int[] LengthOfLIS(int[] a){
        int n = a.length;
        int index = 0;
        int[] dp=new int[n];
        dp[index++]=a[0];
        for(int i=1;i<n;i++){
            if(a[i]>dp[index-1]){
                dp[index++]=a[i];
            }
            dp[search(dp,a[i],0,index-1)]=a[i];
        }
        return Arrays.copyOfRange(dp,0,index);

    }
    private static int search(int[] dp, int value,int start,int end) {
        int mid;
        while(start<end){
            mid=(start+end)/2;
            if(dp[mid]==value){
                return mid;
            }else if(dp[mid]>value){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}

