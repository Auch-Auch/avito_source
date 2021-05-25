package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
public final class zzf implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzd zzb;

    public zzf(zzd zzd, Task task) {
        this.zzb = zzd;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task task = (Task) zzd.zza(this.zzb).then(this.zza);
            if (task == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.zza;
            task.addOnSuccessListener(executor, this.zzb);
            task.addOnFailureListener(executor, this.zzb);
            task.addOnCanceledListener(executor, this.zzb);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                zzd.zzb(this.zzb).zza((Exception) e.getCause());
            } else {
                zzd.zzb(this.zzb).zza((Exception) e);
            }
        } catch (Exception e2) {
            zzd.zzb(this.zzb).zza(e2);
        }
    }
}
