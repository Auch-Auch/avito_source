package com.otaliastudios.cameraview.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
public class WorkerHandler {
    public static final CameraLogger e = CameraLogger.create(WorkerHandler.class.getSimpleName());
    public static final ConcurrentHashMap<String, WeakReference<WorkerHandler>> f = new ConcurrentHashMap<>(4);
    public static WorkerHandler g;
    public String a;
    public HandlerThread b;
    public Handler c = new Handler(this.b.getLooper());
    public Executor d = new b();

    public class a extends HandlerThread {
        public a(WorkerHandler workerHandler, String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Object
        @NonNull
        public String toString() {
            return super.toString() + "[" + getThreadId() + "]";
        }
    }

    public class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            WorkerHandler.this.run(runnable);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ CountDownLatch a;

        public c(WorkerHandler workerHandler, CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.countDown();
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ TaskCompletionSource a;
        public final /* synthetic */ Callable b;

        public d(WorkerHandler workerHandler, TaskCompletionSource taskCompletionSource, Callable callable) {
            this.a = taskCompletionSource;
            this.b = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.trySetResult(this.b.call());
            } catch (Exception e) {
                this.a.trySetException(e);
            }
        }
    }

    public WorkerHandler(@NonNull String str) {
        this.a = str;
        a aVar = new a(this, str);
        this.b = aVar;
        aVar.setDaemon(true);
        this.b.start();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        post(new c(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    public static void destroyAll() {
        for (String str : f.keySet()) {
            WeakReference<WorkerHandler> weakReference = f.get(str);
            WorkerHandler workerHandler = weakReference.get();
            if (workerHandler != null) {
                workerHandler.destroy();
            }
            weakReference.clear();
        }
        f.clear();
    }

    public static void execute(@NonNull Runnable runnable) {
        get().post(runnable);
    }

    @NonNull
    public static WorkerHandler get(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<WorkerHandler>> concurrentHashMap = f;
        if (concurrentHashMap.containsKey(str)) {
            WorkerHandler workerHandler = concurrentHashMap.get(str).get();
            if (workerHandler == null) {
                e.w("get:", "Thread reference died. Removing.", str);
                concurrentHashMap.remove(str);
            } else if (!workerHandler.getThread().isAlive() || workerHandler.getThread().isInterrupted()) {
                workerHandler.destroy();
                e.w("get:", "Thread reference found, but not alive or interrupted.", "Removing.", str);
                concurrentHashMap.remove(str);
            } else {
                e.w("get:", "Reusing cached worker handler.", str);
                return workerHandler;
            }
        }
        e.i("get:", "Creating new handler.", str);
        WorkerHandler workerHandler2 = new WorkerHandler(str);
        concurrentHashMap.put(str, new WeakReference<>(workerHandler2));
        return workerHandler2;
    }

    public void destroy() {
        HandlerThread thread = getThread();
        if (thread.isAlive()) {
            thread.interrupt();
            thread.quit();
        }
        f.remove(this.a);
    }

    @NonNull
    public Executor getExecutor() {
        return this.d;
    }

    @NonNull
    public Handler getHandler() {
        return this.c;
    }

    @NonNull
    public Looper getLooper() {
        return this.b.getLooper();
    }

    @NonNull
    public HandlerThread getThread() {
        return this.b;
    }

    public void post(@NonNull Runnable runnable) {
        this.c.post(runnable);
    }

    public void remove(@NonNull Runnable runnable) {
        this.c.removeCallbacks(runnable);
    }

    public void run(@NonNull Runnable runnable) {
        if (Thread.currentThread() == getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public <T> Task<T> post(@NonNull Callable<T> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        post(new d(this, taskCompletionSource, callable));
        return taskCompletionSource.getTask();
    }

    public <T> Task<T> run(@NonNull Callable<T> callable) {
        if (Thread.currentThread() != getThread()) {
            return post(callable);
        }
        try {
            return Tasks.forResult(callable.call());
        } catch (Exception e2) {
            return Tasks.forException(e2);
        }
    }

    public void post(long j, @NonNull Runnable runnable) {
        this.c.postDelayed(runnable, j);
    }

    @NonNull
    public static WorkerHandler get() {
        WorkerHandler workerHandler = get("FallbackCameraThread");
        g = workerHandler;
        return workerHandler;
    }
}
