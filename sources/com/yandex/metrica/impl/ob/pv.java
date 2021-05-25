package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class pv extends ro implements pz {
    @Nullable
    private volatile py a;

    public pv(@Nullable py pyVar, @NonNull qe qeVar) {
        this(pyVar, qeVar, new dj());
    }

    @Override // com.yandex.metrica.impl.ob.ph
    public boolean a() {
        pw pwVar;
        py pyVar = this.a;
        return (pyVar == null || (pwVar = pyVar.b) == null || !a(pwVar.c)) ? false : true;
    }

    @Override // com.yandex.metrica.impl.ob.ph
    public boolean b() {
        py pyVar = this.a;
        return pyVar != null && pyVar.a.a;
    }

    @Override // com.yandex.metrica.impl.ob.ro
    @NonNull
    public String c() {
        return "fused";
    }

    @VisibleForTesting
    public pv(@Nullable py pyVar, @NonNull qe qeVar, @NonNull dj djVar) {
        super(qeVar, djVar);
        this.a = pyVar;
    }

    @Override // com.yandex.metrica.impl.ob.pz
    public void a(@Nullable py pyVar) {
        this.a = pyVar;
    }
}
