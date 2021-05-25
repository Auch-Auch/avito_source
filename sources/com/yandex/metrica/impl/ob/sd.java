package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.cg;
import java.util.EnumSet;
public class sd {
    private static final EnumSet<cg.a> a = EnumSet.of(cg.a.OFFLINE);
    private aaz b = new aaw();
    private final Context c;

    public sd(@NonNull Context context) {
        this.c = context;
    }

    public boolean a() {
        return !a.contains(this.b.a(this.c));
    }
}
