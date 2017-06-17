package jav.core.enviroment.restrauant;

import java.util.List;

/**
 * Created by gongkuaikuai on 2017/4/10.
 */
public class Waiter {
    public void pourTea(Customer customer) {
    }

    public List<Order> write(Customer customer) {
        return null;
    }

    public void serve(Customer customer, Course course){

    }

    public void exchangePlate(Customer customer){}

    public Cook pass(List<Order> orders) {
        return new Cook();
    }
}
