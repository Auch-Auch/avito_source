package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
public final class bi {
    private static volatile bi a;
    private static final Object b = new Object();
    @NonNull
    private String c;

    private bi(Context context) {
        this.c = cg.a(context.getResources().getConfiguration().locale);
        eh.a().a(this, ep.class, el.a(new ek<ep>() { // from class: com.yandex.metrica.impl.ob.bi.1
            public void a(ep epVar) {
                bi.this.c = epVar.a;
            }
        }).a());
    }

    public static bi a(@NonNull Context context) {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new bi(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    @NonNull
    public String a() {
        return this.c;
    }
}
