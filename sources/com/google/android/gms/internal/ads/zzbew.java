package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.HashMap;
public final class zzbew implements Runnable {
    private final /* synthetic */ String zzeca;
    private final /* synthetic */ String zzeks;
    private final /* synthetic */ int zzekt;
    private final /* synthetic */ int zzeku;
    private final /* synthetic */ boolean zzekv;
    private final /* synthetic */ zzbev zzekw;
    private final /* synthetic */ long zzeky;
    private final /* synthetic */ long zzekz;
    private final /* synthetic */ int zzela;
    private final /* synthetic */ int zzelb;

    public zzbew(zzbev zzbev, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.zzekw = zzbev;
        this.zzeca = str;
        this.zzeks = str2;
        this.zzekt = i;
        this.zzeku = i2;
        this.zzeky = j;
        this.zzekz = j2;
        this.zzekv = z;
        this.zzela = i3;
        this.zzelb = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap k0 = a.k0("event", "precacheProgress");
        k0.put("src", this.zzeca);
        k0.put("cachedSrc", this.zzeks);
        k0.put("bytesLoaded", Integer.toString(this.zzekt));
        k0.put("totalBytes", Integer.toString(this.zzeku));
        k0.put("bufferedDuration", Long.toString(this.zzeky));
        k0.put("totalDuration", Long.toString(this.zzekz));
        k0.put("cacheReady", this.zzekv ? "1" : "0");
        k0.put("playerCount", Integer.toString(this.zzela));
        k0.put("playerPreparedCount", Integer.toString(this.zzelb));
        this.zzekw.zza("onPrecacheEvent", k0);
    }
}
