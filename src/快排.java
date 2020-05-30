import java.util.Arrays;

/**
 * Created by PC on 2017/8/7.
 */
public class 快排 {
    public static void main(String[] args){
        int[] a = {5,3,6,9,8,2,5,63,3,2,1,5,3,2,5,6,2132,1654,654,6};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void getK(int[] a,int k,int start,int end){
        if(start>=end)return;
        int i = start,j = end;
        while(i<j){
            while(i<j&&a[i]<=a[j])j--;
            swap(a,i,j);
            while(i<j&&a[i]<=a[j])i++;
            swap(a,i,j);
        }
        if(k==i)return;
        if(k<i)qsort(a,start,i-1);
        if(k>i)qsort(a,i+1,end);
    }
    public static void qsort(int[] a,int start,int end){
        if(start>=end)return;
        int i = start,j = end;
        while(i<j){
            while(i<j&&a[i]<=a[j])j--;
            swap(a,i,j);
            while(i<j&&a[i]<=a[j])i++;
            swap(a,i,j);
        }
        qsort(a,start,i-1);
        qsort(a,i+1,end);
    }
    public static void sort(int[] a,int start,int end){
        if(start>=end)return;
        int i = start;
        int j = start+1;
        while(j<=end){
            if(a[j]<a[start]){
                i++;
                swap(a,i,j);
            }
            j++;
        }
        swap(a,start,i);
        sort(a,start,i-1);
        sort(a,i+1,end);
    }
    public static void swap(int[] a,int i,int j){
        if(i!=j){
            a[i]^=a[j]^=a[i];
            a[j]^=a[i];
        }
    }

    public static <T> void print(T a){
        System.out.println(a.toString());
    }
}