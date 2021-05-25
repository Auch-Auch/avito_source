package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
@GwtCompatible
public abstract class m<K, V> extends p<K, V> {
    public m(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    @Override // a2.j.d.c.p, a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public abstract /* bridge */ /* synthetic */ Map asMap();

    @Override // a2.j.d.c.p, a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h
    public Set<K> e() {
        return q();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public abstract /* bridge */ /* synthetic */ Set keySet();

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }
}
