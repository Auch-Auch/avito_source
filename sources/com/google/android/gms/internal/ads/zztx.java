package com.google.android.gms.internal.ads;

import android.os.RemoteException;
public final class zztx {
    private final byte[] zzbxv;
    private int zzbxw;
    private int zzbxx;
    private final /* synthetic */ zztt zzbxy;

    private zztx(zztt zztt, byte[] bArr) {
        this.zzbxy = zztt;
        this.zzbxv = bArr;
    }

    public final zztx zzbx(int i) {
        this.zzbxw = i;
        return this;
    }

    public final zztx zzby(int i) {
        this.zzbxx = i;
        return this;
    }

    public final synchronized void zzdv() {
        try {
            zztt zztt = this.zzbxy;
            if (zztt.zzbxu) {
                zztt.zzbxt.zzc(this.zzbxv);
                this.zzbxy.zzbxt.zzs(this.zzbxw);
                this.zzbxy.zzbxt.zzt(this.zzbxx);
                this.zzbxy.zzbxt.zza(null);
                this.zzbxy.zzbxt.zzdv();
            }
        } catch (RemoteException e) {
            zzbbd.zzb("Clearcut log failed", e);
        }
    }
}
