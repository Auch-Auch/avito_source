package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ey;
import com.yandex.metrica.impl.ob.hc;
import com.yandex.metrica.impl.ob.hk;
public class hl<T extends hk, C extends ey> extends hc<T, C> {
    public hl(@NonNull hi<T> hiVar, @NonNull C c) {
        super(hiVar, c);
    }

    public boolean a(@NonNull aa aaVar, @NonNull final gj gjVar) {
        return a(aaVar, new hc.a<T>() { // from class: com.yandex.metrica.impl.ob.hl.1
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.metrica.impl.ob.hl$1 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.yandex.metrica.impl.ob.hc.a
            public /* bridge */ /* synthetic */ boolean a(Object obj, aa aaVar2) {
                return a((AnonymousClass1) ((hk) obj), aaVar2);
            }

            public boolean a(T t, aa aaVar2) {
                return t.a(aaVar2, gjVar);
            }
        });
    }
}
