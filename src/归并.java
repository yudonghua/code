/**
 * Created by PC on 2017/8/7.
 */
public class 归并 {
    public static void sort(int[] a,int start,int end) {
        int mid = (start+end)/2;
        if(start<end) {
            sort(a,start,mid);
            sort(a,mid+1,end);
            merge(a,start,mid,end);
        }
    }
    public static void merge(int[] a,int start,int mid,int end) {
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=end) {
            if(a[i]<=a[j]) {
                temp[k++]=a[i++];
            }else {
                temp[k++]=a[j++];
            }
        }
        while(i<=mid) {
            temp[k++]=a[i++];
        }
        while(j<=end) {
            temp[k++]=a[j++];
        }
        for(int l:temp) {
            a[start++]=l;
        }
    }
}
