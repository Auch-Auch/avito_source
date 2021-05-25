package com.google.android.exoplayer2;

import a2.b.a.a.a;
import android.os.Build;
import java.util.HashSet;
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final String DEFAULT_USER_AGENT = a.u(a.L("ExoPlayerLib/2.12.2 (Linux;Android "), Build.VERSION.RELEASE, ") ", VERSION_SLASHY);
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.12.2";
    public static final int VERSION_INT = 2012002;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.12.2";
    public static final HashSet<String> a = new HashSet<>();
    public static String b = "goog.exo.core";

    public static synchronized void registerModule(String str) {
        synchronized (ExoPlayerLibraryInfo.class) {
            if (a.add(str)) {
                b += ", " + str;
            }
        }
    }

    public static synchronized String registeredModules() {
        String str;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = b;
        }
        return str;
    }
}
