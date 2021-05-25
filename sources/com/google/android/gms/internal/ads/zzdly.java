package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
public final class zzdly {
    public static void zza(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(i);
        zzbbd.zzfd(sb.toString());
        zzaxy.zza(str, th);
        if (i != 3) {
            zzp.zzkt().zzb(th, str);
        }
    }

    public static void zze(Context context, boolean z) {
        if (z) {
            zzbbd.zzfd("This request is sent from a test device.");
            return;
        }
        zzwe.zzpq();
        String zzbm = zzbat.zzbm(context);
        StringBuilder sb = new StringBuilder(String.valueOf(zzbm).length() + 101);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(zzbm);
        sb.append("\") to get test ads on this device.");
        zzbbd.zzfd(sb.toString());
    }
}
