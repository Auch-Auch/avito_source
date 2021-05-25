package com.google.android.gms.internal.ads;
public final class zzbem implements zzbfd {
    @Override // com.google.android.gms.internal.ads.zzbfd
    public final zzbev zza(zzbde zzbde, int i, String str, zzbdf zzbdf) {
        if (i <= 0) {
            return new zzbfc(zzbde);
        }
        int zzaas = zzbeb.zzaas();
        if (zzaas < zzbdf.zzeib) {
            return new zzbfg(zzbde, zzbdf);
        }
        if (zzaas < zzbdf.zzehv) {
            return new zzbfh(zzbde, zzbdf);
        }
        return new zzbff(zzbde);
    }
}
