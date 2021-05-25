package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
public final class zzwd extends zzwf<zzaed> {
    private final /* synthetic */ zzvr zzchz;
    private final /* synthetic */ View zzcik;
    private final /* synthetic */ HashMap zzcil;
    private final /* synthetic */ HashMap zzcim;

    public zzwd(zzvr zzvr, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzchz = zzvr;
        this.zzcik = view;
        this.zzcil = hashMap;
        this.zzcim = hashMap2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaed zza(zzxh zzxh) throws RemoteException {
        return zzxh.zza(ObjectWrapper.wrap(this.zzcik), ObjectWrapper.wrap(this.zzcil), ObjectWrapper.wrap(this.zzcim));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaed zzpn() {
        zzvr.zza(this.zzcik.getContext(), "native_ad_view_holder_delegate");
        return new zzzn();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaed zzpo() throws RemoteException {
        return this.zzchz.zzcih.zzb(this.zzcik, this.zzcil, this.zzcim);
    }
}
