package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
public final class zzeq implements zzer {
    private final /* synthetic */ Activity val$activity;

    public zzeq(zzej zzej, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzer
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.val$activity);
    }
}
