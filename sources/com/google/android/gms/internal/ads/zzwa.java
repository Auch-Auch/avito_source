package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzwa extends zzwf<zzaea> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvr zzchz;
    private final /* synthetic */ FrameLayout zzcii;
    private final /* synthetic */ FrameLayout zzcij;

    public zzwa(zzvr zzvr, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzchz = zzvr;
        this.zzcii = frameLayout;
        this.zzcij = frameLayout2;
        this.val$context = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaea zza(zzxh zzxh) throws RemoteException {
        return zzxh.zza(ObjectWrapper.wrap(this.zzcii), ObjectWrapper.wrap(this.zzcij));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaea zzpn() {
        zzvr.zza(this.val$context, "native_ad_view_delegate");
        return new zzzo();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzaea zzpo() throws RemoteException {
        return this.zzchz.zzcid.zzb(this.val$context, this.zzcii, this.zzcij);
    }
}
