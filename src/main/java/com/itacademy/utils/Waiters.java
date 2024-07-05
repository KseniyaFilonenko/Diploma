package com.itacademy.utils;

public class Waiters {
    public static void waitLoadingLoginPage(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
