package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbw;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class zzdu {
    private static final ConditionVariable zzwh = new ConditionVariable();
    @VisibleForTesting
    public static volatile zztt zzwi = null;
    private static volatile Random zzwk = null;
    private zzex zzwg;
    @VisibleForTesting
    public volatile Boolean zzwj;

    public zzdu(zzex zzex) {
        this.zzwg = zzex;
        zzex.zzcg().execute(new zzdt(this));
    }

    public static int zzbu() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            return zzbv().nextInt();
        }
    }

    private static Random zzbv() {
        if (zzwk == null) {
            synchronized (zzdu.class) {
                if (zzwk == null) {
                    zzwk = new Random();
                }
            }
        }
        return zzwk;
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, null, null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzwh.block();
            if (this.zzwj.booleanValue() && zzwi != null) {
                zzbw.zza.C0189zza zzc = zzbw.zza.zzs().zzk(this.zzwg.zzvr.getPackageName()).zzc(j);
                if (str != null) {
                    zzc.zzn(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzeeo.zza(exc, new PrintWriter(stringWriter));
                    zzc.zzl(stringWriter.toString()).zzm(exc.getClass().getName());
                }
                zztx zzf = zzwi.zzf(((zzbw.zza) ((zzegp) zzc.zzbfx())).toByteArray());
                zzf.zzby(i);
                if (i2 != -1) {
                    zzf.zzbx(i2);
                }
                zzf.zzdv();
            }
        } catch (Exception unused) {
        }
    }
}
