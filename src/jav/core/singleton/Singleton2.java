package jav.core.singleton;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class Singleton2 {
    private static Singleton2 s;

    public synchronized  static Singleton2 getS(){
        if(s == null){
            s = new Singleton2();
        }
        return s;
    }

    private Singleton2(){}

}
