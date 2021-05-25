package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdzb implements zzdwt {
    private final zzdxf<zzdwt> zzhst;

    public zzdzb(zzdxf<zzdwt> zzdxf) {
        this.zzhst = zzdxf;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzedd.zza(this.zzhst.zzaxy().zzayc(), this.zzhst.zzaxy().zzaxz().zzc(bArr, bArr2));
    }
}
