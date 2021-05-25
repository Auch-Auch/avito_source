package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzvw extends zzwf<zzwu> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvj zzchw;
    private final /* synthetic */ String zzchx;
    private final /* synthetic */ zzvr zzchz;

    public zzvw(zzvr zzvr, Context context, zzvj zzvj, String str) {
        this.zzchz = zzvr;
        this.val$context = context;
        this.zzchw = zzvj;
        this.zzchx = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwu zza(zzxh zzxh) throws RemoteException {
        return zzxh.zza(ObjectWrapper.wrap(this.val$context), this.zzchw, this.zzchx, 202006000);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwu zzpn() {
        zzvr.zza(this.val$context, "search");
        return new zzzk();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzwu zzpo() throws RemoteException {
        return this.zzchz.zzcia.zza(this.val$context, this.zzchw, this.zzchx, null, 3);
    }
}
