package com.google.android.gms.internal.measurement;
public final class zzjc implements zzjk {
    private zzjk[] zza;

    public zzjc(zzjk... zzjkArr) {
        this.zza = zzjkArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zza(Class<?> cls) {
        for (zzjk zzjk : this.zza) {
            if (zzjk.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final zzjh zzb(Class<?> cls) {
        zzjk[] zzjkArr = this.zza;
        for (zzjk zzjk : zzjkArr) {
            if (zzjk.zza(cls)) {
                return zzjk.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
