package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzvs extends zzwf<zzaql> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzvr zzchz;

    public zzvs(zzvr zzvr, Activity activity) {
        this.zzchz = zzvr;
        this.val$activity = activity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaql zza(zzxh zzxh) throws RemoteException {
        return zzxh.zzb(ObjectWrapper.wrap(this.val$activity));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaql zzpn() {
        zzvr.zza(this.val$activity, "ad_overlay");
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaql zzpo() throws RemoteException {
        return this.zzchz.zzcig.zzc(this.val$activity);
    }
}
