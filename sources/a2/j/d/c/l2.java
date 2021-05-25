package a2.j.d.c;

import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;
public final class l2 extends UnmodifiableIterator<Map.Entry<K, V>> {
    public final /* synthetic */ Iterator a;

    public l2(Iterator it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return Maps.n((Map.Entry) this.a.next());
    }
}
