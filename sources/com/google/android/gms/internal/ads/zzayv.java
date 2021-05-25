package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzp;
@TargetApi(24)
public class zzayv extends zzays {
    @VisibleForTesting
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzctg)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcti)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzwe.zzpq();
        int zzc = zzbat.zzc(activity, configuration.screenHeightDp);
        int zzc2 = zzbat.zzc(activity, configuration.screenWidthDp);
        zzp.zzkp();
        DisplayMetrics zza = zzayh.zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int intValue = ((Integer) zzwe.zzpu().zzd(zzaat.zzctf)).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d));
        if (!(zze(i, zzc + dimensionPixelSize, intValue) && zze(i2, zzc2, intValue))) {
            return true;
        }
        return false;
    }
}
