package com.yandex.metrica.impl.ob;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.yandex.metrica.ConfigurationService;
public class ke implements kd, kg {
    @NonNull
    private final Context a;
    @Nullable
    private final AlarmManager b;
    @NonNull
    private abt c;

    public ke(@NonNull Context context) {
        this(context, (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM), new abs());
    }

    @NonNull
    private Intent b(@NonNull Context context) {
        return new Intent(context, ConfigurationService.class).setAction("com.yandex.metrica.configuration.ACTION_SCHEDULED_START");
    }

    @VisibleForTesting
    public ke(@NonNull Context context, @Nullable AlarmManager alarmManager, @NonNull abt abt) {
        this.a = context;
        this.b = alarmManager;
        this.c = abt;
    }

    @Override // com.yandex.metrica.impl.ob.kg
    public void a(final long j, boolean z) {
        dl.a(new abz<AlarmManager>() { // from class: com.yandex.metrica.impl.ob.ke.1
            public void a(@NonNull AlarmManager alarmManager) throws Throwable {
                ke keVar = ke.this;
                alarmManager.set(3, ke.this.c.c() + j, keVar.a(keVar.a));
            }
        }, this.b, "scheduling wakeup in [ConfigurationServiceController]", "AlarmManager");
    }

    @Override // com.yandex.metrica.impl.ob.kg
    public void a() {
        dl.a(new abz<AlarmManager>() { // from class: com.yandex.metrica.impl.ob.ke.2
            public void a(@NonNull AlarmManager alarmManager) throws Throwable {
                ke keVar = ke.this;
                alarmManager.cancel(keVar.a(keVar.a));
            }
        }, this.b, "cancelling scheduled wakeup in [ConfigurationServiceController]", "AlarmManager");
    }

    @Override // com.yandex.metrica.impl.ob.kd
    public void a(@NonNull Bundle bundle) {
        try {
            this.a.startService(new Intent().setComponent(new ComponentName(this.a.getPackageName(), ConfigurationService.class.getName())).setAction("com.yandex.metrica.configuration.ACTION_INIT").putExtras(bundle));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private PendingIntent a(@NonNull Context context) {
        return PendingIntent.getService(context, 7695435, b(context), 134217728);
    }
}
