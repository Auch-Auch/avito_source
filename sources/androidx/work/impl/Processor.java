package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ExecutionListener, ForegroundProcessor {
    public static final String l = Logger.tagWithPrefix("Processor");
    @Nullable
    public PowerManager.WakeLock a;
    public Context b;
    public Configuration c;
    public TaskExecutor d;
    public WorkDatabase e;
    public Map<String, WorkerWrapper> f = new HashMap();
    public Map<String, WorkerWrapper> g = new HashMap();
    public List<Scheduler> h;
    public Set<String> i;
    public final List<ExecutionListener> j;
    public final Object k;

    public static class a implements Runnable {
        @NonNull
        public ExecutionListener a;
        @NonNull
        public String b;
        @NonNull
        public ListenableFuture<Boolean> c;

        public a(@NonNull ExecutionListener executionListener, @NonNull String str, @NonNull ListenableFuture<Boolean> listenableFuture) {
            this.a = executionListener;
            this.b = str;
            this.c = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                z = this.c.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.a.onExecuted(this.b, z);
        }
    }

    public Processor(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list) {
        this.b = context;
        this.c = configuration;
        this.d = taskExecutor;
        this.e = workDatabase;
        this.h = list;
        this.i = new HashSet();
        this.j = new ArrayList();
        this.a = null;
        this.k = new Object();
    }

    public static boolean a(@NonNull String str, @Nullable WorkerWrapper workerWrapper) {
        if (workerWrapper != null) {
            workerWrapper.interrupt();
            Logger.get().debug(l, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        Logger.get().debug(l, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    public void addExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.k) {
            this.j.add(executionListener);
        }
    }

    public final void b() {
        synchronized (this.k) {
            if (!(!this.f.isEmpty())) {
                SystemForegroundService instance = SystemForegroundService.getInstance();
                if (instance != null) {
                    Logger.get().debug(l, "No more foreground work. Stopping SystemForegroundService", new Throwable[0]);
                    instance.stopForegroundService();
                } else {
                    Logger.get().debug(l, "No more foreground work. SystemForegroundService is already stopped", new Throwable[0]);
                }
                PowerManager.WakeLock wakeLock = this.a;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.a = null;
                }
            }
        }
    }

    public boolean hasWork() {
        boolean z;
        synchronized (this.k) {
            if (this.g.isEmpty()) {
                if (this.f.isEmpty()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isCancelled(@NonNull String str) {
        boolean contains;
        synchronized (this.k) {
            contains = this.i.contains(str);
        }
        return contains;
    }

    public boolean isEnqueued(@NonNull String str) {
        boolean z;
        synchronized (this.k) {
            if (!this.g.containsKey(str)) {
                if (!this.f.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isEnqueuedInForeground(@NonNull String str) {
        boolean containsKey;
        synchronized (this.k) {
            containsKey = this.f.containsKey(str);
        }
        return containsKey;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String str, boolean z) {
        synchronized (this.k) {
            this.g.remove(str);
            Logger.get().debug(l, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            for (ExecutionListener executionListener : this.j) {
                executionListener.onExecuted(str, z);
            }
        }
    }

    public void removeExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.k) {
            this.j.remove(executionListener);
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(@NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        synchronized (this.k) {
            Logger.get().info(l, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            WorkerWrapper remove = this.g.remove(str);
            if (remove != null) {
                if (this.a == null) {
                    PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.b, "ProcessorForegroundLck");
                    this.a = newWakeLock;
                    newWakeLock.acquire();
                }
                this.f.put(str, remove);
                ContextCompat.startForegroundService(this.b, SystemForegroundDispatcher.createStartForegroundIntent(this.b, str, foregroundInfo));
            }
        }
    }

    public boolean startWork(@NonNull String str) {
        return startWork(str, null);
    }

    public boolean stopAndCancelWork(@NonNull String str) {
        boolean a3;
        synchronized (this.k) {
            boolean z = true;
            Logger.get().debug(l, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.i.add(str);
            WorkerWrapper remove = this.f.remove(str);
            if (remove == null) {
                z = false;
            }
            if (remove == null) {
                remove = this.g.remove(str);
            }
            a3 = a(str, remove);
            if (z) {
                b();
            }
        }
        return a3;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void stopForeground(@NonNull String str) {
        synchronized (this.k) {
            this.f.remove(str);
            b();
        }
    }

    public boolean stopForegroundWork(@NonNull String str) {
        boolean a3;
        synchronized (this.k) {
            Logger.get().debug(l, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            a3 = a(str, this.f.remove(str));
        }
        return a3;
    }

    public boolean stopWork(@NonNull String str) {
        boolean a3;
        synchronized (this.k) {
            Logger.get().debug(l, String.format("Processor stopping background work %s", str), new Throwable[0]);
            a3 = a(str, this.g.remove(str));
        }
        return a3;
    }

    public boolean startWork(@NonNull String str, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.k) {
            if (isEnqueued(str)) {
                Logger.get().debug(l, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            WorkerWrapper build = new WorkerWrapper.Builder(this.b, this.c, this.d, this, this.e, str).withSchedulers(this.h).withRuntimeExtras(runtimeExtras).build();
            ListenableFuture<Boolean> future = build.getFuture();
            future.addListener(new a(this, str, future), this.d.getMainThreadExecutor());
            this.g.put(str, build);
            this.d.getBackgroundExecutor().execute(build);
            Logger.get().debug(l, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }
}
