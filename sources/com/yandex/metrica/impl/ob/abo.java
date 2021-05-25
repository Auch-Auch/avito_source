package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class abo {
    @Nullable
    public static String a(@NonNull Context context, @Nullable String str) throws UnsupportedEncodingException {
        return Base64.encodeToString(b(context, ax.b(str).getBytes("UTF-8")), 0);
    }

    @Nullable
    public static String b(@NonNull Context context, @NonNull String str) throws UnsupportedEncodingException {
        return a(context, str.getBytes("UTF-8"));
    }

    @Nullable
    private static byte[] b(@NonNull Context context, @NonNull byte[] bArr) {
        try {
            byte[] a = a(context);
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = (byte) (bArr[i] ^ a[i % a.length]);
            }
            return bArr2;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static String a(@NonNull Context context, @NonNull byte[] bArr) throws UnsupportedEncodingException {
        byte[] b = b(context, Base64.decode(bArr, 0));
        if (b != null) {
            return ax.c(new String(b, "UTF-8"));
        }
        return null;
    }

    @NonNull
    private static byte[] a(@NonNull Context context) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return a(context.getPackageName());
    }

    @NonNull
    public static byte[] a(@NonNull String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance(Constants.MD5);
        instance.reset();
        instance.update(str.getBytes("UTF-8"));
        return instance.digest();
    }
}
