package com.yandex.metrica.impl.ob;

import android.util.SparseArray;
public class up {
    private static SparseArray<String> a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(0, "String");
        a.put(1, "Number");
        a.put(2, "Counter");
    }

    public static String a(int i) {
        return a.get(i);
    }
}
