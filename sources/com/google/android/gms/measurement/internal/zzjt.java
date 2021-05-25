package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjx;
public final class zzjt<T extends Context & zzjx> {
    private final T zza;

    public zzjt(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    @MainThread
    public final void zza() {
        zzgd zza2 = zzgd.zza(this.zza, null, null);
        zzez zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void zzb() {
        zzgd zza2 = zzgd.zza(this.zza, null, null);
        zzez zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
            return;
        }
        zzc().zzx().zza("onRebind called. action", intent.getAction());
    }

    private final zzez zzc() {
        return zzgd.zza(this.zza, null, null).zzr();
    }

    @MainThread
    public final int zza(Intent intent, int i, int i2) {
        zzgd zza2 = zzgd.zza(this.zza, null, null);
        zzez zzr = zza2.zzr();
        if (intent == null) {
            zzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new Runnable(this, i2, zzr, intent) { // from class: com.google.android.gms.measurement.internal.zzjs
                private final zzjt zza;
                private final int zzb;
                private final zzez zzc;
                private final Intent zzd;

                {
                    this.zza = r1;
                    this.zzb = r2;
                    this.zzc = r3;
                    this.zzd = r4;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc, this.zzd);
                }
            });
        }
        return 2;
    }

    @MainThread
    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    private final void zza(Runnable runnable) {
        zzkk zza2 = zzkk.zza(this.zza);
        zza2.zzq().zza(new zzju(this, zza2, runnable));
    }

    @MainThread
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzge(zzkk.zza(this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    @TargetApi(24)
    @MainThread
    public final boolean zza(JobParameters jobParameters) {
        zzgd zza2 = zzgd.zza(this.zza, null, null);
        zzez zzr = zza2.zzr();
        String string = jobParameters.getExtras().getString("action");
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(new Runnable(this, zzr, jobParameters) { // from class: com.google.android.gms.measurement.internal.zzjv
            private final zzjt zza;
            private final zzez zzb;
            private final JobParameters zzc;

            {
                this.zza = r1;
                this.zzb = r2;
                this.zzc = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc);
            }
        });
        return true;
    }

    public final /* synthetic */ void zza(zzez zzez, JobParameters jobParameters) {
        zzez.zzx().zza("AppMeasurementJobService processed last upload request.");
        this.zza.zza(jobParameters, false);
    }

    public final /* synthetic */ void zza(int i, zzez zzez, Intent intent) {
        if (this.zza.zza(i)) {
            zzez.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            this.zza.zza(intent);
        }
    }
}
