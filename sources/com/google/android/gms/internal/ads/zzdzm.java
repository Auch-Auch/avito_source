package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdzm extends zzdxa<zzebp, zzebl> {
    private final /* synthetic */ zzdzk zzhtc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdzm(zzdzk zzdzk, Class cls) {
        super(cls);
        this.zzhtc = zzdzk;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ void zzd(zzebp zzebp) throws GeneralSecurityException {
        zzebp zzebp2 = zzebp;
        if (zzebp2.getKeySize() >= 16) {
            zzdzk.zza(zzebp2.zzbap());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzebl zze(zzebp zzebp) throws GeneralSecurityException {
        zzebp zzebp2 = zzebp;
        return (zzebl) ((zzegp) zzebl.zzbaq().zzfd(0).zzd(zzebp2.zzbap()).zzad(zzeff.zzu(zzeei.zzfo(zzebp2.getKeySize()))).zzbfx());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzebp zzr(zzeff zzeff) throws zzegz {
        return zzebp.zzs(zzeff, zzegc.zzbex());
    }
}
