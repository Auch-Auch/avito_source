package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@TargetApi(14)
public final class mu implements ms {
    private static final Object a = new Object();
    private static volatile mu b;
    private final Object c = new Object();
    private boolean d;
    private final Map<mv, Void> e = new WeakHashMap();
    private final Application.ActivityLifecycleCallbacks f = new Application.ActivityLifecycleCallbacks() { // from class: com.yandex.mobile.ads.impl.mu.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            synchronized (mu.this.c) {
                Iterator it = new HashSet(mu.this.e.keySet()).iterator();
                while (it.hasNext()) {
                    ((mv) it.next()).b(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            synchronized (mu.this.c) {
                Iterator it = new HashSet(mu.this.e.keySet()).iterator();
                while (it.hasNext()) {
                    ((mv) it.next()).a(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            synchronized (mu.this.c) {
                if (mu.this.e.isEmpty()) {
                    mu.this.a(activity);
                }
            }
        }
    };

    @NonNull
    public static mu a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new mu();
                }
            }
        }
        return b;
    }

    private boolean b() {
        boolean z;
        synchronized (this.c) {
            z = this.d;
        }
        return z;
    }

    @Override // com.yandex.mobile.ads.impl.ms
    public final void b(@NonNull Context context, @NonNull mv mvVar) {
        synchronized (this.c) {
            this.e.remove(mvVar);
            if (this.e.isEmpty()) {
                a(context);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.ms
    public final void a(@NonNull Context context, @NonNull mv mvVar) {
        synchronized (this.c) {
            this.e.put(mvVar, null);
            if (!b()) {
                try {
                    ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.f);
                    this.d = true;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @VisibleForTesting
    public final void a(@NonNull Context context) {
        try {
            if (b()) {
                ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f);
                this.d = false;
            }
        } catch (Throwable unused) {
        }
    }
}
