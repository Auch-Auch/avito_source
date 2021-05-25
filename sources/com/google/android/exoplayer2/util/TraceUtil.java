package com.google.android.exoplayer2.util;

import android.os.Trace;
public final class TraceUtil {
    public static void beginSection(String str) {
        if (Util.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (Util.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
