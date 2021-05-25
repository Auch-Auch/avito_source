package com.google.android.gms.tasks;

import java.util.concurrent.Callable;
public final class zzy implements Runnable {
    private final /* synthetic */ zzu zza;
    private final /* synthetic */ Callable zzb;

    public zzy(zzu zzu, Callable callable) {
        this.zza = zzu;
        this.zzb = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.zza((zzu) this.zzb.call());
        } catch (Exception e) {
            this.zza.zza(e);
        } catch (Throwable th) {
            this.zza.zza((Exception) new RuntimeException(th));
        }
    }
}
