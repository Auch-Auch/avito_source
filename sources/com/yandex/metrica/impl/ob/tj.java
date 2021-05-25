package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Base64;
public class tj implements tx {
    @NonNull
    private final ack a;

    public tj() {
        this(new ack());
    }

    @Override // com.yandex.metrica.impl.ob.tx
    @NonNull
    public byte[] a(@NonNull to toVar) {
        byte[] bArr = new byte[0];
        String str = toVar.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        return this.a.a(toVar.s).a(bArr);
    }

    @VisibleForTesting
    public tj(@NonNull ack ack) {
        this.a = ack;
    }
}
