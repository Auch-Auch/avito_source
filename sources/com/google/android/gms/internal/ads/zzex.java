package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcf;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public class zzex {
    private static final String TAG = "zzex";
    public Context zzvr;
    private volatile boolean zzxj;
    private zzev zzyt;
    private ExecutorService zzyu;
    private DexClassLoader zzyv;
    private zzei zzyw;
    private byte[] zzyx;
    private volatile AdvertisingIdClient zzyy = null;
    private Future zzyz;
    private boolean zzza;
    private volatile zzcf.zza zzzb;
    private Future zzzc;
    private zzdu zzzd;
    private boolean zzze;
    private boolean zzzf;
    private Map<Pair<String, String>, zzgk> zzzg;
    private boolean zzzh;

    private zzex(Context context) {
        boolean z = false;
        this.zzxj = false;
        this.zzyz = null;
        this.zzzb = null;
        this.zzzc = null;
        this.zzze = false;
        this.zzzf = false;
        this.zzzh = false;
        Context applicationContext = context.getApplicationContext();
        z = applicationContext != null ? true : z;
        this.zzza = z;
        this.zzvr = z ? applicationContext : context;
        this.zzzg = new HashMap();
        if (this.zzyt == null) {
            this.zzyt = new zzev(this.zzvr);
        }
    }

    public static zzex zza(Context context, String str, String str2, boolean z) {
        zzex zzex = new zzex(context);
        try {
            zzex.zzyu = Executors.newCachedThreadPool(new zzfa());
            zzex.zzxj = z;
            if (z) {
                zzex.zzyz = zzex.zzyu.submit(new zzez(zzex));
            }
            zzex.zzyu.execute(new zzfb(zzex));
            try {
                GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
                zzex.zzze = instance.getApkVersion(zzex.zzvr) > 0;
                zzex.zzzf = instance.isGooglePlayServicesAvailable(zzex.zzvr) == 0;
            } catch (Throwable unused) {
            }
            zzex.zza(0, true);
            if (!zzfg.isMainThread() || !((Boolean) zzwe.zzpu().zzd(zzaat.zzcqv)).booleanValue()) {
                zzei zzei = new zzei(null);
                zzex.zzyw = zzei;
                try {
                    zzex.zzyx = zzei.zzap(str);
                    try {
                        File cacheDir = zzex.zzvr.getCacheDir();
                        if (cacheDir == null) {
                            cacheDir = zzex.zzvr.getDir("dex", 0);
                            if (cacheDir == null) {
                                throw new zzeu();
                            }
                        }
                        File file = new File(String.format("%s/%s.jar", cacheDir, "1588462714860"));
                        if (!file.exists()) {
                            byte[] zza = zzex.zzyw.zza(zzex.zzyx, str2);
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(zza, 0, zza.length);
                            fileOutputStream.close();
                        }
                        zzex.zzb(cacheDir, "1588462714860");
                        try {
                            zzex.zzyv = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzex.zzvr.getClassLoader());
                            zzc(file);
                            zzex.zza(cacheDir, "1588462714860");
                            zzaq(String.format("%s/%s.dex", cacheDir, "1588462714860"));
                            zzex.zzzd = new zzdu(zzex);
                            zzex.zzzh = true;
                            return zzex;
                        } catch (Throwable th) {
                            zzc(file);
                            zzex.zza(cacheDir, "1588462714860");
                            zzaq(String.format("%s/%s.dex", cacheDir, "1588462714860"));
                            throw th;
                        }
                    } catch (FileNotFoundException e) {
                        throw new zzeu(e);
                    } catch (IOException e2) {
                        throw new zzeu(e2);
                    } catch (zzeh e3) {
                        throw new zzeu(e3);
                    } catch (NullPointerException e4) {
                        throw new zzeu(e4);
                    }
                } catch (zzeh e5) {
                    throw new zzeu(e5);
                }
            } else {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
        } catch (zzeu unused2) {
        }
    }

    private static void zzaq(String str) {
        zzc(new File(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
        r0 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[ExcHandler: zzeh | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:21:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd A[SYNTHETIC, Splitter:B:55:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e4 A[SYNTHETIC, Splitter:B:59:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00eb A[SYNTHETIC, Splitter:B:66:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f2 A[SYNTHETIC, Splitter:B:70:0x00f2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzex.zzb(java.io.File, java.lang.String):boolean");
    }

    private static void zzc(File file) {
        if (!file.exists()) {
            String.format("File %s not found. No need for deletion", file.getAbsolutePath());
        } else {
            file.delete();
        }
    }

    /* access modifiers changed from: private */
    public final void zzcq() {
        try {
            if (this.zzyy == null && this.zzza) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzvr);
                advertisingIdClient.start();
                this.zzyy = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzyy = null;
        }
    }

    @VisibleForTesting
    private final zzcf.zza zzcr() {
        try {
            PackageInfo packageInfo = this.zzvr.getPackageManager().getPackageInfo(this.zzvr.getPackageName(), 0);
            Context context = this.zzvr;
            return zzdqi.zzj(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Context getContext() {
        return this.zzvr;
    }

    public final boolean isInitialized() {
        return this.zzzh;
    }

    public final int zzbu() {
        if (this.zzzd != null) {
            return zzdu.zzbu();
        }
        return Integer.MIN_VALUE;
    }

    public final boolean zzcb() {
        return this.zzyt.zzcb();
    }

    public final ExecutorService zzcg() {
        return this.zzyu;
    }

    public final DexClassLoader zzch() {
        return this.zzyv;
    }

    public final zzei zzci() {
        return this.zzyw;
    }

    public final byte[] zzcj() {
        return this.zzyx;
    }

    public final boolean zzck() {
        return this.zzze;
    }

    public final zzdu zzcl() {
        return this.zzzd;
    }

    public final boolean zzcm() {
        return this.zzzf;
    }

    public final zzev zzcn() {
        return this.zzyt;
    }

    public final zzcf.zza zzco() {
        return this.zzzb;
    }

    public final Future zzcp() {
        return this.zzzc;
    }

    public final AdvertisingIdClient zzcs() {
        if (!this.zzxj) {
            return null;
        }
        if (this.zzyy != null) {
            return this.zzyy;
        }
        Future future = this.zzyz;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzyz = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzyz.cancel(true);
            }
        }
        return this.zzyy;
    }

    @VisibleForTesting
    public final zzcf.zza zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return zzcr();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cd, code lost:
        r10 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[ExcHandler: zzeh | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:20:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d4 A[SYNTHETIC, Splitter:B:43:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00db A[SYNTHETIC, Splitter:B:47:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e5 A[SYNTHETIC, Splitter:B:55:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ec A[SYNTHETIC, Splitter:B:59:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzex.zza(java.io.File, java.lang.String):void");
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzzg.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzzg.put(new Pair<>(str, str2), new zzgk(this, str, str2, clsArr));
        return true;
    }

    public final Method zza(String str, String str2) {
        zzgk zzgk = this.zzzg.get(new Pair(str, str2));
        if (zzgk == null) {
            return null;
        }
        return zzgk.zzdb();
    }

    @VisibleForTesting
    public final void zza(int i, boolean z) {
        if (this.zzzf) {
            Future<?> submit = this.zzyu.submit(new zzfc(this, i, z));
            if (i == 0) {
                this.zzzc = submit;
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzcf.zza zza) {
        if (i >= 4) {
            return false;
        }
        if (zza != null && zza.zzaj() && !zza.zzaf().equals("0000000000000000000000000000000000000000000000000000000000000000") && zza.zzao() && zza.zzap().zzbg() && zza.zzap().zzbh() != -2) {
            return false;
        }
        return true;
    }
}
