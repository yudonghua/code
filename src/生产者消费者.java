/**
 * Created by PC on 2017/8/15.
 */
public class 生产者消费者 {
    public static void main(String[] args){
        Thread thread0 = new ThreadA();
        Thread thread1 = new ThreadA();
        Thread thread2 = new ThreadA();
        Thread thread3 = new ThreadA();
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("end");
    }
}
class Z{
    Z z;
    Z(){}

}
class ThreadA extends Thread{
    @Override
    public void run() {
        dd();
        ff();
    }
    public synchronized void dd(){
        System.out.println("dd");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void ff(){
        System.out.println("ff");
    }
}
class ThreadB extends Thread{
    @Override
    public void run() {

    }
}


class C{
    int max;
    int num;
    C(int max,int num){
        this.max=max;
        this.num=num;
    }
}
class Pro implements Runnable{
    C c;
    int i;
    Pro(C c,int i){
        this.c=c;
        this.i=i;
    }
    @Override
    public void run() {
        while(true){
            synchronized (c){

                while(c.num==c.max){
                    System.out.println(i+"生产等待");
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c.num++;
                System.out.println(i+"生产一个："+c.num);

                c.notify();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Cus implements Runnable{
    C c;
    int i;
    Cus(C c,int i){
        this.c=c;
        this.i=i;
    }
    @Override
    public void run() {
        while (true){
            synchronized (c){
                while(c.num==0){

                    System.out.println(i+"消费等待");
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c.num--;
                System.out.println(i+"消费一个："+c.num);

                c.notify();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}