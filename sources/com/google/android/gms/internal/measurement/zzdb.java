package com.google.android.gms.internal.measurement;
public final class zzdb extends zzcw<Long> {
    public zzdb(zzdf zzdf, String str, Long l, boolean z) {
        super(zzdf, str, l, z, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        String.valueOf(zzb).length();
        valueOf.length();
        return null;
    }
}
