package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
@GwtCompatible
@CanIgnoreReturnValue
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        mo147delegate().addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract ListenableFuture<? extends V> mo147delegate();

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        public final ListenableFuture<V> a;

        public SimpleForwardingListenableFuture(ListenableFuture<V> listenableFuture) {
            this.a = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        }

        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public final ListenableFuture<V> mo147delegate() {
            return this.a;
        }
    }
}
