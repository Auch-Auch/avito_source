package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@GwtCompatible
@CanIgnoreReturnValue
public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {

    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {
        public final Future<V> a;

        public SimpleForwardingFuture(Future<V> future) {
            this.a = (Future) Preconditions.checkNotNull(future);
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public final Future<V> mo147delegate() {
            return this.a;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return mo147delegate().cancel(z);
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Future<? extends V> mo147delegate();

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return (V) mo147delegate().get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return mo147delegate().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return mo147delegate().isDone();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) mo147delegate().get(j, timeUnit);
    }
}
