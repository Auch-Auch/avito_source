package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
public final class zm {
    @NonNull
    private final List<zi> a;
    @Nullable
    private final zb b;
    @NonNull
    private final List<String> c;

    public zm(@NonNull zl<zb> zlVar, @NonNull zl<List<zi>> zlVar2, @NonNull zl<List<String>> zlVar3) {
        this.b = zlVar.d();
        this.a = zlVar2.d();
        this.c = zlVar3.d();
    }

    @NonNull
    public List<zi> a() {
        return this.a;
    }

    @Nullable
    public zb b() {
        return this.b;
    }

    @NonNull
    public List<String> c() {
        return this.c;
    }
}
