package a2.j.d.f;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;
public class g0 extends UnmodifiableIterator<K> {
    public final /* synthetic */ Iterator a;
    public final /* synthetic */ h0 b;

    public g0(h0 h0Var, Iterator it) {
        this.b = h0Var;
        this.a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        Map.Entry<K, V> entry = (Map.Entry) this.a.next();
        this.b.a.b = entry;
        return entry.getKey();
    }
}
