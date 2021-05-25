package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b2\u0010\u0013J#\u0010\t\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010\u0013J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010!J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010\u0005\u001a\u00020#8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010%R\u0016\u0010,\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u001c8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u00101¨\u00063"}, d2 = {"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/lang/Class;", "fjpClass", "Ljava/util/concurrent/ExecutorService;", "executor", "", "isGoodCommonPool$kotlinx_coroutines_core", "(Ljava/lang/Class;Ljava/util/concurrent/ExecutorService;)Z", "isGoodCommonPool", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "usePrivatePool$kotlinx_coroutines_core", "()V", "usePrivatePool", "", "timeout", "shutdown$kotlinx_coroutines_core", "(J)V", "shutdown", "restore$kotlinx_coroutines_core", "restore", "", "toString", "()Ljava/lang/String;", "close", AuthSource.BOOKING_ORDER, "()Ljava/util/concurrent/ExecutorService;", AuthSource.SEND_ABUSE, "Ljava/util/concurrent/Executor;", "c", "()Ljava/util/concurrent/Executor;", "", "d", "()I", "parallelism", "getExecutor", "I", "requestedParallelism", "pool", "Ljava/util/concurrent/Executor;", "DEFAULT_PARALLELISM_PROPERTY_NAME", "Ljava/lang/String;", "Z", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class CommonPool extends ExecutorCoroutineDispatcher {
    @NotNull
    public static final String DEFAULT_PARALLELISM_PROPERTY_NAME = "kotlinx.coroutines.default.parallelism";
    public static final CommonPool INSTANCE = new CommonPool();
    public static final int a;
    public static boolean b;
    public static volatile Executor pool;

    public static final class a implements ThreadFactory {
        public final /* synthetic */ AtomicInteger a;

        public a(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder L = a2.b.a.a.a.L("CommonPool-worker-");
            L.append(this.a.incrementAndGet());
            Thread thread = new Thread(runnable, L.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public static final class b implements Runnable {
        public static final b a = new b();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class c implements Executor {
        public static final c a = new c();

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            throw new RejectedExecutionException("CommonPool was shutdown");
        }
    }

    static {
        String str;
        int i;
        try {
            str = System.getProperty(DEFAULT_PARALLELISM_PROPERTY_NAME);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            Integer intOrNull = l.toIntOrNull(str);
            if (intOrNull == null || intOrNull.intValue() < 1) {
                throw new IllegalStateException(a2.b.a.a.a.c3("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
            i = intOrNull.intValue();
        } else {
            i = -1;
        }
        a = i;
    }

    public final ExecutorService a() {
        return Executors.newFixedThreadPool(d(), new a(new AtomicInteger()));
    }

    public final ExecutorService b() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return a();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return a();
        }
        if (!b && a < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(invoke instanceof ExecutorService)) {
                    invoke = null;
                }
                executorService = (ExecutorService) invoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (!INSTANCE.isGoodCommonPool$kotlinx_coroutines_core(cls, executorService)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(INSTANCE.d()));
            if (!(newInstance instanceof ExecutorService)) {
                newInstance = null;
            }
            executorService2 = (ExecutorService) newInstance;
        } catch (Throwable unused3) {
        }
        if (executorService2 != null) {
            return executorService2;
        }
        return a();
    }

    public final synchronized Executor c() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = b();
            pool = executor;
        }
        return executor;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    public final int d() {
        Integer valueOf = Integer.valueOf(a);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return e.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = c();
            }
            TimeSource timeSource = TimeSourceKt.getTimeSource();
            if (timeSource == null || (runnable2 = timeSource.wrapTask(runnable)) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException unused) {
            TimeSource timeSource2 = TimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unTrackTask();
            }
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        Executor executor = pool;
        return executor != null ? executor : c();
    }

    public final boolean isGoodCommonPool$kotlinx_coroutines_core(@NotNull Class<?> cls, @NotNull ExecutorService executorService) {
        executorService.submit(b.a);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
        }
        if (num == null || num.intValue() < 1) {
            return false;
        }
        return true;
    }

    public final synchronized void restore$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0);
        b = false;
        pool = null;
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long j) {
        Executor executor = pool;
        if (!(executor instanceof ExecutorService)) {
            executor = null;
        }
        ExecutorService executorService = (ExecutorService) executor;
        if (executorService != null) {
            executorService.shutdown();
            if (j > 0) {
                executorService.awaitTermination(j, TimeUnit.MILLISECONDS);
            }
            Iterator<T> it = executorService.shutdownNow().iterator();
            while (it.hasNext()) {
                DefaultExecutor.INSTANCE.enqueue(it.next());
            }
        }
        pool = c.a;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher, java.lang.Object
    @NotNull
    public String toString() {
        return "CommonPool";
    }

    public final synchronized void usePrivatePool$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0);
        b = true;
        pool = null;
    }
}
