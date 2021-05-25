package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
public final class zzboo extends zzbni {
    private final Executor zzfmk;
    private final zzafq zzfpa;
    private final Runnable zzfpb;

    public zzboo(zzbpg zzbpg, zzafq zzafq, Runnable runnable, Executor executor) {
        super(zzbpg);
        this.zzfpa = zzafq;
        this.zzfpb = runnable;
        this.zzfmk = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final zzyg getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final void zza(ViewGroup viewGroup, zzvj zzvj) {
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final zzdkw zzahp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final View zzahq() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final zzdkw zzahu() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final int zzahv() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    @WorkerThread
    public final void zzahw() {
        this.zzfmk.execute(new Runnable(this, new Runnable(new AtomicReference(this.zzfpb)) { // from class: com.google.android.gms.internal.ads.zzbon
            private final AtomicReference zzfoz;

            {
                this.zzfoz = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable = (Runnable) this.zzfoz.getAndSet(null);
                if (runnable != null) {
                    runnable.run();
                }
            }
        }) { // from class: com.google.android.gms.internal.ads.zzboq
            private final Runnable zzfkq;
            private final zzboo zzfpc;

            {
                this.zzfpc = r1;
                this.zzfkq = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfpc.zze(this.zzfkq);
            }
        });
    }

    public final /* synthetic */ void zze(Runnable runnable) {
        try {
            if (!this.zzfpa.zzm(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final void zzkd() {
    }
}
