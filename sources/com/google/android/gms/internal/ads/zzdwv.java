package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehz;
import java.security.GeneralSecurityException;
public class zzdwv<PrimitiveT, KeyProtoT extends zzehz> implements zzdww<PrimitiveT> {
    private final zzdwx<KeyProtoT> zzhqr;
    private final Class<PrimitiveT> zzhqs;

    public zzdwv(zzdwx<KeyProtoT> zzdwx, Class<PrimitiveT> cls) {
        if (zzdwx.zzaxt().contains(cls) || Void.class.equals(cls)) {
            this.zzhqr = zzdwx;
            this.zzhqs = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzdwx.toString(), cls.getName()));
    }

    private final zzdwy<?, KeyProtoT> zzaxq() {
        return new zzdwy<>(this.zzhqr.zzaxv());
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: java.lang.Class<PrimitiveT>, java.lang.Class<P> */
    private final PrimitiveT zzb(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.zzhqs)) {
            this.zzhqr.zzc(keyprotot);
            return (PrimitiveT) this.zzhqr.zza(keyprotot, (Class<PrimitiveT>) this.zzhqs);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    @Override // com.google.android.gms.internal.ads.zzdww
    public final String getKeyType() {
        return this.zzhqr.getKeyType();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.ads.zzehz */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdww
    public final PrimitiveT zza(zzehz zzehz) throws GeneralSecurityException {
        String name = this.zzhqr.zzaxr().getName();
        String concat = name.length() != 0 ? "Expected proto of type ".concat(name) : new String("Expected proto of type ");
        if (this.zzhqr.zzaxr().isInstance(zzehz)) {
            return zzb(zzehz);
        }
        throw new GeneralSecurityException(concat);
    }

    @Override // com.google.android.gms.internal.ads.zzdww
    public final Class<PrimitiveT> zzaxp() {
        return this.zzhqs;
    }

    @Override // com.google.android.gms.internal.ads.zzdww
    public final PrimitiveT zzm(zzeff zzeff) throws GeneralSecurityException {
        try {
            return zzb(this.zzhqr.zzp(zzeff));
        } catch (zzegz e) {
            String name = this.zzhqr.zzaxr().getName();
            throw new GeneralSecurityException(name.length() != 0 ? "Failures parsing proto of type ".concat(name) : new String("Failures parsing proto of type "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdww
    public final zzehz zzn(zzeff zzeff) throws GeneralSecurityException {
        try {
            return zzaxq().zzq(zzeff);
        } catch (zzegz e) {
            String name = this.zzhqr.zzaxv().zzaxw().getName();
            throw new GeneralSecurityException(name.length() != 0 ? "Failures parsing proto of type ".concat(name) : new String("Failures parsing proto of type "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdww
    public final zzebt zzo(zzeff zzeff) throws GeneralSecurityException {
        try {
            return (zzebt) ((zzegp) zzebt.zzbbb().zzhq(this.zzhqr.getKeyType()).zzaf(zzaxq().zzq(zzeff).zzbda()).zzb(this.zzhqr.zzaxs()).zzbfx());
        } catch (zzegz e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
