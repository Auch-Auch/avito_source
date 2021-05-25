package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.c {
    public static final String d = Logger.tagWithPrefix("SystemAlarmService");
    public SystemAlarmDispatcher b;
    public boolean c;

    @MainThread
    public final void a() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.b = systemAlarmDispatcher;
        if (systemAlarmDispatcher.j != null) {
            Logger.get().error(SystemAlarmDispatcher.k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            systemAlarmDispatcher.j = this;
        }
    }

    @Override // androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.c
    @MainThread
    public void onAllCommandsCompleted() {
        this.c = true;
        Logger.get().debug(d, "All commands completed in dispatcher", new Throwable[0]);
        WakeLocks.checkWakeLocks();
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
        this.c = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.c = true;
        this.b.b();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.c) {
            Logger.get().info(d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.b.b();
            a();
            this.c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.b.add(intent, i2);
        return 3;
    }
}
