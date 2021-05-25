package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
public final class zzdox<O> {
    private final E zzhgq;
    @Nullable
    private final String zzhgr;
    private final List<zzdvt<?>> zzhgt;
    public final /* synthetic */ zzdor zzhgu;
    private final zzdvt<?> zzhgv;
    private final zzdvt<O> zzhgw;

    private zzdox(zzdor zzdor, E e, String str, zzdvt<?> zzdvt, List<zzdvt<?>> list, zzdvt<O> zzdvt2) {
        this.zzhgu = zzdor;
        this.zzhgq = e;
        this.zzhgr = str;
        this.zzhgv = zzdvt;
        this.zzhgt = list;
        this.zzhgw = zzdvt2;
    }

    public final <O2> zzdox<O2> zza(zzduv<O, O2> zzduv) {
        return zza(zzduv, this.zzhgu.zzgay);
    }

    public final zzdos<E, O> zzauz() {
        E e = this.zzhgq;
        String str = this.zzhgr;
        if (str == null) {
            str = this.zzhgu.zzv(e);
        }
        zzdos<E, O> zzdos = new zzdos<>(e, str, this.zzhgw);
        this.zzhgu.zzhgp.zza(zzdos);
        zzdvt<?> zzdvt = this.zzhgv;
        zzdpb zzdpb = new Runnable(this, zzdos) { // from class: com.google.android.gms.internal.ads.zzdpb
            private final zzdox zzhgz;
            private final zzdos zzhha;

            {
                this.zzhgz = r1;
                this.zzhha = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzdox zzdox = this.zzhgz;
                zzdox.zzhgu.zzhgp.zzb(this.zzhha);
            }
        };
        zzdvw zzdvw = zzbbi.zzedz;
        zzdvt.addListener(zzdpb, zzdvw);
        zzdvl.zza(zzdos, new zzdpe(this, zzdos), zzdvw);
        return zzdos;
    }

    public final <O2> zzdox<O2> zzb(zzdoq<O, O2> zzdoq) {
        return zza(new zzduv(zzdoq) { // from class: com.google.android.gms.internal.ads.zzdpa
            private final zzdoq zzhgy;

            {
                this.zzhgy = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return zzdvl.zzaf(this.zzhgy.apply(obj));
            }
        });
    }

    public final <O2> zzdox<O2> zze(zzdvt<O2> zzdvt) {
        return zza(new zzduv(zzdvt) { // from class: com.google.android.gms.internal.ads.zzdoz
            private final zzdvt zzgbt;

            {
                this.zzgbt = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgbt;
            }
        }, zzbbi.zzedz);
    }

    public final zzdox<O> zzgx(String str) {
        return new zzdox<>(this.zzhgu, this.zzhgq, str, this.zzhgv, this.zzhgt, this.zzhgw);
    }

    public final zzdox<O> zzw(E e) {
        return this.zzhgu.zza(e, zzauz());
    }

    private final <O2> zzdox<O2> zza(zzduv<O, O2> zzduv, Executor executor) {
        return new zzdox<>(this.zzhgu, this.zzhgq, this.zzhgr, this.zzhgv, this.zzhgt, zzdvl.zzb(this.zzhgw, zzduv, executor));
    }

    public final <T extends Throwable> zzdox<O> zza(Class<T> cls, zzdoq<T, O> zzdoq) {
        return zza(cls, new zzduv(zzdoq) { // from class: com.google.android.gms.internal.ads.zzdpc
            private final zzdoq zzhgy;

            {
                this.zzhgy = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return zzdvl.zzaf(this.zzhgy.apply((Throwable) obj));
            }
        });
    }

    public final <T extends Throwable> zzdox<O> zza(Class<T> cls, zzduv<T, O> zzduv) {
        zzdor zzdor = this.zzhgu;
        return new zzdox<>(zzdor, this.zzhgq, this.zzhgr, this.zzhgv, this.zzhgt, zzdvl.zzb(this.zzhgw, cls, zzduv, zzdor.zzgay));
    }

    public final zzdox<O> zza(long j, TimeUnit timeUnit) {
        zzdor zzdor = this.zzhgu;
        return new zzdox<>(zzdor, this.zzhgq, this.zzhgr, this.zzhgv, this.zzhgt, zzdvl.zza(this.zzhgw, j, timeUnit, zzdor.zzfnh));
    }
}
