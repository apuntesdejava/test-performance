/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apuntesdejava.test.performance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author diego
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        while (list.size() < 1000) {
            list.add(random.nextInt());
        }

        System.out.println("--- MIDIENDO VALID LIST");
        long test1 = testPerformance(list, (l) -> Utils.isValidListIf(l));
        long test2 = testPerformance(list, (l) -> Utils.isValidListInline(l));
        long test3 = testPerformance(list, (l) -> Utils.isValidListOptional(l));
        System.out.printf("usando if      :%10d%n", test1);
        System.out.printf("usando inline  :%10d%n", test2);
        System.out.printf("usando optional:%10d%n", test3);

        String test = "12345678990qwertyuiopasdfghjklzxcvbnm";
        long test4 = testPerformance(test, t -> Utils.isValidStringIf(t));
        long test5 = testPerformance(test, t -> Utils.isValidStringInLine(t));
        long test6 = testPerformance(test, t -> Utils.isValidStringOption(t));
        long test7 = testPerformance(test, t -> StringUtils.isNotBlank(t));

        System.out.println("--- MIDIENDO VALID STRING");
        System.out.printf("usando if      :%10d%n" ,test4);
        System.out.printf("usando inline  :%10d%n" , test5);
        System.out.printf("usando optional:%10d%n" , test6);
        System.out.printf("usando lang3   :%10d%n" , test7);

    }

    public static <T> long testPerformance(T param, Consumer<T> consumer) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            consumer.accept(param);
        }
        long end = System.nanoTime();
        return end - start;
    }
}
