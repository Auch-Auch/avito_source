package com.yandex.metrica.impl.ob;

import android.content.Context;
@Deprecated
public class te extends ta {
    private static final th d = new th("PREF_KEY_OFFSET");
    private th e = new th(d.a(), null);

    public te(Context context, String str) {
        super(context, str);
    }

    public long a(int i) {
        return this.c.getLong(this.e.b(), (long) i);
    }

    @Override // com.yandex.metrica.impl.ob.ta
    public String f() {
        return "_servertimeoffset";
    }

    public void a() {
        h(this.e.b()).j();
    }
}
