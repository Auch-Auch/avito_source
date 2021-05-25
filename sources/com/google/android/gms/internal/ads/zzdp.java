package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public final class zzdp implements zzdw {
    @Nullable
    private static zzdp zzvq;
    private final Context zzvr;
    private final zzdrq zzvs;
    private final zzdrv zzvt;
    private final zzdsa zzvu;
    private final zzew zzvv;
    private final zzdpy zzvw;
    private final Executor zzvx;
    private final zzgo zzvy;
    private final zzdrw zzvz;
    @VisibleForTesting
    private volatile long zzwa = 0;
    private final Object zzwb = new Object();
    private volatile boolean zzwc;

    @VisibleForTesting
    private zzdp(@NonNull Context context, @NonNull zzdpy zzdpy, @NonNull zzdrq zzdrq, @NonNull zzdrv zzdrv, @NonNull zzdsa zzdsa, @NonNull zzew zzew, @NonNull Executor executor, @NonNull zzdpx zzdpx, zzgo zzgo) {
        this.zzvr = context;
        this.zzvw = zzdpy;
        this.zzvs = zzdrq;
        this.zzvt = zzdrv;
        this.zzvu = zzdsa;
        this.zzvv = zzew;
        this.zzvx = executor;
        this.zzvy = zzgo;
        this.zzvz = new zzds(this, zzdpx);
    }

    public static synchronized zzdp zza(@NonNull String str, @NonNull Context context, boolean z) {
        zzdp zzdp;
        synchronized (zzdp.class) {
            if (zzvq == null) {
                zzdqc zzava = zzdqc.zzavd().zzhb(str).zzbq(z).zzava();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzdp zza = zza(context, zzdpy.zza(context, newCachedThreadPool), zzava, newCachedThreadPool);
                zzvq = zza;
                zza.zzbq();
                zzvq.zzbt();
            }
            zzdp = zzvq;
        }
        return zzdp;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4 A[Catch:{ zzegz -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1 A[Catch:{ zzegz -> 0x0110 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzbs() {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.zzbs():void");
    }

    private final void zzbt() {
        if (!this.zzwc) {
            synchronized (this.zzwb) {
                if (!this.zzwc) {
                    if ((System.currentTimeMillis() / 1000) - this.zzwa >= 3600) {
                        zzdrn zzawi = this.zzvu.zzawi();
                        if (zzawi == null || zzawi.zzfg(3600)) {
                            zzbr();
                        }
                    }
                }
            }
        }
    }

    private final zzdrn zzp(int i) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcqf)).booleanValue()) {
            return this.zzvt.zzp(i);
        }
        return this.zzvs.zzp(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(int i, int i2, int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zzb(View view) {
        this.zzvv.zzc(view);
    }

    public final synchronized void zzbq() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdrn zzp = zzp(zzdry.zzhkz);
        if (zzp == null || zzp.zza()) {
            this.zzvw.zzg(4013, System.currentTimeMillis() - currentTimeMillis);
        } else {
            this.zzvu.zzb(zzp);
        }
    }

    public final void zzbr() {
        this.zzvx.execute(new zzdr(this));
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zzb(Context context) {
        zzbt();
        zzdqe zzawh = this.zzvu.zzawh();
        if (zzawh == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzv = zzawh.zzv(context, null);
        this.zzvw.zza(5001, System.currentTimeMillis() - currentTimeMillis, zzv, null);
        return zzv;
    }

    public static zzdp zza(@NonNull Context context, @NonNull zzdpy zzdpy, @NonNull zzdqc zzdqc) {
        return zza(context, zzdpy, zzdqc, Executors.newCachedThreadPool());
    }

    private static zzdp zza(@NonNull Context context, @NonNull zzdpy zzdpy, @NonNull zzdqc zzdqc, @NonNull Executor executor) {
        zzdqo zza = zzdqo.zza(context, executor, zzdpy, zzdqc);
        zzev zzev = new zzev(context);
        zzew zzew = new zzew(zzdqc, zza, new zzfi(context, zzev), zzev);
        zzgo zzavs = new zzdre(context, zzdpy).zzavs();
        zzdpx zzdpx = new zzdpx();
        return new zzdp(context, zzdpy, new zzdrq(context, zzavs), new zzdrv(context, zzavs), new zzdsa(context, zzew, zzdpy, zzdpx), zzew, executor, zzdpx, zzavs);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(MotionEvent motionEvent) {
        zzdqe zzawh = this.zzvu.zzawh();
        if (zzawh != null) {
            try {
                zzawh.zza(null, motionEvent);
            } catch (zzdrx e) {
                this.zzvw.zza(e.zzawg(), -1, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view, Activity activity) {
        zzbt();
        zzdqe zzawh = this.zzvu.zzawh();
        if (zzawh == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza = zzawh.zza(context, null, str, view, activity);
        this.zzvw.zza(5000, System.currentTimeMillis() - currentTimeMillis, zza, null);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, View view, Activity activity) {
        zzbt();
        zzdqe zzawh = this.zzvu.zzawh();
        if (zzawh == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb = zzawh.zzb(context, null, view, activity);
        this.zzvw.zza(5002, System.currentTimeMillis() - currentTimeMillis, zzb, null);
        return zzb;
    }
}
