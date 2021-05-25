package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class gn extends gc {
    public gn(@NonNull Context context, @NonNull ft ftVar) {
        super(context, ftVar);
    }

    @VisibleForTesting
    public void a(boolean z) {
        c().a(z);
    }

    @Override // com.yandex.metrica.impl.ob.gc
    public void b(@NonNull aa aaVar, @NonNull ew ewVar) {
        a(((Boolean) abw.b(ewVar.b.e, Boolean.TRUE)).booleanValue());
        b().a(aaVar, ewVar);
    }
}
