/**
 * Created by PC on 2017/9/9.
 */
public class Test {

    public static void main(String[] args){
        String[] s =new String[Integer.MAX_VALUE - 8];
        s[0]="dd";
    }
    public static void dd(AA a){
        System.out.println("a");
    }
    public static void dd(BB b){
        System.out.println("b");
    }


}
class AA{

    public void aa(){
        System.out.print("aa");
        dd();
    }

    public void dd(){
        System.out.print("aadd");
    }


}
class BB extends AA{
    public void dd(){
        System.out.print("bbdd");
    }
    BB(){
        System.out.println("BB() a");
    }
}

