package com.facebook.appevents.codeless.internal;
public class UnityReflection {
    public static Class<?> a;

    public static void captureViewHierarchy() {
        sendMessage("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    public static void sendEventMapping(String str) {
        sendMessage("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }

    public static void sendMessage(String str, String str2, String str3) {
        try {
            if (a == null) {
                a = Class.forName("com.unity3d.player.UnityPlayer");
            }
            a.getMethod("UnitySendMessage", String.class, String.class, String.class).invoke(a, str, str2, str3);
        } catch (Exception unused) {
        }
    }
}
