package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    public final String a;
    public final int b;
    public final boolean c;

    public static final class a extends Thread implements NonBlockingThread {
        public a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        String str = this.a + '-' + incrementAndGet();
        Thread aVar = this.c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong, java.lang.Object
    public String toString() {
        return a2.b.a.a.a.t(a2.b.a.a.a.L("RxThreadFactory["), this.a, "]");
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.a = str;
        this.b = i;
        this.c = z;
    }
}
