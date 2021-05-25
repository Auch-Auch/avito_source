package com.google.mlkit.common.sdkinternal;

import a2.j.h.a.c.f;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzao;
import com.google.android.gms.internal.mlkit_common.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
@KeepForSdk
public class MLTaskExecutor {
    public static final Object b = new Object();
    @GuardedBy("lock")
    public static MLTaskExecutor c;
    public Handler a;

    public enum a implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public final void execute(@NonNull Runnable runnable) {
            MLTaskExecutor.getInstance().a.post(runnable);
        }
    }

    public MLTaskExecutor(Looper looper) {
        this.a = new zzb(looper);
    }

    @KeepForSdk
    public static MLTaskExecutor getInstance() {
        MLTaskExecutor mLTaskExecutor;
        synchronized (b) {
            if (c == null) {
                HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                handlerThread.start();
                c = new MLTaskExecutor(handlerThread.getLooper());
            }
            mLTaskExecutor = c;
        }
        return mLTaskExecutor;
    }

    @KeepForSdk
    public static Executor workerThreadExecutor() {
        return a.INSTANCE;
    }

    @KeepForSdk
    public Handler getHandler() {
        return this.a;
    }

    @KeepForSdk
    public <ResultT> Task<ResultT> scheduleCallable(Callable<ResultT> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        scheduleRunnable(new Runnable(callable, taskCompletionSource) { // from class: a2.j.h.a.c.g
            public final Callable a;
            public final TaskCompletionSource b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Callable callable2 = this.a;
                TaskCompletionSource taskCompletionSource2 = this.b;
                Object obj = MLTaskExecutor.b;
                try {
                    taskCompletionSource2.setResult(callable2.call());
                } catch (MlKitException e) {
                    taskCompletionSource2.setException(e);
                } catch (Exception e2) {
                    taskCompletionSource2.setException(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e2));
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    @KeepForSdk
    public void scheduleRunnable(Runnable runnable) {
        workerThreadExecutor().execute(runnable);
    }

    @KeepForSdk
    public void scheduleRunnableDelayed(Runnable runnable, long j) {
        this.a.postDelayed(runnable, j);
    }

    /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: com.google.android.gms.tasks.Task<TContinuationResult>, com.google.android.gms.tasks.Task<ResultT> */
    @KeepForSdk
    public <ResultT> Task<ResultT> scheduleTaskCallable(Callable<Task<ResultT>> callable) {
        return (Task<TContinuationResult>) scheduleCallable(callable).continueWithTask(zzao.zza(), f.a);
    }
}
