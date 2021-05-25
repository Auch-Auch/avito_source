package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
public final class zzqx implements zzrb {
    private final /* synthetic */ Activity val$activity;

    public zzqx(zzqt zzqt, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzrb
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
