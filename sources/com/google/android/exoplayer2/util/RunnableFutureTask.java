package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public abstract class RunnableFutureTask<R, E extends Exception> implements RunnableFuture<R> {
    public final ConditionVariable a = new ConditionVariable();
    public final ConditionVariable b = new ConditionVariable();
    public final Object c = new Object();
    @Nullable
    public Exception d;
    @Nullable
    public R e;
    @Nullable
    public Thread f;
    public boolean g;

    @UnknownNull
    public final R a() throws ExecutionException {
        if (this.g) {
            throw new CancellationException();
        } else if (this.d == null) {
            return this.e;
        } else {
            throw new ExecutionException(this.d);
        }
    }

    public final void blockUntilFinished() {
        this.b.blockUninterruptible();
    }

    public final void blockUntilStarted() {
        this.a.blockUninterruptible();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        synchronized (this.c) {
            if (!this.g) {
                if (!this.b.isOpen()) {
                    this.g = true;
                    cancelWork();
                    Thread thread = this.f;
                    if (thread == null) {
                        this.a.open();
                        this.b.open();
                    } else if (z) {
                        thread.interrupt();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void cancelWork() {
    }

    @UnknownNull
    public abstract R doWork() throws Exception;

    @Override // java.util.concurrent.Future
    @UnknownNull
    public final R get() throws ExecutionException, InterruptedException {
        this.b.block();
        return a();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.g;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b.isOpen();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        synchronized (this.c) {
            if (!this.g) {
                this.f = Thread.currentThread();
                this.a.open();
                try {
                    this.e = doWork();
                    synchronized (this.c) {
                        this.b.open();
                        this.f = null;
                        Thread.interrupted();
                    }
                } catch (Exception e2) {
                    try {
                        this.d = e2;
                        synchronized (this.c) {
                            this.b.open();
                            this.f = null;
                            Thread.interrupted();
                        }
                    } catch (Throwable th) {
                        synchronized (this.c) {
                            this.b.open();
                            this.f = null;
                            Thread.interrupted();
                            throw th;
                        }
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @UnknownNull
    public final R get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.b.block(TimeUnit.MILLISECONDS.convert(j, timeUnit))) {
            return a();
        }
        throw new TimeoutException();
    }
}
