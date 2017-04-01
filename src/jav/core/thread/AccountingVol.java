package jav.core.thread;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class AccountingVol implements Runnable{
    static AccountingVol instance = new AccountingVol();

    static Integer i = 0;

    public synchronized static void increase(){
        i++;
    }

    @Override
    public void run() {
        for(int j=0;j<10000000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AccountingVol());
        Thread t2 = new Thread(new AccountingVol());
        t1.start();
        t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
