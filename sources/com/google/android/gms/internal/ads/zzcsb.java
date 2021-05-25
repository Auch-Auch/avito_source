package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzcsb extends zzaon {
    private zzcrg<zzapa, zzcso> zzglp;
    private final /* synthetic */ zzcsa zzglq;

    private zzcsb(zzcsa zzcsa, zzcrg<zzapa, zzcso> zzcrg) {
        this.zzglq = zzcsa;
        this.zzglp = zzcrg;
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzdq(String str) throws RemoteException {
        ((zzcso) this.zzglp.zzglc).zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzglq.view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzcso) this.zzglp.zzglc).onAdLoaded();
    }
}
