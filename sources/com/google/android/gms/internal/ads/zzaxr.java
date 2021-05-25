package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;
public final class zzaxr {
    private final Object lock = new Object();
    @VisibleForTesting
    private long zzdyu = -1;
    @VisibleForTesting
    private long zzdyv = -1;
    @VisibleForTesting
    @GuardedBy("lock")
    private int zzdyw = -1;
    @VisibleForTesting
    public int zzdyx = -1;
    @VisibleForTesting
    private long zzdyy = 0;
    @VisibleForTesting
    private final String zzdyz;
    private final zzaya zzdza;
    @VisibleForTesting
    @GuardedBy("lock")
    private int zzdzb = 0;
    @VisibleForTesting
    @GuardedBy("lock")
    private int zzdzc = 0;

    public zzaxr(String str, zzaya zzaya) {
        this.zzdyz = str;
        this.zzdza = zzaya;
    }

    private static boolean zzan(Context context) {
        Context zzab = zzatg.zzab(context);
        int identifier = zzab.getResources().getIdentifier("Theme.Translucent", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "android");
        if (identifier == 0) {
            zzbbd.zzfd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzab.getPackageManager().getActivityInfo(new ComponentName(zzab.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzbbd.zzfd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzbbd.zzfe("Fail to fetch AdActivity theme");
            zzbbd.zzfd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public final void zza(zzvc zzvc, long j) {
        Bundle bundle;
        synchronized (this.lock) {
            long zzxf = this.zzdza.zzxf();
            long currentTimeMillis = zzp.zzkw().currentTimeMillis();
            if (this.zzdyv == -1) {
                if (currentTimeMillis - zzxf > ((Long) zzwe.zzpu().zzd(zzaat.zzcof)).longValue()) {
                    this.zzdyx = -1;
                } else {
                    this.zzdyx = this.zzdza.zzxg();
                }
                this.zzdyv = j;
                this.zzdyu = j;
            } else {
                this.zzdyu = j;
            }
            if (zzvc == null || (bundle = zzvc.extras) == null || bundle.getInt("gw", 2) != 1) {
                this.zzdyw++;
                int i = this.zzdyx + 1;
                this.zzdyx = i;
                if (i == 0) {
                    this.zzdyy = 0;
                    this.zzdza.zzfa(currentTimeMillis);
                } else {
                    this.zzdyy = currentTimeMillis - this.zzdza.zzxh();
                }
            }
        }
    }

    public final Bundle zzp(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.zzdyz);
            bundle.putLong("basets", this.zzdyv);
            bundle.putLong("currts", this.zzdyu);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzdyw);
            bundle.putInt("preqs_in_session", this.zzdyx);
            bundle.putLong("time_in_session", this.zzdyy);
            bundle.putInt("pclick", this.zzdzb);
            bundle.putInt("pimp", this.zzdzc);
            bundle.putBoolean("support_transparent_background", zzan(context));
        }
        return bundle;
    }

    public final void zzvz() {
        synchronized (this.lock) {
            this.zzdzc++;
        }
    }

    public final void zzwa() {
        synchronized (this.lock) {
            this.zzdzb++;
        }
    }
}
