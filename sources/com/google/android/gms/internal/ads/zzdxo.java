package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxm;
import java.security.GeneralSecurityException;
import java.util.Set;
public final class zzdxo implements zzdxm.zzb {
    private final /* synthetic */ zzdwx zzhrr;

    public zzdxo(zzdwx zzdwx) {
        this.zzhrr = zzdwx;
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final Set<Class<?>> zzaxt() {
        return this.zzhrr.zzaxt();
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final zzdww<?> zzayd() {
        zzdwx zzdwx = this.zzhrr;
        return new zzdwv(zzdwx, zzdwx.zzaxu());
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final Class<?> zzaye() {
        return this.zzhrr.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final Class<?> zzayf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxm.zzb
    public final <Q> zzdww<Q> zzb(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzdwv(this.zzhrr, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }
}
