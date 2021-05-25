package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
public final class zzdrq {
    private final SharedPreferences zzcld;
    private final File zzhks;
    @VisibleForTesting
    private final File zzhkt;
    private final zzgo zzvy;

    public zzdrq(@NonNull Context context, zzgo zzgo) {
        this.zzcld = context.getSharedPreferences("pcvmspf", 0);
        this.zzhks = zzdrp.zza(context.getDir("pccache", 0), false);
        this.zzhkt = zzdrp.zza(context.getDir("tmppccache", 0), true);
        this.zzvy = zzgo;
    }

    private final File zzawd() {
        File file = new File(this.zzhks, Integer.toString(this.zzvy.zzv()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zzawe() {
        return a.m2(17, "FBAMTD", this.zzvy.zzv());
    }

    private final String zzawf() {
        return a.m2(17, "LATMTD", this.zzvy.zzv());
    }

    @VisibleForTesting
    private final zzgr zzei(int i) {
        String str;
        if (i == zzdry.zzhkz) {
            str = this.zzcld.getString(zzawf(), null);
        } else {
            str = i == zzdry.zzhla ? this.zzcld.getString(zzawe(), null) : null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            zzgr zzl = zzgr.zzl(zzeff.zzu(Hex.stringToBytes(str)));
            String zzdg = zzl.zzdg();
            if (zzdrp.zza(zzdg, "pcam", zzawd()).exists() && zzdrp.zza(zzdg, "pcbc", zzawd()).exists()) {
                return zzl;
            }
            return null;
        } catch (zzegz unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0140, code lost:
        if (r0.commit() != false) goto L_0x0144;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzgq r9, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzdrw r10) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrq.zza(com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzdrw):boolean");
    }

    public final zzdrn zzp(int i) {
        zzgr zzei = zzei(i);
        if (zzei == null) {
            return null;
        }
        String zzdg = zzei.zzdg();
        return new zzdrn(zzei, zzdrp.zza(zzdg, "pcam", zzawd()), zzdrp.zza(zzdg, "pcbc", zzawd()), zzdrp.zza(zzdg, "pcopt", zzawd()));
    }

    @VisibleForTesting
    private static String zza(@NonNull zzgr zzgr) {
        return Hex.bytesToStringLowercase(zzgr.zzbda().toByteArray());
    }
}
