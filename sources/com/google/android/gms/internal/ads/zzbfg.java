package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import com.avito.android.remote.model.ProfileTab;
import java.util.Arrays;
import java.util.List;
@TargetApi(16)
public final class zzbfg extends zzbev implements zzbei {
    private String zzefy;
    private boolean zzelf;
    private zzbeb zzeli;
    private Exception zzelj;
    private boolean zzelk;

    public zzbfg(zzbde zzbde, zzbdf zzbdf) {
        super(zzbde);
        zzbeb zzbeb = new zzbeb(zzbde.getContext(), zzbdf);
        this.zzeli = zzbeb;
        zzbeb.zza(this);
    }

    private final void zzfq(String str) {
        synchronized (this) {
            this.zzelf = true;
            notify();
            release();
        }
        String str2 = this.zzefy;
        if (str2 != null) {
            String zzfo = zzfo(str2);
            Exception exc = this.zzelj;
            if (exc != null) {
                zza(this.zzefy, zzfo, "badUrl", zzb(str, exc));
            } else {
                zza(this.zzefy, zzfo, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void abort() {
        zzfq(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbev, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzbeb zzbeb = this.zzeli;
        if (zzbeb != null) {
            zzbeb.zza((zzbei) null);
            this.zzeli.release();
        }
        super.release();
    }

    @Override // com.google.android.gms.internal.ads.zzbei
    public final void zza(String str, Exception exc) {
        String str2 = (String) zzwe.zzpu().zzd(zzaat.zzclt);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains(ProfileTab.ALL) || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzelj = exc;
        zzbbd.zzd("Precache error", exc);
        zzfq(str);
    }

    public final zzbeb zzaav() {
        synchronized (this) {
            this.zzelk = true;
            notify();
        }
        this.zzeli.zza((zzbei) null);
        zzbeb zzbeb = this.zzeli;
        this.zzeli = null;
        return zzbeb;
    }

    @Override // com.google.android.gms.internal.ads.zzbei
    public final void zzb(boolean z, long j) {
        zzbde zzbde = this.zzekx.get();
        if (zzbde != null) {
            zzbbi.zzedy.execute(new Runnable(zzbde, z, j) { // from class: com.google.android.gms.internal.ads.zzbfj
                private final boolean zzegf;
                private final long zzejh;
                private final zzbde zzelq;

                {
                    this.zzelq = r1;
                    this.zzegf = r2;
                    this.zzejh = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzelq.zza(this.zzegf, this.zzejh);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzdl(int i) {
        this.zzeli.zzaat().zzds(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzdm(int i) {
        this.zzeli.zzaat().zzdt(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzdn(int i) {
        this.zzeli.zzaat().zzdn(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void zzdo(int i) {
        this.zzeli.zzaat().zzdo(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbei
    public final void zzdq(int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = r33.zzelj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        if (r0 == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0152, code lost:
        r0 = th;
     */
    @Override // com.google.android.gms.internal.ads.zzbev
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(java.lang.String r34, java.lang.String[] r35) {
        /*
        // Method dump skipped, instructions count: 418
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfg.zze(java.lang.String, java.lang.String[]):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final boolean zzfn(String str) {
        return zze(str, new String[]{str});
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final String zzfo(String str) {
        String valueOf = String.valueOf(super.zzfo(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    @Override // com.google.android.gms.internal.ads.zzbei
    public final void zzn(int i, int i2) {
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder K = a.K(a.q0(message, a.q0(canonicalName, a.q0(str, 2))), str, "/", canonicalName, ":");
        K.append(message);
        return K.toString();
    }
}
