package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.io.IOException;
public class nc<T> implements nd<T> {
    @NonNull
    private final nd<T> a;
    @NonNull
    private final acd b;

    public nc(@NonNull nd<T> ndVar, @NonNull acd acd) {
        this.a = ndVar;
        this.b = acd;
    }

    @Override // com.yandex.metrica.impl.ob.nd
    @NonNull
    public byte[] a(@NonNull T t) {
        try {
            return this.b.a(this.a.a(t));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // com.yandex.metrica.impl.ob.nd
    @NonNull
    public T b(@NonNull byte[] bArr) throws IOException {
        try {
            return this.a.b(this.b.b(bArr));
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    @Override // com.yandex.metrica.impl.ob.nd
    @NonNull
    public T c() {
        return this.a.c();
    }
}
