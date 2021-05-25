package io.reactivex.rxjava3.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.Objects;
import s6.a.e.a.b.b;
public final class AndroidSchedulers {
    public static final Scheduler a = RxAndroidPlugins.initMainThreadScheduler(s6.a.e.a.b.a.a);

    public static final class a {
        public static final Scheduler a = new b(new Handler(Looper.getMainLooper()), true);
    }

    public AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler from(Looper looper) {
        return from(looper, true);
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
        return new b(new Handler(looper), z);
    }
}
