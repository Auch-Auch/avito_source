package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzaxy;
public final class zzr extends zzc {
    public zzr(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzc, com.google.android.gms.internal.ads.zzaql
    public final void onCreate(Bundle bundle) {
        zzaxy.zzei("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzdnx = 3;
        this.zzaas.finish();
    }
}
