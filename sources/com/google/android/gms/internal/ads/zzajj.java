package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;
@ParametersAreNonnullByDefault
public final class zzajj extends zzajw<zzali> implements zzajs, zzajx {
    private final zzbhx zzdfq;
    private zzaka zzdfr;

    public zzajj(Context context, zzbbg zzbbg) throws zzbgc {
        try {
            zzbhx zzbhx = new zzbhx(context, new zzajp(this));
            this.zzdfq = zzbhx;
            zzbhx.setWillNotDraw(true);
            zzbhx.addJavascriptInterface(new zzajq(this), "GoogleJsInterface");
            zzp.zzkp().zza(context, zzbbg.zzbra, zzbhx.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbgc("Init failed.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void destroy() {
        this.zzdfq.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final boolean isDestroyed() {
        return this.zzdfq.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zza(zzaka zzaka) {
        this.zzdfr = zzaka;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void zza(String str, Map map) {
        zzajr.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajs, com.google.android.gms.internal.ads.zzajk
    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zzcz(String str) {
        zzda(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zzda(String str) {
        zzbbi.zzedy.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzajm
            private final zzajj zzdfs;
            private final String zzdft;

            {
                this.zzdfs = r1;
                this.zzdft = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdfs.zzdf(this.zzdft);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zzdb(String str) {
        zzbbi.zzedy.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzajl
            private final zzajj zzdfs;
            private final String zzdft;

            {
                this.zzdfs = r1;
                this.zzdft = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdfs.zzde(this.zzdft);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajs, com.google.android.gms.internal.ads.zzakh
    public final void zzdc(String str) {
        zzbbi.zzedy.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzajo
            private final zzajj zzdfs;
            private final String zzdft;

            {
                this.zzdfs = r1;
                this.zzdft = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdfs.zzdd(this.zzdft);
            }
        });
    }

    public final /* synthetic */ void zzdd(String str) {
        this.zzdfq.zzdc(str);
    }

    public final /* synthetic */ void zzde(String str) {
        this.zzdfq.loadUrl(str);
    }

    public final /* synthetic */ void zzdf(String str) {
        this.zzdfq.loadData(str, "text/html", "UTF-8");
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final void zzj(String str, String str2) {
        zzajr.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final zzalh zztd() {
        return new zzalk(this);
    }
}
