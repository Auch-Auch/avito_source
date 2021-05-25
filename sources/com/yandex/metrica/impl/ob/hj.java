package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.fe;
import com.yandex.metrica.impl.ob.hc;
import com.yandex.metrica.impl.ob.hq;
public class hj<T extends hq, C extends fe> extends hc<T, C> {
    public hj(hi<T> hiVar, C c) {
        super(hiVar, c);
    }

    public boolean b(aa aaVar) {
        return a(aaVar, new hc.a<T>() { // from class: com.yandex.metrica.impl.ob.hj.1
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.metrica.impl.ob.hj$1 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.yandex.metrica.impl.ob.hc.a
            public /* bridge */ /* synthetic */ boolean a(Object obj, aa aaVar2) {
                return a((AnonymousClass1) ((hq) obj), aaVar2);
            }

            public boolean a(T t, aa aaVar2) {
                return t.a(aaVar2);
            }
        });
    }
}
