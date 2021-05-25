package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import com.avito.android.geo.GeoPositionModelKt;
import java.util.Collections;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {
    public static final String j = Logger.tagWithPrefix("DelayMetCommandHandler");
    public final Context a;
    public final int b;
    public final String c;
    public final SystemAlarmDispatcher d;
    public final WorkConstraintsTracker e;
    public final Object f = new Object();
    public int g = 0;
    @Nullable
    public PowerManager.WakeLock h;
    public boolean i = false;

    public DelayMetCommandHandler(@NonNull Context context, int i2, @NonNull String str, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.a = context;
        this.b = i2;
        this.d = systemAlarmDispatcher;
        this.c = str;
        this.e = new WorkConstraintsTracker(context, systemAlarmDispatcher.b, this);
    }

    public final void a() {
        synchronized (this.f) {
            this.e.reset();
            this.d.c.stopTimer(this.c);
            PowerManager.WakeLock wakeLock = this.h;
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.get().debug(j, String.format("Releasing wakelock %s for WorkSpec %s", this.h, this.c), new Throwable[0]);
                this.h.release();
            }
        }
    }

    @WorkerThread
    public void b() {
        this.h = WakeLocks.newWakeLock(this.a, String.format("%s (%s)", this.c, Integer.valueOf(this.b)));
        Logger logger = Logger.get();
        String str = j;
        logger.debug(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.h, this.c), new Throwable[0]);
        this.h.acquire();
        WorkSpec workSpec = this.d.e.getWorkDatabase().workSpecDao().getWorkSpec(this.c);
        if (workSpec == null) {
            c();
            return;
        }
        boolean hasConstraints = workSpec.hasConstraints();
        this.i = hasConstraints;
        if (!hasConstraints) {
            Logger.get().debug(str, String.format("No constraints for %s", this.c), new Throwable[0]);
            onAllConstraintsMet(Collections.singletonList(this.c));
            return;
        }
        this.e.replace(Collections.singletonList(workSpec));
    }

    public final void c() {
        synchronized (this.f) {
            if (this.g < 2) {
                this.g = 2;
                Logger logger = Logger.get();
                String str = j;
                logger.debug(str, String.format("Stopping work for WorkSpec %s", this.c), new Throwable[0]);
                Context context = this.a;
                String str2 = this.c;
                String str3 = CommandHandler.d;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str2);
                SystemAlarmDispatcher systemAlarmDispatcher = this.d;
                systemAlarmDispatcher.g.post(new SystemAlarmDispatcher.b(systemAlarmDispatcher, intent, this.b));
                if (this.d.d.isEnqueued(this.c)) {
                    Logger.get().debug(str, String.format("WorkSpec %s needs to be rescheduled", this.c), new Throwable[0]);
                    Intent c2 = CommandHandler.c(this.a, this.c);
                    SystemAlarmDispatcher systemAlarmDispatcher2 = this.d;
                    systemAlarmDispatcher2.g.post(new SystemAlarmDispatcher.b(systemAlarmDispatcher2, c2, this.b));
                } else {
                    Logger.get().debug(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.c), new Throwable[0]);
                }
            } else {
                Logger.get().debug(j, String.format("Already stopped work for %s", this.c), new Throwable[0]);
            }
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<String> list) {
        if (list.contains(this.c)) {
            synchronized (this.f) {
                if (this.g == 0) {
                    this.g = 1;
                    Logger.get().debug(j, String.format("onAllConstraintsMet for %s", this.c), new Throwable[0]);
                    if (this.d.d.startWork(this.c)) {
                        this.d.c.startTimer(this.c, GeoPositionModelKt.MIN_GEO_REPORT_TIMEOUT, this);
                    } else {
                        a();
                    }
                } else {
                    Logger.get().debug(j, String.format("Already started work for %s", this.c), new Throwable[0]);
                }
            }
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        c();
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String str, boolean z) {
        Logger.get().debug(j, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        a();
        if (z) {
            Intent c2 = CommandHandler.c(this.a, this.c);
            SystemAlarmDispatcher systemAlarmDispatcher = this.d;
            systemAlarmDispatcher.g.post(new SystemAlarmDispatcher.b(systemAlarmDispatcher, c2, this.b));
        }
        if (this.i) {
            Intent a3 = CommandHandler.a(this.a);
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.d;
            systemAlarmDispatcher2.g.post(new SystemAlarmDispatcher.b(systemAlarmDispatcher2, a3, this.b));
        }
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public void onTimeLimitExceeded(@NonNull String str) {
        Logger.get().debug(j, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        c();
    }
}
