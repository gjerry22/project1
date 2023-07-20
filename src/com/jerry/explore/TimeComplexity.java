package com.jerry.explore;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Jerry
 */
public class TimeComplexity {

    public static void function1(long n) {
        System.out.println("o(n)算法");
        long k = 0;
        for (long i = 0; i < n; i++) {
            k++;
        }
    }

    public static void function2(long n) {
        System.out.println("o(n^2)算法");
        long k = 0;
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
                k++;
            }
        }
    }


    public static void function3(long n) {
        System.out.println("o(nlogn)算法");
        long k = 0;
        for (long i = 0; i < n; i++) {
            // 注意这里j=1
            for (long j = 1; j < n; j = j * 2) {
                k++;
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.print("输入n: ");
            String str = in.nextLine();
            int n = Integer.parseInt(str);
            System.out.println(n);
//            long n = 0L, m = 0L;
//            n = in.nextLong();
//            m = in.nextLong();
//            System.out.println(n);
//            System.out.println(m);
//            long startTime = System.currentTimeMillis();
//
//            function1(n);
//            // function2(n);
//            // function3(n);
//
//            long endTime = System.currentTimeMillis();
//            long costTime = endTime - startTime;
//            System.out.println("算法耗时 == " + costTime + "ms");
        }
    }
}
