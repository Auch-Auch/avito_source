package com.google.android.gms.internal.ads;
public final class zzcqq {
    private int responseCode = 0;
    private long zzgkb = 0;
    private long zzgkc = 0;
    private long zzgkd = 0;
    private final Object zzgke = new Object();
    private final Object zzgkf = new Object();
    private final Object zzgkg = new Object();
    private final Object zzgkh = new Object();

    public final int getResponseCode() {
        int i;
        synchronized (this.zzgke) {
            i = this.responseCode;
        }
        return i;
    }

    public final long zzapp() {
        long j;
        synchronized (this.zzgkf) {
            j = this.zzgkb;
        }
        return j;
    }

    public final synchronized long zzapq() {
        long j;
        synchronized (this.zzgkg) {
            j = this.zzgkc;
        }
        return j;
    }

    public final synchronized long zzapr() {
        long j;
        synchronized (this.zzgkh) {
            j = this.zzgkd;
        }
        return j;
    }

    public final void zzdz(int i) {
        synchronized (this.zzgke) {
            this.responseCode = i;
        }
    }

    public final void zzeo(long j) {
        synchronized (this.zzgkf) {
            this.zzgkb = j;
        }
    }

    public final synchronized void zzep(long j) {
        synchronized (this.zzgkh) {
            this.zzgkd = j;
        }
    }

    public final synchronized void zzff(long j) {
        synchronized (this.zzgkg) {
            this.zzgkc = j;
        }
    }
}
