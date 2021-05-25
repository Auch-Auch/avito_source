package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
public final class zzeo implements zzer {
    private final /* synthetic */ Activity val$activity;

    public zzeo(zzej zzej, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzer
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.val$activity);
    }
}
