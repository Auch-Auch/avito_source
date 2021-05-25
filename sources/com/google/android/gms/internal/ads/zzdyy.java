package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;
public class zzdyy implements zzdxh<zzdwu> {
    private static final Logger logger = Logger.getLogger(zzdyy.class.getName());

    public static class zza implements zzdwu {
        private final zzdxf<zzdwu> zzhst;

        public zza(zzdxf<zzdwu> zzdxf) {
            this.zzhst = zzdxf;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdxf] */
    @Override // com.google.android.gms.internal.ads.zzdxh
    public final /* synthetic */ zzdwu zza(zzdxf<zzdwu> zzdxf) throws GeneralSecurityException {
        return new zza(zzdxf);
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    public final Class<zzdwu> zzaxp() {
        return zzdwu.class;
    }
}
