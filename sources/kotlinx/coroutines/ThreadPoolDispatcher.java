package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/ThreadPoolDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "", "close", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicInteger;", AuthSource.BOOKING_ORDER, "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNo", "Ljava/util/concurrent/Executor;", "c", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "", "d", "I", "nThreads", "e", "Ljava/lang/String;", "name", "<init>", "(ILjava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class ThreadPoolDispatcher extends ExecutorCoroutineDispatcherBase {
    public final AtomicInteger b = new AtomicInteger();
    @NotNull
    public final Executor c;
    public final int d;
    public final String e;

    public static final class a implements ThreadFactory {
        public final /* synthetic */ ThreadPoolDispatcher a;

        public a(ThreadPoolDispatcher threadPoolDispatcher) {
            this.a = threadPoolDispatcher;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            String str;
            ThreadPoolDispatcher threadPoolDispatcher = this.a;
            if (threadPoolDispatcher.d == 1) {
                str = this.a.e;
            } else {
                str = this.a.e + "-" + this.a.b.incrementAndGet();
            }
            return new PoolThread(threadPoolDispatcher, runnable, str);
        }
    }

    public ThreadPoolDispatcher(int i, @NotNull String str) {
        this.d = i;
        this.e = str;
        this.c = Executors.newScheduledThreadPool(i, new a(this));
        initFutureCancellation$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executor = getExecutor();
        Objects.requireNonNull(executor, "null cannot be cast to non-null type java.util.concurrent.ExecutorService");
        ((ExecutorService) executor).shutdown();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this.c;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.CoroutineDispatcher, java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ThreadPoolDispatcher[");
        L.append(this.d);
        L.append(", ");
        return a2.b.a.a.a.s(L, this.e, ']');
    }
}
