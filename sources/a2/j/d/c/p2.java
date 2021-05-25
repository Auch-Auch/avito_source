package a2.j.d.c;

import com.google.common.collect.Multimaps;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;
public class p2 extends Multisets.e<K> {
    public final /* synthetic */ Map.Entry a;

    public p2(Multimaps.g.a aVar, Map.Entry entry) {
        this.a = entry;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        return ((Collection) this.a.getValue()).size();
    }

    @Override // com.google.common.collect.Multiset.Entry
    public K getElement() {
        return (K) this.a.getKey();
    }
}
