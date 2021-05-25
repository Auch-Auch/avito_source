package com.google.mlkit.common.sdkinternal;

import a2.j.h.a.c.j;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzal;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import java.util.Deque;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@KeepForSdk
public class MlKitThreadPool extends zzal {
    public static final ThreadLocal<Deque<Runnable>> d = new j();
    public final ExecutorService a = new ThreadPoolExecutor(0, Runtime.getRuntime().availableProcessors(), 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: a2.j.h.a.c.i
        public final MlKitThreadPool a;

        {
            this.a = r1;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            MlKitThreadPool mlKitThreadPool = this.a;
            Thread newThread = mlKitThreadPool.b.newThread(runnable);
            synchronized (mlKitThreadPool.c) {
                mlKitThreadPool.c.put(newThread, null);
            }
            return newThread;
        }
    });
    public final ThreadFactory b = Executors.defaultThreadFactory();
    @GuardedBy("threadPoolThreads")
    public final WeakHashMap<Thread, Void> c = new WeakHashMap<>();

    public static void a(Runnable runnable) {
        Deque<Runnable> deque = d.get();
        deque.add(runnable);
        if (deque.size() <= 1) {
            do {
                runnable.run();
                deque.removeFirst();
                runnable = deque.peekFirst();
            } while (runnable != null);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        boolean containsKey;
        synchronized (this.c) {
            containsKey = this.c.containsKey(Thread.currentThread());
        }
        if (containsKey) {
            a(runnable);
        } else {
            this.a.execute(new Runnable(runnable) { // from class: a2.j.h.a.c.h
                public final Runnable a;

                {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MlKitThreadPool.a(this.a);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal
    /* renamed from: zzb */
    public final ExecutorService zza() {
        return this.a;
    }
}
