package a2.j.d.c;

import a2.j.d.c.t0;
import com.google.common.base.Predicate;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;
public class u0 implements Predicate<Map.Entry<K, Collection<V>>> {
    public final /* synthetic */ Predicate a;

    public u0(t0.b.a aVar, Predicate predicate) {
        this.a = predicate;
    }

    @Override // com.google.common.base.Predicate
    public boolean apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.a.apply(Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size()));
    }
}
