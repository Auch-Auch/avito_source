package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
public final class zzdqo {
    private final Executor executor;
    private final zzdqu zzhjk;
    private final zzdqu zzhjl;
    private Task<zzcf.zza> zzhjm;
    private Task<zzcf.zza> zzhjn;
    private final Context zzvr;
    private final zzdpy zzvw;
    private final zzdqc zzyr;

    @VisibleForTesting
    private zzdqo(Context context, Executor executor2, zzdpy zzdpy, zzdqc zzdqc, zzdqs zzdqs, zzdqr zzdqr) {
        this.zzvr = context;
        this.executor = executor2;
        this.zzvw = zzdpy;
        this.zzyr = zzdqc;
        this.zzhjk = zzdqs;
        this.zzhjl = zzdqr;
    }

    public static zzdqo zza(@NonNull Context context, @NonNull Executor executor2, @NonNull zzdpy zzdpy, @NonNull zzdqc zzdqc) {
        zzdqo zzdqo = new zzdqo(context, executor2, zzdpy, zzdqc, new zzdqs(), new zzdqr());
        if (zzdqo.zzyr.zzavc()) {
            zzdqo.zzhjm = zzdqo.zzd(new Callable(zzdqo) { // from class: com.google.android.gms.internal.ads.zzdqn
                private final zzdqo zzhjj;

                {
                    this.zzhjj = r1;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzhjj.zzavk();
                }
            });
        } else {
            zzdqo.zzhjm = Tasks.forResult(zzdqo.zzhjk.zzavl());
        }
        zzdqo.zzhjn = zzdqo.zzd(new Callable(zzdqo) { // from class: com.google.android.gms.internal.ads.zzdqq
            private final zzdqo zzhjj;

            {
                this.zzhjj = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhjj.zzavj();
            }
        });
        return zzdqo;
    }

    private final Task<zzcf.zza> zzd(@NonNull Callable<zzcf.zza> callable) {
        return Tasks.call(this.executor, callable).addOnFailureListener(this.executor, new OnFailureListener(this) { // from class: com.google.android.gms.internal.ads.zzdqp
            private final zzdqo zzhjj;

            {
                this.zzhjj = r1;
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zzhjj.zzc(exc);
            }
        });
    }

    public final zzcf.zza zzavi() {
        return zza(this.zzhjm, this.zzhjk.zzavl());
    }

    public final /* synthetic */ zzcf.zza zzavj() throws Exception {
        return this.zzhjl.zzcj(this.zzvr);
    }

    public final /* synthetic */ zzcf.zza zzavk() throws Exception {
        return this.zzhjk.zzcj(this.zzvr);
    }

    public final /* synthetic */ void zzc(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzvw.zza(2025, -1, exc);
    }

    public final zzcf.zza zzco() {
        return zza(this.zzhjn, this.zzhjl.zzavl());
    }

    private static zzcf.zza zza(@NonNull Task<zzcf.zza> task, @NonNull zzcf.zza zza) {
        if (!task.isSuccessful()) {
            return zza;
        }
        return task.getResult();
    }
}
