package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
public class zr {
    @NonNull
    private final Map<Float, Integer> a = new HashMap();

    public zr(@NonNull TreeSet<Float> treeSet) {
        int i = 0;
        for (Float f : treeSet.descendingSet()) {
            this.a.put(f, Integer.valueOf(i));
            i++;
        }
    }

    public void a(@NonNull aad aad) {
        aad.l = this.a.get(aad.f);
    }
}
