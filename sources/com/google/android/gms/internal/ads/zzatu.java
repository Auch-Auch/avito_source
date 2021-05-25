package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
public final class zzatu implements RewardItem {
    private final zzatj zzdvb;

    public zzatu(zzatj zzatj) {
        this.zzdvb = zzatj;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int getAmount() {
        zzatj zzatj = this.zzdvb;
        if (zzatj == null) {
            return 0;
        }
        try {
            return zzatj.getAmount();
        } catch (RemoteException e) {
            zzbbd.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String getType() {
        zzatj zzatj = this.zzdvb;
        if (zzatj == null) {
            return null;
        }
        try {
            return zzatj.getType();
        } catch (RemoteException e) {
            zzbbd.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
