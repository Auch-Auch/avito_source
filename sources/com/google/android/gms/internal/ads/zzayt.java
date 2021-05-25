package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
@TargetApi(19)
public class zzayt extends zzayq {
    @Override // com.google.android.gms.internal.ads.zzayq, com.google.android.gms.internal.ads.zzaym
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final ViewGroup.LayoutParams zzxt() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
