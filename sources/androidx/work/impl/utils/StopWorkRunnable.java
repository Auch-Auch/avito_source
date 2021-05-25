package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StopWorkRunnable implements Runnable {
    public static final String d = Logger.tagWithPrefix("StopWorkRunnable");
    public final WorkManagerImpl a;
    public final String b;
    public final boolean c;

    public StopWorkRunnable(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str, boolean z) {
        this.a = workManagerImpl;
        this.b = str;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        WorkDatabase workDatabase = this.a.getWorkDatabase();
        Processor processor = this.a.getProcessor();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            boolean isEnqueuedInForeground = processor.isEnqueuedInForeground(this.b);
            if (this.c) {
                z = this.a.getProcessor().stopForegroundWork(this.b);
            } else {
                if (!isEnqueuedInForeground && workSpecDao.getState(this.b) == WorkInfo.State.RUNNING) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, this.b);
                }
                z = this.a.getProcessor().stopWork(this.b);
            }
            Logger.get().debug(d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.b, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
