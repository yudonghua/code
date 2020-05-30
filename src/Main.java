import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static boolean con = true;
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 34);
        calendar.set(Calendar.SECOND, 0);
        Date date=calendar.getTime();
        System.out.println(date);
        TimerTask task = new TimerTask() {

            public void run() {

                System.out.println("-------设定要指定任务--------");
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,date,10000);
    }
    public static String re(String[] ss){
        return null;
    }
    public static void main2(String[] args)  {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] ss = str.split(",");
        int n = Integer.parseInt(ss[0]);
        if(n<3){
            System.out.println("incorrect data");
            return;
        }
        long start = 0;
        long end = 0;
        try {
            start = stringToLong(ss[1],"yyyy-MM-dd HH:mm:ss");
            end = stringToLong(ss[2],"yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            System.out.println("incorrect data");
            return;
        }
        long num = (end - start)/1000/60/15/n+1;
        long time = (end - start)%(1000*60*15*n);
        if(end<start){
            System.out.println("incorrect data");
            return;
        }
        long m = time/1000/60;
        System.out.println(num+";"+(m/15%n+1)+"-"+((m+5)/15%n+1));
    }
    public static long stringToLong(String strTime,String formatType) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		Date date = formatter.parse(strTime);
		if (date == null) {
			return 0;
		} else {
			return date.getTime();
		}
	}

    public static int getNum2(String str){
        int k= 0;
        int min =0;
        int max=0;
        boolean start = false;
        for(int i =0;i<str.length();i++){
            if(start){
                if(i>str.length()-max)break;
                if(str.charAt(i)=='(')k++;
                else {
                    k--;
                    if(min>k)min=k;
                }
            }else{
                if(str.charAt(i)=='(')k++;
                else {
                    min = k;
                    max=k;
                    start = true;
                }
            }
        }
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)==')'&&str.charAt(i+1)=='(') k=0;
            if(str.charAt(i)=='(')k++;
        }
        return min;
    }
    public static int getNum(String str){
        int k=0,max=0;
        for(int i =str.length()-1;i>0;i--){
            if(str.charAt(i)=='(')break;
            max++;
        }
        for(int i =0;i<str.length()-1;i++){
            if(str.charAt(i)==')'&&str.charAt(i+1)=='(') k=0;
            if(str.charAt(i)=='(')k++;
        }
        if(max==k)return max;
        return max-k;
    }

    public static int max(int[] a,int k){
        int max = 0;
        for(int i = 1;i<=a.length;i++){
            long sum = 0;
            for(int j = 0;j<i;j++){
                sum+=a[j];
            }
            if(sum%k==0&&sum!=0)max=i;
            for(int j =i;j<a.length;j++){
                sum = sum + a[j] - a[j-i];
                if(sum%k==0)max=i;
            }
        }
        return max;
    }


}
class TreeNode {
    int val;
     TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static void main(String[] args){
        Pattern p= Pattern.compile(" ");
        StringBuffer a = new StringBuffer("1 1 1 1 1 1 1");
        Matcher m=p.matcher(a);
        while(m.find()) {
            m.group();
            a.delete(m.start(),m.end());
            a.insert(m.start(),"%20");

        }
        System.out.println(a);
    }

}


class A implements Comparable<A>{
    int a ;
    public int A(){
        return 0;
    }
    public A(int a){
        this.a=a;
    }
    @Override
    public int compareTo(A o) {
        return a-o.a;
    }
    public String toString(){
        return a+"";
    }
}
class B implements Comparator<A>{

    @Override
    public int compare(A o1, A o2) {
        return o2.a-o1.a;
    }
}


