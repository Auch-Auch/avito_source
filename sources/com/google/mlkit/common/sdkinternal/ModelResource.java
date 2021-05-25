package com.google.mlkit.common.sdkinternal;

import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.ModelResource;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
@KeepForSdk
public abstract class ModelResource {
    public final AtomicInteger a = new AtomicInteger(0);
    public final AtomicBoolean b = new AtomicBoolean(false);
    @KeepForSdk
    public final TaskQueue taskQueue = new TaskQueue();

    @KeepForSdk
    public <T> Task<T> callAfterLoad(Executor executor, Callable<T> callable, CancellationToken cancellationToken) {
        Preconditions.checkState(this.a.get() > 0);
        if (cancellationToken.isCancellationRequested()) {
            return Tasks.forCanceled();
        }
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.taskQueue.submit(new Executor(executor, cancellationToken, cancellationTokenSource, taskCompletionSource) { // from class: a2.j.h.a.c.m
            public final Executor a;
            public final CancellationToken b;
            public final CancellationTokenSource c;
            public final TaskCompletionSource d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                Executor executor2 = this.a;
                CancellationToken cancellationToken2 = this.b;
                CancellationTokenSource cancellationTokenSource2 = this.c;
                TaskCompletionSource taskCompletionSource2 = this.d;
                try {
                    executor2.execute(runnable);
                } catch (RuntimeException e) {
                    if (cancellationToken2.isCancellationRequested()) {
                        cancellationTokenSource2.cancel();
                    } else {
                        taskCompletionSource2.setException(e);
                    }
                    throw e;
                }
            }
        }, new Runnable(this, cancellationToken, cancellationTokenSource, callable, taskCompletionSource) { // from class: a2.j.h.a.c.l
            public final ModelResource a;
            public final CancellationToken b;
            public final CancellationTokenSource c;
            public final Callable d;
            public final TaskCompletionSource e;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ModelResource modelResource = this.a;
                CancellationToken cancellationToken2 = this.b;
                CancellationTokenSource cancellationTokenSource2 = this.c;
                Callable callable2 = this.d;
                TaskCompletionSource taskCompletionSource2 = this.e;
                Objects.requireNonNull(modelResource);
                if (cancellationToken2.isCancellationRequested()) {
                    cancellationTokenSource2.cancel();
                    return;
                }
                try {
                    if (!modelResource.b.get()) {
                        modelResource.load();
                        modelResource.b.set(true);
                    }
                    if (cancellationToken2.isCancellationRequested()) {
                        cancellationTokenSource2.cancel();
                        return;
                    }
                    Object call = callable2.call();
                    if (cancellationToken2.isCancellationRequested()) {
                        cancellationTokenSource2.cancel();
                    } else {
                        taskCompletionSource2.setResult(call);
                    }
                } catch (RuntimeException e2) {
                    throw new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e2);
                } catch (Exception e3) {
                    if (cancellationToken2.isCancellationRequested()) {
                        cancellationTokenSource2.cancel();
                    } else {
                        taskCompletionSource2.setException(e3);
                    }
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    @KeepForSdk
    public boolean isLoaded() {
        return this.b.get();
    }

    @VisibleForTesting
    @KeepForSdk
    @WorkerThread
    public abstract void load() throws MlKitException;

    @KeepForSdk
    public void pin() {
        this.a.incrementAndGet();
    }

    @KeepForSdk
    @WorkerThread
    public abstract void release();

    @KeepForSdk
    public void unpin(Executor executor) {
        Preconditions.checkState(this.a.get() > 0);
        this.taskQueue.submit(executor, new Runnable(this) { // from class: a2.j.h.a.c.k
            public final ModelResource a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ModelResource modelResource = this.a;
                int decrementAndGet = modelResource.a.decrementAndGet();
                Preconditions.checkState(decrementAndGet >= 0);
                if (decrementAndGet == 0) {
                    modelResource.release();
                    modelResource.b.set(false);
                }
            }
        });
    }
}
