package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class q extends cu<Boolean> {
    public q(@NonNull Context context, @NonNull String str) {
        super(context, str, "bool");
    }

    @Nullable
    /* renamed from: a */
    public Boolean b(int i) {
        return Boolean.valueOf(this.a.getResources().getBoolean(i));
    }
}
