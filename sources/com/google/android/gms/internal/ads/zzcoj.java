package com.google.android.gms.internal.ads;

import android.os.Binder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;
public abstract class zzcoj implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    public final Object mLock = new Object();
    public final zzbbq<InputStream> zzdih = new zzbbq<>();
    public boolean zzgib = false;
    public boolean zzgic = false;
    public zzasp zzgid;
    @GuardedBy("mLock")
    @VisibleForTesting(otherwise = 3)
    public zzarx zzgie;

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzbbd.zzef("Disconnected from remote ad request service.");
        this.zzdih.setException(new zzcpa(zzdmd.zzhco));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzbbd.zzef("Cannot connect to remote service, fallback to local instance.");
    }

    public final void zzapl() {
        synchronized (this.mLock) {
            this.zzgic = true;
            if (this.zzgie.isConnected() || this.zzgie.isConnecting()) {
                this.zzgie.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
