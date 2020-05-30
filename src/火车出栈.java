import java.util.*;
public class 火车出栈 {
    static int[] in;
    static TreeSet<String> set = new TreeSet<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        in = new int[n];
        for(int i = 0;i<n;i++)in[i]=input.nextInt();
        fun(0,new Stack<>(),"");
        for(String s:set)System.out.println(s);
    }
    static void fun(int n, Stack <Integer> stk, String sout) {
        if(n == in.length && stk.isEmpty())set.add(sout.trim());
        else{
            if (n <  in.length){
                stk.push(in[n]);
                fun(n+1, stk, sout);
                stk.pop();
            }
            if (!stk.isEmpty()){
                String temp = sout+ stk.peek()+" ";
                Integer integer= stk.pop();//出栈
                fun(n, stk,temp);
                stk.push(integer);
            }
        }
    }
    static void fun2(int n, Stack <Integer> stk, String sout) {
        if(n == in.length && stk.isEmpty())set.add(sout.trim());
        else{
            //入栈
            if (n <  in.length){
                //入栈时没有输出
                stk.push(in[n]);
                fun(n+1, stk, sout);//入栈游标+1
                stk.pop();
            }
            //出栈
            if (!stk.isEmpty()){
                String temp = sout+ stk.peek()+" ";//出栈时输出
                Integer integer= stk.pop();
                fun(n, stk,temp);//出栈游标不动
                stk.push(integer);
            }
        }
    }
}