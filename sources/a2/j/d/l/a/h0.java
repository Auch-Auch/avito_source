package a2.j.d.l.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@CanIgnoreReturnValue
@GwtIncompatible
public abstract class h0 implements ExecutorService {
    public final ExecutorService a;

    public h0(ExecutorService executorService) {
        this.a = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    public abstract <T> Callable<T> a(Callable<T> callable);

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j, timeUnit);
    }

    public final <T> ImmutableList<Callable<T>> b(Collection<? extends Callable<T>> collection) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Callable<T> callable : collection) {
            builder.add((ImmutableList.Builder) a(callable));
        }
        return builder.build();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ExecutorService executorService = this.a;
        Supplier supplier = ((y) this).c;
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        executorService.execute(new k(supplier, runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.a.invokeAll(b(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.a.invokeAny(b(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.a.submit(a((Callable) Preconditions.checkNotNull(callable)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.a.invokeAll(b(collection), j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.a.invokeAny(b(collection), j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        ExecutorService executorService = this.a;
        Supplier supplier = ((y) this).c;
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return executorService.submit(new k(supplier, runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t) {
        ExecutorService executorService = this.a;
        Supplier supplier = ((y) this).c;
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return executorService.submit(new k(supplier, runnable), t);
    }
}
