package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.yandex.metrica.CounterConfiguration;
public class co extends et {
    public ai a;
    public ch b;
    private ar c = new ar();

    public co(@NonNull eu euVar, @NonNull CounterConfiguration counterConfiguration) {
        super(euVar, counterConfiguration);
    }

    public void a(adj adj) {
        this.a = new ai(adj);
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        h().a(bundle);
        g().b(bundle);
        return bundle;
    }

    public void c() {
        this.c.b();
    }

    public boolean d() {
        return this.c.a();
    }

    public String e() {
        return this.a.a();
    }

    public ch f() {
        return this.b;
    }

    public void a(xx xxVar) {
        b(xxVar);
    }

    public boolean a() {
        return this.c.c();
    }

    public void a(String str, String str2) {
        this.a.a(str, str2);
    }

    public void b(xx xxVar) {
        if (xxVar != null) {
            h().c(xxVar.a());
        }
    }

    public void a(ch chVar) {
        this.b = chVar;
    }
}
