package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.uy;
import java.util.ArrayList;
import java.util.HashMap;
public class uq {
    private static final int[] a = {0, 1, 2, 3};
    private final SparseArray<HashMap<String, uy.a.C0346a>> b;
    private int c;

    public uq() {
        this(a);
    }

    @Nullable
    public uy.a.C0346a a(int i, @NonNull String str) {
        return this.b.get(i).get(str);
    }

    public void b() {
        this.c++;
    }

    @NonNull
    public uy.a c() {
        uy.a aVar = new uy.a();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.b.size(); i++) {
            SparseArray<HashMap<String, uy.a.C0346a>> sparseArray = this.b;
            for (uy.a.C0346a aVar2 : sparseArray.get(sparseArray.keyAt(i)).values()) {
                arrayList.add(aVar2);
            }
        }
        aVar.b = (uy.a.C0346a[]) arrayList.toArray(new uy.a.C0346a[arrayList.size()]);
        return aVar;
    }

    @VisibleForTesting
    public uq(int[] iArr) {
        this.b = new SparseArray<>();
        this.c = 0;
        for (int i : iArr) {
            this.b.put(i, new HashMap<>());
        }
    }

    public void a(@NonNull uy.a.C0346a aVar) {
        this.b.get(aVar.c).put(new String(aVar.b), aVar);
    }

    public int a() {
        return this.c;
    }
}
