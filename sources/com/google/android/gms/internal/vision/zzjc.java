package com.google.android.gms.internal.vision;
public final class zzjc implements zzjk {
    private zzjk[] zzaab;

    public zzjc(zzjk... zzjkArr) {
        this.zzaab = zzjkArr;
    }

    @Override // com.google.android.gms.internal.vision.zzjk
    public final boolean zza(Class<?> cls) {
        for (zzjk zzjk : this.zzaab) {
            if (zzjk.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzjk
    public final zzjl zzb(Class<?> cls) {
        zzjk[] zzjkArr = this.zzaab;
        for (zzjk zzjk : zzjkArr) {
            if (zzjk.zza(cls)) {
                return zzjk.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
