package com.cbt.utilities;

public class StringUtility {
    public static void verifyEquals(String Expected, String Actual) {
        if(Expected.equals(Actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected = " + Expected);
            System.out.println("Actual = " + Actual);
        }
    }
    public static void verifyStartsWith(String Expected, String Actual) {
        if(Actual.startsWith(Expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected = " + Expected);
            System.out.println("Actual = " + Actual);
        }
    }
    public static void verifyContainsUrl(String Expected, String Actual) {
        Expected = Expected.toLowerCase().replace(" ", "");
        Actual = Actual.substring(Actual.indexOf("www.")+4,Actual.indexOf(".com"));
        if(Expected.contains(Actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected = " + Expected);
            System.out.println("Actual = " + Actual);
        }
    }
}
