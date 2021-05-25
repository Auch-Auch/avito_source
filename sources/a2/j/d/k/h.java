package a2.j.d.k;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;
public final class h extends Ordering<K> {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ Map b;

    public h(Comparator comparator, Map map) {
        this.a = comparator;
        this.b = map;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(K k, K k2) {
        return this.a.compare(this.b.get(k), this.b.get(k2));
    }
}
