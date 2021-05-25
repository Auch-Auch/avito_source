package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
@TargetApi(14)
public final class zzrf implements Application.ActivityLifecycleCallbacks {
    private boolean foreground = true;
    private final Object lock = new Object();
    @Nullable
    private Activity zzaas;
    private boolean zzbsq = false;
    @GuardedBy("lock")
    private final List<zzrh> zzbsr = new ArrayList();
    @GuardedBy("lock")
    private final List<zzrw> zzbss = new ArrayList();
    private Runnable zzbst;
    private long zzbsu;
    private Context zzvr;
    private boolean zzzh = false;

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zzaas = activity;
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.zzaas;
    }

    @Nullable
    public final Context getContext() {
        return this.zzvr;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            Activity activity2 = this.zzaas;
            if (activity2 != null) {
                if (activity2.equals(activity)) {
                    this.zzaas = null;
                }
                Iterator<zzrw> it = this.zzbss.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza(activity)) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzp.zzkt().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbbd.zzc("", e);
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzrw zzrw : this.zzbss) {
                try {
                    zzrw.onActivityPaused(activity);
                } catch (Exception e) {
                    zzp.zzkt().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbbd.zzc("", e);
                }
            }
        }
        this.zzbsq = true;
        Runnable runnable = this.zzbst;
        if (runnable != null) {
            zzayh.zzeaj.removeCallbacks(runnable);
        }
        zzdsf zzdsf = zzayh.zzeaj;
        zzri zzri = new zzri(this);
        this.zzbst = zzri;
        zzdsf.postDelayed(zzri, this.zzbsu);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbsq = false;
        boolean z = !this.foreground;
        this.foreground = true;
        Runnable runnable = this.zzbst;
        if (runnable != null) {
            zzayh.zzeaj.removeCallbacks(runnable);
        }
        synchronized (this.lock) {
            for (zzrw zzrw : this.zzbss) {
                try {
                    zzrw.onActivityResumed(activity);
                } catch (Exception e) {
                    zzp.zzkt().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbbd.zzc("", e);
                }
            }
            if (z) {
                for (zzrh zzrh : this.zzbsr) {
                    try {
                        zzrh.zzp(true);
                    } catch (Exception e2) {
                        zzbbd.zzc("", e2);
                    }
                }
            } else {
                zzbbd.zzef("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (!this.zzzh) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                setActivity((Activity) context);
            }
            this.zzvr = application;
            this.zzbsu = ((Long) zzwe.zzpu().zzd(zzaat.zzcoe)).longValue();
            this.zzzh = true;
        }
    }

    public final void zzb(zzrh zzrh) {
        synchronized (this.lock) {
            this.zzbsr.remove(zzrh);
        }
    }

    public final void zza(zzrh zzrh) {
        synchronized (this.lock) {
            this.zzbsr.add(zzrh);
        }
    }
}
