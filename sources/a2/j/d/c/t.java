package a2.j.d.c;

import com.google.common.collect.ArrayTable;
public class t extends g<K, V> {
    public final /* synthetic */ int a;
    public final /* synthetic */ ArrayTable.c b;

    public t(ArrayTable.c cVar, int i) {
        this.b = cVar;
        this.a = i;
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public K getKey() {
        ArrayTable.c cVar = this.b;
        return cVar.a.keySet().asList().get(this.a);
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public V getValue() {
        return (V) this.b.d(this.a);
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public V setValue(V v) {
        return (V) this.b.e(this.a, v);
    }
}
