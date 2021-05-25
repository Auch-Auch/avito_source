package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;
public final class zzss {
    private final Object lock = new Object();
    private final Runnable zzbuv = new zzsr(this);
    @Nullable
    @GuardedBy("lock")
    private zzsx zzbuw;
    @Nullable
    @GuardedBy("lock")
    private zztb zzbux;
    @Nullable
    @GuardedBy("lock")
    private Context zzvr;

    /* access modifiers changed from: private */
    public final void connect() {
        synchronized (this.lock) {
            if (this.zzvr != null) {
                if (this.zzbuw == null) {
                    zzsx zza = zza(new zzst(this), new zzsw(this));
                    this.zzbuw = zza;
                    zza.checkAvailabilityAndConnect();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            zzsx zzsx = this.zzbuw;
            if (zzsx != null) {
                if (zzsx.isConnected() || this.zzbuw.isConnecting()) {
                    this.zzbuw.disconnect();
                }
                this.zzbuw = null;
                this.zzbux = null;
                Binder.flushPendingCommands();
            }
        }
    }

    public final void initialize(Context context) {
        if (context != null) {
            synchronized (this.lock) {
                if (this.zzvr == null) {
                    this.zzvr = context.getApplicationContext();
                    if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcsn)).booleanValue()) {
                        connect();
                    } else {
                        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcsm)).booleanValue()) {
                            zzp.zzks().zza(new zzsu(this));
                        }
                    }
                }
            }
        }
    }

    public final zzsv zza(zzta zzta) {
        synchronized (this.lock) {
            zztb zztb = this.zzbux;
            if (zztb == null) {
                return new zzsv();
            }
            try {
                return zztb.zza(zzta);
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call into cache service.", e);
                return new zzsv();
            }
        }
    }

    public final void zzmt() {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcso)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                zzp.zzkp();
                zzdsf zzdsf = zzayh.zzeaj;
                zzdsf.removeCallbacks(this.zzbuv);
                zzp.zzkp();
                zzdsf.postDelayed(this.zzbuv, ((Long) zzwe.zzpu().zzd(zzaat.zzcsp)).longValue());
            }
        }
    }

    @VisibleForTesting
    private final synchronized zzsx zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzsx(this.zzvr, zzp.zzld().zzyf(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }
}
