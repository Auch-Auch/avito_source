package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
public final class zzxw implements MuteThisAdReason {
    private final String description;
    private zzxv zzcja;

    public zzxw(zzxv zzxv) {
        String str;
        this.zzcja = zzxv;
        try {
            str = zzxv.getDescription();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.description;
    }

    public final String toString() {
        return this.description;
    }

    public final zzxv zzqi() {
        return this.zzcja;
    }
}
