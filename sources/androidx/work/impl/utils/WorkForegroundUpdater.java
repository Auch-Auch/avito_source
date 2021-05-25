package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkForegroundUpdater implements ForegroundUpdater {
    public final TaskExecutor a;
    public final ForegroundProcessor b;
    public final WorkSpecDao c;

    public class a implements Runnable {
        public final /* synthetic */ SettableFuture a;
        public final /* synthetic */ UUID b;
        public final /* synthetic */ ForegroundInfo c;
        public final /* synthetic */ Context d;

        public a(SettableFuture settableFuture, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
            this.a = settableFuture;
            this.b = uuid;
            this.c = foregroundInfo;
            this.d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.a.isCancelled()) {
                    String uuid = this.b.toString();
                    WorkInfo.State state = WorkForegroundUpdater.this.c.getState(uuid);
                    if (state == null || state.isFinished()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    WorkForegroundUpdater.this.b.startForeground(uuid, this.c);
                    this.d.startService(SystemForegroundDispatcher.createNotifyIntent(this.d, uuid, this.c));
                }
                this.a.set(null);
            } catch (Throwable th) {
                this.a.setException(th);
            }
        }
    }

    public WorkForegroundUpdater(@NonNull WorkDatabase workDatabase, @NonNull ForegroundProcessor foregroundProcessor, @NonNull TaskExecutor taskExecutor) {
        this.b = foregroundProcessor;
        this.a = taskExecutor;
        this.c = workDatabase.workSpecDao();
    }

    @Override // androidx.work.ForegroundUpdater
    @NonNull
    public ListenableFuture<Void> setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo) {
        SettableFuture create = SettableFuture.create();
        this.a.executeOnBackgroundThread(new a(create, uuid, foregroundInfo, context));
        return create;
    }
}
