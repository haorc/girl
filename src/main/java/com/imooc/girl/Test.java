package com.imooc.girl;

/**
 * Created by haorc ON 2018/5/8
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("123");
        System.out.println(fun1("100"));
    }

    public static String fun1(String age) {
        try {
            Integer.parseInt(age);
            System.out.println("try---");
            return "try";
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally---");
            return "finally";
        }

    }
}
