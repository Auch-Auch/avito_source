package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.mb;
import com.yandex.metrica.impl.ob.mi;
import java.util.HashMap;
import java.util.List;
public class ls {
    @NonNull
    private final lt a;
    @NonNull
    private final lw b;
    @NonNull
    private final mb.a c;

    public ls(@NonNull lt ltVar, @NonNull lw lwVar) {
        this(ltVar, lwVar, new mb.a());
    }

    public mb a() {
        return this.c.a("main", this.a.c(), this.a.d(), this.a.a(), new md("main", this.b.a()));
    }

    public mb b() {
        HashMap hashMap = new HashMap();
        List<String> list = mi.c.a;
        hashMap.put("preferences", list);
        hashMap.put("binary_data", mi.b.a);
        hashMap.put("startup", list);
        List<String> list2 = mi.a.a;
        hashMap.put("l_dat", list2);
        hashMap.put("lbs_dat", list2);
        return this.c.a("metrica.db", this.a.g(), this.a.h(), this.a.b(), new md("metrica.db", hashMap));
    }

    public mb c() {
        HashMap hashMap = new HashMap();
        hashMap.put("preferences", mi.c.a);
        return this.c.a("client storage", this.a.e(), this.a.f(), new SparseArray<>(), new md("metrica.db", hashMap));
    }

    public ls(@NonNull lt ltVar, @NonNull lw lwVar, @NonNull mb.a aVar) {
        this.a = ltVar;
        this.b = lwVar;
        this.c = aVar;
    }
}
