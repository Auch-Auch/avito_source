package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
public final class zzcom extends zzasi {
    private final /* synthetic */ zzcoj zzgig;

    public zzcom(zzcoj zzcoj) {
        this.zzgig = zzcoj;
    }

    @Override // com.google.android.gms.internal.ads.zzasj
    public final void zza(zzazl zzazl) {
        this.zzgig.zzdih.setException(new zzazk(zzazl.zzacm, zzazl.errorCode));
    }

    @Override // com.google.android.gms.internal.ads.zzasj
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzgig.zzdih.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
