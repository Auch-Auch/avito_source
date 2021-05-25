package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
public class lc {
    @NonNull
    public final String a;
    public final int b;
    public final long c;
    @NonNull
    public final String d;
    @Nullable
    public final Integer e;
    @NonNull
    public final List<StackTraceElement> f;

    public lc(@NonNull String str, int i, long j, @NonNull String str2, @Nullable Integer num, @Nullable List<StackTraceElement> list) {
        this.a = str;
        this.b = i;
        this.c = j;
        this.d = str2;
        this.e = num;
        this.f = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }
}
