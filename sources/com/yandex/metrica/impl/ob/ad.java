package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
@TargetApi(14)
public class ad implements Application.ActivityLifecycleCallbacks {
    private final bj a;
    @NonNull
    private final act b;

    public ad(bj bjVar, @NonNull act act) {
        this.a = bjVar;
        this.b = act;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(final Activity activity) {
        this.b.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.ad.2
            @Override // java.lang.Runnable
            public void run() {
                ad.this.a.c(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        this.b.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.ad.1
            @Override // java.lang.Runnable
            public void run() {
                ad.this.a.b(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
