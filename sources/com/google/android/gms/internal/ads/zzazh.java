package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzazh {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private String zzebe = "";
    @GuardedBy("lock")
    private String zzebf = "";
    @GuardedBy("lock")
    private boolean zzebg = false;
    @VisibleForTesting
    private String zzebh = "";

    private final String zzbi(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzebe)) {
                zzp.zzkp();
                String zzt = zzayh.zzt(context, "debug_signals_id.txt");
                this.zzebe = zzt;
                if (TextUtils.isEmpty(zzt)) {
                    zzp.zzkp();
                    this.zzebe = zzayh.zzxo();
                    zzp.zzkp();
                    zzayh.zzc(context, "debug_signals_id.txt", this.zzebe);
                }
            }
            str = this.zzebe;
        }
        return str;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzd(context, (String) zzwe.zzpu().zzd(zzaat.zzctd), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzp.zzkp();
        zzayh.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbi(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    @VisibleForTesting
    private final boolean zzf(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzwe.zzpu().zzd(zzaat.zzctb), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzbbd.zzef("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzh.trim());
            String optString = jSONObject.optString("gct");
            this.zzebh = jSONObject.optString("status");
            synchronized (this.lock) {
                this.zzebf = optString;
            }
            return true;
        } catch (JSONException e) {
            zzbbd.zzd("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzg(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzwe.zzpu().zzd(zzaat.zzctc), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzbbd.zzef("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzebg = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzbbd.zzd("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String zzh(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzp.zzkp().zzs(context, str2));
        zzdvt<String> zzc = new zzazt(context).zzc(str, hashMap);
        try {
            return zzc.get((long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcte)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            String valueOf = String.valueOf(str);
            zzbbd.zzc(valueOf.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf) : new String("Timeout while retriving a response from: "), e);
            zzc.cancel(true);
            return null;
        } catch (InterruptedException e2) {
            String valueOf2 = String.valueOf(str);
            zzbbd.zzc(valueOf2.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf2) : new String("Interrupted while retriving a response from: "), e2);
            zzc.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            zzbbd.zzc(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzp.zzkp();
        zzayh.zza(context, zzd(context, (String) zzwe.zzpu().zzd(zzaat.zzcta), str, str2));
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3) {
        boolean zzyc = zzyc();
        if (zzg(context, str, str2)) {
            if (!zzyc && !TextUtils.isEmpty(str3)) {
                zzc(context, str2, str3, str);
            }
            zzbbd.zzef("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzi(context, str, str2);
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzp.zzkz().zzyc()) {
            return false;
        }
        zzbbd.zzef("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(this.zzebh)) {
            zzbbd.zzef("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzebh)) {
            zzbbd.zzef("The app is not linked for creative preview.");
            zzi(context, str, str2);
        } else if ("0".equals(this.zzebh)) {
            zzbbd.zzef("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String zzyb() {
        String str;
        synchronized (this.lock) {
            str = this.zzebf;
        }
        return str;
    }

    public final boolean zzyc() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzebg;
        }
        return z;
    }

    @VisibleForTesting
    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzbbd.zzfd("Can not create dialog without Activity Context");
        } else {
            zzayh.zzeaj.post(new zzazg(this, context, str, z, z2));
        }
    }
}
