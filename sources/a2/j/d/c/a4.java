package a2.j.d.c;

import a2.j.d.c.y3;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import java.util.Map;
public class a4 extends ForwardingMapEntry<C, V> {
    public final /* synthetic */ Map.Entry a;

    public a4(y3.g gVar, Map.Entry entry) {
        this.a = entry;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Object mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry, java.lang.Object
    public boolean equals(Object obj) {
        return standardEquals(obj);
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public V setValue(V v) {
        return (V) super.setValue(Preconditions.checkNotNull(v));
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Map.Entry<C, V> mo147delegate() {
        return this.a;
    }
}
