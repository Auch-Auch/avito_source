package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxm;
import java.security.GeneralSecurityException;
import java.util.Set;
public final class zzdxn implements zzdxm.zzb {
    private final /* synthetic */ zzdxj zzhrp;
    private final /* synthetic */ zzdwx zzhrq;

    public zzdxn(zzdxj zzdxj, zzdwx zzdwx) {
        this.zzhrp = zzdxj;
        this.zzhrq = zzdwx;
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final Set<Class<?>> zzaxt() {
        return this.zzhrp.zzaxt();
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final zzdww<?> zzayd() {
        zzdxj zzdxj = this.zzhrp;
        return new zzdxk(zzdxj, this.zzhrq, zzdxj.zzaxu());
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final Class<?> zzaye() {
        return this.zzhrp.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final Class<?> zzayf() {
        return this.zzhrq.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final <Q> zzdww<Q> zzb(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzdxk(this.zzhrp, this.zzhrq, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }
}
