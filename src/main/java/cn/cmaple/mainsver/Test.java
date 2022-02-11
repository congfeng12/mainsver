package cn.cmaple.mainsver;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List a = new ArrayList();
        a.add(1);
        List b = a;
        b.add(2);
        System.out.println("a - " + a);
        System.out.println("b - " + b);
    }
}