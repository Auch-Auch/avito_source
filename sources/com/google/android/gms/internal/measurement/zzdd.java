package com.google.android.gms.internal.measurement;
public final class zzdd extends zzcw<Double> {
    public zzdd(zzdf zzdf, String str, Double d, boolean z) {
        super(zzdf, str, d, z, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Double zza(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
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
