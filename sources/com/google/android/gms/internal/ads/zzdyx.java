package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdyx extends zzdwx<zzebe> {
    public zzdyx() {
        super(zzebe.class, new zzdyw(zzdwt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.ASYMMETRIC_PUBLIC;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzebe zzebe) throws GeneralSecurityException {
        zzebe zzebe2 = zzebe;
        zzeej.zzy(zzebe2.getVersion(), 0);
        zzdze.zza(zzebe2.zzazv());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzebe zzp(zzeff zzeff) throws zzegz {
        return zzebe.zzq(zzeff, zzegc.zzbex());
    }
}
