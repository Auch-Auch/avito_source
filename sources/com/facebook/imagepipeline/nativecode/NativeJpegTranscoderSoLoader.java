package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.nativeloader.NativeLoader;
public class NativeJpegTranscoderSoLoader {
    public static boolean a;

    public static synchronized void ensure() {
        synchronized (NativeJpegTranscoderSoLoader.class) {
            if (!a) {
                NativeLoader.loadLibrary("native-imagetranscoder");
                a = true;
            }
        }
    }
}
