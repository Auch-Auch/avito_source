package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
public final class zzbqb<T> {
    private final Executor executor;
    private final zzcnt zzfql;
    private final zzcod zzfqm;
    private final zzdln zzfqn;
    private final zzdpf zzfqo;
    private final zzbld zzfqp;
    private final zzcuk<T> zzfqq;
    private final zzbwx zzfqr;
    @Nullable
    private final zzdlj zzfqs;
    private final zzcoz zzfqt;
    private final zzbrz zzfqu;
    private final zzcow zzfqv;

    public zzbqb(zzcnt zzcnt, zzcod zzcod, zzdln zzdln, zzdpf zzdpf, zzbld zzbld, zzcuk<T> zzcuk, zzbwx zzbwx, @Nullable zzdlj zzdlj, zzcoz zzcoz, zzbrz zzbrz, Executor executor2, zzcow zzcow) {
        this.zzfql = zzcnt;
        this.zzfqm = zzcod;
        this.zzfqn = zzdln;
        this.zzfqo = zzdpf;
        this.zzfqp = zzbld;
        this.zzfqq = zzcuk;
        this.zzfqr = zzbwx;
        this.zzfqs = zzdlj;
        this.zzfqt = zzcoz;
        this.zzfqu = zzbrz;
        this.executor = executor2;
        this.zzfqv = zzcow;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.ads.zzaap */
    /* JADX WARN: Multi-variable type inference failed */
    private final zzdvt<zzdlj> zza(zzdvt<zzasp> zzdvt) {
        if (this.zzfqs != null) {
            return this.zzfqo.zzu(zzdpg.SERVER_TRANSACTION).zze(zzdvl.zzaf(this.zzfqs)).zzauz();
        }
        zzp.zzkv().zzmt();
        if (this.zzfqn.zzhbu.zzchi != null) {
            return this.zzfqo.zzu(zzdpg.SERVER_TRANSACTION).zze(this.zzfqm.zzapk()).zzauz();
        }
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcxu)).booleanValue()) {
            return this.zzfqo.zza((zzdpf) zzdpg.SERVER_TRANSACTION, (zzdvt) zzdvt).zza(this.zzfql).zzauz();
        }
        zzdox zza = this.zzfqo.zza((zzdpf) zzdpg.SERVER_TRANSACTION, (zzdvt) zzdvt);
        zzcow zzcow = this.zzfqv;
        zzcow.getClass();
        return zza.zza(zzbqe.zza(zzcow)).zzauz();
    }

    public final zzdvt<zzdlj> zzaiu() {
        return zza(this.zzfqu.zzajd());
    }

    public final zzdvt<T> zzaiv() {
        return zzb(zzaiu());
    }

    public final zzbwx zzaiw() {
        return this.zzfqr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.ads.zzaap */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.google.android.gms.internal.ads.zzaap */
    /* JADX WARN: Multi-variable type inference failed */
    public final zzdvt<T> zzb(zzdvt<zzdlj> zzdvt) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcun)).booleanValue()) {
            return this.zzfqo.zza((zzdpf) zzdpg.RENDERER, (zzdvt) zzdvt).zza(this.zzfqp).zza(this.zzfqq).zzauz();
        }
        return this.zzfqo.zza((zzdpf) zzdpg.RENDERER, (zzdvt) zzdvt).zza(this.zzfqp).zza(this.zzfqq).zza((long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcuo)).intValue(), TimeUnit.SECONDS).zzauz();
    }

    public final zzdvt<Void> zzc(zzasp zzasp) {
        zzdos zzauz = this.zzfqo.zza((zzdpf) zzdpg.NOTIFY_CACHE_HIT, (zzdvt) this.zzfqt.zzm(zzasp)).zzauz();
        zzdvl.zza(zzauz, new zzbqf(this), this.executor);
        return zzauz;
    }

    public final zzdvt<T> zzb(@NonNull zzasp zzasp) {
        return zzb(zza(zzasp));
    }

    public final zzdvt<zzdlj> zza(@NonNull zzasp zzasp) {
        return zza(zzdvl.zzaf(zzasp));
    }

    public final zzdvt<zzasp> zza(zzdnd zzdnd) {
        zzdos zzauz = this.zzfqo.zza((zzdpf) zzdpg.GET_CACHE_KEY, (zzdvt) this.zzfqu.zzajd()).zza(new zzduv(this, zzdnd) { // from class: com.google.android.gms.internal.ads.zzbqd
            private final zzbqb zzfqw;
            private final zzdnd zzfqx;

            {
                this.zzfqw = r1;
                this.zzfqx = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzfqw.zza(this.zzfqx, (zzasp) obj);
            }
        }).zzauz();
        zzdvl.zza(zzauz, new zzbqg(this), this.executor);
        return zzauz;
    }

    public final /* synthetic */ zzdvt zza(zzdnd zzdnd, zzasp zzasp) throws Exception {
        zzasp.zzdtg = zzdnd;
        return this.zzfqt.zzl(zzasp);
    }
}
