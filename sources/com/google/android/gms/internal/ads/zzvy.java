package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzvy extends zzwf<zzwr> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzchx;
    private final /* synthetic */ zzamu zzchy;
    private final /* synthetic */ zzvr zzchz;

    public zzvy(zzvr zzvr, Context context, String str, zzamu zzamu) {
        this.zzchz = zzvr;
        this.val$context = context;
        this.zzchx = str;
        this.zzchy = zzamu;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwr zza(zzxh zzxh) throws RemoteException {
        return zzxh.zza(ObjectWrapper.wrap(this.val$context), this.zzchx, this.zzchy, 202006000);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwr zzpn() {
        zzvr.zza(this.val$context, "native_ad");
        return new zzzg();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwr zzpo() throws RemoteException {
        return this.zzchz.zzcib.zza(this.val$context, this.zzchx, this.zzchy);
    }
}
