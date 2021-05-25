package com.yandex.metrica.impl.ob;

import android.content.Context;
@Deprecated
public class td extends ta {
    private static final th d = new th("SERVICE_API_LEVEL");
    private static final th e = new th("CLIENT_API_LEVEL");
    private th f = new th(d.a());
    private th g = new th(e.a());

    public td(Context context) {
        super(context, null);
    }

    public int a() {
        return this.c.getInt(this.f.b(), -1);
    }

    public td b() {
        h(this.f.b());
        return this;
    }

    public td c() {
        h(this.g.b());
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.ta
    public String f() {
        return "_migrationpreferences";
    }
}
