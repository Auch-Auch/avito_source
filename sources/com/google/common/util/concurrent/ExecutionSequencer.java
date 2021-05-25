package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
@Beta
public final class ExecutionSequencer {
    public final AtomicReference<ListenableFuture<Object>> a = new AtomicReference<>(Futures.immediateFuture(null));

    public class a implements AsyncCallable<T> {
        public final /* synthetic */ Callable a;

        public a(ExecutionSequencer executionSequencer, Callable callable) {
            this.a = callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<T> call() throws Exception {
            return Futures.immediateFuture(this.a.call());
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public class b implements AsyncCallable<T> {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ AsyncCallable b;

        public b(ExecutionSequencer executionSequencer, AtomicReference atomicReference, AsyncCallable asyncCallable) {
            this.a = atomicReference;
            this.b = asyncCallable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<T> call() throws Exception {
            if (!this.a.compareAndSet(e.NOT_RUN, e.STARTED)) {
                return Futures.immediateCancelledFuture();
            }
            return this.b.call();
        }

        public String toString() {
            return this.b.toString();
        }
    }

    public class c implements Executor {
        public final /* synthetic */ ListenableFuture a;
        public final /* synthetic */ Executor b;

        public c(ExecutionSequencer executionSequencer, ListenableFuture listenableFuture, Executor executor) {
            this.a = listenableFuture;
            this.b = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.addListener(runnable, this.b);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ ListenableFuture a;
        public final /* synthetic */ ListenableFuture b;
        public final /* synthetic */ AtomicReference c;
        public final /* synthetic */ SettableFuture d;
        public final /* synthetic */ ListenableFuture e;

        public d(ExecutionSequencer executionSequencer, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, AtomicReference atomicReference, SettableFuture settableFuture, ListenableFuture listenableFuture3) {
            this.a = listenableFuture;
            this.b = listenableFuture2;
            this.c = atomicReference;
            this.d = settableFuture;
            this.e = listenableFuture3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.isDone() || (this.b.isCancelled() && this.c.compareAndSet(e.NOT_RUN, e.CANCELLED))) {
                this.d.setFuture(this.e);
            }
        }
    }

    public enum e {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        return submitAsync(new a(this, callable), executor);
    }

    public <T> ListenableFuture<T> submitAsync(AsyncCallable<T> asyncCallable, Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        AtomicReference atomicReference = new AtomicReference(e.NOT_RUN);
        b bVar = new b(this, atomicReference, asyncCallable);
        SettableFuture create = SettableFuture.create();
        ListenableFuture<Object> andSet = this.a.getAndSet(create);
        ListenableFuture submitAsync = Futures.submitAsync(bVar, new c(this, andSet, executor));
        ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(submitAsync);
        d dVar = new d(this, submitAsync, nonCancellationPropagating, atomicReference, create, andSet);
        nonCancellationPropagating.addListener(dVar, MoreExecutors.directExecutor());
        submitAsync.addListener(dVar, MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }
}
