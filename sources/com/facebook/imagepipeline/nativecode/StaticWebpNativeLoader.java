package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.nativeloader.NativeLoader;
public class StaticWebpNativeLoader {
    public static boolean a;

    public static synchronized void ensure() {
        synchronized (StaticWebpNativeLoader.class) {
            if (!a) {
                NativeLoader.loadLibrary("static-webp");
                a = true;
            }
        }
    }
}
