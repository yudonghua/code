public class TestDemo {
    public static void main(String[] args) {
        BThread bt = new BThread();
        AThread at = new AThread();
        try {
            bt.start();
            bt.join();
            at.start();
            //at.join(); //在此处注释掉对join()的调用
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(" end!");
    }
}
class AThread extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("aaa");
    }
}
class BThread extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("bbb");
    }
}