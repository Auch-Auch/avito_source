package com.google.android.gms.internal.ads;

import java.io.IOException;
public abstract class zzefq {
    public int zzibp;
    public int zzibq;
    public int zzibr;
    public zzefx zzibs;
    private boolean zzibt;

    private zzefq() {
        this.zzibq = 100;
        this.zzibr = Integer.MAX_VALUE;
        this.zzibt = false;
    }

    public static zzefq zzb(byte[] bArr, int i, int i2, boolean z) {
        zzefs zzefs = new zzefs(bArr, i, i2, z);
        try {
            zzefs.zzga(i2);
            return zzefs;
        } catch (zzegz e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzfh(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzgc(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzbdt() throws IOException;

    public abstract long zzbdu() throws IOException;

    public abstract long zzbdv() throws IOException;

    public abstract int zzbdw() throws IOException;

    public abstract long zzbdx() throws IOException;

    public abstract int zzbdy() throws IOException;

    public abstract boolean zzbdz() throws IOException;

    public abstract String zzbea() throws IOException;

    public abstract zzeff zzbeb() throws IOException;

    public abstract int zzbec() throws IOException;

    public abstract int zzbed() throws IOException;

    public abstract int zzbee() throws IOException;

    public abstract long zzbef() throws IOException;

    public abstract int zzbeg() throws IOException;

    public abstract long zzbeh() throws IOException;

    public abstract long zzbei() throws IOException;

    public abstract boolean zzbej() throws IOException;

    public abstract int zzbek();

    public abstract void zzfy(int i) throws zzegz;

    public abstract boolean zzfz(int i) throws IOException;

    public abstract int zzga(int i) throws zzegz;

    public abstract void zzgb(int i);
}
