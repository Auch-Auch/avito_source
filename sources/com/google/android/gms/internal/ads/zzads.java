package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzads implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzaes zzdcv;

    public zzads(zzaes zzaes) {
        this.zzdcv = zzaes;
        try {
            zzaes.zzso();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zzdcv.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zzdcv.zzsn();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            return false;
        }
    }
}
