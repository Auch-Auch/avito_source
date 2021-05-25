package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzwb extends zzwf<zzxk> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvr zzchz;

    public zzwb(zzvr zzvr, Context context) {
        this.zzchz = zzvr;
        this.val$context = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzxk zza(zzxh zzxh) throws RemoteException {
        return zzxh.zza(ObjectWrapper.wrap(this.val$context), 202006000);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzxk zzpn() {
        zzvr.zza(this.val$context, "mobile_ads_settings");
        return new zzzm();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzxk zzpo() throws RemoteException {
        return this.zzchz.zzcic.zzi(this.val$context);
    }
}
