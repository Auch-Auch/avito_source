package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
public final class zznn extends zzhy {
    private static final Object zzbgl = new Object();
    private final boolean zzaio;
    private final boolean zzaip;
    private final long zzbgm;
    private final long zzbgn;
    private final long zzbgo;
    private final long zzbgp;

    public zznn(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zzid zza(int i, zzid zzid, boolean z, long j) {
        zzoz.zzc(i, 0, 1);
        boolean z2 = this.zzaio;
        long j2 = this.zzbgn;
        zzid.zzaic = null;
        zzid.zzaim = C.TIME_UNSET;
        zzid.zzain = C.TIME_UNSET;
        zzid.zzaio = z2;
        zzid.zzaip = false;
        zzid.zzais = 0;
        zzid.zzaid = j2;
        zzid.zzaiq = 0;
        zzid.zzair = 0;
        zzid.zzait = 0;
        return zzid;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int zzc(Object obj) {
        return zzbgl.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int zzfd() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int zzfe() {
        return 1;
    }

    private zznn(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbgm = j;
        this.zzbgn = j2;
        this.zzbgo = 0;
        this.zzbgp = 0;
        this.zzaio = z;
        this.zzaip = false;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zzia zza(int i, zzia zzia, boolean z) {
        zzoz.zzc(i, 0, 1);
        Object obj = z ? zzbgl : null;
        return zzia.zza(obj, obj, 0, this.zzbgm, 0, false);
    }
}
