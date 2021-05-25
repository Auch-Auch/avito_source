package a2.j.d.c;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
public class m2 extends Maps.i<K, V> {
    public final /* synthetic */ Maps.g a;

    public m2(Maps.g gVar) {
        this.a = gVar;
    }

    @Override // com.google.common.collect.Maps.i
    public Map<K, V> d() {
        return this.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.a.entryIterator();
    }
}
