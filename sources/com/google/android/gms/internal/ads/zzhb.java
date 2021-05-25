package com.google.android.gms.internal.ads;

import java.io.IOException;
public abstract class zzhb implements zzhw, zzhx {
    private int index;
    private int state;
    private final int zzaea;
    private zzhz zzaeb;
    private zznm zzaec;
    private long zzaed;
    private boolean zzaee = true;
    private boolean zzaef;

    public zzhb(int i) {
        this.zzaea = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzoz.checkState(z);
        this.state = 0;
        this.zzaec = null;
        this.zzaef = false;
        zzef();
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.gms.internal.ads.zzhw, com.google.android.gms.internal.ads.zzhx
    public final int getTrackType() {
        return this.zzaea;
    }

    public void onStarted() throws zzhd {
    }

    public void onStopped() throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void start() throws zzhd {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzoz.checkState(z);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void stop() throws zzhd {
        zzoz.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public void zza(int i, Object obj) throws zzhd {
    }

    public void zza(long j, boolean z) throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zza(zzhz zzhz, zzho[] zzhoArr, zznm zznm, long j, boolean z, long j2) throws zzhd {
        zzoz.checkState(this.state == 0);
        this.zzaeb = zzhz;
        this.state = 1;
        zze(z);
        zza(zzhoArr, zznm, j2);
        zza(j, z);
    }

    public void zza(zzho[] zzhoArr, long j) throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzdo(long j) throws zzhd {
        this.zzaef = false;
        this.zzaee = false;
        zza(j, false);
    }

    public final void zzdp(long j) {
        this.zzaec.zzeh(j - this.zzaed);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final zzhw zzdx() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public zzpd zzdy() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final zznm zzdz() {
        return this.zzaec;
    }

    public void zze(boolean z) throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final boolean zzea() {
        return this.zzaee;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzeb() {
        this.zzaef = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final boolean zzec() {
        return this.zzaef;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzed() throws IOException {
        this.zzaec.zzhq();
    }

    @Override // com.google.android.gms.internal.ads.zzhw
    public int zzee() throws zzhd {
        return 0;
    }

    public void zzef() {
    }

    public final zzhz zzeg() {
        return this.zzaeb;
    }

    public final boolean zzeh() {
        return this.zzaee ? this.zzaef : this.zzaec.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zza(zzho[] zzhoArr, zznm zznm, long j) throws zzhd {
        zzoz.checkState(!this.zzaef);
        this.zzaec = zznm;
        this.zzaee = false;
        this.zzaed = j;
        zza(zzhoArr, j);
    }

    public final int zza(zzhq zzhq, zzjk zzjk, boolean z) {
        int zzb = this.zzaec.zzb(zzhq, zzjk, z);
        if (zzb == -4) {
            if (zzjk.zzgj()) {
                this.zzaee = true;
                if (this.zzaef) {
                    return -4;
                }
                return -3;
            }
            zzjk.zzanx += this.zzaed;
        } else if (zzb == -5) {
            zzho zzho = zzhq.zzaht;
            long j = zzho.zzahn;
            if (j != Long.MAX_VALUE) {
                zzhq.zzaht = zzho.zzds(j + this.zzaed);
            }
        }
        return zzb;
    }
}
