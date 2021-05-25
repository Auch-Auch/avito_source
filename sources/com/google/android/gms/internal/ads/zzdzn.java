package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;
public class zzdzn implements zzdxh<zzdxd> {
    private static final Logger logger = Logger.getLogger(zzdzn.class.getName());

    public static class zza implements zzdxd {
        private final zzdxf<zzdxd> zzhst;
        private final byte[] zzhte;

        private zza(zzdxf<zzdxd> zzdxf) {
            this.zzhte = new byte[]{0};
            this.zzhst = zzdxf;
        }

        @Override // com.google.android.gms.internal.ads.zzdxd
        public final byte[] zzl(byte[] bArr) throws GeneralSecurityException {
            if (this.zzhst.zzaxy().zzayb().equals(zzecn.LEGACY)) {
                return zzedd.zza(this.zzhst.zzaxy().zzayc(), this.zzhst.zzaxy().zzaxz().zzl(zzedd.zza(bArr, this.zzhte)));
            }
            return zzedd.zza(this.zzhst.zzaxy().zzayc(), this.zzhst.zzaxy().zzaxz().zzl(bArr));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdxf] */
    @Override // com.google.android.gms.internal.ads.zzdxh
    public final /* synthetic */ zzdxd zza(zzdxf<zzdxd> zzdxf) throws GeneralSecurityException {
        return new zza(zzdxf);
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    public final Class<zzdxd> zzaxp() {
        return zzdxd.class;
    }
}
