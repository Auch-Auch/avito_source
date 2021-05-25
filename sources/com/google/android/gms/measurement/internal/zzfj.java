package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
public class zzfj extends BroadcastReceiver {
    @VisibleForTesting
    private static final String zza = zzfj.class.getName();
    private final zzkk zzb;
    private boolean zzc;
    private boolean zzd;

    public zzfj(zzkk zzkk) {
        Preconditions.checkNotNull(zzkk);
        this.zzb = zzkk;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.zzb.zzk();
        String action = intent.getAction();
        this.zzb.zzr().zzx().zza("NetworkBroadcastReceiver received action", action);
        if (NetworkChangeReceiver.CONNECTIVITY_ACTION.equals(action)) {
            boolean zzf = this.zzb.zzd().zzf();
            if (this.zzd != zzf) {
                this.zzd = zzf;
                this.zzb.zzq().zza(new zzfi(this, zzf));
                return;
            }
            return;
        }
        this.zzb.zzr().zzi().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public final void zza() {
        this.zzb.zzk();
        this.zzb.zzq().zzd();
        if (!this.zzc) {
            this.zzb.zzn().registerReceiver(this, new IntentFilter(NetworkChangeReceiver.CONNECTIVITY_ACTION));
            this.zzd = this.zzb.zzd().zzf();
            this.zzb.zzr().zzx().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    @WorkerThread
    public final void zzb() {
        this.zzb.zzk();
        this.zzb.zzq().zzd();
        this.zzb.zzq().zzd();
        if (this.zzc) {
            this.zzb.zzr().zzx().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzn().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzr().zzf().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
