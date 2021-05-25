package com.yandex.metrica.impl.ob;

import android.content.Context;
@Deprecated
public class tg extends ta {
    private th d;

    public tg(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.c.getBoolean(this.d.b(), false);
    }

    public void b() {
        h(this.d.b()).j();
    }

    @Override // com.yandex.metrica.impl.ob.ta
    public String f() {
        return "_serviceproviderspreferences";
    }

    public tg(Context context, String str) {
        super(context, str);
        this.d = new th("LOCATION_TRACKING_ENABLED");
    }
}
