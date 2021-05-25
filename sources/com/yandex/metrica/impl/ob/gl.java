package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
public class gl implements fg {
    private final HashMap<String, ft> a = new HashMap<>();
    private final HashMap<String, ey> b = new HashMap<>();
    private final Context c;

    public gl(@NonNull Context context) {
        this.c = context.getApplicationContext();
    }

    @Nullable
    public synchronized ft a(@NonNull fb fbVar) {
        return this.a.get(fbVar.toString());
    }

    @NonNull
    public synchronized ey b(@NonNull fb fbVar, @NonNull ew ewVar, @NonNull fh<ey> fhVar) {
        return (ey) a(fbVar, ewVar, fhVar, this.b);
    }

    @NonNull
    public synchronized ft a(@NonNull fb fbVar, @NonNull ew ewVar, @NonNull fh<ft> fhVar) {
        return (ft) a(fbVar, ewVar, fhVar, this.a);
    }

    @Override // com.yandex.metrica.impl.ob.fg
    public synchronized void b() {
        for (ft ftVar : this.a.values()) {
            ftVar.b();
        }
        for (ey eyVar : this.b.values()) {
            eyVar.b();
        }
        this.a.clear();
        this.b.clear();
        as.s();
    }

    @NonNull
    private <T extends fm> T a(@NonNull fb fbVar, @NonNull ew ewVar, @NonNull fh<T> fhVar, @NonNull Map<String, T> map) {
        T t = map.get(fbVar.toString());
        if (t == null) {
            T b2 = fhVar.b(this.c, fbVar, ewVar);
            map.put(fbVar.toString(), b2);
            return b2;
        }
        t.a(ewVar);
        return t;
    }
}
