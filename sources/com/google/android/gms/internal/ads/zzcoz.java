package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
public final class zzcoz {
    private final zzdvw zzgay;
    private final zzeli<zzcpj> zzghc;
    private final zzcoq zzgit;

    public zzcoz(zzdvw zzdvw, zzcoq zzcoq, zzeli<zzcpj> zzeli) {
        this.zzgay = zzdvw;
        this.zzgit = zzcoq;
        this.zzghc = zzeli;
    }

    private final <RetT> zzdvt<RetT> zza(zzasp zzasp, zzcpk<InputStream> zzcpk, zzcpk<InputStream> zzcpk2, zzduv<InputStream, RetT> zzduv) {
        zzdvt zzdvt;
        String str = zzasp.packageName;
        zzp.zzkp();
        if (zzayh.zzer(str)) {
            zzdvt = zzdvl.immediateFailedFuture(new zzcpa(zzdmd.zzhco));
        } else {
            zzdvt = zzdvl.zzb(zzcpk.zzq(zzasp), ExecutionException.class, zzcpc.zzbok, this.zzgay);
        }
        return zzdvc.zzg(zzdvt).zzb(zzduv, this.zzgay).zza(zzcpa.class, new zzduv(this, zzcpk2, zzasp, zzduv) { // from class: com.google.android.gms.internal.ads.zzcpb
            private final zzcoz zzgiu;
            private final zzcpk zzgiv;
            private final zzasp zzgiw;
            private final zzduv zzgix;

            {
                this.zzgiu = r1;
                this.zzgiv = r2;
                this.zzgiw = r3;
                this.zzgix = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgiu.zza(this.zzgiv, this.zzgiw, this.zzgix, (zzcpa) obj);
            }
        }, this.zzgay);
    }

    public final zzdvt<zzasp> zzl(zzasp zzasp) {
        zzcpe zzcpe = new zzduv(zzasp) { // from class: com.google.android.gms.internal.ads.zzcpe
            private final zzasp zzftf;

            {
                this.zzftf = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                zzasp zzasp2 = this.zzftf;
                zzasp2.zzdth = new String(zzdud.toByteArray((InputStream) obj), zzdsj.UTF_8);
                return zzdvl.zzaf(zzasp2);
            }
        };
        zzcoq zzcoq = this.zzgit;
        zzcoq.getClass();
        return zza(zzasp, zzcpd.zza(zzcoq), new zzcpk(this) { // from class: com.google.android.gms.internal.ads.zzcpg
            private final zzcoz zzgiu;

            {
                this.zzgiu = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzcpk
            public final zzdvt zzq(zzasp zzasp2) {
                return this.zzgiu.zzp(zzasp2);
            }
        }, zzcpe);
    }

    public final zzdvt<Void> zzm(zzasp zzasp) {
        if (zzfg.zzas(zzasp.zzdth)) {
            return zzdvl.immediateFailedFuture(new zzcmt(zzdmd.zzhcp, "Pool key missing from removeUrl call."));
        }
        return zza(zzasp, new zzcpk(this) { // from class: com.google.android.gms.internal.ads.zzcpi
            private final zzcoz zzgiu;

            {
                this.zzgiu = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzcpk
            public final zzdvt zzq(zzasp zzasp2) {
                return this.zzgiu.zzo(zzasp2);
            }
        }, new zzcpk(this) { // from class: com.google.android.gms.internal.ads.zzcph
            private final zzcoz zzgiu;

            {
                this.zzgiu = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzcpk
            public final zzdvt zzq(zzasp zzasp2) {
                return this.zzgiu.zzn(zzasp2);
            }
        }, zzcpf.zzbok);
    }

    public final /* synthetic */ zzdvt zzn(zzasp zzasp) {
        return this.zzghc.get().zzgn(zzasp.zzdth);
    }

    public final /* synthetic */ zzdvt zzo(zzasp zzasp) {
        return this.zzgit.zzgm(zzasp.zzdth);
    }

    public final /* synthetic */ zzdvt zzp(zzasp zzasp) {
        return this.zzghc.get().zzc(zzasp, Binder.getCallingUid());
    }

    public final /* synthetic */ zzdvt zza(zzcpk zzcpk, zzasp zzasp, zzduv zzduv, zzcpa zzcpa) throws Exception {
        return zzdvl.zzb(zzcpk.zzq(zzasp), zzduv, this.zzgay);
    }
}
