package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
public final class zzcng implements zzelo<zzdvt<String>> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdpf> zzfow;

    private zzcng(zzelx<zzdpf> zzelx, zzelx<Context> zzelx2) {
        this.zzfow = zzelx;
        this.zzert = zzelx2;
    }

    public static zzcng zzap(zzelx<zzdpf> zzelx, zzelx<Context> zzelx2) {
        return new zzcng(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzdvt) zzelu.zza(this.zzfow.get().zzu(zzdpg.WEBVIEW_COOKIE).zzc(new Callable(zzp.zzkr().zzbg(this.zzert.get())) { // from class: com.google.android.gms.internal.ads.zzcnc
            private final CookieManager zzghh;

            {
                this.zzghh = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = this.zzghh;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) zzwe.zzpu().zzd(zzaat.zzcny));
            }
        }).zza(1, TimeUnit.SECONDS).zza(Exception.class, zzcnb.zzghg).zzauz(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
