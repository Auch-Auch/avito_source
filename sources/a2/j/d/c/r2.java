package a2.j.d.c;

import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.MutableClassToInstanceMap;
import java.util.Map;
public final class r2 extends ForwardingMapEntry<Class<? extends B>, B> {
    public final /* synthetic */ Map.Entry a;

    public r2(Map.Entry entry) {
        this.a = entry;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Object mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public B setValue(B b) {
        return (B) super.setValue(MutableClassToInstanceMap.d((Class) getKey(), b));
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    /* renamed from: delegate  reason: collision with other method in class */
    public Map.Entry<Class<? extends B>, B> mo147delegate() {
        return this.a;
    }
}
