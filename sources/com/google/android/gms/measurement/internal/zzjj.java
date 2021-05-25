package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
public final class zzjj implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzn zze;
    private final /* synthetic */ zzis zzf;

    public zzjj(zzis zzis, AtomicReference atomicReference, String str, String str2, String str3, zzn zzn) {
        this.zzf = zzis;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                zzer zzer = this.zzf.zzb;
                if (zzer == null) {
                    this.zzf.zzr().zzf().zza("(legacy) Failed to get conditional properties; not connected to service", zzez.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    this.zza.set(zzer.zza(this.zzc, this.zzd, this.zze));
                } else {
                    this.zza.set(zzer.zza(this.zzb, this.zzc, this.zzd));
                }
                this.zzf.zzak();
                this.zza.notify();
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("(legacy) Failed to get conditional properties; remote exception", zzez.zza(this.zzb), this.zzc, e);
                this.zza.set(Collections.emptyList());
            } finally {
                this.zza.notify();
            }
        }
    }
}
