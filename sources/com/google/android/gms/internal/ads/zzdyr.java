package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdyr extends zzdwx<zzecs> {
    public zzdyr() {
        super(zzecs.class, new zzdyq(zzdwq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdxa<com.google.android.gms.internal.ads.zzect, com.google.android.gms.internal.ads.zzecs>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzecs> zzaxv() {
        return new zzdyt(this, zzect.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzecs zzecs) throws GeneralSecurityException {
        zzecs zzecs2 = zzecs;
        zzeej.zzy(zzecs2.getVersion(), 0);
        if (zzecs2.zzayi().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzecs zzp(zzeff zzeff) throws zzegz {
        return zzecs.zzx(zzeff, zzegc.zzbex());
    }
}
