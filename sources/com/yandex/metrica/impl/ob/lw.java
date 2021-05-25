package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.mi;
import java.util.HashMap;
import java.util.List;
public class lw {
    @NonNull
    private final HashMap<String, List<String>> a;

    public lw() {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        this.a = hashMap;
        hashMap.put("reports", mi.f.a);
        hashMap.put("sessions", mi.g.a);
        hashMap.put("preferences", mi.c.a);
        hashMap.put("binary_data", mi.b.a);
    }

    @NonNull
    public HashMap<String, List<String>> a() {
        return this.a;
    }
}
