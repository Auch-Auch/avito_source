package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
public final class zzaic implements zzduv<zzahx, ParcelFileDescriptor> {
    private final /* synthetic */ zzahr zzdfc;

    public zzaic(zzahz zzahz, zzahr zzahr) {
        this.zzdfc = zzahr;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdvt' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduv
    public final /* synthetic */ zzdvt<ParcelFileDescriptor> zzf(zzahx zzahx) throws Exception {
        zzbbq zzbbq = new zzbbq();
        zzahx.zza(this.zzdfc, new zzaib(this, zzbbq));
        return zzbbq;
    }
}
