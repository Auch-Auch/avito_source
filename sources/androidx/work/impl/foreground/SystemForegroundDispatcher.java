package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    public static final String l = Logger.tagWithPrefix("SystemFgDispatcher");
    public Context a;
    public WorkManagerImpl b;
    public final TaskExecutor c;
    public final Object d = new Object();
    public String e;
    public ForegroundInfo f;
    public final Map<String, ForegroundInfo> g;
    public final Map<String, WorkSpec> h;
    public final Set<WorkSpec> i;
    public final WorkConstraintsTracker j;
    @Nullable
    public a k;

    public interface a {
        void cancelNotification(int i);

        void notify(int i, @NonNull Notification notification);

        void startForeground(int i, int i2, @NonNull Notification notification);

        void stop();
    }

    public SystemForegroundDispatcher(@NonNull Context context) {
        this.a = context;
        WorkManagerImpl instance = WorkManagerImpl.getInstance(this.a);
        this.b = instance;
        TaskExecutor workTaskExecutor = instance.getWorkTaskExecutor();
        this.c = workTaskExecutor;
        this.e = null;
        this.f = null;
        this.g = new LinkedHashMap();
        this.i = new HashSet();
        this.h = new HashMap();
        this.j = new WorkConstraintsTracker(this.a, workTaskExecutor, this);
        this.b.getProcessor().addExecutionListener(this);
    }

    @NonNull
    public static Intent createCancelWorkIntent(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_CANCEL_WORK");
        intent.setData(Uri.parse(String.format("workspec://%s", str)));
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @NonNull
    public static Intent createNotifyIntent(@NonNull Context context, @NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.getNotificationId());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.getForegroundServiceType());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.getNotification());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @NonNull
    public static Intent createStartForegroundIntent(@NonNull Context context, @NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.getNotificationId());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.getForegroundServiceType());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.getNotification());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @MainThread
    public final void a(@NonNull Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger.get().debug(l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.k == null)) {
            this.g.put(stringExtra, new ForegroundInfo(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.e)) {
                this.e = stringExtra;
                this.k.startForeground(intExtra, intExtra2, notification);
                return;
            }
            this.k.notify(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, ForegroundInfo> entry : this.g.entrySet()) {
                    i2 |= entry.getValue().getForegroundServiceType();
                }
                ForegroundInfo foregroundInfo = this.g.get(this.e);
                if (foregroundInfo != null) {
                    this.k.startForeground(foregroundInfo.getNotificationId(), i2, foregroundInfo.getNotification());
                }
            }
        }
    }

    @MainThread
    public void b() {
        this.k = null;
        synchronized (this.d) {
            this.j.reset();
        }
        this.b.getProcessor().removeExecutionListener(this);
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<String> list) {
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                Logger.get().debug(l, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                this.b.stopForegroundWork(str);
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    @MainThread
    public void onExecuted(@NonNull String str, boolean z) {
        a aVar;
        Map.Entry<String, ForegroundInfo> entry;
        synchronized (this.d) {
            WorkSpec remove = this.h.remove(str);
            if (remove != null ? this.i.remove(remove) : false) {
                this.j.replace(this.i);
            }
        }
        this.f = this.g.remove(str);
        if (!str.equals(this.e)) {
            ForegroundInfo foregroundInfo = this.f;
            if (foregroundInfo != null && (aVar = this.k) != null) {
                aVar.cancelNotification(foregroundInfo.getNotificationId());
            }
        } else if (this.g.size() > 0) {
            Iterator<Map.Entry<String, ForegroundInfo>> it = this.g.entrySet().iterator();
            Map.Entry<String, ForegroundInfo> next = it.next();
            while (true) {
                entry = next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.e = entry.getKey();
            if (this.k != null) {
                ForegroundInfo value = entry.getValue();
                this.k.startForeground(value.getNotificationId(), value.getForegroundServiceType(), value.getNotification());
                this.k.cancelNotification(value.getNotificationId());
            }
        }
    }
}
