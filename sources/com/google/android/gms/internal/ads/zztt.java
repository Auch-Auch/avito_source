package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zztt {
    @VisibleForTesting
    public zzgx zzbxt;
    @VisibleForTesting
    public boolean zzbxu;

    public zztt(Context context, String str, String str2) {
        zzaat.initialize(context);
        try {
            this.zzbxt = (zzgx) zzbbc.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzts.zzbxs);
            ObjectWrapper.wrap(context);
            this.zzbxt.zza(ObjectWrapper.wrap(context), str, null);
            this.zzbxu = true;
        } catch (RemoteException | zzbbe | NullPointerException unused) {
            zzbbd.zzef("Cannot dynamite load clearcut");
        }
    }

    public final zztx zzf(byte[] bArr) {
        return new zztx(this, bArr);
    }

    public zztt(Context context) {
        zzaat.initialize(context);
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctk)).booleanValue()) {
            try {
                this.zzbxt = (zzgx) zzbbc.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zztv.zzbxs);
                ObjectWrapper.wrap(context);
                this.zzbxt.zza(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzbxu = true;
            } catch (RemoteException | zzbbe | NullPointerException unused) {
                zzbbd.zzef("Cannot dynamite load clearcut");
            }
        }
    }

    public zztt() {
    }
}
