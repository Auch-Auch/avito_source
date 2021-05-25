package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    public static final String k = Logger.tagWithPrefix("ConstraintTrkngWrkr");
    public WorkerParameters f;
    public final Object g = new Object();
    public volatile boolean h = false;
    public SettableFuture<ListenableWorker.Result> i = SettableFuture.create();
    @Nullable
    public ListenableWorker j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
            String string = constraintTrackingWorker.getInputData().getString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME);
            if (TextUtils.isEmpty(string)) {
                Logger.get().error(ConstraintTrackingWorker.k, "No worker to delegate to.", new Throwable[0]);
                constraintTrackingWorker.a();
                return;
            }
            ListenableWorker createWorkerWithDefaultFallback = constraintTrackingWorker.getWorkerFactory().createWorkerWithDefaultFallback(constraintTrackingWorker.getApplicationContext(), string, constraintTrackingWorker.f);
            constraintTrackingWorker.j = createWorkerWithDefaultFallback;
            if (createWorkerWithDefaultFallback == null) {
                Logger.get().debug(ConstraintTrackingWorker.k, "No worker to delegate to.", new Throwable[0]);
                constraintTrackingWorker.a();
                return;
            }
            WorkSpec workSpec = constraintTrackingWorker.getWorkDatabase().workSpecDao().getWorkSpec(constraintTrackingWorker.getId().toString());
            if (workSpec == null) {
                constraintTrackingWorker.a();
                return;
            }
            WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
            workConstraintsTracker.replace(Collections.singletonList(workSpec));
            if (workConstraintsTracker.areAllConstraintsMet(constraintTrackingWorker.getId().toString())) {
                Logger.get().debug(ConstraintTrackingWorker.k, String.format("Constraints met for delegate %s", string), new Throwable[0]);
                try {
                    ListenableFuture<ListenableWorker.Result> startWork = constraintTrackingWorker.j.startWork();
                    startWork.addListener(new l6.d0.a.g.a(constraintTrackingWorker, startWork), constraintTrackingWorker.getBackgroundExecutor());
                } catch (Throwable th) {
                    Logger logger = Logger.get();
                    String str = ConstraintTrackingWorker.k;
                    logger.debug(str, String.format("Delegated worker %s threw exception in startWork.", string), th);
                    synchronized (constraintTrackingWorker.g) {
                        if (constraintTrackingWorker.h) {
                            Logger.get().debug(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                            constraintTrackingWorker.b();
                        } else {
                            constraintTrackingWorker.a();
                        }
                    }
                }
            } else {
                Logger.get().debug(ConstraintTrackingWorker.k, String.format("Constraints not met for delegate %s. Requesting retry.", string), new Throwable[0]);
                constraintTrackingWorker.b();
            }
        }
    }

    public ConstraintTrackingWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f = workerParameters;
    }

    public void a() {
        this.i.set(ListenableWorker.Result.failure());
    }

    public void b() {
        this.i.set(ListenableWorker.Result.retry());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public ListenableWorker getDelegate() {
        return this.j;
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.getInstance(getApplicationContext()).getWorkTaskExecutor();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public WorkDatabase getWorkDatabase() {
        return WorkManagerImpl.getInstance(getApplicationContext()).getWorkDatabase();
    }

    @Override // androidx.work.ListenableWorker
    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.j;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<String> list) {
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        Logger.get().debug(k, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.g) {
            this.h = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.j;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new a());
        return this.i;
    }
}
