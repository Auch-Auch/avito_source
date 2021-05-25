package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.text.TextUtils;
import java.util.HashMap;
public final class zzbfb implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzeca;
    private final /* synthetic */ String zzeks;
    private final /* synthetic */ zzbev zzekw;
    private final /* synthetic */ String zzelc;

    public zzbfb(zzbev zzbev, String str, String str2, String str3, String str4) {
        this.zzekw = zzbev;
        this.zzeca = str;
        this.zzeks = str2;
        this.zzelc = str3;
        this.val$message = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap k0 = a.k0("event", "precacheCanceled");
        k0.put("src", this.zzeca);
        if (!TextUtils.isEmpty(this.zzeks)) {
            k0.put("cachedSrc", this.zzeks);
        }
        zzbev zzbev = this.zzekw;
        k0.put("type", zzbev.zzfp(this.zzelc));
        k0.put("reason", this.zzelc);
        if (!TextUtils.isEmpty(this.val$message)) {
            k0.put("message", this.val$message);
        }
        this.zzekw.zza("onPrecacheEvent", k0);
    }
}
