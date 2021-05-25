package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.gms.common.util.VisibleForTesting;
public final class zzbdy implements zzhs {
    private int zzbiv;
    private final zzoq zzejo;
    private long zzejp;
    private long zzejq;
    private long zzejr;
    private long zzejs;
    private boolean zzejt;

    public zzbdy() {
        this(DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT, 2500, 5000);
    }

    @VisibleForTesting
    private final void zzk(boolean z) {
        this.zzbiv = 0;
        this.zzejt = false;
        if (z) {
            this.zzejo.reset();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final void onStopped() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final void zza(zzhx[] zzhxArr, zznp zznp, zzod zzod) {
        this.zzbiv = 0;
        for (int i = 0; i < zzhxArr.length; i++) {
            if (zzod.zzbg(i) != null) {
                this.zzbiv = zzpq.zzbs(zzhxArr[i].getTrackType()) + this.zzbiv;
            }
        }
        this.zzejo.zzbi(this.zzbiv);
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final synchronized boolean zzc(long j, boolean z) {
        boolean z2;
        long j2 = z ? this.zzejs : this.zzejr;
        if (j2 <= 0 || j >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public final synchronized void zzdn(int i) {
        this.zzejr = ((long) i) * 1000;
    }

    public final synchronized void zzdo(int i) {
        this.zzejs = ((long) i) * 1000;
    }

    public final synchronized void zzds(int i) {
        this.zzejp = ((long) i) * 1000;
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final synchronized boolean zzdt(long j) {
        boolean z;
        char c;
        z = false;
        if (j > this.zzejq) {
            c = 0;
        } else {
            c = j < this.zzejp ? (char) 2 : 1;
        }
        boolean z2 = this.zzejo.zzip() >= this.zzbiv;
        if (c == 2 || (c == 1 && this.zzejt && !z2)) {
            z = true;
        }
        this.zzejt = z;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final void zzez() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final void zzfa() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final zzok zzfb() {
        return this.zzejo;
    }

    private zzbdy(int i, int i2, long j, long j2) {
        this.zzejo = new zzoq(true, 65536);
        this.zzejp = 15000000;
        this.zzejq = 30000000;
        this.zzejr = 2500000;
        this.zzejs = 5000000;
    }

    public final synchronized void zzdt(int i) {
        this.zzejq = ((long) i) * 1000;
    }
}
