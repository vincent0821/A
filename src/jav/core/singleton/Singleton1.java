package jav.core.singleton;

/**
 * Created by gongkuaikuai on 2017/3/31.
 * lazy init
 */
public class Singleton1 {
    private static Singleton1 s;

    public static Singleton1 getS(){
        if(s == null){
            s = new Singleton1();
        }
        return s;
    }

    private Singleton1(){};


}
