package a2.j.d.l.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
public final class e0 implements ThreadFactory {
    public final /* synthetic */ ThreadFactory a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AtomicLong c;
    public final /* synthetic */ Boolean d;
    public final /* synthetic */ Integer e;
    public final /* synthetic */ Thread.UncaughtExceptionHandler f;

    public e0(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = threadFactory;
        this.b = str;
        this.c = atomicLong;
        this.d = bool;
        this.e = num;
        this.f = uncaughtExceptionHandler;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.a.newThread(runnable);
        String str = this.b;
        if (str != null) {
            newThread.setName(String.format(Locale.ROOT, str, Long.valueOf(this.c.getAndIncrement())));
        }
        Boolean bool = this.d;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        Integer num = this.e;
        if (num != null) {
            newThread.setPriority(num.intValue());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f;
        if (uncaughtExceptionHandler != null) {
            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        return newThread;
    }
}
