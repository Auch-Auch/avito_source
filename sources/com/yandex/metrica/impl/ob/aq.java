package com.yandex.metrica.impl.ob;

import android.app.ActivityManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
public class aq {
    private static final Long f = Long.valueOf(TimeUnit.SECONDS.toMillis(5));
    @NonNull
    private final Context a;
    @Nullable
    private final ActivityManager b;
    @NonNull
    private final act c;
    private volatile boolean d;
    private final Set<a> e;
    private final Runnable g;

    public interface a {
        void a(boolean z);
    }

    public aq(@NonNull Context context, @NonNull act act) {
        this(context, (ActivityManager) context.getSystemService("activity"), act);
    }

    private void c() {
        this.c.a(this.g, f.longValue());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        e();
        c();
    }

    private void e() {
        boolean g2 = g();
        if (this.d != g2) {
            this.d = g2;
            f();
        }
    }

    private void f() {
        for (a aVar : this.e) {
            aVar.a(this.d);
        }
    }

    private boolean g() {
        List<ActivityManager.RunningServiceInfo> list = (List) dl.a(new aca<ActivityManager, List<ActivityManager.RunningServiceInfo>>() { // from class: com.yandex.metrica.impl.ob.aq.2
            public List<ActivityManager.RunningServiceInfo> a(ActivityManager activityManager) throws Throwable {
                return activityManager.getRunningServices(Integer.MAX_VALUE);
            }
        }, this.b, "getRunningServices", "ActivityManager");
        if (list != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : list) {
                if (a(runningServiceInfo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b() {
        this.c.b(this.g);
    }

    public void a() {
        d();
    }

    public void b(@NonNull a aVar) {
        this.e.remove(aVar);
    }

    @VisibleForTesting
    public aq(@NonNull Context context, @Nullable ActivityManager activityManager, @NonNull act act) {
        this.e = new CopyOnWriteArraySet();
        this.g = new Runnable() { // from class: com.yandex.metrica.impl.ob.aq.1
            @Override // java.lang.Runnable
            public void run() {
                aq.this.d();
            }
        };
        this.a = context;
        this.b = activityManager;
        this.c = act;
    }

    public boolean a(@Nullable a aVar) {
        if (aVar != null) {
            this.e.add(aVar);
        }
        return this.d;
    }

    private boolean a(@NonNull ActivityManager.RunningServiceInfo runningServiceInfo) {
        return this.a.getPackageName().equals(runningServiceInfo.service.getPackageName()) && runningServiceInfo.foreground;
    }
}
