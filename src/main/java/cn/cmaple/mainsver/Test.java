package cn.cmaple.mainsver;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List a = new ArrayList();
        List b = new ArrayList();
        a.add(1);
        b.add(2);
        a.addAll(b);
        System.out.println("a - " + a);
        System.out.println("b - " + b);
    }
}