package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class rh {
    @NonNull
    public final po a;
    @NonNull
    public final yb b;
    @Nullable
    public final ql c;
    @NonNull
    public final lz d;
    @NonNull
    public final ly e;

    @VisibleForTesting
    public rh(@NonNull po poVar, @NonNull lz lzVar, @NonNull ly lyVar, @NonNull yb ybVar, @Nullable ql qlVar) {
        this.a = poVar;
        this.b = ybVar;
        this.c = qlVar;
        this.d = lzVar;
        this.e = lyVar;
    }

    public static rh a(@NonNull po poVar, @NonNull lz lzVar, @NonNull ly lyVar, @NonNull yb ybVar, @Nullable ql qlVar) {
        return new rh(poVar, lzVar, lyVar, ybVar, qlVar);
    }
}
