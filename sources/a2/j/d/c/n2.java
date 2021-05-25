package a2.j.d.c;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Map;
public final class n2 implements Predicate<Map.Entry<V, K>> {
    public final /* synthetic */ Predicate a;

    public n2(Predicate predicate) {
        this.a = predicate;
    }

    @Override // com.google.common.base.Predicate
    public boolean apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.a.apply(Maps.immutableEntry(entry.getValue(), entry.getKey()));
    }
}
