package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;
public final class zzg extends GmsClientSupervisor {
    @GuardedBy("connectionStatus")
    private final HashMap<GmsClientSupervisor.zza, zzi> zza = new HashMap<>();
    private final Context zzb;
    private final Handler zzc;
    private final ConnectionTracker zzd;
    private final long zze;
    private final long zzf;

    public zzg(Context context) {
        this.zzb = context.getApplicationContext();
        this.zzc = new zzi(context.getMainLooper(), new zzh(this));
        this.zzd = ConnectionTracker.getInstance();
        this.zze = 5000;
        this.zzf = 300000;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zza(GmsClientSupervisor.zza zza2, ServiceConnection serviceConnection, String str) {
        boolean zza3;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zza) {
            zzi zzi = this.zza.get(zza2);
            if (zzi == null) {
                zzi = new zzi(this, zza2);
                zzi.zza(serviceConnection, serviceConnection, str);
                zzi.zza(str);
                this.zza.put(zza2, zzi);
            } else {
                this.zzc.removeMessages(0, zza2);
                if (!zzi.zza(serviceConnection)) {
                    zzi.zza(serviceConnection, serviceConnection, str);
                    int zzb2 = zzi.zzb();
                    if (zzb2 == 1) {
                        serviceConnection.onServiceConnected(zzi.zze(), zzi.zzd());
                    } else if (zzb2 == 2) {
                        zzi.zza(str);
                    }
                } else {
                    String valueOf = String.valueOf(zza2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            zza3 = zzi.zza();
        }
        return zza3;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zzb(GmsClientSupervisor.zza zza2, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zza) {
            zzi zzi = this.zza.get(zza2);
            if (zzi == null) {
                String valueOf = String.valueOf(zza2);
                StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (zzi.zza(serviceConnection)) {
                zzi.zza(serviceConnection, str);
                if (zzi.zzc()) {
                    this.zzc.sendMessageDelayed(this.zzc.obtainMessage(0, zza2), this.zze);
                }
            } else {
                String valueOf2 = String.valueOf(zza2);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
