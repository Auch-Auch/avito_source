package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import org.json.JSONObject;
public final class zzcga {
    private final Executor zzfmk;
    private final zzdln zzfqn;
    private final zzcih zzfzy;

    public zzcga(zzdln zzdln, Executor executor, zzcih zzcih) {
        this.zzfqn = zzdln;
        this.zzfmk = executor;
        this.zzfzy = zzcih;
    }

    private final void zzk(zzbfq zzbfq) {
        zzbfq.zza("/video", zzagp.zzdej);
        zzbfq.zza("/videoMeta", zzagp.zzdek);
        zzbfq.zza("/precache", new zzbfa());
        zzbfq.zza("/delayPageLoaded", zzagp.zzden);
        zzbfq.zza("/instrument", zzagp.zzdel);
        zzbfq.zza("/log", zzagp.zzdee);
        zzbfq.zza("/videoClicked", zzagp.zzdef);
        zzbfq.zzabe().zzbb(true);
        zzbfq.zza("/click", zzagp.zzdea);
        if (this.zzfqn.zzdrn != null) {
            zzbfq.zzabe().zzbc(true);
            zzbfq.zza("/open", new zzahj(null, null));
        } else {
            zzbfq.zzabe().zzbc(false);
        }
        if (zzp.zzln().zzac(zzbfq.getContext())) {
            zzbfq.zza("/logScionEvent", new zzahh(zzbfq.getContext()));
        }
    }

    public final /* synthetic */ zzdvt zza(String str, String str2, Object obj) throws Exception {
        zzbfq zza = this.zzfzy.zza(zzvj.zzpi(), false);
        zzbbr zzl = zzbbr.zzl(zza);
        zzk(zza);
        if (this.zzfqn.zzdrn != null) {
            zza.zza(zzbhj.zzacw());
        } else {
            zza.zza(zzbhj.zzacv());
        }
        zza.zzabe().zza(new zzbhf(this, zza, zzl) { // from class: com.google.android.gms.internal.ads.zzcgd
            private final zzbfq zzgak;
            private final zzcga zzgby;
            private final zzbbr zzgbz;

            {
                this.zzgby = r1;
                this.zzgak = r2;
                this.zzgbz = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzbhf
            public final void zzak(boolean z) {
                this.zzgby.zza(this.zzgak, this.zzgbz, z);
            }
        });
        zza.zzb(str, str2, null);
        return zzl;
    }

    public final /* synthetic */ void zzb(zzbfq zzbfq, zzbbr zzbbr, boolean z) {
        if (!(this.zzfqn.zzhbt == null || zzbfq.zzzo() == null)) {
            zzbfq.zzzo().zzb(this.zzfqn.zzhbt);
        }
        zzbbr.zzys();
    }

    public final zzdvt<zzbfq> zzn(JSONObject jSONObject) {
        return zzdvl.zzb(zzdvl.zzb(zzdvl.zzaf(null), new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzcgb
            private final zzcga zzgby;

            {
                this.zzgby = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgby.zzr(obj);
            }
        }, this.zzfmk), new zzduv(this, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcfz
            private final JSONObject zzfmf;
            private final zzcga zzgby;

            {
                this.zzgby = r1;
                this.zzfmf = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgby.zza(this.zzfmf, (zzbfq) obj);
            }
        }, this.zzfmk);
    }

    public final zzdvt<zzbfq> zzo(String str, String str2) {
        return zzdvl.zzb(zzdvl.zzaf(null), new zzduv(this, str, str2) { // from class: com.google.android.gms.internal.ads.zzcgc
            private final String zzdft;
            private final String zzdin;
            private final zzcga zzgby;

            {
                this.zzgby = r1;
                this.zzdft = r2;
                this.zzdin = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgby.zza(this.zzdft, this.zzdin, obj);
            }
        }, this.zzfmk);
    }

    public final /* synthetic */ zzdvt zzr(Object obj) throws Exception {
        zzbfq zza = this.zzfzy.zza(zzvj.zzpi(), false);
        zzbbr zzl = zzbbr.zzl(zza);
        zzk(zza);
        zza.zzabe().zza(new zzbhe(zzl) { // from class: com.google.android.gms.internal.ads.zzcge
            private final zzbbr zzenh;

            {
                this.zzenh = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbhe
            public final void zztf() {
                this.zzenh.zzys();
            }
        });
        zza.loadUrl((String) zzwe.zzpu().zzd(zzaat.zzcrm));
        return zzl;
    }

    public final /* synthetic */ void zza(zzbfq zzbfq, zzbbr zzbbr, boolean z) {
        if (z) {
            if (!(this.zzfqn.zzhbt == null || zzbfq.zzzo() == null)) {
                zzbfq.zzzo().zzb(this.zzfqn.zzhbt);
            }
            zzbbr.zzys();
            return;
        }
        zzbbr.setException(new zzcuh(zzdmd.zzhco, "Instream video Web View failed to load."));
    }

    public final /* synthetic */ zzdvt zza(JSONObject jSONObject, zzbfq zzbfq) throws Exception {
        zzbbr zzl = zzbbr.zzl(zzbfq);
        if (this.zzfqn.zzdrn != null) {
            zzbfq.zza(zzbhj.zzacw());
        } else {
            zzbfq.zza(zzbhj.zzacv());
        }
        zzbfq.zzabe().zza(new zzbhf(this, zzbfq, zzl) { // from class: com.google.android.gms.internal.ads.zzcgg
            private final zzbfq zzgak;
            private final zzcga zzgby;
            private final zzbbr zzgbz;

            {
                this.zzgby = r1;
                this.zzgak = r2;
                this.zzgbz = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzbhf
            public final void zzak(boolean z) {
                this.zzgby.zzb(this.zzgak, this.zzgbz, z);
            }
        });
        zzbfq.zza("google.afma.nativeAds.renderVideo", jSONObject);
        return zzl;
    }
}
