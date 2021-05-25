package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public abstract class kp {
    @NonNull
    private final Context a;

    public kp(@NonNull Context context) {
        this.a = context;
    }

    @NonNull
    public Context a() {
        return this.a;
    }

    public abstract void a(@Nullable Bundle bundle, @Nullable kn knVar);
}
