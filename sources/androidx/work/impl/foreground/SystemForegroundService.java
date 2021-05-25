package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import java.util.Objects;
import java.util.UUID;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.a {
    public static final String f = Logger.tagWithPrefix("SystemFgService");
    @Nullable
    public static SystemForegroundService g = null;
    public Handler b;
    public boolean c;
    public SystemForegroundDispatcher d;
    public NotificationManager e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundService.this.d;
            Objects.requireNonNull(systemForegroundDispatcher);
            Logger.get().info(SystemForegroundDispatcher.l, "Stopping foreground service", new Throwable[0]);
            SystemForegroundDispatcher.a aVar = systemForegroundDispatcher.k;
            if (aVar != null) {
                ForegroundInfo foregroundInfo = systemForegroundDispatcher.f;
                if (foregroundInfo != null) {
                    aVar.cancelNotification(foregroundInfo.getNotificationId());
                    systemForegroundDispatcher.f = null;
                }
                systemForegroundDispatcher.k.stop();
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Notification b;
        public final /* synthetic */ int c;

        public b(int i, Notification notification, int i2) {
            this.a = i;
            this.b = notification;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.a, this.b, this.c);
            } else {
                SystemForegroundService.this.startForeground(this.a, this.b);
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Notification b;

        public c(int i, Notification notification) {
            this.a = i;
            this.b = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.e.notify(this.a, this.b);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.e.cancel(this.a);
        }
    }

    @Nullable
    public static SystemForegroundService getInstance() {
        return g;
    }

    @MainThread
    public final void a() {
        this.b = new Handler(Looper.getMainLooper());
        this.e = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.d = systemForegroundDispatcher;
        if (systemForegroundDispatcher.k != null) {
            Logger.get().error(SystemForegroundDispatcher.l, "A callback already exists.", new Throwable[0]);
        } else {
            systemForegroundDispatcher.k = this;
        }
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void cancelNotification(int i) {
        this.b.post(new d(i));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void notify(int i, @NonNull Notification notification) {
        this.b.post(new c(i, notification));
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        g = this;
        a();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.d.b();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.c) {
            Logger.get().info(f, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.d.b();
            a();
            this.c = false;
        }
        if (intent == null) {
            return 3;
        }
        SystemForegroundDispatcher systemForegroundDispatcher = this.d;
        Objects.requireNonNull(systemForegroundDispatcher);
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            Logger.get().info(SystemForegroundDispatcher.l, String.format("Started foreground service %s", intent), new Throwable[0]);
            systemForegroundDispatcher.c.executeOnBackgroundThread(new l6.d0.a.e.a(systemForegroundDispatcher, systemForegroundDispatcher.b.getWorkDatabase(), intent.getStringExtra("KEY_WORKSPEC_ID")));
            systemForegroundDispatcher.a(intent);
            return 3;
        } else if ("ACTION_NOTIFY".equals(action)) {
            systemForegroundDispatcher.a(intent);
            return 3;
        } else if (!"ACTION_CANCEL_WORK".equals(action)) {
            return 3;
        } else {
            Logger.get().info(SystemForegroundDispatcher.l, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
                return 3;
            }
            systemForegroundDispatcher.b.cancelWorkById(UUID.fromString(stringExtra));
            return 3;
        }
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void startForeground(int i, int i2, @NonNull Notification notification) {
        this.b.post(new b(i, notification, i2));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    @MainThread
    public void stop() {
        this.c = true;
        Logger.get().debug(f, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        g = null;
        stopSelf();
    }

    public void stopForegroundService() {
        this.b.post(new a());
    }
}
