package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.HashMap;
public final class zzbey implements Runnable {
    private final /* synthetic */ String zzeca;
    private final /* synthetic */ String zzeks;
    private final /* synthetic */ zzbev zzekw;
    private final /* synthetic */ long zzekz;

    public zzbey(zzbev zzbev, String str, String str2, long j) {
        this.zzekw = zzbev;
        this.zzeca = str;
        this.zzeks = str2;
        this.zzekz = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap k0 = a.k0("event", "precacheComplete");
        k0.put("src", this.zzeca);
        k0.put("cachedSrc", this.zzeks);
        k0.put("totalDuration", Long.toString(this.zzekz));
        this.zzekw.zza("onPrecacheEvent", k0);
    }
}
