package com.google.android.gms.internal.gtm;
public final class zzsb implements zzsj {
    private zzsj[] zzbco;

    public zzsb(zzsj... zzsjArr) {
        this.zzbco = zzsjArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzsj
    public final boolean zze(Class<?> cls) {
        for (zzsj zzsj : this.zzbco) {
            if (zzsj.zze(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzsj
    public final zzsi zzf(Class<?> cls) {
        zzsj[] zzsjArr = this.zzbco;
        for (zzsj zzsj : zzsjArr) {
            if (zzsj.zze(cls)) {
                return zzsj.zzf(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
