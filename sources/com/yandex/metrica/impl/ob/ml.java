package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.util.SparseArray;
public class ml {
    private static volatile SparseArray<th> a = new SparseArray<>();

    @NonNull
    public synchronized String a(int i) {
        if (a.get(i) == null) {
            SparseArray<th> sparseArray = a;
            sparseArray.put(i, new th("EVENT_NUMBER_OF_TYPE_" + i));
        }
        return a.get(i).b();
    }
}
