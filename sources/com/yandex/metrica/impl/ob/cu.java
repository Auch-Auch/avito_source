package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public abstract class cu<T> {
    @NonNull
    public final Context a;
    @NonNull
    private final String b;
    @NonNull
    private final String c;

    public cu(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Nullable
    public T a() {
        int identifier = this.a.getResources().getIdentifier(this.b, this.c, this.a.getPackageName());
        if (identifier == 0) {
            return null;
        }
        try {
            return b(identifier);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public abstract T b(int i);
}
