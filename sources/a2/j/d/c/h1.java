package a2.j.d.c;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
public class h1 extends g<K, ImmutableSet<V>> {
    public final /* synthetic */ Map.Entry a;

    public h1(ImmutableMap.c.a aVar, Map.Entry entry) {
        this.a = entry;
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public K getKey() {
        return (K) this.a.getKey();
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public Object getValue() {
        return ImmutableSet.of(this.a.getValue());
    }
}
