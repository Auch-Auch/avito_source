package com.google.android.gms.internal.p001authapi;

import android.util.Base64;
import java.util.Random;
/* renamed from: com.google.android.gms.internal.auth-api.zzal  reason: invalid package */
public final class zzal {
    private static final Random zzcy = new Random();

    public static String zzs() {
        byte[] bArr = new byte[16];
        zzcy.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
