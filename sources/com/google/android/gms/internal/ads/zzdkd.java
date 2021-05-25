package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbxj;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
public final class zzdkd implements zzcxy<zzchu> {
    private final Executor zzfmk;
    private final zzdli zzfsl;
    @GuardedBy("this")
    private final zzdlp zzgps;
    private final zzbii zzgrp;
    private final Context zzgwv;
    private final zzdiz<zzchx, zzchu> zzgwx;
    private final zzdje zzgzn;
    @GuardedBy("this")
    private zzdvt<zzchu> zzgzo;

    public zzdkd(Context context, Executor executor, zzbii zzbii, zzdiz<zzchx, zzchu> zzdiz, zzdje zzdje, zzdlp zzdlp, zzdli zzdli) {
        this.zzgwv = context;
        this.zzfmk = executor;
        this.zzgrp = zzbii;
        this.zzgwx = zzdiz;
        this.zzgzn = zzdje;
        this.zzgps = zzdlp;
        this.zzfsl = zzdli;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzcia zze(zzdiy zzdiy) {
        zzdkj zzdkj = (zzdkj) zzdiy;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxq)).booleanValue()) {
            return this.zzgrp.zzadv().zze(new zzbsg.zza().zzcd(this.zzgwv).zza(zzdkj.zzfqn).zzfx(zzdkj.zzgzl).zza(this.zzfsl).zzajj()).zze(new zzbxj.zza().zzake());
        }
        zzdje zzb = zzdje.zzb(this.zzgzn);
        return this.zzgrp.zzadv().zze(new zzbsg.zza().zzcd(this.zzgwv).zza(zzdkj.zzfqn).zzfx(zzdkj.zzgzl).zza(this.zzfsl).zzajj()).zze(new zzbxj.zza().zza((zzbsu) zzb, this.zzfmk).zza((zzbuj) zzb, this.zzfmk).zza((zzbsz) zzb, this.zzfmk).zza((AdMetadataListener) zzb, this.zzfmk).zza((zzbti) zzb, this.zzfmk).zza((zzbuy) zzb, this.zzfmk).zza(zzb).zzake());
    }

    @Override // com.google.android.gms.internal.ads.zzcxy
    public final boolean isLoading() {
        zzdvt<zzchu> zzdvt = this.zzgzo;
        return zzdvt != null && !zzdvt.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzcxy
    public final boolean zza(zzvc zzvc, String str, zzcxx zzcxx, zzcya<? super zzchu> zzcya) throws RemoteException {
        zzatz zzatz = new zzatz(zzvc, str);
        String str2 = zzcxx instanceof zzdka ? ((zzdka) zzcxx).zzgzl : null;
        if (zzatz.zzbuo == null) {
            zzbbd.zzfc("Ad unit ID should not be null for rewarded video ad.");
            this.zzfmk.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdkc
                private final zzdkd zzgzm;

                {
                    this.zzgzm = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgzm.zzasi();
                }
            });
            return false;
        }
        zzdvt<zzchu> zzdvt = this.zzgzo;
        if (zzdvt != null && !zzdvt.isDone()) {
            return false;
        }
        zzdly.zze(this.zzgwv, zzatz.zzdpw.zzcgy);
        zzdln zzasu = this.zzgps.zzgt(zzatz.zzbuo).zze(zzvj.zzpj()).zzh(zzatz.zzdpw).zzasu();
        zzdkj zzdkj = new zzdkj(null);
        zzdkj.zzfqn = zzasu;
        zzdkj.zzgzl = str2;
        zzdvt<zzchu> zza = this.zzgwx.zza(new zzdja(zzdkj), new zzdjb(this) { // from class: com.google.android.gms.internal.ads.zzdkf
            private final zzdkd zzgzm;

            {
                this.zzgzm = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdjb
            public final zzbsd zzc(zzdiy zzdiy) {
                return this.zzgzm.zze(zzdiy);
            }
        });
        this.zzgzo = zza;
        zzdvl.zza(zza, new zzdke(this, zzcya, zzdkj), this.zzfmk);
        return true;
    }

    public final /* synthetic */ void zzasi() {
        this.zzgzn.zzg(zzdmb.zza(zzdmd.zzhct, null, null));
    }

    public final void zzea(int i) {
        this.zzgps.zzast().zzeb(i);
    }
}
