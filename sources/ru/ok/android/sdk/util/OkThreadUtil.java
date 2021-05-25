package ru.ok.android.sdk.util;

import android.os.Handler;
import android.os.Looper;
public class OkThreadUtil {
    public static Handler a;

    public static final void executeOnMain(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            queueOnMain(runnable, 0);
        }
    }

    public static final Handler getMainThreadHandler() {
        if (a == null) {
            a = new Handler(Looper.getMainLooper());
        }
        return a;
    }

    public static final boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static final void queueOnMain(Runnable runnable, long j) {
        getMainThreadHandler().postDelayed(runnable, j);
    }
}
