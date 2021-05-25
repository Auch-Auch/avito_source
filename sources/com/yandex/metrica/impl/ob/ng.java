package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Arrays;
public class ng {
    @NonNull
    private final a a;
    @NonNull
    private final aay b;

    public static class a {
        public acd a(byte[] bArr, byte[] bArr2) {
            return new acd("AES/CBC/PKCS5Padding", bArr, bArr2);
        }
    }

    public ng() {
        this(new a(), new aay());
    }

    @Nullable
    public byte[] a(@Nullable byte[] bArr, @NonNull String str) {
        try {
            acd a3 = this.a.a(str.getBytes(), Arrays.copyOfRange(bArr, 0, 16));
            if (dl.a(bArr)) {
                return null;
            }
            return this.b.b(a3.a(bArr, 16, bArr.length - 16));
        } catch (Throwable unused) {
            return null;
        }
    }

    @VisibleForTesting
    public ng(@NonNull a aVar, @NonNull aay aay) {
        this.a = aVar;
        this.b = aay;
    }
}
