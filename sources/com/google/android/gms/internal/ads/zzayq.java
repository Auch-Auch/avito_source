package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
@TargetApi(18)
public class zzayq extends zzayr {
    @Override // com.google.android.gms.internal.ads.zzaym
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final int zzxs() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final long zzxw() {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcrg)).booleanValue()) {
            return -1;
        }
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
    }
}
