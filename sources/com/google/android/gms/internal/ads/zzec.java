package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
public final class zzec implements Runnable {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Context zzxp;
    private final /* synthetic */ View zzxq;
    private final /* synthetic */ String zzxt;

    public zzec(zzdy zzdy, Context context, String str, View view, Activity activity) {
        this.zzxp = context;
        this.zzxt = str;
        this.zzxq = view;
        this.val$activity = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzdy.zzxe.zza(this.zzxp, this.zzxt, this.zzxq, this.val$activity);
        } catch (Exception e) {
            zzdy.zzxg.zza(2021, -1, e);
        }
    }
}
