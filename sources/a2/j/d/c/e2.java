package a2.j.d.c;

import com.google.common.collect.Maps;
import java.util.Map;
public final class e2 extends g<K, V2> {
    public final /* synthetic */ Map.Entry a;
    public final /* synthetic */ Maps.EntryTransformer b;

    public e2(Map.Entry entry, Maps.EntryTransformer entryTransformer) {
        this.a = entry;
        this.b = entryTransformer;
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public K getKey() {
        return (K) this.a.getKey();
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public V2 getValue() {
        return (V2) this.b.transformEntry(this.a.getKey(), this.a.getValue());
    }
}
