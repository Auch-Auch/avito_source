package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzvt extends zzwf<zzaul> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzchx;
    private final /* synthetic */ zzamu zzchy;
    private final /* synthetic */ zzvr zzchz;

    public zzvt(zzvr zzvr, Context context, String str, zzamu zzamu) {
        this.zzchz = zzvr;
        this.val$context = context;
        this.zzchx = str;
        this.zzchy = zzamu;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaul zza(zzxh zzxh) throws RemoteException {
        return zzxh.zzb(ObjectWrapper.wrap(this.val$context), this.zzchx, this.zzchy, 202006000);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaul zzpn() {
        zzvr.zza(this.val$context, "rewarded");
        return new zzzq();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaul zzpo() throws RemoteException {
        return zzavb.zzd(this.val$context, this.zzchx, this.zzchy);
    }
}
