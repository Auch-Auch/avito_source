package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdup;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzduz<V> extends zzdup<Object, V> {
    private zzdvb<?> zzhpn;

    public zzduz(zzdtf<? extends zzdvt<?>> zzdtf, boolean z, Executor executor, Callable<V> callable) {
        super(zzdtf, z, false);
        this.zzhpn = new zzduy(this, callable, executor);
        zzaxd();
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final void interruptTask() {
        zzdvb<?> zzdvb = this.zzhpn;
        if (zzdvb != null) {
            zzdvb.interruptTask();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdup
    public final void zza(zzdup.zza zza) {
        super.zza(zza);
        if (zza == zzdup.zza.OUTPUT_FUTURE_DONE) {
            this.zzhpn = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdup
    public final void zzaxe() {
        zzdvb<?> zzdvb = this.zzhpn;
        if (zzdvb != null) {
            zzdvb.execute();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdup
    public final void zzb(int i, @NullableDecl Object obj) {
    }
}
