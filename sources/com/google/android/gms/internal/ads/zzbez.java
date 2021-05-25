package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.HashMap;
public final class zzbez implements Runnable {
    private final /* synthetic */ String zzeca;
    private final /* synthetic */ String zzeks;
    private final /* synthetic */ int zzeku;
    private final /* synthetic */ zzbev zzekw;

    public zzbez(zzbev zzbev, String str, String str2, int i) {
        this.zzekw = zzbev;
        this.zzeca = str;
        this.zzeks = str2;
        this.zzeku = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap k0 = a.k0("event", "precacheComplete");
        k0.put("src", this.zzeca);
        k0.put("cachedSrc", this.zzeks);
        k0.put("totalBytes", Integer.toString(this.zzeku));
        this.zzekw.zza("onPrecacheEvent", k0);
    }
}
