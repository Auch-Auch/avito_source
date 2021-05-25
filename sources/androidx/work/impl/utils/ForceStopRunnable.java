package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.List;
import java.util.concurrent.TimeUnit;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {
    public static final String c = Logger.tagWithPrefix("ForceStopRunnable");
    public static final long d = TimeUnit.DAYS.toMillis(3650);
    public final Context a;
    public final WorkManagerImpl b;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String a = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                Logger.get().verbose(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.b(context);
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this.a = context.getApplicationContext();
        this.b = workManagerImpl;
    }

    public static PendingIntent a(Context context, int i) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return PendingIntent.getBroadcast(context, -1, intent, i);
    }

    public static void b(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent a3 = a(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + d;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, a3);
        }
    }

    @VisibleForTesting
    public boolean cleanUp() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelInvalidJobs(this.a);
        }
        WorkDatabase workDatabase = this.b.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> runningWork = workSpecDao.getRunningWork();
            boolean z = runningWork != null && !runningWork.isEmpty();
            if (z) {
                for (WorkSpec workSpec : runningWork) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, workSpec.id);
                    workSpecDao.markWorkSpecScheduled(workSpec.id, -1);
                }
            }
            workProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
            return z;
        } finally {
            workDatabase.endTransaction();
        }
    }

    @VisibleForTesting
    public boolean isForceStopped() {
        if (a(this.a, 536870912) != null) {
            return false;
        }
        b(this.a);
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        WorkDatabasePathHelper.migrateDatabase(this.a);
        Logger logger = Logger.get();
        String str = c;
        logger.debug(str, "Performing cleanup operations.", new Throwable[0]);
        try {
            boolean cleanUp = cleanUp();
            if (this.b.getPreferenceUtils().getNeedsReschedule()) {
                Logger.get().debug(str, "Rescheduling Workers.", new Throwable[0]);
                this.b.rescheduleEligibleWork();
                this.b.getPreferenceUtils().setNeedsReschedule(false);
            } else if (isForceStopped()) {
                Logger.get().debug(str, "Application was force-stopped, rescheduling.", new Throwable[0]);
                this.b.rescheduleEligibleWork();
            } else if (cleanUp) {
                Logger.get().debug(str, "Found unfinished work, scheduling it.", new Throwable[0]);
                Schedulers.schedule(this.b.getConfiguration(), this.b.getWorkDatabase(), this.b.getSchedulers());
            }
            this.b.onForceStopRunnableCompleted();
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteDatabaseCorruptException e) {
            Logger.get().error(c, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
            throw new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
        }
    }
}
