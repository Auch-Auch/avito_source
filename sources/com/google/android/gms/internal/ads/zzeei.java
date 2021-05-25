package com.google.android.gms.internal.ads;

import java.security.SecureRandom;
public final class zzeei {
    private static final ThreadLocal<SecureRandom> zziad = new zzeeh();

    /* access modifiers changed from: private */
    public static SecureRandom zzbcv() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzfo(int i) {
        byte[] bArr = new byte[i];
        zziad.get().nextBytes(bArr);
        return bArr;
    }
}
