package u6.a.l0;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    public static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(a.class, "inFlightTasks");
    public final ConcurrentLinkedQueue<Runnable> a = new ConcurrentLinkedQueue<>();
    public final ExperimentalCoroutineDispatcher b;
    public final int c;
    public final String d;
    public final int e;
    private volatile int inFlightTasks = 0;

    public a(@NotNull ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, @Nullable String str, int i2) {
        this.b = experimentalCoroutineDispatcher;
        this.c = i;
        this.d = str;
        this.e = i2;
    }

    public final void a(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.c) {
                this.b.dispatchWithContext$kotlinx_coroutines_core(runnable, this, z);
                return;
            }
            this.a.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) < this.c) {
                runnable = this.a.poll();
            } else {
                return;
            }
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
        Runnable poll = this.a.poll();
        if (poll != null) {
            this.b.dispatchWithContext$kotlinx_coroutines_core(poll, this, true);
            return;
        }
        f.decrementAndGet(this);
        Runnable poll2 = this.a.poll();
        if (poll2 != null) {
            a(poll2, true);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        a(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.e;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher, java.lang.Object
    @NotNull
    public String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.b + ']';
    }
}
