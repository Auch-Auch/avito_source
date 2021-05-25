package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehz;
import java.security.GeneralSecurityException;
public final class zzdwy<KeyFormatProtoT extends zzehz, KeyProtoT extends zzehz> {
    private final zzdxa<KeyFormatProtoT, KeyProtoT> zzhqw;

    public zzdwy(zzdxa<KeyFormatProtoT, KeyProtoT> zzdxa) {
        this.zzhqw = zzdxa;
    }

    public final KeyProtoT zzq(zzeff zzeff) throws GeneralSecurityException, zzegz {
        KeyFormatProtoT zzr = this.zzhqw.zzr(zzeff);
        this.zzhqw.zzd(zzr);
        return this.zzhqw.zze(zzr);
    }
}
