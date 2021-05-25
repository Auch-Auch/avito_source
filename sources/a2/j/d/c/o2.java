package a2.j.d.c;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Maps;
import java.util.Map;
public class o2 extends ForwardingMapEntry<K, V> {
    public final /* synthetic */ Map.Entry a;
    public final /* synthetic */ Maps.k.a.C0280a b;

    public o2(Maps.k.a.C0280a aVar, Map.Entry entry) {
        this.b = aVar;
        this.a = entry;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Object mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public V setValue(V v) {
        Preconditions.checkArgument(Maps.k.this.e(getKey(), v));
        return (V) super.setValue(v);
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Map.Entry<K, V> mo147delegate() {
        return this.a;
    }
}
