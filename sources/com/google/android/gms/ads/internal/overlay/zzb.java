package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzaxy;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwe;
public final class zzb {
    public static boolean zza(Context context, zzd zzd, zzt zzt) {
        int i = 0;
        if (zzd == null) {
            zzbbd.zzfe("No intent data for launcher overlay.");
            return false;
        }
        zzaat.initialize(context);
        Intent intent = zzd.intent;
        if (intent != null) {
            return zza(context, intent, zzt);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzd.url)) {
            zzbbd.zzfe("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzd.mimeType)) {
            intent2.setDataAndType(Uri.parse(zzd.url), zzd.mimeType);
        } else {
            intent2.setData(Uri.parse(zzd.url));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzd.packageName)) {
            intent2.setPackage(zzd.packageName);
        }
        if (!TextUtils.isEmpty(zzd.zzdog)) {
            String[] split = zzd.zzdog.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzd.zzdog);
                zzbbd.zzfe(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str = zzd.zzdoh;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzbbd.zzfe("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcsy)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcsx)).booleanValue()) {
                zzp.zzkp();
                zzayh.zzb(context, intent2);
            }
        }
        return zza(context, intent2, zzt);
    }

    private static boolean zza(Context context, Intent intent, zzt zzt) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzaxy.zzei(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzp.zzkp();
            zzayh.zza(context, intent);
            if (zzt == null) {
                return true;
            }
            zzt.zzuz();
            return true;
        } catch (ActivityNotFoundException e) {
            zzbbd.zzfe(e.getMessage());
            return false;
        }
    }
}
