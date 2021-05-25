package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;
@ParametersAreNonnullByDefault
public final class zzajz implements zzajs, zzajx {
    private final zzbfq zzdgc;
    private final Context zzvr;

    public zzajz(Context context, zzbbg zzbbg, @Nullable zzeg zzeg, zzb zzb) throws zzbgc {
        this.zzvr = context;
        zzp.zzkq();
        zzbfq zza = zzbfy.zza(context, zzbhj.zzacu(), "", false, false, zzeg, null, zzbbg, null, null, null, zzto.zzmy(), null, false);
        this.zzdgc = zza;
        zza.getView().setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzwe.zzpq();
        if (zzbat.zzyn()) {
            runnable.run();
        } else {
            zzayh.zzeaj.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void destroy() {
        this.zzdgc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final boolean isDestroyed() {
        return this.zzdgc.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zza(String str, zzahf<? super zzali> zzahf) {
        this.zzdgc.zza(str, new zzaki(this, zzahf));
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void zza(String str, Map map) {
        zzajr.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzb(String str, zzahf<? super zzali> zzahf) {
        this.zzdgc.zza(str, new Predicate(zzahf) { // from class: com.google.android.gms.internal.ads.zzakb
            private final zzahf zzdgd;

            {
                this.zzdgd = r1;
            }

            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzahf zzahf2 = (zzahf) obj;
                return (zzahf2 instanceof zzaki) && zzaki.zza((zzaki) zzahf2).equals(this.zzdgd);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajs, com.google.android.gms.internal.ads.zzajk
    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zzcz(String str) {
        runOnUiThread(new zzakd(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zzda(String str) {
        runOnUiThread(new zzakg(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zzdb(String str) {
        runOnUiThread(new zzakf(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzajs, com.google.android.gms.internal.ads.zzakh
    public final void zzdc(String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzakc
            private final String zzdft;
            private final zzajz zzdge;

            {
                this.zzdge = r1;
                this.zzdft = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdge.zzdh(this.zzdft);
            }
        });
    }

    public final /* synthetic */ void zzdh(String str) {
        this.zzdgc.zzdc(str);
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final void zzj(String str, String str2) {
        zzajr.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final zzalh zztd() {
        return new zzalk(this);
    }

    @Override // com.google.android.gms.internal.ads.zzajx
    public final void zza(zzaka zzaka) {
        zzbhc zzabe = this.zzdgc.zzabe();
        zzaka.getClass();
        zzabe.zza(zzake.zzb(zzaka));
    }
}
