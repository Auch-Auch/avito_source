package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpd;
import com.google.android.gms.internal.ads.zzbse;
import com.google.android.gms.internal.ads.zztw;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
public final class zzdid<R extends zzbse<AdT>, AdT extends zzbpd> implements zzdiz<R, AdT> {
    private final Executor executor;
    private final zzdiz<R, AdT> zzgwx;
    private final zzdiz<R, zzdim<AdT>> zzgyi;
    private final zzdnp<AdT> zzgyj;
    @GuardedBy("this")
    private R zzgyk;

    public zzdid(zzdiz<R, AdT> zzdiz, zzdiz<R, zzdim<AdT>> zzdiz2, zzdnp<AdT> zzdnp, Executor executor2) {
        this.zzgwx = zzdiz;
        this.zzgyi = zzdiz2;
        this.zzgyj = zzdnp;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzasc */
    public final synchronized R zzasb() {
        return this.zzgyk;
    }

    @Override // com.google.android.gms.internal.ads.zzdiz
    public final synchronized zzdvt<AdT> zza(zzdja zzdja, zzdjb<R> zzdjb) {
        zzdln zzafj;
        zzafj = zzdjb.zzc(zzdja.zzgzc).zzael().zzafj();
        return zzdvc.zzg(this.zzgyi.zza(zzdja, zzdjb)).zzb(new zzduv(this, zzdja, new zzdig(zzdjb, zzdja, zzafj.zzhbu, zzafj.zzhbv, this.executor, zzafj.zzhby, null), zzdjb) { // from class: com.google.android.gms.internal.ads.zzdic
            private final zzdid zzgye;
            private final zzdja zzgyf;
            private final zzdig zzgyg;
            private final zzdjb zzgyh;

            {
                this.zzgye = r1;
                this.zzgyf = r2;
                this.zzgyg = r3;
                this.zzgyh = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgye.zza(this.zzgyf, this.zzgyg, this.zzgyh, (zzdim) obj);
            }
        }, this.executor);
    }

    private final zzdvt<AdT> zza(zzdnh<AdT> zzdnh, zzdja zzdja, zzdjb<R> zzdjb) {
        zzbsd<R> zzc = zzdjb.zzc(zzdja.zzgzc);
        if (zzdnh.zzhfi != null) {
            R zzael = zzc.zzael();
            if (zzael.zzafk() != null) {
                zzdnh.zzhfi.zzain().zzb(zzael.zzafk());
            }
            return zzdvl.zzaf(zzdnh.zzhfi);
        }
        zzc.zza(zzdnh.zzeua);
        zzdvt<AdT> zza = this.zzgwx.zza(zzdja, new zzdjb(zzc) { // from class: com.google.android.gms.internal.ads.zzdif
            private final zzbsd zzgym;

            {
                this.zzgym = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdjb
            public final zzbsd zzc(zzdiy zzdiy) {
                return this.zzgym;
            }
        });
        this.zzgyk = this.zzgwx.zzasb();
        return zza;
    }

    public final /* synthetic */ zzdvt zza(zzdjb zzdjb, zzdnt zzdnt) throws Exception {
        zzdnv zzdnv;
        if (zzdnt == null || zzdnt.zzgyw == null || (zzdnv = zzdnt.zzhfx) == null) {
            throw new zzcmt(zzdmd.zzhco, "Empty prefetch");
        }
        zzdnt.zzgyw.zzhfh.zzaiw().zze((zztw.zzb) ((zzegp) zztw.zzb.zzng().zza(zztw.zzb.zza.zzne().zzb(zztw.zzb.zzc.IN_MEMORY).zza(zztw.zzb.zzd.zzni())).zzbfx()));
        return zza(zzdnt.zzgyw, ((zzdig) zzdnv).zzgyo, zzdjb);
    }

    public final /* synthetic */ zzdvt zza(zzdja zzdja, zzdig zzdig, zzdjb zzdjb, zzdim zzdim) throws Exception {
        if (zzdim != null) {
            zzdig zzdig2 = new zzdig(zzdig.zzgyn, zzdig.zzgyo, zzdig.zzdpw, zzdig.zzbuo, zzdig.executor, zzdig.zzgsx, zzdim.zzgyp);
            if (zzdim.zzgyw != null) {
                this.zzgyk = null;
                this.zzgyj.zzb(zzdig2);
                return zza(zzdim.zzgyw, zzdja, zzdjb);
            }
            zzdvt<zzdnt<AdT>> zzc = this.zzgyj.zzc(zzdig2);
            if (zzc != null) {
                this.zzgyk = (R) ((zzbse) zzdjb.zzc(zzdja.zzgzc).zzael());
                return zzdvl.zzb(zzc, new zzduv(this, zzdjb) { // from class: com.google.android.gms.internal.ads.zzdie
                    private final zzdid zzgye;
                    private final zzdjb zzgyl;

                    {
                        this.zzgye = r1;
                        this.zzgyl = r2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzduv
                    public final zzdvt zzf(Object obj) {
                        return this.zzgye.zza(this.zzgyl, (zzdnt) obj);
                    }
                }, this.executor);
            }
            this.zzgyj.zzb(zzdig2);
            zzdja = new zzdja(zzdja.zzgzc, zzdim.zzgid);
        }
        zzdvt<AdT> zza = this.zzgwx.zza(zzdja, zzdjb);
        this.zzgyk = this.zzgwx.zzasb();
        return zza;
    }
}
