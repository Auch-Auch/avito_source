package com.google.android.gms.internal.ads;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public final class zzcz implements Runnable {
    private zzcz() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzcx.zza(MessageDigest.getInstance(Constants.MD5));
        } catch (NoSuchAlgorithmException unused) {
        } finally {
            zzcx.zznv.countDown();
        }
    }
}
