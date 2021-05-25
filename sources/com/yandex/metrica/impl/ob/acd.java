package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class acd {
    private final String a;
    private final byte[] b;
    private final byte[] c;

    public acd(String str, byte[] bArr, byte[] bArr2) {
        this.a = str;
        this.b = bArr;
        this.c = bArr2;
    }

    @SuppressLint({"TrulyRandom"})
    public byte[] a(byte[] bArr) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
        Cipher instance = Cipher.getInstance(this.a);
        instance.init(1, secretKeySpec, new IvParameterSpec(this.c));
        return instance.doFinal(bArr);
    }

    @SuppressLint({"TrulyRandom"})
    public byte[] b(byte[] bArr) throws Throwable {
        return a(bArr, 0, bArr.length);
    }

    public byte[] a(byte[] bArr, int i, int i2) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
        Cipher instance = Cipher.getInstance(this.a);
        instance.init(2, secretKeySpec, new IvParameterSpec(this.c));
        return instance.doFinal(bArr, i, i2);
    }
}
