package com.google.android.gms.tasks;
public final class zzg implements Runnable {
    private final /* synthetic */ zzh zza;

    public zzg(zzh zzh) {
        this.zza = zzh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzb) {
            if (this.zza.zzc != null) {
                this.zza.zzc.onCanceled();
            }
        }
    }
}
