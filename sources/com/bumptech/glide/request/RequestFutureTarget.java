package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    public static final a k = new a();
    public final int a;
    public final int b;
    public final boolean c = true;
    public final a d;
    @Nullable
    @GuardedBy("this")
    public R e;
    @Nullable
    @GuardedBy("this")
    public Request f;
    @GuardedBy("this")
    public boolean g;
    @GuardedBy("this")
    public boolean h;
    @GuardedBy("this")
    public boolean i;
    @Nullable
    @GuardedBy("this")
    public GlideException j;

    @VisibleForTesting
    public static class a {
    }

    public RequestFutureTarget(int i2, int i3) {
        a aVar = k;
        this.a = i2;
        this.b = i3;
        this.d = aVar;
    }

    public final synchronized R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.c && !isDone()) {
            Util.assertBackgroundThread();
        }
        if (this.g) {
            throw new CancellationException();
        } else if (this.i) {
            throw new ExecutionException(this.j);
        } else if (this.h) {
            return this.e;
        } else {
            if (l == null) {
                Objects.requireNonNull(this.d);
                wait(0);
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    Objects.requireNonNull(this.d);
                    wait(longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.i) {
                throw new ExecutionException(this.j);
            } else if (this.g) {
                throw new CancellationException();
            } else if (this.h) {
                return this.e;
            } else {
                throw new TimeoutException();
            }
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Request request;
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.g = true;
            Objects.requireNonNull(this.d);
            notifyAll();
            request = null;
            if (z) {
                Request request2 = this.f;
                this.f = null;
                request = request2;
            }
        }
        if (request != null) {
            request.clear();
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public synchronized Request getRequest() {
        return this.f;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.a, this.b);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.g || this.h || this.i;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(@NonNull R r, @Nullable Transition<? super R> transition) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(@Nullable Request request) {
        this.f = request;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.i = true;
        this.j = glideException;
        Objects.requireNonNull(this.d);
        notifyAll();
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.h = true;
        this.e = r;
        Objects.requireNonNull(this.d);
        notifyAll();
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }
}
