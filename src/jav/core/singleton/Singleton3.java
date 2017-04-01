package jav.core.singleton;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class Singleton3 {
    private static Singleton3 s;

    public static Singleton3 getS(){
        if(s == null){
            synchronized (Singleton3.class){
                if(s==null){
                    s = new Singleton3();
                }
            }
        }
        return s;
    }

    private Singleton3(){}
}
