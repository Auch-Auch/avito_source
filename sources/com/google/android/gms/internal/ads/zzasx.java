package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
public final class zzasx {
    private float zzbrw;
    private int zzdng;
    private int zzdnh;
    private int zzdtj;
    private boolean zzdtk;
    private boolean zzdtl;
    private String zzdtm;
    private String zzdtn;
    private boolean zzdto;
    private final boolean zzdtp;
    private boolean zzdtq;
    private boolean zzdtr;
    private boolean zzdts;
    private String zzdtt;
    private String zzdtu;
    private String zzdtv;
    private int zzdtw;
    private int zzdtx;
    private int zzdty;
    private int zzdtz;
    private int zzdua;
    private int zzdub;
    private double zzduc;
    private boolean zzdud;
    private boolean zzdue;
    private int zzduf;
    private String zzdug;
    private String zzduh;
    private boolean zzdui;

    public zzasx(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzv(context);
        zzw(context);
        zzx(context);
        Locale locale = Locale.getDefault();
        boolean z = true;
        this.zzdtk = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdtl = zza(packageManager, "http://www.google.com") == null ? false : z;
        this.zzdtn = locale.getCountry();
        zzwe.zzpq();
        this.zzdto = zzbat.zzym();
        this.zzdtp = DeviceProperties.isLatchsky(context);
        this.zzdtq = DeviceProperties.isSidewinder(context);
        this.zzdtt = locale.getLanguage();
        this.zzdtu = zza(context, packageManager);
        this.zzdtv = zzy(context);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.zzbrw = displayMetrics.density;
            this.zzdng = displayMetrics.widthPixels;
            this.zzdnh = displayMetrics.heightPixels;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private final void zzv(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdtj = audioManager.getMode();
                this.zzdtr = audioManager.isMusicActive();
                this.zzdts = audioManager.isSpeakerphoneOn();
                this.zzdtw = audioManager.getStreamVolume(3);
                this.zzdua = audioManager.getRingerMode();
                this.zzdub = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzp.zzkt().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdtj = -2;
        this.zzdtr = false;
        this.zzdts = false;
        this.zzdtw = 0;
        this.zzdua = 2;
        this.zzdub = 0;
    }

    @TargetApi(16)
    private final void zzw(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzdtm = telephonyManager.getNetworkOperator();
        this.zzdty = telephonyManager.getNetworkType();
        this.zzdtz = telephonyManager.getPhoneType();
        this.zzdtx = -2;
        this.zzdue = false;
        this.zzduf = -1;
        zzp.zzkp();
        if (zzayh.zzr(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzdtx = activeNetworkInfo.getType();
                this.zzduf = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzdtx = -1;
            }
            this.zzdue = connectivityManager.isActiveNetworkMetered();
        }
    }

    private final void zzx(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.zzduc = (double) (((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzdud = z;
            return;
        }
        this.zzduc = -1.0d;
        this.zzdud = false;
    }

    private static String zzy(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzasu zzvk() {
        return new zzasu(this.zzdtj, this.zzdtk, this.zzdtl, this.zzdtm, this.zzdtn, this.zzdto, this.zzdtp, this.zzdtq, this.zzdtr, this.zzdts, this.zzdtt, this.zzdtu, this.zzdtv, this.zzdtw, this.zzdtx, this.zzdty, this.zzdtz, this.zzdua, this.zzdub, this.zzbrw, this.zzdng, this.zzdnh, this.zzduc, this.zzdud, this.zzdue, this.zzduf, this.zzdug, this.zzdui, this.zzduh);
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzp.zzkt().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public zzasx(Context context, zzasu zzasu) {
        zzv(context);
        zzw(context);
        zzx(context);
        this.zzdug = Build.FINGERPRINT;
        this.zzduh = Build.DEVICE;
        this.zzdui = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzabu.zzk(context);
        this.zzdtk = zzasu.zzdtk;
        this.zzdtl = zzasu.zzdtl;
        this.zzdtn = zzasu.zzdtn;
        this.zzdto = zzasu.zzdto;
        this.zzdtp = zzasu.zzdtp;
        this.zzdtq = zzasu.zzdtq;
        this.zzdtt = zzasu.zzdtt;
        this.zzdtu = zzasu.zzdtu;
        this.zzdtv = zzasu.zzdtv;
        this.zzbrw = zzasu.zzbrw;
        this.zzdng = zzasu.zzdng;
        this.zzdnh = zzasu.zzdnh;
    }
}
