package jav.core.thread;

import java.util.Objects;

/**
 * Created by gongkuaikuai on 2017/4/1.
 */
public class BadLockOnInteger implements Runnable {
    static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();
    @Override
    public void run() {
        for(int j = 0; j<100000; j++){
            synchronized (this){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
