package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
public class ky {
    @NonNull
    public final lc a;
    @NonNull
    public final List<lc> b;

    public ky(@NonNull lc lcVar, @Nullable List<lc> list) {
        this.a = lcVar;
        this.b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }
}
