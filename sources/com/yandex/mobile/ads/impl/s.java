package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.yandex.mobile.ads.AdRequestError;
import java.lang.ref.WeakReference;
public final class s implements ad {
    private static final SparseArray<AdRequestError> c;
    private final ai a = ai.a();
    private final WeakReference<ab> b;

    static {
        SparseArray<AdRequestError> sparseArray = new SparseArray<>();
        c = sparseArray;
        sparseArray.put(6, v.j);
        sparseArray.put(2, v.g);
        sparseArray.put(5, v.e);
        sparseArray.put(8, v.f);
        AdRequestError adRequestError = v.m;
        sparseArray.put(10, adRequestError);
        sparseArray.put(4, adRequestError);
        sparseArray.put(9, v.h);
        sparseArray.put(7, v.l);
        sparseArray.put(11, v.o);
    }

    public s(ab abVar) {
        this.b = new WeakReference<>(abVar);
    }

    public final void a(@NonNull bx bxVar) {
        ab abVar = this.b.get();
        if (abVar != null) {
            this.a.a(abVar.n(), (ry) bxVar);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ad
    public final boolean a_() {
        return false;
    }

    public final void b() {
        a();
        this.b.clear();
    }

    public final void a() {
        ab abVar = this.b.get();
        if (abVar != null) {
            this.a.a(abVar.n(), dt.a(abVar));
        }
    }

    public static AdRequestError a(int i) {
        return c.get(i, v.t);
    }
}
