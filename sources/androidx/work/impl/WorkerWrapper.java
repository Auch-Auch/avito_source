package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import l6.d0.a.b;
import l6.d0.a.c;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkerWrapper implements Runnable {
    public static final String t = Logger.tagWithPrefix("WorkerWrapper");
    public Context a;
    public String b;
    public List<Scheduler> c;
    public WorkerParameters.RuntimeExtras d;
    public WorkSpec e;
    public ListenableWorker f;
    @NonNull
    public ListenableWorker.Result g = ListenableWorker.Result.failure();
    public Configuration h;
    public TaskExecutor i;
    public ForegroundProcessor j;
    public WorkDatabase k;
    public WorkSpecDao l;
    public DependencyDao m;
    public WorkTagDao n;
    public List<String> o;
    public String p;
    @NonNull
    public SettableFuture<Boolean> q = SettableFuture.create();
    @Nullable
    public ListenableFuture<ListenableWorker.Result> r = null;
    public volatile boolean s;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class Builder {
        @NonNull
        public Context a;
        @Nullable
        public ListenableWorker b;
        @NonNull
        public ForegroundProcessor c;
        @NonNull
        public TaskExecutor d;
        @NonNull
        public Configuration e;
        @NonNull
        public WorkDatabase f;
        @NonNull
        public String g;
        public List<Scheduler> h;
        @NonNull
        public WorkerParameters.RuntimeExtras i = new WorkerParameters.RuntimeExtras();

        public Builder(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull ForegroundProcessor foregroundProcessor, @NonNull WorkDatabase workDatabase, @NonNull String str) {
            this.a = context.getApplicationContext();
            this.d = taskExecutor;
            this.c = foregroundProcessor;
            this.e = configuration;
            this.f = workDatabase;
            this.g = str;
        }

        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        @NonNull
        public Builder withRuntimeExtras(@Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.i = runtimeExtras;
            }
            return this;
        }

        @NonNull
        public Builder withSchedulers(@NonNull List<Scheduler> list) {
            this.h = list;
            return this;
        }

        @NonNull
        @VisibleForTesting
        public Builder withWorker(@NonNull ListenableWorker listenableWorker) {
            this.b = listenableWorker;
            return this;
        }
    }

    public WorkerWrapper(@NonNull Builder builder) {
        this.a = builder.a;
        this.i = builder.d;
        this.j = builder.c;
        this.b = builder.g;
        this.c = builder.h;
        this.d = builder.i;
        this.f = builder.b;
        this.h = builder.e;
        WorkDatabase workDatabase = builder.f;
        this.k = workDatabase;
        this.l = workDatabase.workSpecDao();
        this.m = this.k.dependencyDao();
        this.n = this.k.workTagDao();
    }

    public final void a(ListenableWorker.Result result) {
        boolean z = false;
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.get().info(t, String.format("Worker result SUCCESS for %s", this.p), new Throwable[0]);
            if (this.e.isPeriodic()) {
                e();
                return;
            }
            this.k.beginTransaction();
            try {
                this.l.setState(WorkInfo.State.SUCCEEDED, this.b);
                this.l.setOutput(this.b, ((ListenableWorker.Result.Success) this.g).getOutputData());
                long currentTimeMillis = System.currentTimeMillis();
                for (String str : this.m.getDependentWorkIds(this.b)) {
                    if (this.l.getState(str) == WorkInfo.State.BLOCKED && this.m.hasCompletedAllPrerequisites(str)) {
                        Logger.get().info(t, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                        this.l.setState(WorkInfo.State.ENQUEUED, str);
                        this.l.setPeriodStartTime(str, currentTimeMillis);
                    }
                }
                this.k.setTransactionSuccessful();
            } finally {
                this.k.endTransaction();
                f(z);
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(t, String.format("Worker result RETRY for %s", this.p), new Throwable[0]);
            d();
        } else {
            Logger.get().info(t, String.format("Worker result FAILURE for %s", this.p), new Throwable[0]);
            if (this.e.isPeriodic()) {
                e();
            } else {
                h();
            }
        }
    }

    public final void b(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.l.getState(str2) != WorkInfo.State.CANCELLED) {
                this.l.setState(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.m.getDependentWorkIds(str2));
        }
    }

    public void c() {
        if (!i()) {
            this.k.beginTransaction();
            try {
                WorkInfo.State state = this.l.getState(this.b);
                this.k.workProgressDao().delete(this.b);
                if (state == null) {
                    f(false);
                } else if (state == WorkInfo.State.RUNNING) {
                    a(this.g);
                } else if (!state.isFinished()) {
                    d();
                }
                this.k.setTransactionSuccessful();
            } finally {
                this.k.endTransaction();
            }
        }
        List<Scheduler> list = this.c;
        if (list != null) {
            for (Scheduler scheduler : list) {
                scheduler.cancel(this.b);
            }
            Schedulers.schedule(this.h, this.k, this.c);
        }
    }

    public final void d() {
        this.k.beginTransaction();
        boolean z = true;
        try {
            this.l.setState(WorkInfo.State.ENQUEUED, this.b);
            this.l.setPeriodStartTime(this.b, System.currentTimeMillis());
            this.l.markWorkSpecScheduled(this.b, -1);
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            f(z);
        }
    }

    public final void e() {
        this.k.beginTransaction();
        boolean z = false;
        try {
            this.l.setPeriodStartTime(this.b, System.currentTimeMillis());
            this.l.setState(WorkInfo.State.ENQUEUED, this.b);
            this.l.resetWorkSpecRunAttemptCount(this.b);
            this.l.markWorkSpecScheduled(this.b, -1);
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            f(z);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[Catch:{ all -> 0x0059 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(boolean r5) {
        /*
            r4 = this;
            androidx.work.impl.WorkDatabase r0 = r4.k
            r0.beginTransaction()
            androidx.work.impl.WorkDatabase r0 = r4.k     // Catch:{ all -> 0x0059 }
            androidx.work.impl.model.WorkSpecDao r0 = r0.workSpecDao()     // Catch:{ all -> 0x0059 }
            java.util.List r0 = r0.getAllUnfinishedWork()     // Catch:{ all -> 0x0059 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r0 = 0
            goto L_0x001c
        L_0x001b:
            r0 = 1
        L_0x001c:
            if (r0 == 0) goto L_0x0025
            android.content.Context r0 = r4.a     // Catch:{ all -> 0x0059 }
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r2 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            androidx.work.impl.utils.PackageManagerHelper.setComponentEnabled(r0, r2, r1)     // Catch:{ all -> 0x0059 }
        L_0x0025:
            if (r5 == 0) goto L_0x0030
            androidx.work.impl.model.WorkSpecDao r0 = r4.l     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r4.b     // Catch:{ all -> 0x0059 }
            r2 = -1
            r0.markWorkSpecScheduled(r1, r2)     // Catch:{ all -> 0x0059 }
        L_0x0030:
            androidx.work.impl.model.WorkSpec r0 = r4.e     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0045
            androidx.work.ListenableWorker r0 = r4.f     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0045
            boolean r0 = r0.isRunInForeground()     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0045
            androidx.work.impl.foreground.ForegroundProcessor r0 = r4.j     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r4.b     // Catch:{ all -> 0x0059 }
            r0.stopForeground(r1)     // Catch:{ all -> 0x0059 }
        L_0x0045:
            androidx.work.impl.WorkDatabase r0 = r4.k     // Catch:{ all -> 0x0059 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0059 }
            androidx.work.impl.WorkDatabase r0 = r4.k
            r0.endTransaction()
            androidx.work.impl.utils.futures.SettableFuture<java.lang.Boolean> r0 = r4.q
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r0.set(r5)
            return
        L_0x0059:
            r5 = move-exception
            androidx.work.impl.WorkDatabase r0 = r4.k
            r0.endTransaction()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.f(boolean):void");
    }

    public final void g() {
        WorkInfo.State state = this.l.getState(this.b);
        if (state == WorkInfo.State.RUNNING) {
            Logger.get().debug(t, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.b), new Throwable[0]);
            f(true);
            return;
        }
        Logger.get().debug(t, String.format("Status for %s is %s; not doing any work", this.b, state), new Throwable[0]);
        f(false);
    }

    @NonNull
    public ListenableFuture<Boolean> getFuture() {
        return this.q;
    }

    @VisibleForTesting
    public void h() {
        this.k.beginTransaction();
        boolean z = false;
        try {
            b(this.b);
            this.l.setOutput(this.b, ((ListenableWorker.Result.Failure) this.g).getOutputData());
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            f(z);
        }
    }

    public final boolean i() {
        if (!this.s) {
            return false;
        }
        Logger.get().debug(t, String.format("Work interrupted for %s", this.p), new Throwable[0]);
        WorkInfo.State state = this.l.getState(this.b);
        if (state == null) {
            f(false);
        } else {
            f(!state.isFinished());
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void interrupt() {
        boolean z;
        this.s = true;
        i();
        ListenableFuture<ListenableWorker.Result> listenableFuture = this.r;
        if (listenableFuture != null) {
            z = listenableFuture.isDone();
            this.r.cancel(true);
        } else {
            z = false;
        }
        ListenableWorker listenableWorker = this.f;
        if (listenableWorker == null || z) {
            Logger.get().debug(t, String.format("WorkSpec %s is already done. Not interrupting.", this.e), new Throwable[0]);
        } else {
            listenableWorker.stop();
        }
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public void run() {
        Data merge;
        boolean z;
        List<String> tagsForWorkSpecId = this.n.getTagsForWorkSpecId(this.b);
        this.o = tagsForWorkSpecId;
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.b);
        sb.append(", tags={ ");
        boolean z2 = true;
        for (String str : tagsForWorkSpecId) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        this.p = sb.toString();
        if (!i()) {
            this.k.beginTransaction();
            try {
                WorkSpec workSpec = this.l.getWorkSpec(this.b);
                this.e = workSpec;
                if (workSpec == null) {
                    Logger.get().error(t, String.format("Didn't find WorkSpec for id %s", this.b), new Throwable[0]);
                    f(false);
                } else {
                    WorkInfo.State state = workSpec.state;
                    WorkInfo.State state2 = WorkInfo.State.ENQUEUED;
                    if (state != state2) {
                        g();
                        this.k.setTransactionSuccessful();
                        Logger.get().debug(t, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.e.workerClassName), new Throwable[0]);
                    } else {
                        if (workSpec.isPeriodic() || this.e.isBackedOff()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            WorkSpec workSpec2 = this.e;
                            if (!(workSpec2.periodStartTime == 0) && currentTimeMillis < workSpec2.calculateNextRunTime()) {
                                Logger.get().debug(t, String.format("Delaying execution for %s because it is being executed before schedule.", this.e.workerClassName), new Throwable[0]);
                                f(true);
                            }
                        }
                        this.k.setTransactionSuccessful();
                        this.k.endTransaction();
                        if (this.e.isPeriodic()) {
                            merge = this.e.input;
                        } else {
                            InputMerger createInputMergerWithDefaultFallback = this.h.getInputMergerFactory().createInputMergerWithDefaultFallback(this.e.inputMergerClassName);
                            if (createInputMergerWithDefaultFallback == null) {
                                Logger.get().error(t, String.format("Could not create Input Merger %s", this.e.inputMergerClassName), new Throwable[0]);
                                h();
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(this.e.input);
                            arrayList.addAll(this.l.getInputsFromPrerequisites(this.b));
                            merge = createInputMergerWithDefaultFallback.merge(arrayList);
                        }
                        WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.b), merge, this.o, this.d, this.e.runAttemptCount, this.h.getExecutor(), this.i, this.h.getWorkerFactory(), new WorkProgressUpdater(this.k, this.i), new WorkForegroundUpdater(this.k, this.j, this.i));
                        if (this.f == null) {
                            this.f = this.h.getWorkerFactory().createWorkerWithDefaultFallback(this.a, this.e.workerClassName, workerParameters);
                        }
                        ListenableWorker listenableWorker = this.f;
                        if (listenableWorker == null) {
                            Logger.get().error(t, String.format("Could not create Worker %s", this.e.workerClassName), new Throwable[0]);
                            h();
                        } else if (listenableWorker.isUsed()) {
                            Logger.get().error(t, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.e.workerClassName), new Throwable[0]);
                            h();
                        } else {
                            this.f.setUsed();
                            this.k.beginTransaction();
                            try {
                                if (this.l.getState(this.b) == state2) {
                                    z = true;
                                    this.l.setState(WorkInfo.State.RUNNING, this.b);
                                    this.l.incrementWorkSpecRunAttemptCount(this.b);
                                } else {
                                    z = false;
                                }
                                this.k.setTransactionSuccessful();
                                if (!z) {
                                    g();
                                } else if (!i()) {
                                    SettableFuture create = SettableFuture.create();
                                    this.i.getMainThreadExecutor().execute(new b(this, create));
                                    create.addListener(new c(this, create, this.p), this.i.getBackgroundExecutor());
                                }
                            } finally {
                                this.k.endTransaction();
                            }
                        }
                    }
                }
            } finally {
                this.k.endTransaction();
            }
        }
    }
}
