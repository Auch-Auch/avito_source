package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.util.SparseArray;
import com.yandex.metrica.YandexMetrica;
public abstract class bu {

    public interface a {
        void a(Context context);
    }

    public abstract int a(td tdVar);

    public abstract SparseArray<a> a();

    public void a(Context context) {
        td tdVar = new td(context);
        int a3 = a(tdVar);
        int b = b();
        if (a3 < b) {
            if (a3 > 0) {
                a(context, a3, b);
            }
            a(tdVar, b);
            tdVar.j();
        }
    }

    public abstract void a(td tdVar, int i);

    public int b() {
        return YandexMetrica.getLibraryApiLevel();
    }

    private void a(Context context, int i, int i2) {
        SparseArray<a> a3 = a();
        while (true) {
            i++;
            if (i <= i2) {
                a aVar = a3.get(i);
                if (aVar != null) {
                    aVar.a(context);
                }
            } else {
                return;
            }
        }
    }
}
