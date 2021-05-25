package com.google.android.gms.internal.ads;
public final class zzaau implements zzadc {
    private final /* synthetic */ zzaap zzcxy;

    public zzaau(zzaap zzaap) {
        this.zzcxy = zzaap;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final String get(String str, String str2) {
        return this.zzcxy.zzcld.getString(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final Long getLong(String str, long j) {
        try {
            return Long.valueOf(this.zzcxy.zzcld.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.zzcxy.zzcld.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final Double zza(String str, double d) {
        return Double.valueOf((double) this.zzcxy.zzcld.getFloat(str, (float) d));
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final Boolean zzf(String str, boolean z) {
        return Boolean.valueOf(this.zzcxy.zzcld.getBoolean(str, z));
    }
}
