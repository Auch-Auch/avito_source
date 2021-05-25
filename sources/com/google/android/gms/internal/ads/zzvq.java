package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzvq extends zzwf<zzwu> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvj zzchw;
    private final /* synthetic */ String zzchx;
    private final /* synthetic */ zzamu zzchy;
    private final /* synthetic */ zzvr zzchz;

    public zzvq(zzvr zzvr, Context context, zzvj zzvj, String str, zzamu zzamu) {
        this.zzchz = zzvr;
        this.val$context = context;
        this.zzchw = zzvj;
        this.zzchx = str;
        this.zzchy = zzamu;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwu zza(zzxh zzxh) throws RemoteException {
        return zzxh.zza(ObjectWrapper.wrap(this.val$context), this.zzchw, this.zzchx, this.zzchy, 202006000);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwu zzpn() {
        zzvr.zza(this.val$context, "banner");
        return new zzzk();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwu zzpo() throws RemoteException {
        return this.zzchz.zzcia.zza(this.val$context, this.zzchw, this.zzchx, this.zzchy, 1);
    }
}
