package com.yandex.mobile.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.am;
import java.io.Serializable;
public abstract class c implements Serializable {
    private static final long serialVersionUID = -7571518881522543353L;
    @NonNull
    private final am a;

    public c(int i, int i2, @NonNull am.a aVar) {
        this.a = new am(i, i2, aVar);
    }

    @NonNull
    public final am a() {
        return this.a;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((c) obj).a);
    }

    public int getHeight() {
        return this.a.b();
    }

    public int getHeightInPixels(@NonNull Context context) {
        return this.a.c(context);
    }

    public int getWidth() {
        return this.a.a();
    }

    public int getWidthInPixels(@NonNull Context context) {
        return this.a.d(context);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a.toString();
    }

    public int getHeight(@NonNull Context context) {
        return this.a.a(context);
    }

    public int getWidth(@NonNull Context context) {
        return this.a.b(context);
    }
}
