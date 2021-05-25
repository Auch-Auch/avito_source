package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;
public final class zzavh extends zzauj {
    private final String type;
    private final int zzdva;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzavh(@Nullable zzaue zzaue) {
        this(zzaue != null ? zzaue.type : "", zzaue != null ? zzaue.zzdva : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final int getAmount() throws RemoteException {
        return this.zzdva;
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final String getType() throws RemoteException {
        return this.type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzavh(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzavh(String str, int i) {
        this.type = str;
        this.zzdva = i;
    }
}
