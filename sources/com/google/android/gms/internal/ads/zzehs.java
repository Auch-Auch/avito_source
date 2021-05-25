package com.google.android.gms.internal.ads;
public final class zzehs implements zzeia {
    private zzeia[] zzihs;

    public zzehs(zzeia... zzeiaArr) {
        this.zzihs = zzeiaArr;
    }

    @Override // com.google.android.gms.internal.ads.zzeia
    public final boolean zze(Class<?> cls) {
        for (zzeia zzeia : this.zzihs) {
            if (zzeia.zze(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzeia
    public final zzehx zzf(Class<?> cls) {
        zzeia[] zzeiaArr = this.zzihs;
        for (zzeia zzeia : zzeiaArr) {
            if (zzeia.zze(cls)) {
                return zzeia.zzf(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
