package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class acg implements acn {
    private acf a;

    public acg() {
        this(new acf());
    }

    @Override // com.yandex.metrica.impl.ob.acn
    @Nullable
    public byte[] a(@Nullable byte[] bArr) {
        return this.a.a(bArr);
    }

    @VisibleForTesting
    public acg(acf acf) {
        this.a = acf;
    }

    @Override // com.yandex.metrica.impl.ob.acn
    @NonNull
    public aco a() {
        return aco.AES_RSA;
    }
}
