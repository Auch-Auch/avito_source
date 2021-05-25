package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.ExecutionException;
public final class zzfo extends zzgm {
    private static final zzgl<zzcy> zzaax = new zzgl<>();
    private final Context zzaav;
    private zzby.zza zzaay = null;

    public zzfo(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2, Context context, zzby.zza zza2) {
        super(zzex, str, str2, zza, i, 27);
        this.zzaav = context;
        this.zzaay = zza2;
    }

    private static String zza(zzby.zza zza) {
        if (zza == null || !zza.zzz() || zzfg.zzas(zza.zzaa().zzaf())) {
            return null;
        }
        return zza.zzaa().zzaf();
    }

    private final String zzcx() {
        try {
            if (this.zzwg.zzcp() != null) {
                this.zzwg.zzcp().get();
            }
            zzcf.zza zzco = this.zzwg.zzco();
            if (zzco == null || !zzco.zzaj()) {
                return null;
            }
            return zzco.zzaf();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0095: APUT  
      (r6v1 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x0091: INVOKE  (r2v3 java.lang.Boolean) = (r2v2 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    @Override // com.google.android.gms.internal.ads.zzgm
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcw() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
        // Method dump skipped, instructions count: 289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfo.zzcw():void");
    }
}
