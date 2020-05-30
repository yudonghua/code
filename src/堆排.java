import java.util.Arrays;

/**
 * Created by PC on 2017/8/8.
 */
public class 堆排 {
    public static void main(String[] args){
        int[] a ={5,2,3,6,6,9,5,2,6};
        System.out.println(Arrays.toString(sort(a)));
    }
    public static int[] sort(int[] a){
        init(a);
        for(int i = a.length-1;i>=0;i--){
            swap(a,0,i);
            adjustHeap(a,0,i);
        }
        return a;
    }

    public static int[] adjustHeap(int[] a,int root,int length){
        int left = root*2+1;
        int right = root*2+2;
        int max = root;
        if(left<length&&a[max]<a[left]){
            max = left;
        }
        if(right<length&&a[max]<a[right]){
            max = right;
        }
        if(max!=root){
            swap(a,root,max);
            adjustHeap(a,max,length);
        }
        return a;
    }
    public static int[] init(int[] a){
        int mid = (a.length-2)/2;
        for(int i = mid;i>=0;i--){
            adjustHeap(a,i,a.length);
        }
        return a;
    }

    public static void swap(int[] a,int i,int j){
        if(i!=j){
            a[i]^=a[j]^=a[i];
            a[j]^=a[i];
        }
    }
}
