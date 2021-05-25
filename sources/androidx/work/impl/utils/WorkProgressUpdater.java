package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkProgressUpdater implements ProgressUpdater {
    public static final String c = Logger.tagWithPrefix("WorkProgressUpdater");
    public final WorkDatabase a;
    public final TaskExecutor b;

    public class a implements Runnable {
        public final /* synthetic */ UUID a;
        public final /* synthetic */ Data b;
        public final /* synthetic */ SettableFuture c;

        public a(UUID uuid, Data data, SettableFuture settableFuture) {
            this.a = uuid;
            this.b = data;
            this.c = settableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            String uuid = this.a.toString();
            Logger logger = Logger.get();
            String str = WorkProgressUpdater.c;
            logger.debug(str, String.format("Updating progress for %s (%s)", this.a, this.b), new Throwable[0]);
            WorkProgressUpdater.this.a.beginTransaction();
            try {
                WorkSpec workSpec = WorkProgressUpdater.this.a.workSpecDao().getWorkSpec(uuid);
                if (workSpec != null) {
                    if (workSpec.state == WorkInfo.State.RUNNING) {
                        WorkProgressUpdater.this.a.workProgressDao().insert(new WorkProgress(uuid, this.b));
                    } else {
                        Logger.get().warning(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", uuid), new Throwable[0]);
                    }
                    this.c.set(null);
                    WorkProgressUpdater.this.a.setTransactionSuccessful();
                    WorkProgressUpdater.this.a.endTransaction();
                    return;
                }
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            } catch (Throwable th) {
                WorkProgressUpdater.this.a.endTransaction();
                throw th;
            }
        }
    }

    public WorkProgressUpdater(@NonNull WorkDatabase workDatabase, @NonNull TaskExecutor taskExecutor) {
        this.a = workDatabase;
        this.b = taskExecutor;
    }

    @Override // androidx.work.ProgressUpdater
    @NonNull
    public ListenableFuture<Void> updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data) {
        SettableFuture create = SettableFuture.create();
        this.b.executeOnBackgroundThread(new a(uuid, data, create));
        return create;
    }
}
