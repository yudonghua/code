//import java.util.*;
//import java.util.regex.*;
//
///**
// * Created by PC on 2017/8/7.
// */
//public class Main0 {
//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        long[] x = new long[n];
//        long[] y = new long[n];
//        for(int i =0;i<n;i++){
//            x[i] = input.nextInt();
//        }
//        for(int i =0;i<n;i++){
//            y[i] = input.nextInt();
//        }
////        System.out.prlongln(Arrays.toString(x));
////        System.out.prlongln(Arrays.toString(y));
////        findSum(x,y,0,1);
//        String str = "";
//        for(int i = 0;i<n;i++){
//            long min = Long.MAX_VALUE;
//
//            for(int j = 0;j<n;j++){
//                min = Math.min(findSum(x,y,j,i+1),min);
//            }
//            str+=min+" ";
//        }
//
//        System.out.println(str.trim());
//    }
//    public static long findSum(long[] x,long[] y,int index,int k){
//        int n = x.length;
//        long[] xy = new long[n];
//        for(int i =0;i<n;i++){
//            xy[i] = Math.abs(x[i]-x[index])+Math.abs(y[i]-y[index]);
//        }
//        Arrays.sort(xy);
//        long sum = 0;
//        for(int i = 0;i<k;i++){
//            sum+=xy[i];
//        }
//        return sum;
//    }
//}