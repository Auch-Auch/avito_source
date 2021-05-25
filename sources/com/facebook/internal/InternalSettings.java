package com.facebook.internal;
public class InternalSettings {
    public static volatile String a;

    public static String getCustomUserAgent() {
        return a;
    }

    public static boolean isUnityApp() {
        return a != null && a.startsWith("Unity.");
    }

    public static void setCustomUserAgent(String str) {
        a = str;
    }
}
