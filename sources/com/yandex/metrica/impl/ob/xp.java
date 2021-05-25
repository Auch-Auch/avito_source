package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;
import java.util.Collections;
import java.util.List;
public class xp {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @NonNull
    public final List<Pair<String, String>> d;
    @Nullable
    public final Long e;
    @NonNull
    public final List<a> f;

    public enum a {
        WIFI,
        CELL
    }

    public xp(@Nullable String str, @Nullable String str2, @Nullable String str3, @NonNull List<Pair<String, String>> list, @Nullable Long l, @NonNull List<a> list2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = Collections.unmodifiableList(list);
        this.e = l;
        this.f = list2;
    }
}
