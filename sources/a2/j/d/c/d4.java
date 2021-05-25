package a2.j.d.c;

import a2.j.d.c.e4;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.collect.ForwardingMapEntry;
import java.util.Collection;
import java.util.Map;
public class d4 extends ForwardingMapEntry<K, Collection<V>> {
    public final /* synthetic */ Map.Entry a;
    public final /* synthetic */ e4.a b;

    public d4(e4.a aVar, Map.Entry entry) {
        this.b = aVar;
        this.a = entry;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Object mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public Object getValue() {
        return AppCompatDelegateImpl.i.d((Collection) this.a.getValue(), e4.this.b);
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Map.Entry<K, Collection<V>> mo147delegate() {
        return this.a;
    }
}
