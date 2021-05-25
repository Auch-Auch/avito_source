package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzazt {
    private static zzae zzebu;
    private static final Object zzebv = new Object();
    @Deprecated
    private static final zzazx<Void> zzebw = new zzazs();

    public zzazt(Context context) {
        zzbk(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzae zzbk(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzazt.zzebv
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzae r1 = com.google.android.gms.internal.ads.zzazt.zzebu     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzaat.initialize(r3)     // Catch:{ all -> 0x0036 }
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzaai<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaat.zzcsu     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzaap r2 = com.google.android.gms.internal.ads.zzwe.zzpu()     // Catch:{ all -> 0x0036 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0036 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzazi.zzbj(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x0030
        L_0x002c:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzbk.zza(r3)     // Catch:{ all -> 0x0036 }
        L_0x0030:
            com.google.android.gms.internal.ads.zzazt.zzebu = r3     // Catch:{ all -> 0x0036 }
        L_0x0032:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzazt.zzebu     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return r3
        L_0x0036:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazt.zzbk(android.content.Context):com.google.android.gms.internal.ads.zzae");
    }

    public static zzdvt<zzy> zzev(String str) {
        zzbbq zzbbq = new zzbbq();
        zzebu.zze(new zzazz(str, zzbbq));
        return zzbbq;
    }

    public final zzdvt<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        zzazw zzazw = new zzazw(null);
        zzazv zzazv = new zzazv(this, str, zzazw);
        zzbax zzbax = new zzbax(null);
        zzazu zzazu = new zzazu(this, i, str, zzazw, zzazv, bArr, map, zzbax);
        if (zzbax.isEnabled()) {
            try {
                zzbax.zza(str, ShareTarget.METHOD_GET, zzazu.getHeaders(), zzazu.zzg());
            } catch (zzl e) {
                zzbbd.zzfe(e.getMessage());
            }
        }
        zzebu.zze(zzazu);
        return zzazw;
    }

    public final zzdvt<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
