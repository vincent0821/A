package jav.core.singleton;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public enum Singleton6 {
    s;

    private int a;
    void add(int b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        Singleton6.s.add(3);
    }


}
