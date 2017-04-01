package jav.core.singleton;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class Scene {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    System.out.println(Thread.currentThread());
                    System.out.println(Singleton1.getS());
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    System.out.println(Thread.currentThread());
                    System.out.println(Singleton1.getS());
                }
            }
        });
        Thread t3 = new Thread(){
            public void run(){
                for(;;){
                    System.out.println(Thread.currentThread());
                    System.out.println(Singleton1.getS());
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
