package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;
public final class zznv extends zzoa {
    private static final int[] zzbgv = new int[0];
    private final zzoe zzbgw;
    private final AtomicReference<zzny> zzbgx;

    public zznv() {
        this(null);
    }

    private static int zze(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0176, code lost:
        if (r10 <= r15) goto L_0x017b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a9  */
    @Override // com.google.android.gms.internal.ads.zzoa
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzob[] zza(com.google.android.gms.internal.ads.zzhw[] r34, com.google.android.gms.internal.ads.zznp[] r35, int[][][] r36) throws com.google.android.gms.internal.ads.zzhd {
        /*
        // Method dump skipped, instructions count: 1053
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznv.zza(com.google.android.gms.internal.ads.zzhw[], com.google.android.gms.internal.ads.zznp[], int[][][]):com.google.android.gms.internal.ads.zzob[]");
    }

    private zznv(zzoe zzoe) {
        this.zzbgw = null;
        this.zzbgx = new AtomicReference<>(new zzny());
    }

    private static boolean zza(zzho zzho, String str) {
        return str != null && TextUtils.equals(str, zzpq.zzbj(zzho.zzahp));
    }
}
