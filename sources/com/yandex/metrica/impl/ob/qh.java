package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class qh {
    @NonNull
    public final po a;
    @NonNull
    public final dn b;
    @NonNull
    public final zk c;
    @NonNull
    public final rm d;
    @NonNull
    public final pn e;
    @Nullable
    public final ql f;

    @VisibleForTesting
    public qh(@NonNull po poVar, @Nullable ql qlVar, @NonNull dn dnVar, @NonNull zk zkVar, @NonNull rm rmVar, @NonNull pn pnVar) {
        this.a = poVar;
        this.b = dnVar;
        this.c = zkVar;
        this.d = rmVar;
        this.e = pnVar;
        this.f = qlVar;
    }

    public static qh a(@NonNull rh rhVar, @NonNull rm rmVar, @NonNull pn pnVar, @NonNull dn dnVar, @NonNull zk zkVar) {
        return new qh(rhVar.a, rhVar.c, dnVar, zkVar, rmVar, pnVar);
    }
}
