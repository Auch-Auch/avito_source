package o6;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public final class b {
    public static final b d = new b();
    public final ExecutorService a;
    public final ScheduledExecutorService b;
    public final Executor c;

    /* renamed from: o6.b$b  reason: collision with other inner class name */
    public static class ExecutorC0545b implements Executor {
        public ThreadLocal<Integer> a = new ThreadLocal<>();

        public ExecutorC0545b(a aVar) {
        }

        public final int a() {
            Integer num = this.a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.a.remove();
            } else {
                this.a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Integer num = this.a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.a.set(Integer.valueOf(intValue));
            if (intValue <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    a();
                    throw th;
                }
            } else {
                b.d.a.execute(runnable);
            }
            a();
        }
    }

    public b() {
        boolean z;
        ThreadPoolExecutor threadPoolExecutor;
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            z = false;
        } else {
            z = property.toLowerCase(Locale.US).contains("android");
        }
        if (!z) {
            threadPoolExecutor = Executors.newCachedThreadPool();
        } else {
            a aVar = a.b;
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(a.d, a.e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
            threadPoolExecutor = threadPoolExecutor2;
        }
        this.a = threadPoolExecutor;
        this.b = Executors.newSingleThreadScheduledExecutor();
        this.c = new ExecutorC0545b(null);
    }
}
