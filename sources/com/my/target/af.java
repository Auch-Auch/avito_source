package com.my.target;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public abstract class af {
    public static final Executor a = Executors.newSingleThreadExecutor();
    public static final Executor b = Executors.newSingleThreadExecutor();
    public static final Executor c = new a();
    public static final Handler d = new Handler(Looper.getMainLooper());

    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            af.d.post(runnable);
        }
    }

    public static void a(@NonNull Runnable runnable) {
        a.execute(runnable);
    }

    public static void b(@NonNull Runnable runnable) {
        b.execute(runnable);
    }

    public static void c(@NonNull Runnable runnable) {
        c.execute(runnable);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
