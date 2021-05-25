package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
public final class zzdkt extends AdMetadataListener {
    private final /* synthetic */ zzdkr zzgzx;
    private final /* synthetic */ zzxb zzgzy;

    public zzdkt(zzdkr zzdkr, zzxb zzxb) {
        this.zzgzx = zzdkr;
        this.zzgzy = zzxb;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.zzgzx.zzgzw != null) {
            try {
                this.zzgzy.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
