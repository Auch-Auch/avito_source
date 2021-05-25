package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.fk;
import java.util.Iterator;
public class hc<T, C extends fk> {
    private final hi<T> a;
    private final C b;

    public interface a<T> {
        boolean a(T t, aa aaVar);
    }

    public hc(hi<T> hiVar, C c) {
        this.a = hiVar;
        this.b = c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.yandex.metrica.impl.ob.hc$a<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(@NonNull aa aaVar, @NonNull a<T> aVar) {
        Iterator<? extends T> it = a(aaVar).a().iterator();
        while (it.hasNext()) {
            if (aVar.a(it.next(), aaVar)) {
                return true;
            }
        }
        return false;
    }

    public hf<T> a(aa aaVar) {
        return this.a.a(aaVar.g());
    }
}
