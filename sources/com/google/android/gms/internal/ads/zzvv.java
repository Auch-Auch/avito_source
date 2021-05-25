package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzvv extends zzwf<zzawu> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzamu zzchy;

    public zzvv(zzvr zzvr, Context context, zzamu zzamu) {
        this.val$context = context;
        this.zzchy = zzamu;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzpp */
    public final zzawu zzpo() {
        try {
            return ((zzawz) zzbbc.zza(this.val$context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzvu.zzbxs)).zzd(ObjectWrapper.wrap(this.val$context), this.zzchy, 202006000);
        } catch (RemoteException | zzbbe | NullPointerException unused) {
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* synthetic */ zzawu zza(zzxh zzxh) throws RemoteException {
        return zzxh.zzb(ObjectWrapper.wrap(this.val$context), this.zzchy, 202006000);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwf
    public final /* bridge */ /* synthetic */ zzawu zzpn() {
        return null;
    }
}
