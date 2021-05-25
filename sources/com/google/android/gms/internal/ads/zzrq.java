package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public abstract class zzrq {
    @Nullable
    private static MessageDigest zzbtz;
    public Object mLock = new Object();

    public abstract byte[] zzbu(String str);

    @Nullable
    public final MessageDigest zzmq() {
        synchronized (this.mLock) {
            MessageDigest messageDigest = zzbtz;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbtz = MessageDigest.getInstance(Constants.MD5);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzbtz;
        }
    }
}
