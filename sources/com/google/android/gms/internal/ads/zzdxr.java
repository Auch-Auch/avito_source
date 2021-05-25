package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;
public class zzdxr implements zzdxh<zzdwq> {
    private static final Logger logger = Logger.getLogger(zzdxr.class.getName());

    public static class zza implements zzdwq {
        private final zzdxf<zzdwq> zzhsd;

        private zza(zzdxf<zzdwq> zzdxf) {
            this.zzhsd = zzdxf;
        }

        @Override // com.google.android.gms.internal.ads.zzdwq
        public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzedd.zza(this.zzhsd.zzaxy().zzayc(), this.zzhsd.zzaxy().zzaxz().zzc(bArr, bArr2));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdxf] */
    @Override // com.google.android.gms.internal.ads.zzdxh
    public final /* synthetic */ zzdwq zza(zzdxf<zzdwq> zzdxf) throws GeneralSecurityException {
        return new zza(zzdxf);
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    public final Class<zzdwq> zzaxp() {
        return zzdwq.class;
    }
}
