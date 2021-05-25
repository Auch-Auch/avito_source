package com.google.common.util.concurrent;

import a2.j.d.l.a.a;
import a2.j.d.l.a.e;
import a2.j.d.l.a.f0;
import a2.j.d.l.a.g0;
import a2.j.d.l.a.l;
import a2.j.d.l.a.m;
import a2.j.d.l.a.r;
import a2.j.d.l.a.t;
import a2.j.d.l.a.u;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Futures extends t {

    @Beta
    @GwtCompatible
    @CanIgnoreReturnValue
    public static final class FutureCombiner<V> {
        public final boolean a;
        public final ImmutableList<ListenableFuture<? extends V>> b;

        public class a implements Callable<Void> {
            public final /* synthetic */ Runnable a;

            public a(FutureCombiner futureCombiner, Runnable runnable) {
                this.a = runnable;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                this.a.run();
                return null;
            }
        }

        public FutureCombiner(boolean z, ImmutableList immutableList, a aVar) {
            this.a = z;
            this.b = immutableList;
        }

        @CanIgnoreReturnValue
        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            return new m(this.b, this.a, executor, callable);
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            return new m(this.b, this.a, executor, asyncCallable);
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.common.util.concurrent.ListenableFuture<C>, com.google.common.util.concurrent.ListenableFuture<?> */
        public ListenableFuture<?> run(Runnable runnable, Executor executor) {
            return (ListenableFuture<C>) call(new a(this, runnable), executor);
        }
    }

    public static class a implements Runnable {
        public final /* synthetic */ Future a;

        public a(Future future) {
            this.a = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.cancel(false);
        }
    }

    public static class c implements Runnable {
        public final /* synthetic */ f a;
        public final /* synthetic */ ImmutableList b;
        public final /* synthetic */ int c;

        public c(f fVar, ImmutableList immutableList, int i) {
            this.a = fVar;
            this.b = immutableList;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = this.a;
            ImmutableList immutableList = this.b;
            int i = this.c;
            ListenableFuture<? extends T>[] listenableFutureArr = fVar.d;
            ListenableFuture<? extends T> listenableFuture = listenableFutureArr[i];
            listenableFutureArr[i] = null;
            for (int i2 = fVar.e; i2 < immutableList.size(); i2++) {
                if (((AbstractFuture) immutableList.get(i2)).setFuture(listenableFuture)) {
                    fVar.a();
                    fVar.e = i2 + 1;
                    return;
                }
            }
            fVar.e = immutableList.size();
        }
    }

    public static final class d<V> implements Runnable {
        public final Future<V> a;
        public final FutureCallback<? super V> b;

        public d(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.a = future;
            this.b = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.onSuccess(Futures.getDone(this.a));
            } catch (ExecutionException e) {
                this.b.onFailure(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.b.onFailure(e2);
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.b).toString();
        }
    }

    public static final class e<T> extends AbstractFuture<T> {
        public f<T> h;

        public e(f fVar, a aVar) {
            this.h = fVar;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.h = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            f<T> fVar = this.h;
            if (!super.cancel(z)) {
                return false;
            }
            fVar.a = true;
            if (!z) {
                fVar.b = false;
            }
            fVar.a();
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            f<T> fVar = this.h;
            if (fVar == null) {
                return null;
            }
            StringBuilder L = a2.b.a.a.a.L("inputCount=[");
            L.append(fVar.d.length);
            L.append("], remaining=[");
            L.append(fVar.c.get());
            L.append("]");
            return L.toString();
        }
    }

    public static final class f<T> {
        public boolean a = false;
        public boolean b = true;
        public final AtomicInteger c;
        public final ListenableFuture<? extends T>[] d;
        public volatile int e = 0;

        public f(ListenableFuture[] listenableFutureArr, a aVar) {
            this.d = listenableFutureArr;
            this.c = new AtomicInteger(listenableFutureArr.length);
        }

        public final void a() {
            if (this.c.decrementAndGet() == 0 && this.a) {
                ListenableFuture<? extends T>[] listenableFutureArr = this.d;
                for (ListenableFuture<? extends T> listenableFuture : listenableFutureArr) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.b);
                    }
                }
            }
        }
    }

    public static final class g<V> extends AbstractFuture.j<V> implements Runnable {
        public ListenableFuture<V> h;

        public g(ListenableFuture<V> listenableFuture) {
            this.h = listenableFuture;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.h = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            ListenableFuture<V> listenableFuture = this.h;
            if (listenableFuture == null) {
                return null;
            }
            return "delegate=[" + listenableFuture + "]";
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> listenableFuture = this.h;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new d(listenableFuture, futureCallback), executor);
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new l.b(ImmutableList.copyOf(listenableFutureArr), true);
    }

    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        int i = a2.j.d.l.a.a.k;
        a.b bVar = new a.b(listenableFuture, cls, function);
        listenableFuture.addListener(bVar, MoreExecutors.d(executor, bVar));
        return bVar;
    }

    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        int i = a2.j.d.l.a.a.k;
        a.C0077a aVar = new a.C0077a(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(aVar, MoreExecutors.d(executor, aVar));
        return aVar;
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        Ordering<Constructor<?>> ordering = r.a;
        r.c.b.a(cls);
        try {
            return future.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw r.a(cls, e2);
        } catch (ExecutionException e3) {
            r.b(e3.getCause(), cls);
            throw null;
        }
    }

    @CanIgnoreReturnValue
    public static <V> V getDone(Future<V> future) throws ExecutionException {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Uninterruptibles.getUninterruptibly(future);
    }

    @CanIgnoreReturnValue
    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return (V) Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new ExecutionError((Error) cause);
            }
            throw new UncheckedExecutionException(cause);
        }
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new u.a();
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        Preconditions.checkNotNull(th);
        return new u.b(th);
    }

    public static <V> ListenableFuture<V> immediateFuture(@NullableDecl V v) {
        if (v == null) {
            return u.c.c;
        }
        return new u.c(v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.Collection] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.Beta
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<T>> inCompletionOrder(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0007
            java.util.Collection r6 = (java.util.Collection) r6
            goto L_0x000b
        L_0x0007:
            com.google.common.collect.ImmutableList r6 = com.google.common.collect.ImmutableList.copyOf(r6)
        L_0x000b:
            int r0 = r6.size()
            com.google.common.util.concurrent.ListenableFuture[] r0 = new com.google.common.util.concurrent.ListenableFuture[r0]
            java.lang.Object[] r6 = r6.toArray(r0)
            com.google.common.util.concurrent.ListenableFuture[] r6 = (com.google.common.util.concurrent.ListenableFuture[]) r6
            com.google.common.util.concurrent.Futures$f r0 = new com.google.common.util.concurrent.Futures$f
            r1 = 0
            r0.<init>(r6, r1)
            com.google.common.collect.ImmutableList$Builder r2 = com.google.common.collect.ImmutableList.builder()
            r3 = 0
            r4 = 0
        L_0x0023:
            int r5 = r6.length
            if (r4 >= r5) goto L_0x0031
            com.google.common.util.concurrent.Futures$e r5 = new com.google.common.util.concurrent.Futures$e
            r5.<init>(r0, r1)
            r2.add(r5)
            int r4 = r4 + 1
            goto L_0x0023
        L_0x0031:
            com.google.common.collect.ImmutableList r1 = r2.build()
        L_0x0035:
            int r2 = r6.length
            if (r3 >= r2) goto L_0x0049
            r2 = r6[r3]
            com.google.common.util.concurrent.Futures$c r4 = new com.google.common.util.concurrent.Futures$c
            r4.<init>(r0, r1, r3)
            java.util.concurrent.Executor r5 = com.google.common.util.concurrent.MoreExecutors.directExecutor()
            r2.addListener(r4, r5)
            int r3 = r3 + 1
            goto L_0x0035
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Futures.inCompletionOrder(java.lang.Iterable):com.google.common.collect.ImmutableList");
    }

    @Beta
    @GwtIncompatible
    public static <I, O> Future<O> lazyTransform(Future<I> future, Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new b(future, function);
    }

    @Beta
    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        g gVar = new g(listenableFuture);
        listenableFuture.addListener(gVar, MoreExecutors.directExecutor());
        return gVar;
    }

    @Beta
    @GwtIncompatible
    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        g0 g0Var = new g0(asyncCallable);
        g0Var.addListener(new a(scheduledExecutorService.schedule(g0Var, j, timeUnit)), MoreExecutors.directExecutor());
        return g0Var;
    }

    @Beta
    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        g0 g0Var = new g0(asyncCallable);
        executor.execute(g0Var);
        return g0Var;
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new l.b(ImmutableList.copyOf(listenableFutureArr), false);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        int i = a2.j.d.l.a.e.j;
        Preconditions.checkNotNull(function);
        e.b bVar = new e.b(listenableFuture, function);
        listenableFuture.addListener(bVar, MoreExecutors.d(executor, bVar));
        return bVar;
    }

    @Beta
    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        int i = a2.j.d.l.a.e.j;
        Preconditions.checkNotNull(executor);
        e.a aVar = new e.a(listenableFuture, asyncFunction);
        listenableFuture.addListener(aVar, MoreExecutors.d(executor, aVar));
        return aVar;
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(listenableFutureArr), null);
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(listenableFutureArr), null);
    }

    @Beta
    @GwtIncompatible
    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        f0 f0Var = new f0(listenableFuture);
        f0.b bVar = new f0.b(f0Var);
        f0Var.i = scheduledExecutorService.schedule(bVar, j, timeUnit);
        listenableFuture.addListener(bVar, MoreExecutors.directExecutor());
        return f0Var;
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new l.b(ImmutableList.copyOf(iterable), true);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new l.b(ImmutableList.copyOf(iterable), false);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(iterable), null);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(iterable), null);
    }

    public static class b implements Future<O> {
        public final /* synthetic */ Future a;
        public final /* synthetic */ Function b;

        public b(Future future, Function function) {
            this.a = future;
            this.b = function;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.a.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public O get() throws InterruptedException, ExecutionException {
            try {
                return (O) this.b.apply(this.a.get());
            } catch (Throwable th) {
                throw new ExecutionException(th);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.a.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.a.isDone();
        }

        @Override // java.util.concurrent.Future
        public O get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            try {
                return (O) this.b.apply(this.a.get(j, timeUnit));
            } catch (Throwable th) {
                throw new ExecutionException(th);
            }
        }
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) throws Exception {
        Ordering<Constructor<?>> ordering = r.a;
        r.c.b.a(cls);
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw r.a(cls, e2);
        } catch (TimeoutException e3) {
            throw r.a(cls, e3);
        } catch (ExecutionException e4) {
            r.b(e4.getCause(), cls);
            throw null;
        }
    }
}
