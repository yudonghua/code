/**
 * Created by PC on 2017/8/12.
 */
public class 元素位置 {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,8,9};
        System.out.println(indexInArray(a,-1));
    }
    public static int indexInArray(int [] array,int num) {
        int low = 0;
        int high = array.length-1;
        int mid = (low+high)/2;
        while(low<high){
            if(array[mid]==num){
                break;
            }else if(array[mid]>num){
                high = mid-1;
            }else if(array[mid]<num){
                low = mid+1;
            }
            mid = (low+high)/2;
        }
        return mid;
    }
}
