package com.google.android.gms.internal.ads;
public final class zzkd implements zzke {
    private final long zzaid;

    public zzkd(long j) {
        this.zzaid = j;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long getDurationUs() {
        return this.zzaid;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final boolean isSeekable() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long zzdz(long j) {
        return 0;
    }
}
