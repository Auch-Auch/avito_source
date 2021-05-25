package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
public abstract class zzbi<T> {
    private static final Object zzge = new Object();
    @Nullable
    private static volatile zzbr zzgf = null;
    private static volatile boolean zzgg = false;
    private static final AtomicReference<Collection<zzbi<?>>> zzgh = new AtomicReference<>();
    private static zzbs zzgi = new zzbs(zzbk.zzgq);
    private static final AtomicInteger zzgl = new AtomicInteger();
    private final String name;
    private final zzbo zzgj;
    private final T zzgk;
    private volatile int zzgm;
    private volatile T zzgn;
    private final boolean zzgo;

    private zzbi(zzbo zzbo, String str, T t, boolean z) {
        this.zzgm = -1;
        String str2 = zzbo.zzgt;
        if (str2 == null && zzbo.zzgu == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (str2 == null || zzbo.zzgu == null) {
            this.zzgj = zzbo;
            this.name = str;
            this.zzgk = t;
            this.zzgo = z;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    @Nullable
    private final T zza(zzbr zzbr) {
        zzay zzay;
        Object zzb;
        boolean z = false;
        if (!this.zzgj.zzgz) {
            String str = (String) zzbd.zze(zzbr.zzaa()).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
            if (str != null && zzaq.zzfb.matcher(str).matches()) {
                z = true;
            }
        }
        if (!z) {
            if (this.zzgj.zzgu == null) {
                zzay = zzbq.zzb(zzbr.zzaa(), this.zzgj.zzgt);
            } else if (!zzbg.zza(zzbr.zzaa(), this.zzgj.zzgu)) {
                zzay = null;
            } else if (this.zzgj.zzha) {
                ContentResolver contentResolver = zzbr.zzaa().getContentResolver();
                String lastPathSegment = this.zzgj.zzgu.getLastPathSegment();
                String packageName = zzbr.zzaa().getPackageName();
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + String.valueOf(lastPathSegment).length() + 1);
                sb.append(lastPathSegment);
                sb.append("#");
                sb.append(packageName);
                zzay = zzau.zza(contentResolver, zzbj.getContentProviderUri(sb.toString()));
            } else {
                zzay = zzau.zza(zzbr.zzaa().getContentResolver(), this.zzgj.zzgu);
            }
            if (!(zzay == null || (zzb = zzay.zzb(zzag())) == null)) {
                return zza(zzb);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String valueOf = String.valueOf(zzag());
            if (valueOf.length() != 0) {
                "Bypass reading Phenotype values for flag: ".concat(valueOf);
            } else {
                new String("Bypass reading Phenotype values for flag: ");
            }
        }
        return null;
    }

    public static void zzaf() {
        zzgl.incrementAndGet();
    }

    public static final /* synthetic */ boolean zzah() {
        return true;
    }

    @Nullable
    private final T zzb(zzbr zzbr) {
        zzcw<Context, Boolean> zzcw;
        zzbo zzbo = this.zzgj;
        if (!zzbo.zzgx && ((zzcw = zzbo.zzhb) == null || zzcw.apply(zzbr.zzaa()).booleanValue())) {
            zzbd zze = zzbd.zze(zzbr.zzaa());
            zzbo zzbo2 = this.zzgj;
            Object zzb = zze.zzb(zzbo2.zzgx ? null : zze(zzbo2.zzgv));
            if (zzb != null) {
                return zza(zzb);
            }
        }
        return null;
    }

    private final String zze(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.name);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Deprecated
    public static void zzi(Context context) {
        synchronized (zzge) {
            zzbr zzbr = zzgf;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzbr == null || zzbr.zzaa() != context) {
                zzau.zzy();
                zzbq.zzy();
                zzbd.zzae();
                zzgf = new zzav(context, zzdi.zza(new zzdf(context) { // from class: com.google.android.gms.internal.vision.zzbl
                    private final Context zzgr;

                    {
                        this.zzgr = r1;
                    }

                    @Override // com.google.android.gms.internal.vision.zzdf
                    public final Object get() {
                        return zzbi.zzk(this.zzgr);
                    }
                }));
                zzgl.incrementAndGet();
            }
        }
    }

    public static void zzj(Context context) {
        if (zzgf == null) {
            synchronized (zzge) {
                if (zzgf == null) {
                    zzi(context);
                }
            }
        }
    }

    public static final /* synthetic */ zzcy zzk(Context context) {
        new zzbh();
        return zzbh.zzg(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get() {
        /*
            r6 = this;
            boolean r0 = r6.zzgo
            if (r0 != 0) goto L_0x0011
            com.google.android.gms.internal.vision.zzbs r0 = com.google.android.gms.internal.vision.zzbi.zzgi
            java.lang.String r1 = r6.name
            boolean r0 = r0.zzg(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            com.google.android.gms.internal.vision.zzde.checkState(r0, r1)
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = com.google.android.gms.internal.vision.zzbi.zzgl
            int r0 = r0.get()
            int r1 = r6.zzgm
            if (r1 >= r0) goto L_0x0086
            monitor-enter(r6)
            int r1 = r6.zzgm     // Catch:{ all -> 0x0083 }
            if (r1 >= r0) goto L_0x0081
            com.google.android.gms.internal.vision.zzbr r1 = com.google.android.gms.internal.vision.zzbi.zzgf     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0026
            r2 = 1
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            java.lang.String r3 = "Must call PhenotypeFlag.init() first"
            com.google.android.gms.internal.vision.zzde.checkState(r2, r3)     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.vision.zzbo r2 = r6.zzgj     // Catch:{ all -> 0x0083 }
            boolean r2 = r2.zzgy     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r6.zzb(r1)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x0039
            goto L_0x0050
        L_0x0039:
            java.lang.Object r2 = r6.zza(r1)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x004e
            goto L_0x0050
        L_0x0040:
            java.lang.Object r2 = r6.zza(r1)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x0047
            goto L_0x0050
        L_0x0047:
            java.lang.Object r2 = r6.zzb(r1)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            T r2 = r6.zzgk     // Catch:{ all -> 0x0083 }
        L_0x0050:
            com.google.android.gms.internal.vision.zzdf r1 = r1.zzab()     // Catch:{ all -> 0x0083 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.vision.zzcy r1 = (com.google.android.gms.internal.vision.zzcy) r1     // Catch:{ all -> 0x0083 }
            boolean r3 = r1.isPresent()     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x007d
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.vision.zzbe r1 = (com.google.android.gms.internal.vision.zzbe) r1     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.vision.zzbo r2 = r6.zzgj     // Catch:{ all -> 0x0083 }
            android.net.Uri r3 = r2.zzgu     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = r2.zzgt     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = r2.zzgw     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r6.name     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r1.zza(r3, r4, r2, r5)     // Catch:{ all -> 0x0083 }
            if (r1 != 0) goto L_0x0079
            T r2 = r6.zzgk     // Catch:{ all -> 0x0083 }
            goto L_0x007d
        L_0x0079:
            java.lang.Object r2 = r6.zza(r1)     // Catch:{ all -> 0x0083 }
        L_0x007d:
            r6.zzgn = r2     // Catch:{ all -> 0x0083 }
            r6.zzgm = r0     // Catch:{ all -> 0x0083 }
        L_0x0081:
            monitor-exit(r6)     // Catch:{ all -> 0x0083 }
            goto L_0x0086
        L_0x0083:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0083 }
            throw r0
        L_0x0086:
            T r0 = r6.zzgn
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzbi.get():java.lang.Object");
    }

    public abstract T zza(Object obj);

    public final String zzag() {
        return zze(this.zzgj.zzgw);
    }

    public /* synthetic */ zzbi(zzbo zzbo, String str, Object obj, boolean z, zzbn zzbn) {
        this(zzbo, str, obj, z);
    }

    /* access modifiers changed from: private */
    public static <T> zzbi<T> zza(zzbo zzbo, String str, T t, zzbp<T> zzbp, boolean z) {
        return new zzbm(zzbo, str, t, true, zzbp);
    }
}
