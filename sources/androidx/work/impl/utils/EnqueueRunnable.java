package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EnqueueRunnable implements Runnable {
    public static final String c = Logger.tagWithPrefix("EnqueueRunnable");
    public final WorkContinuationImpl a;
    public final OperationImpl b = new OperationImpl();

    public EnqueueRunnable(@NonNull WorkContinuationImpl workContinuationImpl) {
        this.a = workContinuationImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v15, types: [java.util.List] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x026d A[LOOP:9: B:138:0x0267->B:140:0x026d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0296 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c0  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(@androidx.annotation.NonNull androidx.work.impl.WorkContinuationImpl r20) {
        /*
        // Method dump skipped, instructions count: 674
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.a(androidx.work.impl.WorkContinuationImpl):boolean");
    }

    public static void b(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            String str = workSpec.workerClassName;
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input).putString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME, str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    @VisibleForTesting
    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.a.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean a3 = a(this.a);
            workDatabase.setTransactionSuccessful();
            return a3;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public Operation getOperation() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!this.a.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.a.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.b.setState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.a));
        } catch (Throwable th) {
            this.b.setState(new Operation.State.FAILURE(th));
        }
    }

    @VisibleForTesting
    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.a.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
