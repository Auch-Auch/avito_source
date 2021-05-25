package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
public class cm implements Runnable {
    @NonNull
    private final Context a;
    private final aa b;
    private final Bundle c;
    @NonNull
    private final gf d;

    public cm(@NonNull Context context, aa aaVar, Bundle bundle, @NonNull gf gfVar) {
        this.a = context;
        this.b = aaVar;
        this.c = bundle;
        this.d = gfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ge a3;
        et etVar = new et(this.c);
        if (!et.a(etVar, this.a) && (a3 = ge.a(etVar)) != null) {
            ew ewVar = new ew(etVar);
            this.d.a(a3, ewVar).a(this.b, ewVar);
        }
    }
}
