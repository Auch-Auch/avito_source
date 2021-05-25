package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
public final class zzdql implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzgib = false;
    private boolean zzgic = false;
    private final zzdrf zzhjg;
    private final zzdra zzhjh;

    public zzdql(@NonNull Context context, @NonNull Looper looper, @NonNull zzdra zzdra) {
        this.zzhjh = zzdra;
        this.zzhjg = new zzdrf(context, looper, this, this, 12800000);
    }

    private final void zzapl() {
        synchronized (this.lock) {
            if (this.zzhjg.isConnected() || this.zzhjg.isConnecting()) {
                this.zzhjg.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.lock) {
            if (!this.zzgic) {
                this.zzgic = true;
                try {
                    this.zzhjg.zzavt().zza(new zzdrd(this.zzhjh.toByteArray()));
                } catch (Exception unused) {
                } finally {
                    zzapl();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    public final void zzavh() {
        synchronized (this.lock) {
            if (!this.zzgib) {
                this.zzgib = true;
                this.zzhjg.checkAvailabilityAndConnect();
            }
        }
    }
}
