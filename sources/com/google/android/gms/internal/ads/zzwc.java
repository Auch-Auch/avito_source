package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzwc extends zzwf<zzatm> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzamu zzchy;
    private final /* synthetic */ zzvr zzchz;

    public zzwc(zzvr zzvr, Context context, zzamu zzamu) {
        this.zzchz = zzvr;
        this.val$context = context;
        this.zzchy = zzamu;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzatm zza(zzxh zzxh) throws RemoteException {
        return zzxh.zza(ObjectWrapper.wrap(this.val$context), this.zzchy, 202006000);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzatm zzpn() {
        zzvr.zza(this.val$context, "rewarded_video");
        return new zzzs();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzatm zzpo() throws RemoteException {
        return this.zzchz.zzcie.zzb(this.val$context, this.zzchy);
    }
}
