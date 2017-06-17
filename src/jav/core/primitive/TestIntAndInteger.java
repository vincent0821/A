package jav.core.primitive;

/**
 * Created by gongkuaikuai on 2017/4/1.
 */
public class TestIntAndInteger {
    static int i = 1;
    static Integer in = 1;//也是值语意！shit！为什么，因为当对它++的时候，会创建一个新的对象
    static void addI(int j){
        j++;
        System.out.println(i);
    }
    static void addInteger(Integer j){
        j++;
        System.out.println(in);
    }

    public static void main(String[] args) {
        addI(1);
        addInteger(1);
    }
}

