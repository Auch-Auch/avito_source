package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@ParametersAreNonnullByDefault
public final class zzrg {
    private final Object zzbsv = new Object();
    @GuardedBy("activityTrackerLock")
    private zzrf zzbsw = null;
    @GuardedBy("activityTrackerLock")
    private boolean zzbsx = false;

    @Nullable
    public final Activity getActivity() {
        synchronized (this.zzbsv) {
            zzrf zzrf = this.zzbsw;
            if (zzrf == null) {
                return null;
            }
            return zzrf.getActivity();
        }
    }

    @Nullable
    public final Context getContext() {
        synchronized (this.zzbsv) {
            zzrf zzrf = this.zzbsw;
            if (zzrf == null) {
                return null;
            }
            return zzrf.getContext();
        }
    }

    public final void initialize(Context context) {
        synchronized (this.zzbsv) {
            if (!this.zzbsx) {
                Application application = null;
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                }
                if (application == null) {
                    zzbbd.zzfe("Can not cast Context to Application");
                    return;
                }
                if (this.zzbsw == null) {
                    this.zzbsw = new zzrf();
                }
                this.zzbsw.zza(application, context);
                this.zzbsx = true;
            }
        }
    }

    public final void zza(zzrh zzrh) {
        synchronized (this.zzbsv) {
            if (this.zzbsw == null) {
                this.zzbsw = new zzrf();
            }
            this.zzbsw.zza(zzrh);
        }
    }

    public final void zzb(zzrh zzrh) {
        synchronized (this.zzbsv) {
            zzrf zzrf = this.zzbsw;
            if (zzrf != null) {
                zzrf.zzb(zzrh);
            }
        }
    }
}
