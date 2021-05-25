package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.util.SparseIntArray;
public class zs implements zw {
    private final SparseIntArray a = new SparseIntArray();
    private final int b;

    public zs(int i) {
        this.b = i;
    }

    @Override // com.yandex.metrica.impl.ob.zw
    public void a(@NonNull aam aam) {
        SparseIntArray sparseIntArray = this.a;
        int i = aam.p;
        sparseIntArray.put(i, sparseIntArray.get(i) + 1);
    }

    public int a(int i) {
        return this.b - ((Integer) abw.b(Integer.valueOf(this.a.get(i)), 0)).intValue();
    }
}
