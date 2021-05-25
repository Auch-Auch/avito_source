package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.mediation.base.a;
import java.util.List;
public final class bg<T extends a> {
    @NonNull
    private final bm a;
    @NonNull
    private final bb b;
    @NonNull
    private final bj c;
    private int d;

    public bg(@NonNull bm bmVar, @NonNull bb bbVar, @NonNull bj bjVar) {
        this.a = bmVar;
        this.b = bbVar;
        this.c = bjVar;
    }

    @Nullable
    public final bc<T> a(@NonNull Context context, @NonNull Class<T> cls) {
        List<bn> a3 = this.a.a();
        bc<T> bcVar = null;
        while (bcVar == null && this.d < a3.size()) {
            int i = this.d;
            this.d = i + 1;
            bn bnVar = a3.get(i);
            try {
                T cast = cls.cast(Cif.a(Class.forName(bnVar.a()), new Object[0]));
                if (cast == null) {
                    a(context, bnVar, "could_not_create_adapter");
                } else {
                    bcVar = new bc<>(cast, bnVar, this.b);
                }
            } catch (ClassCastException unused) {
                a(context, bnVar, "does_not_conform_to_protocol");
            } catch (Exception unused2) {
                a(context, bnVar, "could_not_create_adapter");
            }
        }
        return bcVar;
    }

    private void a(@NonNull Context context, @NonNull bn bnVar, @NonNull String str) {
        this.c.f(context, bnVar, a2.b.a.a.a.k0("reason", str));
    }
}
