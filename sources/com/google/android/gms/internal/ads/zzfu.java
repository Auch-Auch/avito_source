package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.Callable;
public final class zzfu implements Callable {
    private final zzcf.zza.C0192zza zzabc;
    private final zzex zzwg;

    public zzfu(zzex zzex, zzcf.zza.C0192zza zza) {
        this.zzwg = zzex;
        this.zzabc = zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcy */
    public final Void call() throws Exception {
        if (this.zzwg.zzcp() != null) {
            this.zzwg.zzcp().get();
        }
        zzcf.zza zzco = this.zzwg.zzco();
        if (zzco == null) {
            return null;
        }
        try {
            synchronized (this.zzabc) {
                zzcf.zza.C0192zza zza = this.zzabc;
                byte[] byteArray = zzco.toByteArray();
                zza.zza(byteArray, 0, byteArray.length, zzegc.zzbey());
            }
            return null;
        } catch (zzegz unused) {
            return null;
        }
    }
}
