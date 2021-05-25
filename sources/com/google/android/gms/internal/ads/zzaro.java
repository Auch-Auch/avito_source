package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzaro implements zzars {
    private static final Object lock = new Object();
    @VisibleForTesting
    private static zzars zzdpm;
    @VisibleForTesting
    private static zzars zzdpn;
    private final Context zzcle;
    private final Object zzdpo;
    private final WeakHashMap<Thread, Boolean> zzdpp;
    private final zzbbg zzdpq;
    private final ExecutorService zzyu;

    private zzaro(Context context) {
        this(context, zzbbg.zzyr());
    }

    public static zzars zzc(Context context, zzbbg zzbbg) {
        synchronized (lock) {
            if (zzdpn == null) {
                if (zzact.zzdbl.get().booleanValue()) {
                    if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcxf)).booleanValue()) {
                        zzaro zzaro = new zzaro(context, zzbbg);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzaro.zzdpo) {
                                zzaro.zzdpp.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new zzart(zzaro, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzarq(zzaro, Thread.getDefaultUncaughtExceptionHandler()));
                        zzdpn = zzaro;
                    }
                }
                zzdpn = new zzarv();
            }
        }
        return zzdpn;
    }

    public static zzars zzt(Context context) {
        synchronized (lock) {
            if (zzdpm == null) {
                if (zzact.zzdbl.get().booleanValue()) {
                    if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcxf)).booleanValue()) {
                        zzdpm = new zzaro(context);
                    }
                }
                zzdpm = new zzarv();
            }
        }
        return zzdpm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r3 == false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L_0x003c
            r1 = r11
            r2 = 0
            r3 = 0
        L_0x0007:
            if (r1 == 0) goto L_0x0037
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = 0
        L_0x000f:
            if (r6 >= r5) goto L_0x0032
            r7 = r4[r6]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzbat.zzey(r8)
            if (r8 == 0) goto L_0x001e
            r2 = 1
        L_0x001e:
            java.lang.Class<com.google.android.gms.internal.ads.zzaro> r8 = com.google.android.gms.internal.ads.zzaro.class
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x002f
            r3 = 1
        L_0x002f:
            int r6 = r6 + 1
            goto L_0x000f
        L_0x0032:
            java.lang.Throwable r1 = r1.getCause()
            goto L_0x0007
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            if (r3 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r10 = 0
        L_0x003d:
            if (r10 == 0) goto L_0x0046
            r10 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r0 = ""
            r9.zza(r11, r0, r10)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaro.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    private zzaro(Context context, zzbbg zzbbg) {
        this.zzdpo = new Object();
        this.zzdpp = new WeakHashMap<>();
        this.zzyu = zzdsb.zzawj().zzej(zzdsg.zzhll);
        this.zzcle = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdpq = zzbbg;
    }

    @Override // com.google.android.gms.internal.ads.zzars
    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzars
    public final void zza(Throwable th, String str, float f) {
        if (zzbat.zzd(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzeeo.zza(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            int i = 0;
            int i2 = 1;
            boolean z = Math.random() < ((double) f);
            if (f > 0.0f) {
                i2 = (int) (1.0f / f);
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza(name, stringWriter2, str, i2).toString());
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    this.zzyu.execute(new Runnable(new zzbbh(), (String) obj) { // from class: com.google.android.gms.internal.ads.zzarr
                        private final String zzdft;
                        private final zzbbh zzdpt;

                        {
                            this.zzdpt = r1;
                            this.zzdft = r2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzaro.zza(this.zzdpt, this.zzdft);
                        }
                    });
                }
            }
        }
    }

    @VisibleForTesting
    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z;
        String str4;
        try {
            z = Wrappers.packageManager(this.zzcle).isCallerInstantApp();
        } catch (Throwable th) {
            zzbbd.zzc("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.zzcle.getPackageName();
        } catch (Throwable unused) {
            zzbbd.zzfe("Cannot obtain package name, proceeding.");
            str4 = "unknown";
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            str6 = a.s2(str6.length() + a.q0(str5, 1), str5, " ", str6);
        }
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzdpq.zzbra).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzaat.zzrd())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "317778048").appendQueryParameter("rc", "dev").appendQueryParameter(SDKAnalyticsEvents.PARAMETER_SESSION_ID, zzwe.zzpv()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzact.zzdbj.get()));
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcpp)).booleanValue()) {
            appendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzcle))).appendQueryParameter("lite", this.zzdpq.zzedt ? "1" : "0");
        }
        return appendQueryParameter2;
    }
}
