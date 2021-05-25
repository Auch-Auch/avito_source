package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.m;
public class n {
    @NonNull
    private final Context a;
    @NonNull
    private final j b;

    public n(@NonNull Context context) {
        this(context, new j());
    }

    @NonNull
    @TargetApi(28)
    private m b() {
        AnonymousClass1 r1 = new aca<ActivityManager, Boolean>() { // from class: com.yandex.metrica.impl.ob.n.1
            public Boolean a(@NonNull ActivityManager activityManager) throws Throwable {
                return Boolean.valueOf(activityManager.isBackgroundRestricted());
            }
        };
        return new m((m.a) dl.a(new aca<UsageStatsManager, m.a>() { // from class: com.yandex.metrica.impl.ob.n.2
            public m.a a(@NonNull UsageStatsManager usageStatsManager) {
                return n.this.b.a(usageStatsManager.getAppStandbyBucket());
            }
        }, (UsageStatsManager) this.a.getSystemService("usagestats"), "getting app standby bucket", "usageStatsManager"), (Boolean) dl.a(r1, (ActivityManager) this.a.getSystemService("activity"), "getting is background restricted", "activityManager"));
    }

    @VisibleForTesting
    public n(@NonNull Context context, @NonNull j jVar) {
        this.a = context;
        this.b = jVar;
    }

    @Nullable
    public m a() {
        if (dl.a(28)) {
            return b();
        }
        return null;
    }
}
