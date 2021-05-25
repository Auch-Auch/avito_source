package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.Objects;
import java.util.concurrent.Callable;
public final class AndroidSchedulers {
    public static final Scheduler a = RxAndroidPlugins.initMainThreadScheduler(new a());

    public static class a implements Callable<Scheduler> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return b.a;
        }
    }

    public static final class b {
        public static final Scheduler a = new s6.a.a.a.a(new Handler(Looper.getMainLooper()), false);
    }

    public AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler from(Looper looper) {
        return from(looper, false);
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(a);
    }

    @SuppressLint({"NewApi"})
    public static Scheduler from(Looper looper, boolean z) {
        Objects.requireNonNull(looper, "looper == null");
        int i = Build.VERSION.SDK_INT;
        if (z && i < 22) {
            Message obtain = Message.obtain();
            try {
                obtain.setAsynchronous(true);
            } catch (NoSuchMethodError unused) {
                z = false;
            }
            obtain.recycle();
        }
        return new s6.a.a.a.a(new Handler(looper), z);
    }
}
