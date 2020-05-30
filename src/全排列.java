/**
 * Created by PC on 2017/8/7.
 */
public class 全排列 {
    public static void permutation(char[] a,int start,int end){
        if(start==end){
            System.out.println(a);
        }else for(int i = start;i<=end;i++){
            swap(a,i,start);
            permutation(a,start+1,end);
            swap(a,i,start);
        }
    }
    public static void swap(char[] a,int i,int j){
        if(i!=j){
            a[i]^=a[j]^=a[i];
            a[j]^=a[i];
        }
    }


}
