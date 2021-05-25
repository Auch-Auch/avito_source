package com.bluejamesbond.text;
public class Console {
    public static void log(double d) {
    }

    public static void log(float f) {
    }

    public static void log(int i) {
    }

    public static void log(long j) {
    }

    public static <T> void log(T t) {
        if (t != null) {
            t.toString();
        }
    }

    public static void log(String str) {
    }

    public static void log(String str, double d) {
    }

    public static void log(String str, float f) {
    }

    public static void log(String str, int i) {
    }

    public static void log(String str, long j) {
    }

    public static void log(String str, String str2) {
    }

    public static void log(String str, boolean z) {
    }

    public static void log(boolean z) {
    }
}
