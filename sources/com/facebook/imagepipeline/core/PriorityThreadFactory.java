package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
public class PriorityThreadFactory implements ThreadFactory {
    public final int a;
    public final String b;
    public final boolean c;
    public final AtomicInteger d;

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(PriorityThreadFactory.this.a);
            } catch (Throwable unused) {
            }
            this.a.run();
        }
    }

    public PriorityThreadFactory(int i) {
        this(i, "PriorityThreadFactory", true);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str;
        a aVar = new a(runnable);
        if (this.c) {
            str = this.b + "-" + this.d.getAndIncrement();
        } else {
            str = this.b;
        }
        return new Thread(aVar, str);
    }

    public PriorityThreadFactory(int i, String str, boolean z) {
        this.d = new AtomicInteger(1);
        this.a = i;
        this.b = str;
        this.c = z;
    }
}
