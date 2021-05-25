package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdzk extends zzdwx<zzebl> {
    public zzdzk() {
        super(zzebl.class, new zzdzj(zzdxd.class));
    }

    /* access modifiers changed from: private */
    public static void zza(zzebq zzebq) throws GeneralSecurityException {
        if (zzebq.zzayn() >= 10) {
            int i = zzdzl.zzhsu[zzebq.zzbav().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzebq.zzayn() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzebq.zzayn() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzebq.zzayn() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdxa<com.google.android.gms.internal.ads.zzebp, com.google.android.gms.internal.ads.zzebl>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzebl> zzaxv() {
        return new zzdzm(this, zzebp.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzebl zzebl) throws GeneralSecurityException {
        zzebl zzebl2 = zzebl;
        zzeej.zzy(zzebl2.getVersion(), 0);
        if (zzebl2.zzayi().size() >= 16) {
            zza(zzebl2.zzbap());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzebl zzp(zzeff zzeff) throws zzegz {
        return zzebl.zzr(zzeff, zzegc.zzbex());
    }
}
