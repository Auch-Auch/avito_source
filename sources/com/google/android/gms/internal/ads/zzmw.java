package com.google.android.gms.internal.ads;

import java.io.IOException;
public final class zzmw implements zznm {
    private final int track;
    private final /* synthetic */ zzmn zzbeg;

    public zzmw(zzmn zzmn, int i) {
        this.zzbeg = zzmn;
        this.track = i;
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final boolean isReady() {
        return this.zzbeg.zzbb(this.track);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final int zzb(zzhq zzhq, zzjk zzjk, boolean z) {
        return this.zzbeg.zza(this.track, zzhq, zzjk, z);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzeh(long j) {
        this.zzbeg.zzd(this.track, j);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzhq() throws IOException {
        this.zzbeg.zzhq();
    }
}
