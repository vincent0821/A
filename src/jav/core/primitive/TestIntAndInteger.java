package jav.core.primitive;

/**
 * Created by gongkuaikuai on 2017/4/1.
 */
public class TestIntAndInteger {
    static int i = 1;
    static Integer in = 1;//Ҳ��ֵ���⣡shit��Ϊʲô����Ϊ������++��ʱ�򣬻ᴴ��һ���µĶ���
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

