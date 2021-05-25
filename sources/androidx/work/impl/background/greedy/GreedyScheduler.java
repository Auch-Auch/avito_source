package androidx.work.impl.background.greedy;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    public static final String i = Logger.tagWithPrefix("GreedyScheduler");
    public final Context a;
    public final WorkManagerImpl b;
    public final WorkConstraintsTracker c;
    public final Set<WorkSpec> d = new HashSet();
    public DelayedWorkTracker e;
    public boolean f;
    public final Object g;
    public Boolean h;

    public GreedyScheduler(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkManagerImpl workManagerImpl) {
        this.a = context;
        this.b = workManagerImpl;
        this.c = new WorkConstraintsTracker(context, taskExecutor, this);
        this.e = new DelayedWorkTracker(this, configuration.getRunnableScheduler());
        this.g = new Object();
    }

    @Nullable
    public final String a() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, GreedyScheduler.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th) {
            Logger.get().debug(i, "Unable to check ActivityThread for processName", th);
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) this.a.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String str) {
        if (this.h == null) {
            this.h = Boolean.valueOf(TextUtils.equals(this.a.getPackageName(), a()));
        }
        if (!this.h.booleanValue()) {
            Logger.get().info(i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f) {
            this.b.getProcessor().addExecutionListener(this);
            this.f = true;
        }
        Logger.get().debug(i, String.format("Cancelling work ID %s", str), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.e;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.unschedule(str);
        }
        this.b.stopWork(str);
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<String> list) {
        for (String str : list) {
            Logger.get().debug(i, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.b.startWork(str);
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        for (String str : list) {
            Logger.get().debug(i, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.b.stopWork(str);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String str, boolean z) {
        synchronized (this.g) {
            Iterator<WorkSpec> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WorkSpec next = it.next();
                if (next.id.equals(str)) {
                    Logger.get().debug(i, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.d.remove(next);
                    this.c.replace(this.d);
                    break;
                }
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(@NonNull WorkSpec... workSpecArr) {
        if (this.h == null) {
            this.h = Boolean.valueOf(TextUtils.equals(this.a.getPackageName(), a()));
        }
        if (!this.h.booleanValue()) {
            Logger.get().info(i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f) {
            this.b.getProcessor().addExecutionListener(this);
            this.f = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            long calculateNextRunTime = workSpec.calculateNextRunTime();
            long currentTimeMillis = System.currentTimeMillis();
            if (workSpec.state == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < calculateNextRunTime) {
                    DelayedWorkTracker delayedWorkTracker = this.e;
                    if (delayedWorkTracker != null) {
                        delayedWorkTracker.schedule(workSpec);
                    }
                } else if (workSpec.hasConstraints()) {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 23 && workSpec.constraints.requiresDeviceIdle()) {
                        Logger.get().debug(i, String.format("Ignoring WorkSpec %s, Requires device idle.", workSpec), new Throwable[0]);
                    } else if (i2 < 24 || !workSpec.constraints.hasContentUriTriggers()) {
                        hashSet.add(workSpec);
                        hashSet2.add(workSpec.id);
                    } else {
                        Logger.get().debug(i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", workSpec), new Throwable[0]);
                    }
                } else {
                    Logger.get().debug(i, String.format("Starting work for %s", workSpec.id), new Throwable[0]);
                    this.b.startWork(workSpec.id);
                }
            }
        }
        synchronized (this.g) {
            if (!hashSet.isEmpty()) {
                Logger.get().debug(i, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.d.addAll(hashSet);
                this.c.replace(this.d);
            }
        }
    }

    @VisibleForTesting
    public void setDelayedWorkTracker(@NonNull DelayedWorkTracker delayedWorkTracker) {
        this.e = delayedWorkTracker;
    }

    @VisibleForTesting
    public GreedyScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull WorkConstraintsTracker workConstraintsTracker) {
        this.a = context;
        this.b = workManagerImpl;
        this.c = workConstraintsTracker;
        this.g = new Object();
    }
}
