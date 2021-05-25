package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class pi extends ro implements qn {
    @Nullable
    private volatile pt a;
    @NonNull
    private final String b;

    public pi(@Nullable pt ptVar, @NonNull qe qeVar, @NonNull String str) {
        this(ptVar, qeVar, str, new dj());
    }

    @Override // com.yandex.metrica.impl.ob.ph
    public boolean a() {
        ps psVar;
        pt ptVar = this.a;
        return (ptVar == null || (psVar = ptVar.b) == null || !a(psVar.b)) ? false : true;
    }

    @Override // com.yandex.metrica.impl.ob.ph
    public boolean b() {
        pt ptVar = this.a;
        return ptVar != null && ptVar.a.a;
    }

    @Override // com.yandex.metrica.impl.ob.ro
    @NonNull
    public String c() {
        return this.b;
    }

    @VisibleForTesting
    public pi(@Nullable pt ptVar, @NonNull qe qeVar, @NonNull String str, @NonNull dj djVar) {
        super(qeVar, djVar);
        this.a = ptVar;
        this.b = str;
    }

    @Override // com.yandex.metrica.impl.ob.qn
    public void a(@Nullable pt ptVar) {
        this.a = ptVar;
    }
}
