package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.HashMap;
public final class zzbeu implements Runnable {
    private final /* synthetic */ String zzeca;
    private final /* synthetic */ String zzeks;
    private final /* synthetic */ int zzekt;
    private final /* synthetic */ int zzeku;
    private final /* synthetic */ boolean zzekv = false;
    private final /* synthetic */ zzbev zzekw;

    public zzbeu(zzbev zzbev, String str, String str2, int i, int i2, boolean z) {
        this.zzekw = zzbev;
        this.zzeca = str;
        this.zzeks = str2;
        this.zzekt = i;
        this.zzeku = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap k0 = a.k0("event", "precacheProgress");
        k0.put("src", this.zzeca);
        k0.put("cachedSrc", this.zzeks);
        k0.put("bytesLoaded", Integer.toString(this.zzekt));
        k0.put("totalBytes", Integer.toString(this.zzeku));
        k0.put("cacheReady", this.zzekv ? "1" : "0");
        this.zzekw.zza("onPrecacheEvent", k0);
    }
}
