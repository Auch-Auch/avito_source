package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class add extends adc<byte[]> {
    public add(int i, @NonNull String str, @NonNull abl abl) {
        super(i, str, abl);
    }

    @Override // com.yandex.metrica.impl.ob.adc
    @VisibleForTesting(otherwise = 3)
    public /* bridge */ /* synthetic */ int a() {
        return super.a();
    }

    @Override // com.yandex.metrica.impl.ob.adc
    @VisibleForTesting(otherwise = 3)
    @NonNull
    public /* bridge */ /* synthetic */ String b() {
        return super.b();
    }

    @Nullable
    public byte[] a(@Nullable byte[] bArr) {
        if (bArr == null || bArr.length <= a()) {
            return bArr;
        }
        byte[] bArr2 = new byte[a()];
        System.arraycopy(bArr, 0, bArr2, 0, a());
        if (this.a.c()) {
            this.a.b("\"%s\" %s exceeded limit of %d bytes", b(), bArr, Integer.valueOf(a()));
        }
        return bArr2;
    }
}
