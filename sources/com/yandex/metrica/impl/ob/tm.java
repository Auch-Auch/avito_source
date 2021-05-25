package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class tm implements tx {
    @NonNull
    private final ack a;

    public tm() {
        this(new ack());
    }

    @Override // com.yandex.metrica.impl.ob.tx
    @NonNull
    public byte[] a(@NonNull to toVar) {
        String str = toVar.b;
        return this.a.a(toVar.s).a(str != null ? dh.c(str) : new byte[0]);
    }

    @VisibleForTesting
    public tm(@NonNull ack ack) {
        this.a = ack;
    }
}
