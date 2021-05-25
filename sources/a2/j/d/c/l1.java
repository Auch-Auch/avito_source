package a2.j.d.c;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;
public class l1 extends UnmodifiableIterator<Map.Entry<K, V>> {
    public final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> a;
    public K b = null;
    public Iterator<V> c = Iterators.j.e;
    public final /* synthetic */ ImmutableMultimap d;

    public l1(ImmutableMultimap immutableMultimap) {
        this.d = immutableMultimap;
        this.a = immutableMultimap.f.entrySet().mo99iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c.hasNext() || this.a.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.a.next();
            this.b = (K) entry.getKey();
            this.c = ((ImmutableCollection) entry.getValue()).iterator();
        }
        return Maps.immutableEntry(this.b, this.c.next());
    }
}
