package a2.j.d.c;

import a2.j.d.c.b;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class a implements Iterator<Map.Entry<K, V>> {
    @NullableDecl
    public Map.Entry<K, V> a;
    public final /* synthetic */ Iterator b;
    public final /* synthetic */ b c;

    public a(b bVar, Iterator it) {
        this.c = bVar;
        this.b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Map.Entry<K, V> entry = (Map.Entry) this.b.next();
        this.a = entry;
        return new b.a(entry);
    }

    @Override // java.util.Iterator
    public void remove() {
        Preconditions.checkState(this.a != null, "no calls to next() since the last call to remove()");
        V value = this.a.getValue();
        this.b.remove();
        this.c.b.a.remove(value);
        this.a = null;
    }
}
