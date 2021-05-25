package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
public final class zzdkk extends AdMetadataListener {
    private final /* synthetic */ zzxz zzgzs;
    private final /* synthetic */ zzdkl zzgzt;

    public zzdkk(zzdkl zzdkl, zzxz zzxz) {
        this.zzgzt = zzdkl;
        this.zzgzs = zzxz;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.zzgzt.zzgzw != null) {
            try {
                this.zzgzs.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
