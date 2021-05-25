package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
@Beta
@GwtIncompatible
public final class JdkFutureAdapters {

    public static class a<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
        public static final ThreadFactory e;
        public static final Executor f;
        public final Executor a;
        public final ExecutionList b = new ExecutionList();
        public final AtomicBoolean c = new AtomicBoolean(false);
        public final Future<V> d;

        /* renamed from: com.google.common.util.concurrent.JdkFutureAdapters$a$a  reason: collision with other inner class name */
        public class RunnableC0300a implements Runnable {
            public RunnableC0300a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uninterruptibles.getUninterruptibly(a.this.d);
                } catch (Throwable unused) {
                }
                a.this.b.execute();
            }
        }

        static {
            ThreadFactory build = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            e = build;
            f = Executors.newCachedThreadPool(build);
        }

        public a(Future<V> future, Executor executor) {
            this.d = (Future) Preconditions.checkNotNull(future);
            this.a = (Executor) Preconditions.checkNotNull(executor);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            this.b.add(runnable, executor);
            if (!this.c.compareAndSet(false, true)) {
                return;
            }
            if (this.d.isDone()) {
                this.b.execute();
            } else {
                this.a.execute(new RunnableC0300a());
            }
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.d;
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Future<V> mo147delegate() {
            return this.d;
        }
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future) {
        if (future instanceof ListenableFuture) {
            return (ListenableFuture) future;
        }
        return new a(future, a.f);
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future, Executor executor) {
        Preconditions.checkNotNull(executor);
        if (future instanceof ListenableFuture) {
            return (ListenableFuture) future;
        }
        return new a(future, executor);
    }
}
